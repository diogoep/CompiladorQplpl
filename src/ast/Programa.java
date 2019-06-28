package ast;

import java.util.ArrayList;
public class Programa extends TreeNode {
    private final ArrayList<Declaracao> declaracoes;

    public Programa(ArrayList<Declaracao> declaracoes) {
        this.declaracoes = declaracoes;
    }

    public Programa(){
        this.declaracoes = new ArrayList<>();
    }

    public ArrayList<Declaracao> getDeclaracoes() {
        return this.declaracoes;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Programa]");
        for(Declaracao s : this.declaracoes) {
            s.printAtDepth(depth+1);
        }
    }
}
