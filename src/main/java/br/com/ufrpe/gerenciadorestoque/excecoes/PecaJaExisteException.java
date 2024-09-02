package br.com.ufrpe.gerenciadorestoque.excecoes;

public class PecaJaExisteException extends Exception {
    private String id;

    public PecaJaExisteException(String id){
        super("A peca com id" + id + "já existe!");
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
