package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

public class ItemEvento {
    private Peca peca;
    private int quantidade;

    public ItemEvento(Peca peca, int quantidade){
        this.peca = peca;
        this.quantidade = quantidade;
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) {
        this.peca = peca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
