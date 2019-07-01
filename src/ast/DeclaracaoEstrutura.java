package ast;

import java.util.ArrayList;

public class DeclaracaoEstrutura extends Declaracao {
    private final String identificador ;
    private final ArrayList<DeclaracaoEstrutura> acessos;
    private final int local;

    public DeclaracaoEstrutura(String identificador, ArrayList<DeclaracaoEstrutura> acessos, int local) {
        this.identificador = identificador;
        this.acessos = acessos;
        this.local = local;
    }



    public String getIdentificador() {
        return this.identificador;
    }

    public int getLocal(){
        return this.local;
    }

    public ArrayList<DeclaracaoEstrutura> getAcessos() {
        return this.acessos;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Declaracao Estrutura]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Identificador:" + this.identificador);

        for(DeclaracaoEstrutura ea : this.acessos){
            ea.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
