package simbol;

import ast.*;

import java.util.ArrayList;
public class QplplChecker {

    private Programa codigo;
    private TabelaSimbolos tabGlobal;
    private ArrayList<MensagemErro> erros;


    public QplplChecker(Programa codigo){
        this.codigo = codigo;
        this.tabGlobal = null;
        this.erros = new ArrayList<>();
    }

    public boolean check(){
        tabGlobal = new TabelaSimbolos();
        visit(codigo);
        return true;
    }

    private void visit(Programa codigo){
        for(Declaracao declaracao : codigo.getDeclaracoes()){
            visit((Declaracao) declaracao, tabGlobal);
        }
    }


    //LITERAIS NÃO SAO DECLARACOES, ENTÃO TENHO QUE ARRUMAR TODOS OS LITERAIS
    private void visit(Declaracao declaracao, TabelaSimbolos tabela){
        if(declaracao instanceof DeclaracaoVariavel)       visit((DeclaracaoVariavel) declaracao, tabela);
        else if(declaracao instanceof DeclaracaoFuncao)    visit((DeclaracaoFuncao) declaracao  , tabela); 
    }




    private void visit(DeclaracaoFuncao definicaoFuncao, TabelaSimbolos tabelaAtual){
        Simbolo s = new Simbolo(definicaoFuncao);
        TabelaSimbolos tabBloco = new TabelaSimbolos(tabelaAtual); 
        MensagemErro mErro = new MensagemErro(-1);

        ParametroFormal pfs = definicaoFuncao.getParametros();
        Assinatura simbP = new Assinatura(s.getTipo(), TipoAcessoS.PUBLICO);

        for(DeclaracaoVariavel param : pfs.getParametros()){
            Simbolo p = new Simbolo(param);
            //adicionarParametro tenta adicionar na tabela
            if(!simbP.adicionarParametro(p)){
                erros.add(new MensagemErro(definicaoFuncao.getLocal(),
                        "Parametros com mesmo ID [" + p.getIdentificador() +"]"));
            }else{
                tabBloco.addSimbolo(p,mErro);
            }
        }

        mErro = new MensagemErro(definicaoFuncao.getLocal());
        if(!s.addParametros(simbP,mErro)){
            erros.add(mErro);
        }
        mErro = new MensagemErro(definicaoFuncao.getLocal()); 
        if(!tabelaAtual.addSimbolo(s,mErro)){
        }

        InfoSemanticaBloco infoBloco = new InfoSemanticaBloco(definicaoFuncao.getTipo());
        visitBloco(definicaoFuncao.getBloco(), tabBloco, infoBloco);

        if(!infoBloco.garanteRetorno()){
            erros.add(new MensagemErro(definicaoFuncao.getLocal(),
                    "Funcao ID["+definicaoFuncao.getIdentificadorFuncao()+"] nao garante um retorno"));
        }
    }

    public void visitBloco(Bloco bloco, TabelaSimbolos tabelaAtual,InfoSemanticaBloco infoBloco){
        for(DeclaracaoVariavel dv : bloco.getDefinicoes()){
            visit(dv,tabelaAtual);
        }

        for(Comando cmd : bloco.getComandos()){
            InfoSemanticaBloco infoCmd = new InfoSemanticaBloco(infoBloco);
            visitComando(cmd, tabelaAtual, infoCmd);
            if(infoCmd.garanteRetorno())
                infoBloco.setGaranteRetorno(true);
        }
    }

    public void visitComando(Comando comando, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco) {
        if (comando instanceof ComandoRepeticao) infoBloco.setDentroLaco(true);

        if     (comando instanceof ComandoRepeticao) visitComando((ComandoRepeticao) comando, tabAtual,infoBloco);
        else if(comando instanceof Break) visitComando((Break) comando,tabAtual,infoBloco);
        else if(comando instanceof Condicional) visitComando((Condicional) comando,tabAtual,infoBloco);
        else if(comando instanceof Atribuicao) visitComando((Atribuicao) comando,tabAtual,infoBloco);
        else if(comando instanceof ComandoExpressao) visitComando((ComandoExpressao) comando,tabAtual,infoBloco);
        else if(comando instanceof Entrada) visitComando((Entrada) comando,tabAtual,infoBloco);
        else if(comando instanceof Resultado) visitComando((Resultado) comando,tabAtual,infoBloco);
        else if(comando instanceof Bloco) visitBloco((Bloco) comando, tabAtual, infoBloco);
        else if(comando instanceof Retorno) visitComando((Retorno) comando,tabAtual,infoBloco);
    }



