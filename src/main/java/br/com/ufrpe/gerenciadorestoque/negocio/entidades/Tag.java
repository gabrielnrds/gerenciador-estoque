package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import javafx.scene.paint.Color;

import java.io.Serial;
import java.io.Serializable;

public class Tag implements Serializable {
    @Serial
    private static final long serialVersionUID = 7365591212300L;

    private final String nome;
    private Color cor;

    public Tag(String nome){
        this.nome = nome;
    }

    public Tag(String nome, Color cor){
        this.nome = nome;
        this.cor = cor;
    }

    public Color getCor(){
        return this.cor;
    }

    public String getNome(){
        return this.nome;
    }
}
