package ast;

import java.util.ArrayList;

public class Entrada extends Comando {

    private final ArrayList<Expressao> parametros;
    private final int local;


    public Entrada(int local) {
        this.parametros = new ArrayList<>();
        this.local = local;
    }

    public Entrada(ArrayList<Expressao> parameters, int local) {
        this.parametros = parameters;
        this.local = local;
    }

    public ArrayList<Expressao> getParametros() {
        return parametros;
    }

    public int getLocal(){
        return local;}

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Entrada]: {");


        for(Expressao e : parametros) {
            System.out.print(" ".repeat(depth*2));
            System.out.println("Parametros de Entrada:");
            e.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
