package ast;
import java.util.ArrayList;

public class ParametroFormal extends TreeNode {
    private final ArrayList<DeclaracaoVariavel> parametros;

    public ParametroFormal(){
        this.parametros = new ArrayList<>();
    }

    public ParametroFormal(ArrayList<DeclaracaoVariavel> parametros) {
        this.parametros = parametros;
    }

    public ArrayList<DeclaracaoVariavel> getParametros() {
        return this.parametros;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Parametros Formais]: {");

        for(DeclaracaoVariavel e : parametros) {
            System.out.print(" ".repeat(depth*2));
            System.out.println("Parametros da Expressao:");
            e.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