    public void visitComando(Entrada entrada, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        for(Expressao param : entrada.getParametros()){
            InfoSemanticaExpressao infoParam = new InfoSemanticaExpressao();
            visitExpressao(param,tabAtual,infoParam);
            if(infoParam.getTipoRetornado().getTipo() == TipoValor.VOID || infoParam.getTipoRetornado().getTipo() == TipoValor.INDEFINIDO){
                erros.add(new MensagemErro(entrada.getLocal(),"std::cin nao definido para o tipo "+infoParam.getTipoRetornado()));
            }
        }
        infoBloco.setGaranteRetorno(false);
    }


    public void visitComando(Resultado resultado, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        for(Expressao param : resultado.getParametros()){
            InfoSemanticaExpressao infoParam = new InfoSemanticaExpressao();
            visitExpressao(param,tabAtual,infoParam);
            if(infoParam.getTipoRetornado().getTipo() == TipoValor.VOID || infoParam.getTipoRetornado().getTipo() == TipoValor.INDEFINIDO){
                erros.add(new MensagemErro(resultado.getLocal(),"std::cout nao definido para o tipo "+infoParam.getTipoRetornado()));
            }
        }
        infoBloco.setGaranteRetorno(false);
    }

    public void visitComando(ComandoRepeticao repeticao, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        InfoSemanticaExpressao infoSx = new InfoSemanticaExpressao();
        visitExpressao(repeticao.getCondicao(),tabAtual,infoSx);

        if(infoSx.getTipoRetornado().getTipo() != TipoValor.BOOL){
            erros.add(new MensagemErro(repeticao.getLocal(),
                    "while exige que a condicao seja boleana, recebido "+infoSx.getTipoRetornado()));
        }
        InfoSemanticaBloco infoComando = new InfoSemanticaBloco(infoBloco);
        visitComando(repeticao.getComando(), tabAtual, infoComando);
        infoBloco.setGaranteRetorno(false);
    }


    public void visitComando(Break quebra, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        if(!infoBloco.dentroLaco())
            erros.add(new MensagemErro(quebra.getLocal(),"break sem laco"));
    }


    public void visitComando(Condicional condicional, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        InfoSemanticaExpressao infoCondicao = new InfoSemanticaExpressao();
        visitExpressao(condicional.getCondicao(),tabAtual,infoCondicao);

        if(infoCondicao.getTipoRetornado().getTipo() != TipoValor.BOOL){
            erros.add(new MensagemErro(condicional.getLocal(),
                    "if exige que a condicao seja boleana, recebido "+infoCondicao.getTipoRetornado()));
        }

        InfoSemanticaBloco infoComandoIf = new InfoSemanticaBloco(infoBloco);
        visitComando(condicional.getCodigoIf(), tabAtual, infoComandoIf);
        infoBloco.setGaranteRetorno(false);

        if(condicional.getCodigoElse() != null){
            InfoSemanticaBloco infoComandoElse = new InfoSemanticaBloco(infoBloco);
            visitComando(condicional.getCodigoElse(), tabAtual, infoComandoElse);
            if(infoComandoIf.garanteRetorno() && infoComandoElse.garanteRetorno()){
                infoBloco.setGaranteRetorno(true);
            }
        }
    }


    public void visitComando(Retorno retorno, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        InfoSemanticaExpressao infoCondicao = new InfoSemanticaExpressao();
        visitExpressao(retorno.getExpressao(),tabAtual,infoCondicao);

        if( !infoCondicao.getTipoRetornado().equals(infoBloco.getTipoRetorno())){
            erros.add(new MensagemErro(retorno.getLocal(),
                    "retorno esperado "+infoBloco.getTipoRetorno()+" porem recebido "+infoCondicao.getTipoRetornado()));
        }
        infoBloco.setGaranteRetorno(true);
    }



