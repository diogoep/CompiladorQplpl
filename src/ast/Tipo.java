package ast;

public class Tipo extends TreeNode {

    private final TipoValor tipo;
    private final String tipoEstrutura;

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
        String valor = "[";
        if (tipo == TipoValor.CONSTRUTOR){
            valor += "construtor";
        }else if(tipo == TipoValor.INTEIRO){
            valor += "int";
        }else if (tipo == TipoValor.CHAR){
            valor += "char";
        }else if (tipo == TipoValor.BOOL){
            valor += "bool";
        }else if (tipo == TipoValor.VOID){
            valor += "void";
        }else if (tipo == TipoValor.ESTRUTURA){
            valor += "estrutura: " + this.tipoEstrutura;
        }else if (tipo == TipoValor.INDETERMINADO){
            valor += "indeterminado";
        }
        valor += "]";
        return valor;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Tipo]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Nome do Tipo: " + this.tipo);
        if(tipoEstrutura.length()>0) System.out.println("Nome da Estrutura: " + this.tipoEstrutura);
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
