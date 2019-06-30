package intermediary;

public class Quadrupla {
    private final Operador operador;
    private final String argumento1;
    private final String argumento2;
    private final String destino;
    private Quadrupla proximo;
    //ou cauda
    private Quadrupla tail;

    public Quadrupla(Operador operador, String argumento1, String argumento2, String destino, Quadrupla proximo){
        this.operador = operador;
        this.argumento1 = argumento1;
        this.argumento2 = argumento2;
        this.destino = destino;
        this.proximo = proximo;
        this.tail = this;
    }

    public Quadrupla(Operador operador, String argumento1, String argumento2, String destino){
        this.operador = operador;
        this.argumento1 = argumento1;
        this.argumento2 = argumento2;
        this.destino = destino;
        this.proximo = null;
        this.tail = this;
    }

    public void join(Quadrupla outra){
        if(outra == null){
            return;
        }
        //cauda do ultimo elemento da primeira lista é mudado
        this.tail.proximo = outra;
        //cauda da quadrupla atual vira a cauda da segunda quadrupla
        this.tail = outra.tail;
    }

    public Quadrupla getFinalLista() {
        return tail;
    }

    public void setFinalLista(Quadrupla finalLista) {
        this.tail = finalLista;
    }

    public Quadrupla getProximo() {
        return proximo;
    }

    public void setProximo(Quadrupla proximo) {
        this.proximo = proximo;
    }
    public Operador getOperador() {
        return operador;
    }

    public String getArgumento1() {
        return argumento1;
    }

    public String getArgumento2() {
        return argumento2;
    }

    public String getDestino() {
        return destino;
    }

    public String toString(){
        String r = "[";
        if(operador == Operador.MULTIPLICACAO){
            r += destino+ " := " + argumento1 + " * " + argumento2;
        }else if(operador== Operador.SOMA){
            r += destino+ " := " + argumento1 + " + " + argumento2;
        }else if(operador== Operador.SUBTRACAO){
            r += destino+ " := " + argumento1 + " - " + argumento2;
        }else if(operador== Operador.DIVISAO){
            r += destino+ " := " + argumento1 + " / " + argumento2;
        }else if(operador== Operador.MOD){
            r += destino+ " := " + argumento1 + " % " + argumento2;
        }else if(operador== Operador.GOTO){
            r += "GOTO " + destino;
        }else if(operador== Operador.IFGOTO){
            r += "IF " + argumento1 + " GOTO " + destino;
        }else if(operador== Operador.IFFALSEGOTO){
            r += "IFNOT " + argumento1 + " GOTO " + destino;
        }else if(operador== Operador.ATRIBUICAO){
            r += destino+ " := " + argumento1 ;
        }else if(operador== Operador.IGUAL){
            r += destino+ " := " + argumento1 + " == " + argumento2;
        }else if(operador== Operador.DIFERENTE){
            r += destino+ " := " + argumento1 + " != " + argumento2;
        }else if(operador== Operador.MENORIGUAL){
            r += destino+ " := " + argumento1 + " <= " + argumento2;
        }else if(operador== Operador.MAIORIGUAL){
            r += destino+ " := " + argumento1 + " >= " + argumento2;
        }else if(operador== Operador.MENOR){
            r += destino+ " := " + argumento1 + " < " + argumento2;
        }else if(operador== Operador.MAIOR){
            r += destino+ " := " + argumento1 + " > " + argumento2;
        }else if(operador== Operador.AND){
            r += destino+ " := " + argumento1 + " && " + argumento2;
        }else if(operador== Operador.OR){
            r += destino+ " := " + argumento1 + " || " + argumento2;
        }else if(operador== Operador.LABEL){
            r += "LABEL " + destino;
        }else if(operador== Operador.MAIS){
            r += destino+" := +" + argumento1 ;
        }else if(operador== Operador.MENOS){
            r += destino+" := -" + argumento1 ;
        }else if(operador== Operador.NOT){
            r += destino+" := NOT " + argumento1 ;
        }
        return r + "]";
    }

    public String mostrarCodigo(){
        String resultado = "";
        Quadrupla quadruplaAtual = this;
        while(quadruplaAtual != null){
            resultado+= quadruplaAtual + "\ṇ̣";
            quadruplaAtual = quadruplaAtual.proximo;
        }
        return resultado;
    }
}
