package ast;

public class LiteralInteiro extends Expressao {
    private final int conteudo;
    private final int local;

        public LiteralInteiro(String conteudo, int local) {
        this.conteudo = Integer.valueOf(conteudo);
        this.local = local;
    }

    public LiteralInteiro(int conteudo, int local) {
        this.conteudo = conteudo;
        this.local = local;
    }

    public int getConteudo() {
        return this.conteudo;
    }

    public int getLocal(){
            return this.local;
        }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Literal Inteiro]: " + this.conteudo);
    }
}
