package simbol;


import java.util.List;

public class SimboloFuncao extends Simbolo {
    //parametros de uma funcao
    private List<Parametro> parametros;

    public SimboloFuncao(){
    }

    public SimboloFuncao(Tipo tipo, String identificador){
        super(tipo,identificador);
    }

    public List<Parametro> getParametros() {
        return parametros;
    }

    public void addParametro(Parametro parametro){
        this.parametros.add(parametro);
    }
    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

}