    public void visit(DeclaracaoVariavel declaracaoVariavel, TabelaSimbolos tabAtual){
        Simbolo p = new Simbolo(declaracaoVariavel);
        MensagemErro mErro = new MensagemErro(declaracaoVariavel.getLocal());

        InfoSemanticaExpressao expressaoInfo = new InfoSemanticaExpressao();

        if(declaracaoVariavel.getExpressao() != null) {
            visitExpressao(declaracaoVariavel.getExpressao(), tabAtual, expressaoInfo);

            if (! declaracaoVariavel.getTipo().equals(expressaoInfo.getTipoRetornado())) {
                erros.add(new MensagemErro(declaracaoVariavel.getLocal(),
                        "tipo de ["+p.getIdentificador()+"] esperado " + declaracaoVariavel.getTipo() +
                                " porem recebido " + expressaoInfo.getTipoRetornado()));
            }
        }
        if(!tabAtual.addSimbolo(p,mErro)){
            erros.add(mErro);
        }
    }

    public void visitComando(Atribuicao atribuicao, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        InfoSemanticaExpressao infoExpr = new InfoSemanticaExpressao();
        visitExpressao(atribuicao.getExpressao(),tabAtual,infoExpr);


        InfoSemanticaExpressao infoIdentificador = new InfoSemanticaExpressao();
        visitIdentificador(atribuicao.getVariavel(),tabAtual,infoIdentificador);


        if(!infoIdentificador.getTipoRetornado().equals(infoExpr.getTipoRetornado())){
            erros.add(new MensagemErro(atribuicao.getLocal(),
                    "atribuicao esperando " + infoIdentificador.getTipoRetornado() +
                            " porem recebido " + infoIdentificador.getTipoRetornado()));
        }
        infoBloco.setGaranteRetorno(false);
    }

    public void visitComando(ComandoExpressao comandoExpressao, TabelaSimbolos tabAtual, InfoSemanticaBloco infoBloco){
        InfoSemanticaExpressao infoExpr = new InfoSemanticaExpressao();
        visitExpressao(comandoExpressao.getExpressao(),tabAtual,infoExpr);
        infoBloco.setGaranteRetorno(false);
    }

    public void visitExpressao(Expressao exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){

             if(exp instanceof ExpressaoBinaria) visitExpressao((ExpressaoBinaria) exp,tabAtual,infoSeman);
        else if(exp instanceof ExpressaoUnaria) visitExpressao((ExpressaoUnaria) exp,tabAtual,infoSeman);
        else if(exp instanceof ExpressaoNomeada) visitExpressao((ExpressaoNomeada) exp,tabAtual,infoSeman);
        else if(exp instanceof LiteralChar) visitExpressao((LiteralChar) exp,tabAtual,infoSeman);
        else if(exp instanceof LiteralInteiro) visitExpressao((LiteralInteiro) exp,tabAtual,infoSeman);
        else if(exp instanceof LiteralString) visitExpressao((LiteralString) exp,tabAtual,infoSeman);

    }

