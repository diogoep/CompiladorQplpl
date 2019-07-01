package simbol;

public class Erro {
    private String mensagem;
    private int local;

    public Erro(String mensagem, int local){
        this.mensagem = mensagem;
        this.local = local;
    }
    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    @Override
    public String toString() {
        return "{" +
                "Mensagem='" + mensagem + '\'' +
                ", Local=" + local +
                '}';
    }
}
