package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

public class MovimentacaoPeca implements Serializable {
    @Serial
    private static final long serialVersionUID = -2343448666900L;

    private int numMovimentacao;
    private Peca peca;
    private int quantidade;
    private LocalDateTime dataHora;
    private EnumTipoMovimentacao tipoMovimentacao;
    private String localOrigem;
    private String localDestino;
    private Evento evento;
    private static int proximoNum = 0;

    public MovimentacaoPeca(Peca peca, int quantidade, String observacoes, EnumTipoMovimentacao tipoMovimentacao){
        this.numMovimentacao = getProximoNum();
        this.peca = peca;
        this.quantidade = quantidade;
        this.tipoMovimentacao = tipoMovimentacao;
        this.dataHora = LocalDateTime.now();
    }

    public static int getProximoNum(){
        int num = proximoNum;
        proximoNum++;
        return num;
    }

    public int getNumMovimentacao(){
        return this.numMovimentacao;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidadePeca) {
        this.quantidade = quantidadePeca;
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

    public String getLocalOrigem() {
        return localOrigem;
    }

    public String getLocalDestino() {
        return localDestino;
    }
}