package ast;

import java.util.ArrayList;

public class Resultado extends Comando {
    private final ArrayList<Expressao> parametros;
    private final int local;


    public Resultado(int local) {
        this.parametros = new ArrayList<>();
        this.local = local;
    }

    public Resultado(ArrayList<Expressao> parameters, int local) {
        this.parametros = parameters;
        this.local = local;
    }

    public ArrayList<Expressao> getParametros() {
        return this.parametros;
    }

    public int getLocal(){
        return this.local;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Resultado]: {");


        for(Expressao e : parametros) {
            System.out.print(" ".repeat(depth*2));
            System.out.println("Parametros de Resultados:");
            e.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
