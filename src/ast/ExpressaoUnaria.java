package ast;

public class ExpressaoUnaria extends Expressao {
    private final OperadorUnario operador;
    private final Expressao expressao;
    private final int local;

    public ExpressaoUnaria(OperadorUnario operator, Expressao expr, int local) {
        this.operador = operator;
        this.expressao = expr;
        this.local = local;
    }

    public OperadorUnario getOperador() {
        return this.operador;
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
        System.out.println("[ExpressaoUnaria] " + this.expressao);
        expressao.printAtDepth(depth+1);
    }
}
