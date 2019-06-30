/*package simbol;

import ast.*;

public class BuscaSimbolo {
    private Simbolo resposta;
    private String identificador;
    private  CategoriaEnum categoria;
    private Assinatura parametros;

    public BuscaSimbolo(String identificador){
        this.identificador = identificador;
        this.parametros = new Assinatura(new Tipo(TipoValor.FUNCAO), TipoAcessoS.PUBLICO);
        this.categoria = CategoriaEnum.VARIAVEL;
    }


    public BuscaSimbolo(String identificador, Assinatura parametros){
        this.identificador = identificador;
        this.parametros = parametros;
        this.categoria = CategoriaEnum.FUNCAO;
    }

    public Simbolo buscar(TabelaSimbolos tabAtual, MensagemErro mErro){
        Simbolo r = tabAtual.getSimbolo(this.identificador, mErro);
        if(r == null){
            if(tabAtual.getPai() == null){
                resposta = null;
                return null;
            }else{
                return resposta = buscar(tabAtual.getPai(), mErro);
            }
        }else{
            if(r.getCategoria() == CategoriaEnum.VARIAVEL || r.getCategoria() == CategoriaEnum.ATRIBUTO){
                if(categoria == CategoriaEnum.VARIAVEL){
                    resposta = r;
                    return r;
                }else{
                    mErro.setMensagem("Um simbolo [" + this.identificador + "] ja foi declarado como atributo (l." + r.getLocal() + ")");

                    return resposta = null;
                }
            }else{
                if(r.buscaParametros(parametros)){
                    return resposta = r;
                }else{
                    mErro.setMensagem("[" + this.identificador +"] nao possui os parametros compativeis com " + this.parametros);
                    return resposta = null;
                }
            }
        }
    }

    public String getIdentificador() {
        return this.identificador;
    }


    public Simbolo getResposta() {
        return this.resposta;
    }

    public CategoriaEnum getCategoria() {
        return this.categoria;
    }

}*/