package intermediary;

import ast.*;

public class QplplIRTranslator{
    private DeclaracaoFuncao principal;
    //ou cabeça da lista
    private Quadrupla head;
    private int contadorTemporario;
    private int contadorLabel;

    public QplplIRTranslator(DeclaracaoFuncao declaracaoFuncao){
        this.principal = declaracaoFuncao;
        this.contadorTemporario = 0;
        this.contadorLabel = 0;
        this.head = new Quadrupla(Operador.LABEL, "","","main");
    }

    public Quadrupla translate(){
        return visit(this.principal);
    }

    public Quadrupla visit(DeclaracaoFuncao declaracaoFuncao){
        head.join(visit(declaracaoFuncao.getBloco()));
        return head;
    }

    public Quadrupla visit(Bloco bloco){
        if(bloco.getComandos().size()==0){
            return null;
        }

        Quadrupla resultado = visit(bloco.getComandos().get(0));

        for(int i = 1; i < bloco.getComandos().size(); i++){
            resultado.join(visit(bloco.getComandos().get(i)));
        }
        return resultado;
    }

    public Quadrupla visit(Comando comando){
        if(comando instanceof Atribuicao){
            return visit((Atribuicao) comando);
        }else if(comando instanceof Bloco){
            return visit((Bloco) comando);
        }else if(comando instanceof ComandoRepeticao){
            return visit((ComandoRepeticao) comando);
        }else if(comando instanceof ComandoExpressao){
            return visit((ComandoExpressao) comando);
        }else if(comando instanceof Condicional){
            return visit((Condicional) comando);
        }
        return null;
    }

    public Quadrupla visit(ComandoExpressao comandoExpressao) {
        return visit(comandoExpressao.getExpressao());
    }

    public Quadrupla visit(Atribuicao atribuicao){
        Quadrupla expressao = visit(atribuicao.getExpressao());
        String temporarioResposta = expressao.getFinalLista().getDestino();
        String identificadorVariavel = "";

        if (atribuicao.getIdentificador() instanceof ChamadaFuncao){
            identificadorVariavel = ((ChamadaFuncao) atribuicao.getIdentificador()).getId();
        } else if (atribuicao.getIdentificador() instanceof ChamadaVariavel) {
            identificadorVariavel = ((ChamadaVariavel) atribuicao.getIdentificador()).getIdentificadorFuncao();
        }

        Quadrupla identificador = new Quadrupla(Operador.ATRIBUICAO, temporarioResposta, "",identificadorVariavel);
        expressao.join(identificador);
        return expressao;
    }

    public Quadrupla visit(ComandoRepeticao comandoRepeticao){
        String L1 = novaLabel(), L2 = novaLabel(), L3 = novaLabel();
        Quadrupla condicao = visit(comandoRepeticao.getCondicao());
        Quadrupla comando = visit(comandoRepeticao.getComando());
        Quadrupla label1 = new Quadrupla(Operador.LABEL, "", "", L1);
        Quadrupla label2 = new Quadrupla(Operador.LABEL, "", "", L2);
        Quadrupla label3 = new Quadrupla(Operador.LABEL, "", "", L3);
        Quadrupla testeCondicao = new Quadrupla(Operador.IFGOTO, condicao.getFinalLista().getDestino(),"", L2);
        Quadrupla repete = new Quadrupla(Operador.GOTO, "","", L1);
        Quadrupla fim = new Quadrupla(Operador.GOTO, "","", L3);

        label1.join(condicao);
        label1.join(testeCondicao);
        label1.join(fim);
        label1.join(label2);
        label1.join(comando);
        label1.join(repete);
        label1.join(label3);

        return label1;
    }

