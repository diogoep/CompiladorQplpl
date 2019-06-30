package ast;

public class Condicional extends Comando {

    private final Expressao condicao;
    private final Comando codigoIf;
    private final Comando codigoElse;
    private final int local;

    //SE SO TIVER IF
    public Condicional( Expressao expressao, Comando comandoIf, int local){
        this.condicao = expressao;
        this.codigoIf = comandoIf;
        this.codigoElse = null;
        this.local = local;
    }

    //SE TIVER IF E ELSE
    public Condicional( Expressao expressao, Comando codigoIf, Comando codigoElse , int local){
        this.condicao = expressao;
        this.codigoIf = codigoIf;
        this.codigoElse = codigoElse;
        this.local = local;
    }

    public Expressao getCondicao(){
        return this.condicao;
    }

    public Comando getCodigoIf(){
        return this.codigoIf;
    }

    public Comando getCodigoElse(){
        return this.codigoElse;
    }

    public int getLocal(){
        return this.local;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Condicional]:  {");

        System.out.print(" ".repeat(depth*2));
        condicao.printAtDepth(depth+1);
        System.out.print(" ".repeat(depth*2));
        codigoIf.printAtDepth(depth+1);

        if(codigoElse != null) {
            System.out.print(" ".repeat(depth * 2));
            codigoElse.printAtDepth(depth + 1);
            System.out.print(" ".repeat(depth * 2));
        }
        System.out.println("}");
    }

}