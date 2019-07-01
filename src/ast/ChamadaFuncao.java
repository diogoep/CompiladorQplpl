package ast;

public class ChamadaFuncao extends Identificador {

    private final String id;
    private final Identificador proximo;
    private final ParametroReal parametros;
    private final int local;

    public ChamadaFuncao(String id, int local) {
        this.id = id;
        this.parametros = new ParametroReal();
        this.proximo = null;
        this.local = local;
    }

    public ChamadaFuncao(String id, ParametroReal parameters, int linha) {
        this.id = id;
        this.parametros = parameters;
        this.proximo = null;
        this.local = linha;
    }

    public ChamadaFuncao(String id, ParametroReal parameters, Identificador proximo, int local) {
        this.id = id;
        this.parametros = parameters;
        this.proximo = proximo;
        this.local = local;
    }

    public String getId() {
        return this.id;
    }

    public int getLocal() {
        return this.local;
    }

    public ParametroReal getParametros() {
        return this.parametros;
    }

    public Identificador getProximo() {
        return proximo;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Chamada Funcao]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Identificador: " + id);

        parametros.printAtDepth(depth+1);

        if(proximo != null){
            System.out.print(" ".repeat(depth*2));
            proximo.printAtDepth(depth+1);
            System.out.print(" ".repeat(depth*2));
        }

        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }

}
