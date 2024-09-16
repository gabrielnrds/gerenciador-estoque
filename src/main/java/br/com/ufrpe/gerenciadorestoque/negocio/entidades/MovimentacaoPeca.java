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
    private EnumTipoMovimento tipo;
    private LocalDateTime dataHora;
    private String localOrigem;
    private String localDestino;
    private Evento evento;
    private static int proximoNum = 0;

    public MovimentacaoPeca(Peca peca, int quantidade, String localOrigem, String localDestino, Evento evento){
        this.numMovimentacao = getProximoNum();
        this.peca = peca;
        this.quantidade = quantidade;
        this.dataHora = LocalDateTime.now();
        this.localOrigem = localOrigem;
        this.localDestino = localDestino;
        this.evento = evento;
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

    public void setQuantidade(int quantidade) {
        if(quantidade > 0){
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
    }

    public Evento getEvento(){
        return evento;
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