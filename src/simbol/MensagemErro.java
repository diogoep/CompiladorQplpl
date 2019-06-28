package simbol;


public class MensagemErro {
    private int local;
    private String mensagem;

    public MensagemErro(int local, String mensagem) {
        this.local = local;
        this.mensagem = mensagem;
    }

    public MensagemErro(int local) {
        this.local = local;
        this.mensagem = "";
    }

    @Override
    public String toString() {
        return "{Erro em " + this.local + ": " + this.mensagem + "}";
    }

    public MensagemErro(String mensagem) {
        this.mensagem = mensagem;
        this.local = -1;
    }

    public int getLocal() {
        return local;
    }

    public void setLocal(int local) {
        this.local = local;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }


}