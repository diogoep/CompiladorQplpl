package ast;

import java.util.ArrayList;

public class ChamadaMetodo extends Identificador {


    private final String identificadorFuncao;
    private final String identificadorChamador;
    private final ArrayList<Expressao> parametros;

    public ChamadaMetodo(String identificadorFuncao, String identificadorChamador) {
        this.identificadorFuncao = identificadorFuncao;
        this.identificadorChamador = identificadorChamador;
        this.parametros = new ArrayList<>();
    }

    public ChamadaMetodo(String identificadorFuncao, ArrayList<Expressao> parameters, String identificadorChamador) {
        this.identificadorFuncao = identificadorFuncao;
        this.identificadorChamador = identificadorChamador;
        this.parametros = parameters;
    }

    public String getIdentificadorFuncao() {
        return this.identificadorFuncao;
    }
    public String getIdentificadorChamador(){
        return this.identificadorChamador;
    }

    public ArrayList<Expressao> getParameters() {
        return this.parametros;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[ChamadaFuncao]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Nome: " + this.identificadorFuncao);
        System.out.println("Chamador: " + this.identificadorFuncao);

        for(Expressao e : parametros) {
            System.out.print(" ".repeat(depth*2));
            System.out.println("Parametros da Expressao:");
            e.printAtDepth(depth+1);
        }
        System.out.print(" ".repeat(depth*2));
        System.out.println("}" );

    }

    @Override
    public String getPid() {
        return this.identificadorChamador;

    }
}
