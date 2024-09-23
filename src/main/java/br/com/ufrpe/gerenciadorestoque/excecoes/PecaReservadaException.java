package br.com.ufrpe.gerenciadorestoque.excecoes;

public class PecaReservadaException extends Exception {
    private String idPeca;

    public PecaReservadaException(String idPeca){
        super("A peça de id " + idPeca + " está reservada para um evento");
        this.idPeca = idPeca;
    }

    public String getIdPeca() {
        return idPeca;
    }
}
