package ast;

public class Atribuicao extends Comando {
    //final quer dizer que não pode mudar, e que deve ter um valor atribuido sempre que declarado
    private final Identificador variavel;
    private final Expressao expressao;
    private final int local;

    public Atribuicao(Identificador varid, Expressao expressao, int local) {
        this.variavel = varid;
        this.expressao = expressao;
        this.local = local;
    }

    public Identificador getVariavel() {
        return this.variavel;
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
        System.out.println("[AtribuicaoDeVariavel]: {");

        variavel.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));

        System.out.println("Expressao:");
        expressao.printAtDepth(depth+1);

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}


//fodase