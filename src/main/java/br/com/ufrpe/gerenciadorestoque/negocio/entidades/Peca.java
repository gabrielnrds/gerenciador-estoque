package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.awt.image.BufferedImage;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

public class Peca implements Serializable {

    @Serial
    private static final long serialVersionUID = 7060279674159681283L;

    private String id;
    private String nome;
    private String descricao;
    private double valor;
    private BufferedImage fotoPeca;
    private int quantidadeMin;
    private int quantidade;
    private int numVezesUsada;
    private String localEndereco;
    private ArrayList<Tag> tags;

    public Peca(String id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Peca(String id, String nome, String descricao, double valor, BufferedImage fotoPeca, int quantidadeMin, int quantidade, String localEndereco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.valor = valor;
        this.fotoPeca = fotoPeca;
        this.quantidadeMin = quantidadeMin;
        this.quantidade = quantidade;
        this.localEndereco = localEndereco;
        this.tags = new ArrayList<>();
    }

    public String toString() {
        String string = "ID: %s | %s%n";
        String resultado = String.format(string, this.id, this.nome);
        return resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getQuantidadeMin() {
        return quantidadeMin;
    }

    public void setQuantidadeMin(int quantidadeMin) {
        this.quantidadeMin = quantidadeMin;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getNumVezesUsada() {
        return numVezesUsada;
    }

    public void setNumVezesUsada(int numVezesUsada) {
        this.numVezesUsada = numVezesUsada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getLocalEndereco() {
        return localEndereco;
    }

    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }
}