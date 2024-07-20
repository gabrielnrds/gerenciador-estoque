package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.util.ArrayList;

public class Estoque {
    private String nomeEstoque;
    private String endereco;
    private ArrayList<Peca> pecas;
    private int qtdTotalPecas;

    public Estoque(String nomeEstoque, String endereco){
        this.nomeEstoque = nomeEstoque;
        this.endereco = endereco;
        this.pecas = new ArrayList<Peca>();
    }

    @Override
    public String toString() {
        return "Estoque{" +
                "nomeEstoque='" + nomeEstoque + '\'' +
                ", endereco='" + endereco + '\'' +
                ", qtdTotalPecas=" + qtdTotalPecas +
                '}';
    }

    //getters
    public String getNomeEstoque() {
        return nomeEstoque;
    }

    public String getEndereco() {
        return endereco;
    }

    public ArrayList<Peca> getPecas() {
        return pecas;
    }

    public int getQtdTotalPecas() {
        return qtdTotalPecas;
    }

    //setters
    public void setNomeEstoque(String nomeEstoque) {
        this.nomeEstoque = nomeEstoque;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void setPecas(ArrayList<Peca> pecas) {
        this.pecas = pecas;
    }

    public void setQtdTotalPecas(int qtdTotalPecas) {
        this.qtdTotalPecas = qtdTotalPecas;
    }
}