package simbol;
import java.util.HashMap;
import java.util.Map;

public class TabelaSimbolos{
    TabelaSimbolos tabelaPai;
    private Map<String, Simbolo> mapaSimbolos;

    public TabelaSimbolos(TabelaSimbolos tabelaPai){
        this.tabelaPai = tabelaPai;
        this.mapaSimbolos = new HashMap<>();
    }

    public TabelaSimbolos(){
        this.mapaSimbolos = new HashMap<>();
    }

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


    public Simbolo buscarSimbolo(String identificadorSimbolo, Erro erro){
        if(this.mapaSimbolos.containsKey(identificadorSimbolo)){
            Simbolo simboloRetornado =  this.mapaSimbolos.get(identificadorSimbolo);
            return simboloRetornado;
        }else{
            if(tabelaPai == null) {
                erro.setMensagem("Nao existe simbolo com o identificador " + identificadorSimbolo + "!");
                return null;
            }
            return this.tabelaPai.buscarSimbolo(identificadorSimbolo, erro);
        }
    }






}
