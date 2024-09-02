package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;

public class Tag implements Serializable {
    @Serial
    private static final long serialVersionUID = 7365591212300L;

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
