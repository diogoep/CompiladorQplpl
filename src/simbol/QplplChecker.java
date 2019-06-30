package simbol;

import ast.*;

import java.util.ArrayList;

public class QplplChecker {
    private Programa codigo;
    private TabelaSimbolos tabelaGlobal;
    private ArrayList<Erro> erros;

    public QplplChecker(Programa codigo) {
        this.codigo = codigo;
    }

    public void check() {
        this.tabelaGlobal = new TabelaSimbolos();
        this.erros = new ArrayList<>();
        this.visit(this.codigo, tabelaGlobal);
    }

    public void visit(Programa codigo, TabelaSimbolos tabelaSimbolos) {
        for (Declaracao declaracao : codigo.getDeclaracoes()) {
            visit(declaracao, tabelaSimbolos);
        }
    }

    public void visit(Declaracao declaracao, TabelaSimbolos tabelaSimbolos) {
        if (declaracao instanceof DeclaracaoVariavel) {
            visit((DeclaracaoVariavel) declaracao, tabelaSimbolos);
        } else if (declaracao instanceof DeclaracaoFuncao) {
            visit((DeclaracaoFuncao) declaracao, tabelaSimbolos);
        }else if(declaracao instanceof DeclaracaoEstrutura){

        }else if(declaracao instanceof DeclaracaoMetodo){

        }else if(declaracao instanceof DeclaracaoAtributo){

        }
    }

    public void visit(DeclaracaoFuncao declaracaoFuncao, TabelaSimbolos tabelaSimbolos) {
        SimboloFuncao simboloFuncao = new SimboloFuncao(declaracaoFuncao.getTipo(), declaracaoFuncao.getIdentificadorFuncao());
        TabelaSimbolos tabelaBloco = new TabelaSimbolos(tabelaSimbolos);
        //TODO MAS UM BLOCO PODE TER TANTO DECLARACOES DE VARIAVEIS QUANTO COMANDOS, NÃO DEVEMOS IMPLEMENTAR A "VISITA" AOS COMANDOS NESSE CASO TAMBÉM?
        //Tratamento dos parametros da função
        for (DeclaracaoVariavel declaracaoVariavel : declaracaoFuncao.getParametros().getParametros()) {
            //Agora sim
            Erro erro = new Erro("", declaracaoFuncao.getLocal());
            Parametro parametro = new Parametro(declaracaoVariavel.getTipo(), declaracaoVariavel.getIdentificadorVariavel());
            if (!simboloFuncao.addParametro(parametro, erro)) {
                //Caso de erro. Já que há um parametro com o mesmo nome.
                erros.add(erro);
            } else {
                    tabelaBloco.adicionarSimbolo(new SimboloVariavel(parametro.getTipo(), parametro.getIdentificador()), erro);
            }
        }

        Erro erro = new Erro("", declaracaoFuncao.getLocal());
        if (!tabelaSimbolos.adicionarSimbolo(simboloFuncao, erro)) {
            erros.add(erro);
        }

        visit(declaracaoFuncao.getBloco(), tabelaBloco);

    }

    public void visit(DeclaracaoVariavel declaracaoVariavel, TabelaSimbolos tabelaSimbolos) {
        SimboloVariavel simboloVariavel = new SimboloVariavel(declaracaoVariavel.getTipo(), declaracaoVariavel.getIdentificadorVariavel());
        Erro erro = new Erro("", declaracaoVariavel.getLocal());
        if (!tabelaSimbolos.adicionarSimbolo(simboloVariavel, erro)) {
            erros.add(erro);
        }
        System.err.println("ieaofa");
        //VERIFICAR SE EXISTE EXPRESSAO DO LADO DIREITO DA DECLARACAO;
        if(declaracaoVariavel.getExpressao() != null){
            InfoExpressao infoExpressao = new InfoExpressao();
            visit(declaracaoVariavel.getExpressao(), tabelaSimbolos, infoExpressao);
            //VERIFICAR O TIPO DO LADO DIREITO E DA VARIAVEL, PRA VER SE SAO COMPATIVEIS
            //TODO COMO ELE JÁ LEU O LADO ESQUERDO DA DECLARACAO, O LADO DIREITO SÓ SE ENCAIXA EM UMA EXPRESSAO NOMEADA, NAO UMA EXPRESSAO BINARIA, JÁ QUE NA EXPRESSAO NAO VAI TER O OPERANDO INICIAL
            //TODO SE O LADO DIREITO FOR UMA EXPRESSAO, TEM QUE SER UMA ATRIBUIÇÃO
            //Atribuicao atribuicao = new Atribuicao(simboloVariavel, declaracaoVariavel.getExpressao());
            if(!infoExpressao.getTipoRetornado().equals(declaracaoVariavel.getTipo())){
                //TODO NAO EXISTEM VARIAVEIS BOOL
                Erro erroTipo = new Erro("O tipo esperado é " + declaracaoVariavel.getTipo() + " porém o tipo recebido foi " + infoExpressao.getTipoRetornado(), declaracaoVariavel.getLocal());
                erros.add(erroTipo);
            }
        }

    }

