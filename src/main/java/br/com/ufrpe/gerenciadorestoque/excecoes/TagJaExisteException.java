package br.com.ufrpe.gerenciadorestoque.excecoes;

public class TagJaExisteException extends Exception {
    private String nome;

    public TagJaExisteException(String nome){
        super("A Tag com o nome " + nome + " já existe!");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
