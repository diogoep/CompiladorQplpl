package intermediary;


import ast.*;

public class IRTranslator{
    private int labelAtual;
    private int tempAtual;
    private Quadrupla inicio;


    public IRTranslator(){
        labelAtual = 0;
        tempAtual  = 0;
        inicio = new Quadrupla(operadorIREnum.LABEL, "","","main");
    }

    public Quadrupla getInicio() {
        return this.inicio;
    }

    public Quadrupla gerarCodigoIntermediario (DeclaracaoFuncao main){
        ComandoIntermediaria comando = new ComandoIntermediaria();
        comando.addQuadrupla(inicio);
        comando.merge(visit(main.getBloco()));
        return inicio = comando.getInicio();
    }


    public ComandoIntermediaria visit(Comando cmd){
        if(cmd instanceof Atribuicao) return visit((Atribuicao) cmd);
        if(cmd instanceof ComandoRepeticao) return visit((ComandoRepeticao) cmd);
        if(cmd instanceof Condicional) return visit((Condicional) cmd);
        if(cmd instanceof Bloco) return visit((Bloco) cmd);

        return new ComandoIntermediaria(); 
    }

    public ComandoIntermediaria visit(Bloco block){
        ComandoIntermediaria resposta =  new ComandoIntermediaria();
        for(Comando cmd: block.getComandos()){ 
            resposta.merge(visit(cmd));
        }
        return resposta;

    }



    public ComandoIntermediaria visit(Atribuicao atrib){

        ComandoIntermediaria valor = visit(atrib.getExpressao());
        String tempResposta = valor.getInicio().getDest();
        String destino = atrib.getVariavel().getPid();

        Quadrupla at = new Quadrupla(operadorIREnum.ATRIB,tempResposta,"",destino);
        ComandoIntermediaria resposta = new ComandoIntermediaria();
        resposta.merge(valor);
        resposta.addQuadrupla(at);
        return resposta;
    }

    public ComandoIntermediaria visit(ComandoRepeticao rep){

        ComandoIntermediaria condicao = visit(rep.getCondicao());
        ComandoIntermediaria bloco = visit(rep.getComando());

        String tempResposta = condicao.getFim().getDest();
        

        String labelc = novaLabel();
        String labelf = novaLabel();

        Quadrupla qlabelc = new Quadrupla(operadorIREnum.LABEL,"","",labelc);
        Quadrupla qlabelf = new Quadrupla(operadorIREnum.LABEL,"","",labelf);

        Quadrupla qcond = new Quadrupla(operadorIREnum.IFNOTGOTO,tempResposta,"",labelf);
        Quadrupla qrep = new Quadrupla(operadorIREnum.GOTO,"","",labelc);

        ComandoIntermediaria resposta = new ComandoIntermediaria();
        resposta.addQuadrupla(qlabelc);
        resposta.merge(condicao);
        resposta.addQuadrupla(qcond);
        resposta.merge(bloco);
        resposta.addQuadrupla(qrep);
        resposta.addQuadrupla(qlabelf);

        return resposta;
    }

    public ComandoIntermediaria visit(Condicional sel){

        ComandoIntermediaria condicao = visit(sel.getCondicao());
        ComandoIntermediaria blocoif = visit(sel.getCodigoIf());

        String tempResposta = condicao.getFim().getDest();

        System.out.println("presta");

        String    labelfim = novaLabel();
        Quadrupla qlabelfim = new Quadrupla(operadorIREnum.LABEL,"","",labelfim);
        Quadrupla qcond = new Quadrupla(operadorIREnum.IFNOTGOTO,tempResposta,"",labelfim);

        ComandoIntermediaria resposta = new ComandoIntermediaria();
        if(sel.getCodigoElse() == null){ 
            resposta.merge(condicao);
            resposta.addQuadrupla(qcond);
            resposta.merge(blocoif);
            resposta.addQuadrupla(qlabelfim);
        }else{ 
            ComandoIntermediaria blocoelse = visit(sel.getCodigoElse());
            String labelelse = novaLabel();
            qcond = new Quadrupla(operadorIREnum.IFNOTGOTO,tempResposta,"",labelelse);
            Quadrupla vaifim = new Quadrupla(operadorIREnum.GOTO,"","",labelfim);
            Quadrupla qlabelelse = new Quadrupla(operadorIREnum.LABEL,"","",labelelse);

            resposta.merge(condicao);
            resposta.addQuadrupla(qcond);
            resposta.merge(blocoif);
            resposta.addQuadrupla(vaifim);
            resposta.addQuadrupla(qlabelelse);
            resposta.merge(blocoelse);
            resposta.addQuadrupla(qlabelfim);
        }
        return resposta;
    }




    

