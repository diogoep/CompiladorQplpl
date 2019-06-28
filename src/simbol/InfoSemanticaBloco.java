package simbol;


import ast.*;


public class InfoSemanticaBloco {


    private boolean garanteRetorno; 
    private boolean dentroLaco;    
    private Tipo tipoRetorno;


    public InfoSemanticaBloco(Tipo tipoRetorno){
        this.garanteRetorno = false;
        this.dentroLaco = false;
        this.tipoRetorno = tipoRetorno;
    }

    public InfoSemanticaBloco(boolean dentroLaco, Tipo tipoRetorno){
        this.garanteRetorno = false;
        this.dentroLaco = dentroLaco;
        this.tipoRetorno = tipoRetorno;
    }

    
    public InfoSemanticaBloco(InfoSemanticaBloco other){
        this.garanteRetorno = false;
        this.dentroLaco = other.dentroLaco();
        this.tipoRetorno = other.getTipoRetorno();
    }


    public boolean garanteRetorno() {
        return this.garanteRetorno;
    }

    public boolean dentroLaco() {
        return this.dentroLaco;
    }

    public Tipo getTipoRetorno() {
        return this.tipoRetorno;
    }

    public void setGaranteRetorno(boolean garanteRetorno) {
        this.garanteRetorno = garanteRetorno;
    }

    public void setDentroLaco(boolean dentroLaco) {
        this.dentroLaco = dentroLaco;
    }

    public void setTipoRetorno(Tipo tipoRetorno) {
        this.tipoRetorno = tipoRetorno;
    }
}