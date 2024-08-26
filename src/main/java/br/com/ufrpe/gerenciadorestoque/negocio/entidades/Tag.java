package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

public class Tag {
    private String nome;

    public Tag(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return this.nome;
    }

    public void setNome(){
        this.nome = nome;
    }
}
