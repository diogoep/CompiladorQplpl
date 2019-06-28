package ast;

import java.util.ArrayList;

public class Bloco extends Comando {

    private final ArrayList<DeclaracaoVariavel> definicoes;
    private final ArrayList<Comando> comandos;

    public Bloco(ArrayList<DeclaracaoVariavel> definicoes, ArrayList<Comando> comandos) {
        this.definicoes = definicoes;
        this.comandos = comandos;
    }

    public Bloco() {
        this.definicoes = new ArrayList<DeclaracaoVariavel>();
        this.comandos = new ArrayList<Comando>();
    }

    public ArrayList<DeclaracaoVariavel> getDefinicoes(){
        return this.definicoes;
    }

    public ArrayList<Comando> getComandos(){
        return this.comandos;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Bloco]: {");

        System.out.print(" ".repeat(depth*2));
        for (DeclaracaoVariavel d: definicoes ) {
            d.printAtDepth(depth+1);
        }
        System.out.print(" ".repeat(depth*2));

        for (Comando c: comandos) {
            c.printAtDepth(depth+1);
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
