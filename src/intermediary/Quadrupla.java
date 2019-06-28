package intermediary;
public class Quadrupla {

    private operadorIREnum op;
    private String arg1;
    private String arg2;
    private String dest;

    private Quadrupla proximo;

    public Quadrupla(operadorIREnum op, String arg1, String arg2, String dest, Quadrupla proximo){
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.dest = dest;
        this.proximo = proximo;
    }

    public Quadrupla(operadorIREnum op, String arg1, String arg2, String dest){
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = arg2;
        this.dest = dest;
        this.proximo = null;
    }

    public Quadrupla(operadorIREnum op, String arg1, String dest){
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = "";
        this.dest = dest;
        this.proximo = null;
    }

    public Quadrupla(operadorIREnum op, String arg1){
        this.op = op;
        this.arg1 = arg1;
        this.arg2 = "";
        this.dest = "";
        this.proximo = null;
    }

    public operadorIREnum getOp() {
        return op;
    }

    public void setOp(operadorIREnum op) {
        this.op = op;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }

    public String getDest() {
        return dest;
    }

    public void setDest(String dest) {
        this.dest = dest;
    }

    public Quadrupla getProximo() {
        return proximo;
    }

    public void setProximo(Quadrupla proximo) {
        this.proximo = proximo;
    }

    public String toString(){
        String r = "[";
        if(op == operadorIREnum.MULT){
            r += dest + " := " + arg1 + " * " + arg2;
        }else if(op == operadorIREnum.SOMA){
            r += dest + " := " + arg1 + " + " + arg2;
        }else if(op == operadorIREnum.SUB){
            r += dest + " := " + arg1 + " - " + arg2;
        }else if(op == operadorIREnum.DIV){
            r += dest + " := " + arg1 + " / " + arg2;
        }else if(op == operadorIREnum.MOD){
            r += dest + " := " + arg1 + " % " + arg2;
        }else if(op == operadorIREnum.GOTO){
            r += "GOTO " + dest;
        }else if(op == operadorIREnum.IFGOTO){
            r += "IF " + arg1 + " GOTO " + dest;
        }else if(op == operadorIREnum.IFNOTGOTO){
            r += "IFNOT " + arg1 + " GOTO " + dest;
        }else if(op == operadorIREnum.ATRIB){
            r += dest + " := " + arg1;
        }else if(op == operadorIREnum.IGUAL){
            r += dest + " := " + arg1 + " == " + arg2;
        }else if(op == operadorIREnum.DIFERENTE){
            r += dest + " := " + arg1 + " != " + arg2;
        }else if(op == operadorIREnum.MENORIGUAL){
            r += dest + " := " + arg1 + " <= " + arg2;
        }else if(op == operadorIREnum.MAIORIGUAL){
            r += dest + " := " + arg1 + " >= " + arg2;
        }else if(op == operadorIREnum.MENOR){
            r += dest + " := " + arg1 + " < " + arg2;
        }else if(op == operadorIREnum.MAIOR){
            r += dest + " := " + arg1 + " > " + arg2;
        }else if(op == operadorIREnum.AND){
            r += dest + " := " + arg1 + " && " + arg2;
        }else if(op == operadorIREnum.OR){
            r += dest + " := " + arg1 + " || " + arg2;
        }else if(op == operadorIREnum.LABEL){
            r += "LABEL " + dest;
        }else if(op == operadorIREnum.MAIS){
            r += dest +" := +" + arg1;
        }else if(op == operadorIREnum.MENOS){
            r += dest +" := -" + arg1;
        }else if(op == operadorIREnum.NOT){
            r += dest +" := NOT " + arg1;
        }
        return r + "]";
    }

    public String mostrarCodigo(){
        String re = "";
        Quadrupla atual = this;


        while(atual != null){

            re += atual.toString() + "\n";
            atual = atual.getProximo();
        }

        return re;           
    }

}
