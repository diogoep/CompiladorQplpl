package ast;

import java.util.ArrayList;

public class EstrutAcesso extends TreeNode {





    private final TipoAcesso acesso;
    private final ArrayList<Declaracao> membros;
    private final int local;

    public EstrutAcesso(TipoAcesso acesso, ArrayList<Declaracao> membros, int linha) {
        this.acesso = acesso;
        this.membros = membros;
        this.local = linha;
    }

    public TipoAcesso getAcesso() {
        return acesso;
    }

    public ArrayList<Declaracao> getMembros() {
        return membros;
    }

    public int getLinha(){return local;}

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Chamada Funcao]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Tipo de acesso: " + acesso);


        for(Declaracao me : membros){
            System.out.print(" ".repeat(depth*2));
            me.printAtDepth(depth+1);
            System.out.print(" ".repeat(depth*2));
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
