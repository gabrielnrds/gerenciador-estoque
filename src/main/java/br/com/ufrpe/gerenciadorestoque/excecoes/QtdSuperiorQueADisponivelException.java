package br.com.ufrpe.gerenciadorestoque.excecoes;

public class QtdSuperiorQueADisponivelException extends Exception{
    int qtdDisponivel;
    String id;

    public QtdSuperiorQueADisponivelException(int qtdDisponivel, String id){
        super("A quantidade disponivel da peça de id " + id + " é: " + qtdDisponivel);
        this.qtdDisponivel = qtdDisponivel;
        this.id = id;
    }
}
