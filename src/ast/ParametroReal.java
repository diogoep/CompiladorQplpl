package ast;

import java.util.ArrayList;

public class ParametroReal extends TreeNode {
    private final ArrayList<Expressao> parametros;


    public ParametroReal() {
        this.parametros = new ArrayList<>();
    }

    public ParametroReal(ArrayList<Expressao> parametros){
        this.parametros = parametros;
    }


    public ArrayList<Expressao> getParametros() {
        return this.parametros;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Parametros Reais]: {");


        for(Expressao e : parametros) {
            System.out.print(" ".repeat(depth*2));
            System.out.println("Parameters da Expressao:");
            e.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
