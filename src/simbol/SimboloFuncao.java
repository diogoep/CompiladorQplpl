package simbol;


import ast.Tipo;

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

    public boolean addParametro(Parametro parametro, Erro erro){
        for(Parametro parametroLista: parametros){
           if(parametroLista.getIdentificador().equals(parametro.getIdentificador())){
               erro.setMensagem("Pode haver apenas um parametro com o ID " + parametro.getIdentificador());
               return false;
           }
        }
        this.parametros.add(parametro);
        return true;
    }

    public void setParametros(List<Parametro> parametros) {
        this.parametros = parametros;
    }

}
