package ast;

public class ComandoRepeticao extends Comando {
    private final Expressao condicao;
    private final Comando comando;
    private final int local;


    public ComandoRepeticao(Expressao condicao, Comando comand, int local) {
        this.condicao = condicao;
        this.comando = comand;
        this.local = local;
    }

    public Expressao getCondicao() {
        return this.condicao;
    }

    public Comando getComando(){
        return this.comando;
    }

    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Comando Repeticao]: {");

        condicao.printAtDepth(depth+1);
        System.out.print(" ".repeat(depth*2));
        comando.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));
        System.out.println("}" );

    }
}
