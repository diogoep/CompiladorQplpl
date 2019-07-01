package ast;

import java.util.ArrayList;

public class ChamadaVariavel extends Identificador {
    private final String identificadorFuncao;
    private final Identificador proximo;
    private final int local;

    public ChamadaVariavel(String identificadorFuncao, int local) {
        this.identificadorFuncao = identificadorFuncao;
        this.proximo = null;
        this.local = local;
    }

    public ChamadaVariavel(String identificadorFuncao, Identificador proximo, int local) {
        this.identificadorFuncao = identificadorFuncao;
        this.proximo = proximo;
        this.local = local;
    }

    public String getIdentificadorFuncao() {
        return this.identificadorFuncao;
    }
    public Identificador getProximo() {
        return this.proximo;
    }
    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Chamada de Variavel]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Identificador: " + this.identificadorFuncao);

        if(proximo != null){
            System.out.print(" ".repeat(depth*2));
            proximo.printAtDepth(depth+1);
            System.out.print(" ".repeat(depth*2));
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
