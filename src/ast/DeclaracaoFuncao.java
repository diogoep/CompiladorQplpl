package ast;

import java.util.ArrayList;

public class DeclaracaoFuncao extends Declaracao {
    private final String identificadorFuncao;
    private final ParametroFormal parametros;
    private final Bloco bloco;
    private final Tipo tipo;
    private final int local;

    public DeclaracaoFuncao(Tipo tipo, String identificadorFuncao, ParametroFormal parametros, int local) {
        this.tipo = tipo;
        this.identificadorFuncao = identificadorFuncao;
        this.parametros = parametros;
        this.bloco = new Bloco();
        this.local = local;
    }

    public DeclaracaoFuncao(Tipo tipo, String identificadorFuncao, ParametroFormal parameters, Bloco block, int local) {
        this.tipo = tipo;
        this.identificadorFuncao = identificadorFuncao;
        this.parametros = parameters;
        this.bloco = block;
        this.local = local;

    }

    public String getIdentificadorFuncao() {
        return this.identificadorFuncao;
    }

    public ParametroFormal getParametros() {
        return this.parametros;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public Bloco getBloco() {
        return this.bloco;
    }
    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Declaracao Funcao]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Identificador: " + this.identificadorFuncao + ", Tipo: " + this.tipo);

        parametros.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));
        System.out.println("Bloco:");
        bloco.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
