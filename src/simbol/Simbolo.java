package simbol;

import ast.Tipo;

public class Simbolo {
    //variavel(constante também) e funcao é simbolo
    private Tipo tipo; //tipo de retorno  ou tipo de variavel
    private  String identificador;

    public Simbolo(){
    }

    public Simbolo(Tipo tipo, String identificador){
        this.tipo = tipo;
        this.identificador = identificador;
    }
    public String getIdentificador() {
        return identificador;
    }

    public void setIdentificador(String identificador) {
        this.identificador = identificador;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public void setTipo(Tipo tipo) {
        this.tipo = tipo;
    }

}
