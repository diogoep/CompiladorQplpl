package ast;

public class Break extends Comando {
    private final int local;

    public Break(int local) {
        this.local = local;
    }

    public int getLocal(){return local;}
    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Break]: {");


        System.out.print(" ".repeat(depth*2));
        System.out.println("}" );

    }
}