    public ComandoIntermediaria visit(Expressao expr){
        if(expr instanceof ExpressaoNomeada)    return visit((ExpressaoNomeada) expr);
        if(expr instanceof ExpressaoBinaria) return visit((ExpressaoBinaria) expr);
        if(expr instanceof ExpressaoUnaria)  return visit((ExpressaoUnaria) expr);
        if(expr instanceof LiteralInteiro) return visit((LiteralInteiro) expr);
        if(expr instanceof LiteralString)  return visit((LiteralString) expr);
        if(expr instanceof LiteralBool)    return visit((LiteralBool) expr);
        if(expr instanceof LiteralChar)    return visit((LiteralChar) expr);
        return new ComandoIntermediaria(); 
    }

    public ComandoIntermediaria visit(LiteralInteiro lit){
        Quadrupla q = new Quadrupla(operadorIREnum.ATRIB, ""+lit.getConteudo(),"",novoTemp());
        return new ComandoIntermediaria(q,q);
    }

    public ComandoIntermediaria visit(LiteralChar lit){
        Quadrupla q = new Quadrupla(operadorIREnum.ATRIB, "'"+lit.getConteudo()+"'","",novoTemp());
        return new ComandoIntermediaria(q,q);
    }

    public ComandoIntermediaria visit(LiteralString lit){
        Quadrupla q = new Quadrupla(operadorIREnum.ATRIB, "\""+lit.getConteudo(),"\"",novoTemp());
        return new ComandoIntermediaria(q,q);
    }


    public ComandoIntermediaria visit(LiteralBool lit){
        tempAtual++;
        String v = "false";
        if(lit.getConteudo()) v = "true";
        Quadrupla q = new Quadrupla(operadorIREnum.ATRIB, v,novoTemp());
        return new ComandoIntermediaria(q,q);
    }


    public ComandoIntermediaria visit(ExpressaoNomeada expr){
        tempAtual++;
        Quadrupla q = new Quadrupla(operadorIREnum.ATRIB, expr.getIdentificador().getPid(),"",novoTemp());
        return new ComandoIntermediaria(q,q);
    }

    public ComandoIntermediaria visit(ExpressaoBinaria expr){

        ComandoIntermediaria esq = visit(expr.getExpressaoEsquerda()); 
        ComandoIntermediaria dir = visit(expr.getExpressaoDireita());

        String re = esq.getFim().getDest();
        String rd = dir.getFim().getDest();
        

        esq.merge(dir);
        Quadrupla resultado = new Quadrupla(converteOp(expr.getOperador()),re,rd,novoTemp());
        esq.addQuadrupla(resultado);

        return esq;
    }

    public ComandoIntermediaria visit(ExpressaoUnaria expr){
        ComandoIntermediaria dentro = visit(expr.getExpressao()); 
        String rd = dentro.getFim().getDest();

        Quadrupla una = new Quadrupla(converteOp(expr.getOperador()),rd,"",novoTemp());
        

        dentro.addQuadrupla(una);
        return dentro;
    }

    private String novoTemp(){
        tempAtual++;
        return "T"+tempAtual;
    }
    private String novaLabel(){
        labelAtual++;
        return "L"+labelAtual;
    }


    private operadorIREnum converteOp(OperadorBinario op){
        if(op == OperadorBinario.MULTIPLICACAO) return operadorIREnum.MULT;
        if(op == OperadorBinario.SOMA) return operadorIREnum.SOMA;
        if(op == OperadorBinario.SUBTRACAO) return operadorIREnum.SUB;
        if(op == OperadorBinario.DIVISAO) return operadorIREnum.DIV;
        if(op == OperadorBinario.MOD) return operadorIREnum.MOD;
        if(op == OperadorBinario.IGUAL) return operadorIREnum.IGUAL;
        if(op == OperadorBinario.DIFERENTE) return operadorIREnum.DIFERENTE;
        if(op == OperadorBinario.MENOR) return operadorIREnum.MENOR;
        if(op == OperadorBinario.MAIOR) return operadorIREnum.MAIOR;
        if(op == OperadorBinario.MENORIGUAL) return operadorIREnum.MENORIGUAL;
        if(op == OperadorBinario.MAIORIGUAL) return operadorIREnum.MAIORIGUAL;
        if(op == OperadorBinario.AND) return operadorIREnum.AND;
        if(op == OperadorBinario.OR) return operadorIREnum.OR;
        return operadorIREnum.ERRO;
    }
    private operadorIREnum converteOp(OperadorUnario op){
        if(op == OperadorUnario.MAIS) return operadorIREnum.MAIS;
        if(op == OperadorUnario.MENOS) return operadorIREnum.MENOS;
        if(op == OperadorUnario.NOT) return operadorIREnum.NOT;
        return operadorIREnum.ERRO;
    }


}
