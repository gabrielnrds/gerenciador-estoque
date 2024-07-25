package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.util.ArrayList;
import java.time.LocalDate;

public class Evento {
    private String nomeEvento;
    private String descricao;
    private String cliente;
    private String endereco;
    private LocalDate dataEvento;
    private ArrayList<ItemEvento> listaItensEvento;

    public Evento(String nomeEvento, String descricao, String cliente, String endereco, LocalDate dataEvento) {
        this.nomeEvento = nomeEvento;
        this.descricao = descricao;
        this.cliente = cliente;
        this.endereco = endereco;
        this.dataEvento = dataEvento;
        this.listaItensEvento = new ArrayList<ItemEvento>();
    }
}
