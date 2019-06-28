package ast;

public class Qualificador extends TreeNode {

    private final boolean constante;
    private final boolean estatico;


    public Qualificador(boolean constante, boolean estatico) {
        this.constante = constante;
        this.estatico = estatico;

    }

    public boolean eConstante() {
        return this.constante;
    }

    public boolean eEstatico() {
        return this.estatico;
    }


    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Qualificador]: {");

        if(eConstante()) {
            System.out.println("Constante");
        }else if(eEstatico()) {
            System.out.println("Estatico");
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
