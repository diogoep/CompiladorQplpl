package ast;

public class DeclaracaoAtributo extends Declaracao {

    private final boolean constante;
    private final boolean estatico;
    private final String atributoId;
    private final Expressao expressao;
    private final Tipo tipo;
    private final int local;

    //tipo pode ser int, char, string e tals.
    //mas precisamos representar tambem as estruturas

    public DeclaracaoAtributo(boolean constante, boolean estatico, DeclaracaoVariavel variavel) {
        this.constante = constante;
        this.estatico = estatico;
        this.tipo = variavel.getTipo();

        this.atributoId = variavel.getIdentificadorVariavel();
        this.expressao = variavel.getExpressao();
        this.local = variavel.getLocal();
    }

    public DeclaracaoAtributo(Qualificador qualificador, DeclaracaoVariavel variavel) {
        this.constante = qualificador.eConstante();
        this.estatico = qualificador.eEstatico();
        this.tipo = variavel.getTipo();

        this.atributoId = variavel.getIdentificadorVariavel();
        this.expressao = variavel.getExpressao();
        this.local = variavel.getLocal();
    }

    public boolean getEConstante(){
        return constante;
    }

    public String getAtributoId(){
        return this.atributoId;
    }

    public Expressao getExpressao() {
        return this.expressao;
    }

    public Tipo getTipo(){
        return this.tipo;
    }

    public int getLocal(){
        return this.local;
    }

    public boolean eConstante() {
        return constante;
    }

    public boolean eEstatico() {
        return estatico;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Declaracao Atributo]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Identificador: " + this.atributoId + ", Tipo: " + this.tipo);

        if(this.expressao != null){
            System.out.print(" ".repeat(depth*2));
            System.out.println("Expressao:");
            expressao.printAtDepth(depth+1);


        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
