package ast;

public class ComandoExpressao extends Comando {
    private final Expressao expressao;
    private final int local;

    public ComandoExpressao(Expressao expressao, int local) {
        this.expressao = expressao;
        this.local = local;
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

        System.out.println("[Comando Expressão] ");
        expressao.printAtDepth(depth+1);
    }
}