    public void visit(Bloco bloco, TabelaSimbolos tabelaBloco) {
        for (DeclaracaoVariavel declaracaoVariavel : bloco.getDefinicoes()) {
            Erro erro = new Erro("", declaracaoVariavel.getLocal());
            SimboloVariavel simboloVariavel = new SimboloVariavel(declaracaoVariavel.getTipo(), declaracaoVariavel.getIdentificadorVariavel());
            if (!tabelaBloco.adicionarSimbolo(simboloVariavel, erro)) {
                erros.add(erro);
            }

        }

        for (Comando comando : bloco.getComandos()) {
            visit(comando, tabelaBloco);
        }
    }

    public void visit(Comando comando, TabelaSimbolos tabelaBloco) {
        if (comando instanceof Atribuicao) {
            visit((Atribuicao) comando, tabelaBloco);
        } else if (comando instanceof Break) {
            visit((Break) comando, tabelaBloco);
        } else if (comando instanceof ComandoExpressao) {
            visit((ComandoExpressao) comando, tabelaBloco);
        } else if (comando instanceof ComandoRepeticao) {
            visit((ComandoRepeticao) comando, tabelaBloco);
        } else if (comando instanceof Condicional) {
            visit((Condicional) comando, tabelaBloco);
        } else if (comando instanceof Entrada) {
            visit((Entrada) comando, tabelaBloco);
        } else if (comando instanceof Saida) {
            visit((Saida) comando, tabelaBloco);
        } else if (comando instanceof Retorno) {
            visit((Retorno) comando, tabelaBloco);
        }
    }

    public void visit(Atribuicao atribuicao, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        String identificador = "";
        if (atribuicao.getIdentificador() instanceof ChamadaFuncao) {
            identificador = ((ChamadaFuncao) atribuicao.getIdentificador()).getId();
        } else if (atribuicao.getIdentificador() instanceof ChamadaVariavel) {
            identificador = ((ChamadaVariavel) atribuicao.getIdentificador()).getIdentificadorFuncao();
        }//NOME NÃO É EXPRESSAO      a = a + 1    a+1 = a
        visit(atribuicao.getExpressao(), tabelaBloco, infoExpressao);
        Erro erro = new Erro("", atribuicao.getLocal());
        if (tabelaBloco.buscarSimbolo(identificador, erro) == null) {
            erros.add(erro);
        }
        //TODO CHECAGEM DE TIPOS DO IDENTIFICADOR
    }

    public void visit(Condicional condicional, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        visit(condicional.getCondicao(), tabelaBloco, infoExpressao);
        if (infoExpressao.getTipoRetornado().getTipo() != TipoValor.BOOL) {
            Erro erro = new Erro("A expressão não é do tipo bool! É do tipo" + infoExpressao.getTipoRetornado(), condicional.getLocal());
            erros.add(erro);
            System.err.println();
        }
        visit(condicional.getCodigoIf(), tabelaBloco);
        if (condicional.getCodigoElse() != null) {
            visit(condicional.getCodigoElse(), tabelaBloco);
        }
    }

    public void visit(Break breique, TabelaSimbolos tabela) {
        //TODO Verificar se está dentro do while
    }

    public void visit(ComandoExpressao comandoExpressao, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        visit(comandoExpressao.getExpressao(), tabelaBloco, infoExpressao);
    }

    public void visit(ComandoRepeticao comandoRepeticao, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        visit(comandoRepeticao.getCondicao(), tabelaBloco, infoExpressao);
        if (infoExpressao.getTipoRetornado().getTipo() != TipoValor.BOOL) {
            Erro erro = new Erro("A expressão não é do tipo bool! É do tipo" + infoExpressao.getTipoRetornado(), comandoRepeticao.getLocal());
            erros.add(erro);
        }

        visit(comandoRepeticao.getComando(), tabelaBloco);
    }

