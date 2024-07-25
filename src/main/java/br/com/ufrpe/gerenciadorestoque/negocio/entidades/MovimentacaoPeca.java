package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.time.LocalDate;
import java.time.LocalTime;

public class MovimentacaoPeca {
    private Peca peca;
    private int quantidadePeca;
    private LocalDate data;
    private LocalTime hora;
    private EnumTipoMovimentacao tipoMovimentacao;

    public MovimentacaoPeca(int quantidadePeca){}

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public LocalTime getHora() {
        return hora;
    }

    public void setHora(LocalTime hora) {
        this.hora = hora;
    }

    public EnumTipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(EnumTipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }
}
