package simbol;


import ast.*;

import java.util.*;

public class Assinatura {

    private ArrayList<Simbolo> parametros;
    private Tipo tipo;
    private Set<String> parametrosIds;
    private TipoAcessoS encapsulamento;


    @Override
    public String toString() {
        if(parametros.size() == 0) return "()";

        String res = "" + this.tipo + ":(";
        for(Simbolo s : parametros){
            if(s.getTipo().getTipo() == TipoValor.INTEIRO){
                res += "int,";
            }else if(s.getTipo().getTipo() == TipoValor.BOOL){
                res += "bool,";
            }else if(s.getTipo().getTipo() == TipoValor.CHAR){
                res += "char,";
            }else if(s.getTipo().getTipo() == TipoValor.ESTRUTURA){
                res += s.getTipo().getTipoEstrutura() + ",";
            }
        }
        res = res.substring(0,res.length()-1);
        return res + ")";
    }

    public Assinatura(Tipo tipo, TipoAcessoS encapsulamento){
        this.tipo = tipo;
        this.parametros = new ArrayList<>();
        this.parametrosIds = new HashSet<>();
        this.encapsulamento = encapsulamento;
    }

    public boolean adicionarParametro(Simbolo s){
        if(parametrosIds.contains(s.getIdentificador())){
            return false;
        }

        parametrosIds.add(s.getIdentificador());
        parametros.add(s);
        return true;
    }

    public ArrayList<Simbolo> getParametros() {
        return parametros;
    }

    public boolean equals(Assinatura other){
        ArrayList<Simbolo> os = other.getParametros();
        if(this.parametros.size() != os.size()) return false;
        for(int i = 0; i < parametros.size(); i++){
            Simbolo t = this.parametros.get(i);
            Simbolo o = os.get(i);

            if( ! o.getTipo().equals(t.getTipo()) )
                return false;
        }
        return true;
    }

    public Tipo getTipo() {
        return tipo;
    }

    public void setEncapsulamento(TipoAcessoS encapsulamento) {
        this.encapsulamento = encapsulamento;
    }

    public TipoAcessoS getEncapsulamento() {
        return encapsulamento;
    }
}