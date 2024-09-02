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
        this.setId(id);
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setValor(valor);
        this.setFotoPeca(fotoPeca);
        this.setQuantidadeMin(quantidadeMin);
        this.setQuantidade(quantidade);
        this.setLocalEndereco(localEndereco);
        this.numVezesUsada = 0;
        this.tags = new ArrayList<>();
    }

    public String toString() {
        String string = "ID: %s | %s%n";
        String resultado;
        resultado = String.format(string, this.id, this.nome);
        return resultado;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) throws IllegalArgumentException{
        if(id != null && !(id.isEmpty())){
            this.id = id;
        } else {
            throw new IllegalArgumentException("Erro: id inválido.");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException{
        if(nome != null && !(nome.isEmpty())){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Erro: nome inválido.");
        }
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

    public void setQuantidadeMin(int quantidadeMin) throws IllegalArgumentException {
        if(quantidadeMin >= 0){
            this.quantidadeMin = quantidadeMin;
        } else {
            throw new IllegalArgumentException("Erro: a quantidade mínima de peças deve ser maior ou igual a zero.");
        }

    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) throws IllegalArgumentException {
        if(quantidade > 0){
            this.quantidade = quantidade;
        } else {
            throw new IllegalArgumentException("Erro: a quantidade deve ser um valor positivo.");
        }

    }

    public int getNumVezesUsada() {
        return numVezesUsada;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws IllegalArgumentException {
        if(valor >= 0.0){
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("O valor da peça deve ser maior ou igual a zero.");
        }

    }

    public BufferedImage getFotoPeca(){
        return this.fotoPeca;
    }

    public void setFotoPeca(BufferedImage fotoPeca){
        this.fotoPeca = fotoPeca;
    }

    public String getLocalEndereco() {
        return localEndereco;
    }

    public void setLocalEndereco(String localEndereco) {
        this.localEndereco = localEndereco;
    }

    public ArrayList<Tag> getTags(){
        return this.tags;
    }

    public void adicionarTag(Tag tag){
        if(tag != null && !(this.tags.contains(tag))){
            this.tags.add(tag);
        }
    }

    public void removerTag(Tag tag){
        if(tag != null){
            this.tags.remove(tag);
        }
    }
}