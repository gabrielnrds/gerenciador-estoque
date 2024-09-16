package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

public enum EnumTipoMovimento {
    ENTRADA("Entrada"), SAIDA("Saida");
    private String tipo;

    EnumTipoMovimento(String tipo){
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }
}
