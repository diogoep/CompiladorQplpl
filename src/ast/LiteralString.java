package ast;

public class LiteralString extends Expressao {
    private final String conteudo;
    private final int local;

    public LiteralString(String conteudo, int local) {
        this.conteudo = conteudo;
        this.local = local;
    }

    public String getConteudo() {
        return this.conteudo;
    }
    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Literal String]: " + this.conteudo);
    }
}
