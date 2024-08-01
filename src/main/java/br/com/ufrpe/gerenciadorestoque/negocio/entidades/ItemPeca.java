package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.time.LocalDate;

public class ItemPeca {
    private LocalDate dataAquisicao;
    private EnumCondicaoPeca condicaoPeca;
    private boolean resevada;
    private Estoque localidade;

    public ItemPeca(EnumCondicaoPeca condicaoPeca, Estoque localidade){
        this.dataAquisicao = LocalDate.now();
        this.condicaoPeca = condicaoPeca;
        this.resevada = false;
        this.localidade = localidade;
    }

    public LocalDate getDataAquisicao() {
        return dataAquisicao;
    }

    public void setDataAquisicao(LocalDate dataAquisicao) {
        this.dataAquisicao = dataAquisicao;
    }

    public EnumCondicaoPeca getCondicaoPeca() {
        return condicaoPeca;
    }

    public void setCondicaoPeca(EnumCondicaoPeca condicaoPeca) {
        this.condicaoPeca = condicaoPeca;
    }

    public boolean isResevada() {
        return resevada;
    }

    public void setResevada(boolean resevada) {
        this.resevada = resevada;
    }
}
