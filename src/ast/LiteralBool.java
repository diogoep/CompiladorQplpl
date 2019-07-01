package ast;

public class LiteralBool extends Expressao {
    private final boolean conteudo;
    private final int local;

    public LiteralBool(String conteudo, int local) {
        this.conteudo = conteudo.equals("true");
        this.local = local;
    }

    public LiteralBool(boolean conteudo, int local) {
        this.conteudo = conteudo;
        this.local = local;
    }

    public int getLocal(){
        return this.local;
    }

    public boolean getConteudo() {
        return this.conteudo;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Literal Bool]: " + this.conteudo);
    }
}
