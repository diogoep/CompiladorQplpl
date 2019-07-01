package ast;

public class ExpressaoNomeada extends Expressao {

    private final Identificador identificador;
    private final int local;

    public ExpressaoNomeada(Identificador identificador, int local) {
        this.identificador = identificador;
        this.local = local;
    }

    public Identificador getIdentificador() {
        return this.identificador;
    }

    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Expressao Nomeada]: ");
        identificador.printAtDepth(depth+1);
    }
}