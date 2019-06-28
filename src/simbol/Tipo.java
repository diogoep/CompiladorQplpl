package simbol;

import ast.TipoValor;
import ast.TreeNode;

public class Tipo extends TreeNode {

    private final TipoValor tipo;
    private final String tipoEstrutura;


    //tipo pode ser int, char, string e tals.
    //mas precisamos representar tambem as estruturas

    public Tipo(TipoValor tipo) {
        this.tipoEstrutura = "";
        this.tipo = tipo;
    }

    public Tipo(TipoValor tipo, String tipoEstrutura) {
        this.tipoEstrutura = tipoEstrutura;
        this.tipo = tipo;
    }

    public TipoValor getTipo(){
        return tipo;
    }

    public String getTipoEstrutura(){
        return tipoEstrutura;
    }

    @Override
    public String toString() {
        //INICIO EXPRESSAO
        String valor = "[";
        if (tipo == TipoValor.CONSTRUTOR){
            valor += "construtor";
        }else if(tipo == TipoValor.INTEIRO){
            valor += "int";
        }else if (tipo == TipoValor.CHAR){
            valor += "bool";
        }else if (tipo == TipoValor.BOOL){
            valor += "char";
        }else if (tipo == TipoValor.VOID){
            valor += "void";
        }else if (tipo == TipoValor.ESTRUTURA){
            valor += "estrutura: " + this.tipoEstrutura;
        }
        valor += "]";
        //FINAL EXPRESSAO
        return valor;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Type]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Name: " + this.tipo);
        if(tipoEstrutura.length()>0) System.out.println("NameStruct: " + this.tipoEstrutura);
        System.out.print(" ".repeat(depth*2));

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }

    public boolean equals(Tipo outro){
        //SE OS TIPOS FOREM DIFERENTES
        if(this.tipo != outro.getTipo()){
            return false;
        }
        // SE AMBAS NAO FOREM ESTRUTURAS
        if(this.tipo != TipoValor.ESTRUTURA) {
            return true;
        }
        //SE AMBAS TIVEREM ESTRUTURA, ABAIXO ELE COMPARA
        return this.tipoEstrutura.equals(outro.getTipoEstrutura());
    }
}
