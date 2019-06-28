package ast;

public class LiteralFloat extends Expressao {
    private double conteudo;
    private final int local;

    public LiteralFloat(String conteudo, int local) {
        this.conteudo = Double.valueOf(conteudo);
        this.local = local;
    }

    public LiteralFloat(int conteudo, int local) {
        this.conteudo = conteudo;
        this.local = local;
    }

    public double getConteudo(){
        return this.conteudo;
    }

    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[FloatLiteral]: " + this.conteudo);
    }

}
