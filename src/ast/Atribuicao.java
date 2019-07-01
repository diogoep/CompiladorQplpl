package ast;

public class Atribuicao extends Comando {
    //final quer dizer que não pode mudar, e que deve ter um valor atribuido sempre que declarado
    private final Identificador identificador;
    private final Expressao expressao;
    private final int local;

    public Atribuicao(Identificador varid, Expressao expressao, int local) {
        this.identificador = varid;
        this.expressao = expressao;
        this.local = local;
    }

    public Identificador getIdentificador() {
        return this.identificador;
    }
    public Expressao getExpressao() {
        return this.expressao;
    }
    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Atribuicao De Variavel]: {");

        identificador.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));

        System.out.println("Expressao:");
        expressao.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}