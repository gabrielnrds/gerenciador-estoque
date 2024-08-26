package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Peca {
    private String id;
    private String nome;
    private String descricao;
    private BufferedImage foto;
    private int quantidadeMin;
    private int quantidade;
    private int numVezesUsada;
    private double valor;
    private String localEndereco;
    private ArrayList<Tag> tags = new ArrayList<>();

    public Peca(String id, String nomePeca) {
        this.id = id;
        this.nome = nomePeca;
    }

    public Peca(String id, String nomePeca, String descricao, int quantidadeMin) {
        this.id = id;
        this.nome = nomePeca;
        this.descricao = descricao;
        this.quantidadeMin = quantidadeMin;
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