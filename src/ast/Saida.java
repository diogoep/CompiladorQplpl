package ast;

import java.util.ArrayList;

public class Saida extends Comando {
    private final ArrayList<Expressao> parametros;
    private final int local;


    public Saida(int local) {
        this.parametros = new ArrayList<>();
        this.local = local;
    }

    public Saida(ArrayList<Expressao> parameters, int local) {
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
        System.out.println("[Saida]: {");


        for(Expressao e : parametros) {
            System.out.print(" ".repeat(depth*2));
            System.out.println("Parametros de Resultados:");
            e.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
