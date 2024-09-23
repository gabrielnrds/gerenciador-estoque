package br.com.ufrpe.gerenciadorestoque.excecoes;

public class TagNaoExisteException extends Exception{
    private String nome;

    public TagNaoExisteException(String nome){
        super("Tag com nome " + nome + "não existe.");
        this.nome = nome;
    }

    private String getNome(){
        return this.nome;
    }
}
