package ast;

import java.util.ArrayList;
public class Codigo extends TreeNode{
    private final ArrayList<Declaracao> declaracoes;

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Codigo]");
        for(Declaracao s : this.declaracoes) {
            s.printAtDepth(depth+1);
        }
    }

    public Codigo(ArrayList<Declaracao> s) {
        this.declaracoes = s;
    }

    public Codigo(){
        this.declaracoes = new ArrayList<>();
    }

    public ArrayList<Declaracao> getS() {
        return this.declaracoes;
    }

}
