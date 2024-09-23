package br.com.ufrpe.gerenciadorestoque.excecoes;

public class PecaNaoExisteException extends Exception {
    private String id;

    public PecaNaoExisteException(String id){
        super("Peca com id " + id + " não existe.");
        this.id = id;
    }

    public String getId(){
        return this.id;
    }
}
