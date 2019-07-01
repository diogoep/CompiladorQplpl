package ast;

public class DeclaracaoMetodo extends Declaracao {
    private final boolean constante;
    private final boolean estatico;
    private final String identificadorMetodo;
    private final ParametroFormal parametros;
    private final Bloco bloco;
    private final Tipo tipo;
    private final int local;

    public DeclaracaoMetodo(boolean constante, boolean estatico, DeclaracaoFuncao funcao) {
        this.constante = constante;
        this.estatico = estatico;
        this.tipo = funcao.getTipo();
        this.identificadorMetodo = funcao.getIdentificadorFuncao();
        this.bloco = funcao.getBloco();
        this.local = funcao.getLocal();
        this.parametros = funcao.getParametros();
    }

    public DeclaracaoMetodo(Qualificador qualificador, DeclaracaoFuncao funcao) {
        this.constante = qualificador.eConstante();
        this.estatico = qualificador.eEstatico();
        this.tipo = funcao.getTipo();

        this.identificadorMetodo = funcao.getIdentificadorFuncao();
        this.bloco = funcao.getBloco();
        this.local = funcao.getLocal();
        this.parametros = funcao.getParametros();
    }


    public boolean getEConstante()  {
        return constante;
    }

    public Tipo getTipo() {
        return this.tipo;
    }

    public int getLocal(){
        return this.local;
    }
    public String getIdentificadorMetodo() {
        return this.identificadorMetodo;
    }
    public ParametroFormal getParametros()
    {
        return this.parametros;
    }
    public Bloco getBloco() {
        return this.bloco;
    }


    public boolean eConstante() {
        return constante;
    }

    public boolean eEstatico() {
        return estatico;
    }

    @Override
    public void printAtDepth(int depth) {
        System.out.print(" ".repeat(depth*2));
        System.out.println("[Declaracao Metodo]: {");

        System.out.print(" ".repeat(depth*2));
        System.out.println("Identificador: " + this.identificadorMetodo + ", Tipo: " + this.tipo);


        System.out.print(" ".repeat(depth*2));
        System.out.println("}");
    }
}
