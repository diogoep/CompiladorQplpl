package simbol;


import ast.*;


public class InfoBloco {


    private boolean garanteRetorno; //saber se esse bloco tem retorna concert
    private boolean dentroLaco;     //saber se pode usar um break
    private Tipo tipoRetorno;       //vc ta dentro de uma funcao, entao vc precisa saber o tipo da funcao. Caso voce use um return


    public InfoBloco(Tipo tipoRetorno){
        this.garanteRetorno = false;
        this.dentroLaco = false;
        this.tipoRetorno = tipoRetorno;
    }

    public InfoBloco(boolean dentroLaco, Tipo tipoRetorno){
        this.garanteRetorno = false;
        this.dentroLaco = dentroLaco;
        this.tipoRetorno = tipoRetorno;
    }

    
    public InfoBloco(InfoBloco outro){
        this.garanteRetorno = false;
        this.dentroLaco = outro.dentroLaco();
        this.tipoRetorno = outro.getTipoRetorno();
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