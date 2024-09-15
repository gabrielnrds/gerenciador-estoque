package br.com.ufrpe.gerenciadorestoque.excecoes;

public class EventoJaExisteException extends Exception {
    private String nome;

    public EventoJaExisteException(String nome){
        super("O evento com o nome " + nome + "já existe.");
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }
}
