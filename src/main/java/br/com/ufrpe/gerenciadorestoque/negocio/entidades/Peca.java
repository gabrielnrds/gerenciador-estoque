package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Peca {
    private int codPeca;
    private String nomePeca; //boleira de bronze
    private String descricao; //boleira pequena de material bronze
    private LocalDate dataAquisicao; //20/07/2024
    private double valor; //35.70
    private int quantidadeMin; //2
    private int quantidadeEstoque; //0
    private boolean reservada; //false
    private int numVezesUsada; //0
    private EnumCondicaoPeca condicaoPeca; //BOA
    private Categoria categoria = new Categoria();
    private Estoque localEstoque;

    public Peca(){}

    public Peca(int codPeca, String nomePeca, String descricao, LocalDate dataAquisicao, double valor, EnumCondicaoPeca condicaoPeca, String tipo, String cor, String material, String estilo, Estoque localEstoque){
        this.codPeca = codPeca;
        this.nomePeca = nomePeca;
        this.descricao = descricao;
        this.dataAquisicao = LocalDate.now();
        this.valor = valor;
        this.condicaoPeca = condicaoPeca;
        this.localEstoque = localEstoque;
        this.categoria = new Categoria(tipo, cor, material, estilo);
    }

    @Override
    public String toString() {
        return "Peca{" +
                "codPeca=" + codPeca +
                ", nomePeca='" + nomePeca + '\'' +
                ", descricao='" + descricao + '\'' +
                ", dataAquisicao=" + dataAquisicao +
                ", valor=" + valor +
                ", quantidadeMin=" + quantidadeMin +
                ", quantidadeEstoque=" + quantidadeEstoque +
                ", reservada=" + reservada +
                ", numVezesUsada=" + numVezesUsada +
                ", condicaoPeca=" + condicaoPeca +
                '}';
    }

    //getters
    public int getCodPeca() {
        return codPeca;
    }

    public String nomePeca(){
        return nomePeca;
    }

    public String getDescricao() {
        return descricao;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
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

    public boolean isReservada() {
        return reservada;
    }

    public int getNumVezesUsada() {
        return numVezesUsada;
    }

    public EnumCondicaoPeca getCondicaoPeca() {
        return condicaoPeca;
    }

    //setters
    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
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

    public void setReservada(boolean reservada) {
        this.reservada = reservada;
    }

    public void setCondicaoPeca(EnumCondicaoPeca condicaoPeca) {
        this.condicaoPeca = condicaoPeca;
    }
}