    //CIN
    public void visit(Entrada entrada, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        for (Expressao expressao : entrada.getParametros()) {
            visit(expressao, tabelaBloco, infoExpressao);
            if (infoExpressao.getTipoRetornado().getTipo() == TipoValor.VOID) {
                Erro erro = new Erro("Não é possível receber algo do tipo VOID!", entrada.getLocal());
                erros.add(erro);
            }
        }
    }

    //COUT
    public void visit(Saida saida, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        for (Expressao expressao : saida.getParametros()) {
            visit(expressao, tabelaBloco, infoExpressao);
        }
        if (infoExpressao.getTipoRetornado().getTipo() == TipoValor.VOID) {
            Erro erro = new Erro("Não é possível imprimir algo do tipo VOID!", saida.getLocal());
            erros.add(erro);
        }
    }

    public void visit(Retorno retorno, TabelaSimbolos tabelaBloco) {
        InfoExpressao infoExpressao = new InfoExpressao();
        visit(retorno.getExpressao(), tabelaBloco, infoExpressao);
        //TODO CHECAGEM DE ERRO
    }

    public void visit(Expressao expressao, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao) {
        if (expressao instanceof ExpressaoUnaria) {
            visit((ExpressaoUnaria) expressao, tabelaBloco, infoExpressao);
        } else if (expressao instanceof ExpressaoBinaria) {
            visit((ExpressaoBinaria) expressao, tabelaBloco, infoExpressao);
        } else if (expressao instanceof ExpressaoNomeada) {
            visit((ExpressaoNomeada) expressao, tabelaBloco, infoExpressao);
        }else if(expressao instanceof LiteralBool){
            visit((LiteralBool) expressao, tabelaBloco, infoExpressao);
        }else if(expressao instanceof LiteralInteiro){
            visit((LiteralInteiro) expressao, tabelaBloco, infoExpressao);
        }else if(expressao instanceof LiteralChar){
            visit((LiteralChar) expressao, tabelaBloco, infoExpressao);
        }else if(expressao instanceof LiteralString){
            visit((LiteralString) expressao, tabelaBloco, infoExpressao);
        }
    }


    public void visit(ExpressaoBinaria expressao, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao) {
        InfoExpressao infoExpressaoEsquerda = new InfoExpressao();
        InfoExpressao infoExpressaoDireita = new InfoExpressao();
        visit(expressao.getExpressaoDireita(), tabelaBloco, infoExpressaoEsquerda);
        visit(expressao.getExpressaoEsquerda(), tabelaBloco, infoExpressaoDireita);
        /*Erro erro = new Erro()
        if(infoExpressaoDireita != infoExpressaoEsquerda){
        }*/
        if ((expressao.getOperador() == OperadorBinario.SOMA) || (expressao.getOperador() == OperadorBinario.SUBTRACAO)
                || (expressao.getOperador() == OperadorBinario.DIVISAO) || (expressao.getOperador() == OperadorBinario.MULTIPLICACAO)
                || (expressao.getOperador() == OperadorBinario.MOD) || (expressao.getOperador() == OperadorBinario.MAIOR)
                || (expressao.getOperador() == OperadorBinario.MAIORIGUAL) || (expressao.getOperador() == OperadorBinario.MENOR)
                || (expressao.getOperador() == OperadorBinario.MENORIGUAL)) {
            System.err.println(expressao.getOperador() + " e " + infoExpressaoDireita.getTipoRetornado().getTipo() + " e " + infoExpressaoEsquerda.getTipoRetornado().getTipo());
            if (infoExpressaoDireita.getTipoRetornado().getTipo() != TipoValor.INTEIRO || infoExpressaoEsquerda.getTipoRetornado().getTipo() != TipoValor.INTEIRO) {
                erros.add(new Erro("Operador " + expressao.getOperador() + " somente válido para inteiros!", expressao.getLocal()));

            }
            infoExpressao.setTipoRetornado(new Tipo(TipoValor.INTEIRO));
        }else if ((expressao.getOperador() == OperadorBinario.AND) || (expressao.getOperador() == OperadorBinario.OR)) {
            if (infoExpressaoDireita.getTipoRetornado().getTipo() != TipoValor.BOOL || infoExpressaoEsquerda.getTipoRetornado().getTipo() != TipoValor.BOOL) {
                erros.add(new Erro("Operador " + expressao.getOperador() + " somente válido para booleanos!", expressao.getLocal()));
            }
            infoExpressao.setTipoRetornado(new Tipo(TipoValor.BOOL));
        }else if ((expressao.getOperador() == OperadorBinario.DIFERENTE) || (expressao.getOperador() == OperadorBinario.IGUAL)){
            if (infoExpressaoDireita.getTipoRetornado().getTipo() != infoExpressaoEsquerda.getTipoRetornado().getTipo()) {
                erros.add(new Erro("O tipo " + infoExpressaoEsquerda.getTipoRetornado().getTipo() + " não é compatível com o tipo " + infoExpressaoDireita.getTipoRetornado().getTipo() + "!" , expressao.getLocal()));
            }
            infoExpressao.setTipoRetornado(new Tipo(infoExpressaoDireita.getTipoRetornado().getTipo()));
        }
    }

