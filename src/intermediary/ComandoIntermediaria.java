package intermediary;

public class ComandoIntermediaria {

    private Quadrupla inicio;
    private Quadrupla fim;

    public ComandoIntermediaria(Quadrupla inicio, Quadrupla fim){
        this.inicio = inicio;
        this.fim = fim;
    }

    public ComandoIntermediaria(){
        inicio = null;
        fim = null;
    }


    public void merge(ComandoIntermediaria outro){
        if(inicio == null){
            this.inicio = outro.getInicio();
            this.fim  = outro.getFim();
        }else if(outro.getFim() != null) {
            fim.setProximo(outro.getInicio());
            this.fim = outro.getFim();
        }
    }

    public void addQuadrupla(Quadrupla q){
        if(inicio == null){
            inicio = q;
            fim  = q;
        }else {
            this.fim.setProximo(q);
            this.fim = q;
        }
    }

    public Quadrupla getInicio() {
        return this.inicio;
    }

    public void setInicio(Quadrupla inicio) {
        this.inicio = inicio;
    }

    public Quadrupla getFim() {
        return this.fim;
    }

    public void setFim(Quadrupla fim) {
        this.fim = fim;
    }
}