    public Quadrupla visit(Condicional condicional){
        String L1 = novaLabel(), L2 = novaLabel(), L3 = novaLabel();
        Quadrupla condicao = visit(condicional.getCondicao());
        Quadrupla comandoIf = visit(condicional.getCodigoIf());
        if(condicional.getCodigoElse() == null){
            Quadrupla label1 = new Quadrupla(Operador.LABEL, "", "", L1);
            Quadrupla label2 = new Quadrupla(Operador.LABEL, "", "", L2);
            Quadrupla testeCondicao = new Quadrupla(Operador.IFFALSEGOTO, condicao.getFinalLista().getDestino(),"", L2);
            label1.join(condicao);
            label1.join(testeCondicao);
            label1.join(comandoIf);
            label1.join(label2);
            return label1;
        }else{
            Quadrupla comandoElse = visit(condicional.getCodigoElse());
            Quadrupla label1 = new Quadrupla(Operador.LABEL, "", "", L1);
            Quadrupla label2 = new Quadrupla(Operador.LABEL, "", "", L2);
            Quadrupla label3 = new Quadrupla(Operador.LABEL, "", "", L3);
            Quadrupla testeCondicao = new Quadrupla(Operador.IFFALSEGOTO, condicao.getFinalLista().getDestino(),"", L2);
            Quadrupla fim = new Quadrupla(Operador.GOTO, "","", L3);
            //System.out.println("forkforkfor"); System.err.println(comandoElse.mostrarCodigo());
            label1.join(condicao);
            label1.join(testeCondicao);
            label1.join(comandoIf);
            label1.join(fim);
            label1.join(label2);
            label1.join(comandoElse);
            label1.join(label3);
            return label1;
        }
    }

    public Quadrupla visit(Expressao expressao){
            if (expressao instanceof ExpressaoUnaria){
                return visit((ExpressaoUnaria) expressao);
            } else if (expressao instanceof ExpressaoBinaria) {
                return visit((ExpressaoBinaria) expressao);
            } else if (expressao instanceof ExpressaoNomeada) {
                return visit((ExpressaoNomeada) expressao);
            }else if(expressao instanceof LiteralBool){
                return visit((LiteralBool) expressao);
            }else if(expressao instanceof LiteralInteiro){
                return visit((LiteralInteiro) expressao);
            }else if(expressao instanceof LiteralChar){
                return visit((LiteralChar) expressao);
            }else if(expressao instanceof LiteralString){
                return visit((LiteralString) expressao);
            }
            return null;
    }


    public Quadrupla visit(LiteralInteiro literalInteiro){
        Quadrupla quadrupla = new Quadrupla(Operador.ATRIBUICAO, String.valueOf(literalInteiro.getConteudo()), "", novoTemporario());
        return quadrupla;
    }

    public Quadrupla visit(LiteralBool literalBool){
        Quadrupla quadrupla = new Quadrupla(Operador.ATRIBUICAO, String.valueOf(literalBool.getConteudo()), "", novoTemporario());
        return quadrupla;
    }
    public Quadrupla visit(LiteralChar literalChar){
        Quadrupla quadrupla = new Quadrupla(Operador.ATRIBUICAO, String.valueOf(literalChar.getConteudo()), "", novoTemporario());
        return quadrupla;
    }
    public Quadrupla visit(LiteralString literalString){
        Quadrupla quadrupla = new Quadrupla(Operador.ATRIBUICAO, String.valueOf(literalString.getConteudo()), "", novoTemporario());
        return quadrupla;
    }


    public Quadrupla visit(ExpressaoNomeada expressaoNomeada){
        String identificadorVariavel = "";

        if (expressaoNomeada.getIdentificador() instanceof ChamadaFuncao){
            identificadorVariavel = ((ChamadaFuncao) expressaoNomeada.getIdentificador()).getId();
        } else if (expressaoNomeada.getIdentificador() instanceof ChamadaVariavel) {
            identificadorVariavel = ((ChamadaVariavel) expressaoNomeada.getIdentificador()).getIdentificadorFuncao();
        }

        Quadrupla quadrupla = new Quadrupla(Operador.ATRIBUICAO, identificadorVariavel, "", novoTemporario());
         return quadrupla;
    }