    public void visit(ExpressaoUnaria expressao, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao) {
        InfoExpressao infoExpressaoInterna = new InfoExpressao();
        visit(expressao.getExpressao(),tabelaBloco,infoExpressaoInterna);
        /*Erro erro = new Erro()
        if(infoExpressaoDireita != infoExpressaoEsquerda){
        }*/
        //TODO PARAR ANALISE SE ALGUMA RETORNAR UM ERRO
        if ((expressao.getOperador() == OperadorUnario.MAIS) || (expressao.getOperador() == OperadorUnario.MENOS)
                || (expressao.getOperador() == OperadorUnario.DECRESCIMODIREITA) || (expressao.getOperador() == OperadorUnario.INCREMENTODIREITA)
                || (expressao.getOperador() == OperadorUnario.DECRESCIMOESQUERDA) || (expressao.getOperador() == OperadorUnario.INCREMENTOESQUERDA)){
            if (infoExpressaoInterna.getTipoRetornado().getTipo() != TipoValor.INTEIRO){
                erros.add(new Erro("Operador " + expressao.getOperador() + " somente válido para inteiros!", expressao.getLocal()));
            }
            infoExpressao.setTipoRetornado(new Tipo(TipoValor.INTEIRO));
        }else if (expressao.getOperador() == OperadorUnario.NOT){
            if (infoExpressaoInterna.getTipoRetornado().getTipo() != TipoValor.BOOL){
                erros.add(new Erro("Operador " + expressao.getOperador() + " somente válido para booleanos!", expressao.getLocal()));
            }
            infoExpressao.setTipoRetornado(new Tipo(TipoValor.BOOL));
        }
    }

    public void visit(ExpressaoNomeada expressaoNomeada, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao){
        String identificador = "";
        if (expressaoNomeada.getIdentificador() instanceof ChamadaFuncao){
            identificador = ((ChamadaFuncao) expressaoNomeada.getIdentificador()).getId();
        } else if (expressaoNomeada.getIdentificador() instanceof ChamadaVariavel) {
            identificador = ((ChamadaVariavel) expressaoNomeada.getIdentificador()).getIdentificadorFuncao();
        }//NOME NÃO É EXPRESSAO      a = a + 1    a+1 = a
        Erro erro = new Erro("", expressaoNomeada.getLocal());
        //TODO O ALGORITMO DEVERIA RETORNAR O ERRO AQUI!!!!!!!
        //TODO ACHO QUE O ALGORITMO NAO ESTA PROCESSANDO OS COMANDOS, SÓ AS EXPRESSOES
        Simbolo simbolo = tabelaBloco.buscarSimbolo(identificador, erro);
        if (simbolo == null){
            erros.add(erro);
            infoExpressao.setTipoRetornado(new Tipo(TipoValor.INDETERMINADO));
        }else{
            infoExpressao.setTipoRetornado(new Tipo(simbolo.getTipo().getTipo()));
        }
    }

    public void visit(LiteralString literalString, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao){
        infoExpressao.setTipoRetornado(new Tipo(TipoValor.STRING));
    }

    public void visit(LiteralBool literalBool, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao){
        infoExpressao.setTipoRetornado(new Tipo(TipoValor.BOOL));
    }

    public void visit(LiteralChar literalChar, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao){
        infoExpressao.setTipoRetornado(new Tipo(TipoValor.CHAR));
    }

    public void visit(LiteralInteiro literalInteiro, TabelaSimbolos tabelaBloco, InfoExpressao infoExpressao){
        infoExpressao.setTipoRetornado(new Tipo(TipoValor.INTEIRO));
    }

    public void mostrarErros(){
        String erros = "l de erros: \n";
        for(Erro erro: this.erros){
            erros+= erro + "\n";
        }
        System.err.println(erros);
    }

}
