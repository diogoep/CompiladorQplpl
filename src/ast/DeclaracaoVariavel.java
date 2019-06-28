package ast;

public class DeclaracaoVariavel extends Declaracao {
    private final String identificadorVariavel;
    private final Expressao expressao;
    private final Tipo tipo;
    private final int local;

    private final String tipoEstrutura;
    //tipo pode ser int, char, string e tals.
    //mas precisamos representar tambem as estruturas


    public DeclaracaoVariavel(Tipo tipo, String identificadorVariavel, int local) {
        this.tipoEstrutura = "";
        this.tipo = tipo;
        this.identificadorVariavel = identificadorVariavel;
        this.expressao = null; // cuida da inicializacao sem valor
        this.local = local;
    }

    public DeclaracaoVariavel(Tipo tipo, String identificadorVariavel, Expressao expressao, int local) {
        this.tipoEstrutura = "";
        this.tipo = tipo;
        this.identificadorVariavel = identificadorVariavel;
        this.expressao = expressao;
        this.local = local;
    }


    public DeclaracaoVariavel(boolean constante, Tipo tipo, boolean qualificador, String identificadorVariavel, Expressao expressao, int local){
        this.tipo = tipo;
        this.tipoEstrutura = "";
        this.identificadorVariavel = identificadorVariavel;
        this.expressao = expressao;
        this.local = local;
    }



    public String getTipoEstrutura(){
        return this.tipoEstrutura;
    }


    public String getIdentificadorVariavel() {
        return this.identificadorVariavel;
    }

    public Expressao getExpressao() {
        return this.expressao;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[DeclaracaoVariavel]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Nome: " + this.identificadorVariavel + ", Tipo: " + this.tipo);

        if(expressao != null){
            System.out.print(" ".repeat(depth*2));
            expressao.printAtDepth(depth+1);
            System.out.println("Expressao: ");

        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
