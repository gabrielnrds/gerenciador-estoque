package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.util.ArrayList;

public class Peca {
    private String idPeca;
    private String nomePeca;
    private String descricao;
    private double valor;
    private int quantidadeMin;
    private int quantidadeEstoque;
    private int numVezesUsada;
    private ArrayList<ItemPeca> itensPeca = new ArrayList<>();
    private ArrayList<Tag> tags = new ArrayList<>();

    public Peca(String idPeca, String nomePeca){
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
    }

    public Peca(String idPeca, String nomePeca, String descricao, double valor, int quantidadeMin){
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.descricao = descricao;
        this.valor = valor;
        this.quantidadeMin = quantidadeMin;
    }

    @Override
    public String toString() {
        return "Peca{" +
                "codPeca=" + idPeca +
                ", nomePeca='" + nomePeca + '\'' +
                ", descricao='" + descricao + '\'' +
                ", valor=" + valor +
                ", quantidadeMin=" + quantidadeMin +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", numVezesUsada=" + numVezesUsada +
                '}';
    }

    //getters
    public String getIdPeca() {
        return idPeca;
    }

    public String getNomePeca(){
        return nomePeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public int getNumVezesUsada() {
        return numVezesUsada;
    }

    //setters
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
}
