package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.time.LocalDate;
import java.util.Objects;
import java.util.ArrayList;

public class Peca {
    private int idPeca;
    private String nomePeca;
    private String descricao;
    private double valor;
    private int quantidadeMin;
    private int quantidadeEstoque;
    private int numVezesUsada;
    private Categoria categoria = new Categoria();
    private ArrayList<ItemPeca> itensPeca;

    public Peca(){}

    public Peca(int idPeca, String nomePeca, String descricao, LocalDate dataAquisicao, double valor, EnumCondicaoPeca condicaoPeca, String tipo, String cor, String material, String estilo, Estoque localEstoque){
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.descricao = descricao;
        this.valor = valor;
        this.categoria = new Categoria(tipo, cor, material, estilo);
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
    public int getIdPeca() {
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
