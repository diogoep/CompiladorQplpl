package simbol;


import ast.*;
public class InfoSemanticaExpressao {
    private Tipo tipoRetornado;     
    private Tipo escopoAtual;      

    public InfoSemanticaExpressao(){
        this.tipoRetornado = null;
        this.escopoAtual = null;
    }
    public InfoSemanticaExpressao(Tipo tipoRetornado){
        this.tipoRetornado = tipoRetornado;
        this.escopoAtual = null;
    }

    public Tipo getTipoRetornado() {
        return this.tipoRetornado;
    }

    public Tipo getEscopoAtual() {
        return this.escopoAtual;
    }

    public void setEscopoAtual(Tipo escopoAtual) {
        this.escopoAtual = escopoAtual;
    }

    public void setTipoRetornado(Tipo tipoRetornado) {
        this.tipoRetornado = tipoRetornado;
    }
}