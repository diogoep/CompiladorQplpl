package simbol;

import ast.Tipo;

public class Parametro {
    private Tipo tipo;
    private String identificador;

    public Tipo getTipo() {
        return tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

    public Parametro(Tipo tipo, String identificador){
        this.tipo = tipo;
        this.identificador = identificador;
    }

    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }


}
