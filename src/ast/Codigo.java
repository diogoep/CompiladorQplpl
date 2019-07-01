package ast;

import java.util.ArrayList;
public class Codigo extends TreeNode {
    private final ArrayList<Declaracao> declaracoes;

    public Codigo(ArrayList<Declaracao> declaracoes) {
        this.declaracoes = declaracoes;
    }

    public Codigo(){
        this.declaracoes = new ArrayList<>();
    }

    public ArrayList<Declaracao> getDeclaracoes() {
        return this.declaracoes;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Codigo]");
        for(Declaracao declaracao : this.declaracoes) {
            declaracao.printAtDepth(depth+1);
        }
    }
}
