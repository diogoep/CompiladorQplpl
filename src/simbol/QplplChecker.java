package simbol;

import ast.*;
import java.util.ArrayList;

public class QplplChecker{
        private Codigo codigo;
        private TabelaSimbolos tabelaGlobal;
        private ArrayList<Erro> erros;

        public QplplChecker(Codigo codigo){
            this.codigo = codigo;
        }

        public void check(){
            this.tabelaGlobal = new TabelaSimbolos();
            this.erros = new ArrayList<>();
        }

        public void visit(Codigo codigo, TabelaSimbolos tabelaSimbolos){
            for(Declaracao declaracao: codigo.getDeclaracoes()){
                visit(declaracao, tabelaSimbolos);
            }
        }
        public void visit(Declaracao declaracao, TabelaSimbolos tabelaSimbolos){
            if(declaracao instanceof DeclaracaoVariavel){
                visit((DeclaracaoVariavel) declaracao, tabelaSimbolos);
            }else if(declaracao instanceof DeclaracaoFuncao){
                visit((DeclaracaoFuncao) declaracao, tabelaSimbolos);
            }
        }

        public void visit(DeclaracaoFuncao declaracaoFuncao, TabelaSimbolos tabelaSimbolos) {
            SimboloFuncao simboloFuncao = new SimboloFuncao(declaracaoFuncao.getTipo(), declaracaoFuncao.getIdentificadorFuncao());
            TabelaSimbolos tabelaBloco = new TabelaSimbolos(tabelaSimbolos);

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
            if(!tabelaSimbolos.adicionarSimbolo(simboloFuncao, erro)){
                erros.add(erro);
            }
            visit(declaracaoFuncao.getBloco(), tabelaBloco);
        }


        public void visit(Bloco bloco, TabelaSimbolos tabelaSimbolos){


        }










        }























