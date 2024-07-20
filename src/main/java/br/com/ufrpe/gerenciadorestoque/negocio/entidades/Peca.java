package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.time.LocalDate;
import java.util.Objects;

public class Peca {
    private int codPeca;
    private String nomePeca;
    private String descricao;
    private LocalDate dataAquisicao;
    private double valor;
    private int quantidadeMin;
    private int quantidadeEstoque;
    private boolean reservada;
    private int numVezesUsada;
    private EnumCondicaoPeca condicaoPeca;
    private Categoria categoria;

    public Peca(int codPeca, String nomePeca, String descricao, LocalDate dataAquisicao, double valor, EnumCondicaoPeca condicaoPeca){
        this.codPeca = codPeca;
        this.nomePeca = nomePeca;
        this.descricao = descricao;
        this.dataAquisicao = LocalDate.now();
        this.valor = valor;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Peca peca = (Peca) o;
        return getCodPeca() == peca.getCodPeca();
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getCodPeca());
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
