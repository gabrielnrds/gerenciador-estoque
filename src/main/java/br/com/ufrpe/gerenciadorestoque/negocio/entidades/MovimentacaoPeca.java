package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.time.LocalDateTime;


public class MovimentacaoPeca {
    private int numMovimentacao;
    private Peca peca;
    private int quantidadePeca;
    private LocalDateTime dataHora;
    private EnumTipoMovimentacao tipoMovimentacao;
    private Estoque localOrigem;
    private Estoque localDestino;
    private static int proximoNum = 0;

    public MovimentacaoPeca(Peca peca, int quantidadePeca, EnumTipoMovimentacao tipoMovimentacao, Estoque localOrigem, Estoque localDestino){
        this.numMovimentacao = getProximoNum();
        this.peca = peca;
        this.quantidadePeca = quantidadePeca;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHora = LocalDateTime.now();
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
    }

    public int getProximoNum(){
        int num = proximoNum;
        proximoNum++;
        return num;
    }

    public int getNumMovimentacao(){
        return this.numMovimentacao;
    }

    public int getQuantidadePeca() {
        return quantidadePeca;
    }

    public void setQuantidadePeca(int quantidadePeca) {
        this.quantidadePeca = quantidadePeca;
    }

    public EnumTipoMovimentacao getTipoMovimentacao() {
        return tipoMovimentacao;
    }

    public void setTipoMovimentacao(EnumTipoMovimentacao tipoMovimentacao) {
        this.tipoMovimentacao = tipoMovimentacao;
    }

    public Peca getPeca() {
        return peca;
    }

    public LocalDateTime getDataHora() {
        return dataHora;
    }

    public Estoque getLocalOrigem() {
        return localOrigem;
    }

    public Estoque getLocalDestino() {
        return localDestino;
    }
}