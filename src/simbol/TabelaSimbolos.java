package simbol;

import java.util.List;
import java.util.Map;

public class TabelaSimbolos{
    TabelaSimbolos tabelaPai;
    private Map<String, Simbolo> mapaSimbolos;

    public TabelaSimbolos getTabelaPai() {
        return tabelaPai;
    }

    public void setTabelaPai(TabelaSimbolos tabelaPai) {
        this.tabelaPai = tabelaPai;
    }

    public boolean adicionarSimbolo(Simbolo simbolo, Erro erro){
        if(this.mapaSimbolos.containsKey(simbolo.getIdentificador())){
            erro.setMensagem("Ja existe um simbolo com o identificador " + simbolo.getIdentificador());
            return false;
        }else{
            this.mapaSimbolos.put(simbolo.getIdentificador(),simbolo);
            return true;
        }
    }


    public Simbolo buscarSimbolo(Simbolo simbolo, Erro erro){
        if(this.mapaSimbolos.containsKey(simbolo.getIdentificador())){
            Simbolo simboloRetornado =  this.mapaSimbolos.get(simbolo.getIdentificador());
            return simboloRetornado;
        }else{
            if(tabelaPai == null) {
                erro.setMensagem("Nao existe simbolo com o identificador " + simbolo.getIdentificador() + "!");
                return null;
            }
            return this.tabelaPai.buscarSimbolo(simbolo, erro);
        }
    }






}
