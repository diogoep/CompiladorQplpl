package ast;

public class ComandoExpressao extends Comando {
    private final Expressao expressao;
    private final int local;

    public ComandoExpressao(Expressao expressao, int local) {
        this.expressao = expressao;
        this.local = local;
    }

    public Expressao getExpressao() {
        return this.expressao;
    }
    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));

        System.out.println("[Comand Expression] ");
        expressao.printAtDepth(depth+1);
    }
}

/*


    public ExpressaoBinaria(Expressao left, String operador, Expressao right) {
        this.esq = left;
        this.operador = toOperador(operador);
        this.dir = right;
    }


private OperadorBinario toOperador(String s){
        if(s.equals("+"))  return OperadorBinario.MAIS;
        if(s.equals("-"))  return OperadorBinario.MENOS;
        if(s.equals("*"))  return OperadorBinario.VEZES;
        if(s.equals("/"))  return OperadorBinario.DIV;
        if(s.equals("==")) return OperadorBinario.IGUAL;
        if(s.equals("<"))  return OperadorBinario.MENOR;
        if(s.equals("<=")) return OperadorBinario.MENORIGUAL;
        if(s.equals(">"))  return OperadorBinario.MAIOR;
        if(s.equals(">=")) return OperadorBinario.MAIORIGUAL;
        if(s.equals("!=")) return OperadorBinario.DIFERENTE;
        if(s.equals("%"))  return OperadorBinario.MODULO;
        if(s.equals("&&")) return OperadorBinario.AND;
        if(s.equals("||")) return OperadorBinario.OR;
        else return OperadorBinario.DIFERENTE;
    }





 */