    public void visitExpressao(ExpressaoBinaria exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){

        InfoSemanticaExpressao infoEsq = new InfoSemanticaExpressao();
        InfoSemanticaExpressao infoDir = new InfoSemanticaExpressao();

        visitExpressao(exp.getExpressaoEsquerda(), tabAtual, infoEsq);
        visitExpressao(exp.getExpressaoDireita(), tabAtual, infoDir);


        OperadorBinario op = exp.getOperador();
        if(        op == OperadorBinario.SOMA
                || op == OperadorBinario.SUBTRACAO
                || op == OperadorBinario.DIVISAO
                || op == OperadorBinario.MULTIPLICACAO
                || op == OperadorBinario.MOD )
        {
            infoSeman.setTipoRetornado(new Tipo(TipoValor.INTEIRO));
            if(infoEsq.getTipoRetornado().getTipo() != TipoValor.INTEIRO || infoDir.getTipoRetornado().getTipo() != TipoValor.INTEIRO){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" so e permitido entre inteiros"));
            }
        } 
        else if (op == OperadorBinario.MAIOR || op == OperadorBinario.MAIORIGUAL || op == OperadorBinario.MENOR || op == OperadorBinario.MENORIGUAL){
            infoSeman.setTipoRetornado(new Tipo(TipoValor.BOOL));
            if(infoEsq.getTipoRetornado().getTipo() != TipoValor.INTEIRO || infoDir.getTipoRetornado().getTipo() != TipoValor.INTEIRO){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" so e permitido entre inteiros"));
            }
        }else if(op == OperadorBinario.IGUAL || op == OperadorBinario.DIFERENTE){
            infoSeman.setTipoRetornado(new Tipo(TipoValor.BOOL));
            if(infoEsq.getTipoRetornado().getTipo() != infoDir.getTipoRetornado().getTipo()){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" so e permitido entre tipos iguais"));
            }
        }if(op == OperadorBinario.AND  || op == OperadorBinario.OR )
        {
            infoSeman.setTipoRetornado(new Tipo(TipoValor.BOOL));
            if(infoEsq.getTipoRetornado().getTipo() != TipoValor.BOOL || infoDir.getTipoRetornado().getTipo() != TipoValor.BOOL){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" so e permitido entre boleanos"));
            }
        }
    }
    public void visitExpressao(LiteralBool exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        infoSeman.setTipoRetornado(new Tipo(TipoValor.BOOL));
    }

    public void visitExpressao(LiteralInteiro exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        infoSeman.setTipoRetornado(new Tipo(TipoValor.INTEIRO));
    }
    public void visitExpressao(LiteralChar exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        infoSeman.setTipoRetornado(new Tipo(TipoValor.CHAR));
    }
    public void visitExpressao(LiteralString exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        infoSeman.setTipoRetornado(new Tipo(TipoValor.STRING));
    }


    public void visitExpressao(ExpressaoUnaria exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        InfoSemanticaExpressao infoDentro = new InfoSemanticaExpressao();
        visitExpressao(exp.getExpressao(), tabAtual, infoDentro);

        OperadorUnario op = exp.getOperador();
        if(op == OperadorUnario.MAIS || op == OperadorUnario.MENOS){
            infoSeman.setTipoRetornado(new Tipo(TipoValor.INTEIRO));
            if(infoDentro.getTipoRetornado().getTipo() != TipoValor.INTEIRO ){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" definido para inteiros"));
            }
        }else if(op == OperadorUnario.NOT){
            infoSeman.setTipoRetornado(new Tipo(TipoValor.BOOL));
            if(infoDentro.getTipoRetornado().getTipo() != TipoValor.BOOL ){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" definido para boleanos"));
            }
        }else if(op == OperadorUnario.DECRESCIMODIREITA|| op == OperadorUnario.INCREMENTODIREITA ||op == OperadorUnario.INCREMENTOESQUERDA ||op == OperadorUnario.DECRESCIMOESQUERDA){
            infoSeman.setTipoRetornado(new Tipo(TipoValor.INTEIRO));

            if(!(exp.getExpressao() instanceof ExpressaoNomeada) || infoDentro.getTipoRetornado().getTipo() != TipoValor.INTEIRO ){
                erros.add(new MensagemErro(exp.getLocal(), "operador "+op+" definido para variaveis inteiras"));
            }
        }
    }

    public void visitExpressao (ExpressaoNomeada exp, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        Identificador identificador = exp.getIdentificador();
        visitIdentificador(identificador,tabAtual,infoSeman);
    }


    public void visitIdentificador(Identificador identificador, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        if(identificador instanceof ChamadaFuncao){
            visitChamada((ChamadaFuncao) identificador,tabAtual,infoSeman);
        }else if(identificador instanceof ChamadaVariavel){
            InfoSemanticaExpressao infoIdentificador = new InfoSemanticaExpressao();
            visitChamada((ChamadaVariavel) identificador,tabAtual,infoSeman);
        }
    }
    public void visitChamada2 (Identificador identificador, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){

        if(identificador instanceof ChamadaFuncao){
            InfoSemanticaExpressao infoIdentificador = new InfoSemanticaExpressao();
            visitChamada2((ChamadaFuncao) identificador,tabAtual,infoIdentificador);
        }else if(identificador instanceof ChamadaVariavel){
            InfoSemanticaExpressao infoIdentificador = new InfoSemanticaExpressao();
            visitChamada2((ChamadaVariavel) identificador,tabAtual,infoIdentificador);
        }
    }

    public void visitChamada(ChamadaFuncao chamadaFuncao, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){

        Assinatura parametros = new Assinatura(new Tipo(TipoValor.FUNCAO),TipoAcessoS.PUBLICO);
        ArrayList<Expressao> parametosReais = chamadaFuncao.getParametros().getParametros();
        int i = 0;

        for(Expressao a : parametosReais){
            InfoSemanticaExpressao infoSx = new InfoSemanticaExpressao();
            visitExpressao(a,tabAtual,infoSx);
            Simbolo p = new Simbolo("a"+(i++),infoSx.getTipoRetornado(), chamadaFuncao.getLocal());
            parametros.adicionarParametro(p);
        }

        MensagemErro mErro = new MensagemErro(chamadaFuncao.getLocal());
        BuscaSimbolo busca = new BuscaSimbolo(chamadaFuncao.getId(), parametros);
        busca.buscar(tabAtual, mErro);


        if (busca.getResposta() == null) {
            erros.add(mErro);
            infoSeman.setTipoRetornado(new Tipo(TipoValor.INDEFINIDO));
            return;
        } else {
            infoSeman.setTipoRetornado(busca.getResposta().getTipo());
            if (chamadaFuncao.getProximo() != null) {
                if (busca.getResposta().getTipo().getTipo() != TipoValor.ESTRUTURA) {
                    erros.add(new MensagemErro(chamadaFuncao.getLocal(), "requisicao de membro para uma nao estrutura "+busca.getResposta().getTipo()));
                    infoSeman.setTipoRetornado(new Tipo(TipoValor.INDEFINIDO));
                    return;
                }

                infoSeman.setEscopoAtual(busca.getResposta().getTipo());
                visitChamada2(chamadaFuncao.getProximo(), tabAtual, infoSeman);
                return;
            }
        }
    }

    public void visitChamada2(ChamadaFuncao chamadaFuncao, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        Assinatura parametros = new Assinatura(new Tipo(TipoValor.FUNCAO),TipoAcessoS.PUBLICO);
        ArrayList<Expressao> parametosReais = chamadaFuncao.getParametros().getParametros();
        int i = 0;

        for(Expressao a : parametosReais){
            InfoSemanticaExpressao infoSx = new InfoSemanticaExpressao();
            visitExpressao(a,tabAtual,infoSx);
            Simbolo p = new Simbolo("a"+i++,infoSx.getTipoRetornado(), chamadaFuncao.getLocal());
            parametros.adicionarParametro(p);
            int b;
        }
    }

    public void visitChamada(ChamadaVariavel chamadaVariavel, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
        MensagemErro mErro = new MensagemErro(chamadaVariavel.getLocal());
        BuscaSimbolo busca = new BuscaSimbolo(chamadaVariavel.getIdentificadorFuncao());
        busca.buscar(tabAtual, mErro);

        if (busca.getResposta() == null) {
            erros.add(mErro);
            infoSeman.setTipoRetornado(new Tipo(TipoValor.INDEFINIDO));
            return;
        } else {
            infoSeman.setTipoRetornado(busca.getResposta().getTipo());
            if (chamadaVariavel.getProximo() != null) {
                if (busca.getResposta().getTipo().getTipo() != TipoValor.ESTRUTURA) {
                    erros.add(new MensagemErro(chamadaVariavel.getLocal(), "requisicao de membro para nao estrutura "+busca.getResposta().getTipo()));
                    infoSeman.setTipoRetornado(new Tipo(TipoValor.INDEFINIDO));
                    return;
                }
                infoSeman.setEscopoAtual(busca.getResposta().getTipo());
                visitChamada2(chamadaVariavel.getProximo(), tabAtual, infoSeman);
                return;
            }
        }
    }

    public void visitChamada2(ChamadaVariavel chamadaVariavel, TabelaSimbolos tabAtual, InfoSemanticaExpressao infoSeman){
    }




    public String mostrarErros(){
        String res = "Lista de erros:\n";
        for(MensagemErro mErro : erros){
            res += mErro + "\n";
        }
        return res;
    }

}









