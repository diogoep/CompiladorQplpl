package ast;
public class LiteralChar extends Expressao {
    private final char conteudo;

    public LiteralChar(String text, int local) {
        conteudo = text.charAt(1);
    }

    public LiteralChar(char value, int local) {
        this.conteudo = value;
    }

    public char getConteudo() {
        return conteudo;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Literal Char]: " + this.conteudo);
    }


}


