package br.com.ufrpe.gerenciadorestoque.excecoes;

public class EventoNaoExisteException extends Exception {
    private String nome;

    public EventoNaoExisteException(String nome){
        super("Evento com nome " + nome + "não existe.");
        this.nome = nome;
    }

    private String getNome(){
        return this.nome;
    }
}
