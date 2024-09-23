package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.io.Serializable;

public class ItemEvento implements Serializable {
    private Peca peca;
    private int quantidade;
    private double valor;

    public ItemEvento(Peca peca, int quantidade){
        setPeca(peca);
        setQuantidade(quantidade);
        setValor(calcularValorTotal(peca, quantidade));
    }

    public String toString(){
        return ("Peça: " + this.peca.getNome() + " | quantidade: " + this.quantidade + " | valor: R$" + this.valor);
    }

    public Peca getPeca() {
        return peca;
    }

    public void setPeca(Peca peca) throws IllegalArgumentException{
        if(peca != null){
            this.peca = peca;
        } else {
            throw new IllegalArgumentException("Peça inválida.");
        }
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws IllegalArgumentException {
        if(quantidade > 0){
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("Erro: o número de peças deve ser positivo.");
        }
    }

    public double getValor() {
        return valor;
    }

    private double calcularValorTotal(Peca peca, int quantidade){
        return peca.getValor() * quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