    public Quadrupla visit(ExpressaoBinaria expressaoBinaria){
        Quadrupla quadruplaEsquerda = visit(expressaoBinaria.getExpressaoEsquerda());
        Quadrupla quadruplaDireita = visit (expressaoBinaria.getExpressaoDireita ());

        String temporarioRespostaEsquerda = quadruplaEsquerda.getFinalLista().getDestino();
        String temporarioRespostaDireita  = quadruplaDireita.getFinalLista().getDestino();

        quadruplaEsquerda.join(quadruplaDireita);
        Operador operadorExpressao = conversaoOperador(expressaoBinaria.getOperador());
        Quadrupla quadrupla = new Quadrupla(operadorExpressao, temporarioRespostaEsquerda, temporarioRespostaDireita, novoTemporario());
        quadruplaEsquerda.join(quadrupla);
        return quadruplaEsquerda;
    }

    public Quadrupla visit(ExpressaoUnaria expressaoUnaria){
        Quadrupla quadruplaInterna = visit(expressaoUnaria.getExpressao());
        String temporarioRespostaInterna = quadruplaInterna.getFinalLista().getDestino();
        Operador operadorExpressao = conversaoOperador(expressaoUnaria.getOperador());
        Quadrupla quadrupla = new Quadrupla(operadorExpressao, temporarioRespostaInterna,"", novoTemporario());
        quadruplaInterna.join(quadrupla);
        return quadruplaInterna;
    }


    public String novoTemporario(){
        String temporario = "T"+this.contadorTemporario;
        this.contadorTemporario++;
        return temporario;
    }


    public String novaLabel(){
        String label = "L"+this.contadorLabel;
        this.contadorLabel++;
        return label;
    }





    //TODO CHECAGEM DE RETORNO NO CHECKER
public Operador conversaoOperador(OperadorBinario operadorBinario){
        if(operadorBinario == OperadorBinario.IGUAL){
            return Operador.IGUAL;
        }else if(operadorBinario == OperadorBinario.DIFERENTE){
            return Operador.DIFERENTE;
        }else if(operadorBinario == OperadorBinario.SOMA){
            return Operador.SOMA;
        }else if(operadorBinario == OperadorBinario.SUBTRACAO){
            return Operador.SUBTRACAO;
        }else if(operadorBinario == OperadorBinario.DIVISAO){
            return Operador.DIVISAO;
        }else if(operadorBinario == OperadorBinario.MOD){
            return Operador.MOD;
        }else if(operadorBinario == OperadorBinario.MAIOR){
            return Operador.MAIOR;
        }else if(operadorBinario == OperadorBinario.MAIORIGUAL){
            return Operador.MAIORIGUAL;
        }else if(operadorBinario == OperadorBinario.MENOR){
            return Operador.MENOR;
        }else if(operadorBinario == OperadorBinario.MENORIGUAL){
            return Operador.MENORIGUAL;
        }else if(operadorBinario == OperadorBinario.OR){
            return Operador.OR;
        }else if(operadorBinario == OperadorBinario.AND){
            return Operador.AND;
        }else if(operadorBinario == OperadorBinario.MULTIPLICACAO){
            return Operador.MULTIPLICACAO;
        }
            return null;
        
}

    public Operador conversaoOperador(OperadorUnario operadorUnario){
        if(operadorUnario == OperadorUnario.MAIS){
            return Operador.MAIS;
        }else if(operadorUnario == OperadorUnario.MENOS){
            return Operador.MENOS;
        }else if(operadorUnario == OperadorUnario.NOT){
            return Operador.NOT;
        }else if(operadorUnario == OperadorUnario.DECRESCIMODIREITA){
            return Operador.DECRESCIMODIREITA;
        }else if(operadorUnario == OperadorUnario.DECRESCIMOESQUERDA){
            return Operador.DECRESCIMOESQUERDA;
        }else if(operadorUnario == OperadorUnario.INCREMENTODIREITA){
            return Operador.INCREMENTODIREITA;
        }else if(operadorUnario == OperadorUnario.INCREMENTOESQUERDA){
            return Operador.INCREMENTOESQUERDA;
        }
        return null;

    }




    public Quadrupla getHead() {
        return head;
    }
}
