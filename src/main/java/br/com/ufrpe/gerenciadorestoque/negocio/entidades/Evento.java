package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.ArrayList;
import java.time.LocalDate;

public class Evento implements Serializable {
    @Serial
    private static final long serialVersionUID = 4212167967755L;

    private String nomeEvento;
    private String descricao;
    private String cliente;
    private String endereco;
    private LocalDate dataEvento;
    private LocalTime horaEvento;
    private ArrayList<ItemEvento> itensEvento;
    private double valor;

    public Evento(String nomeEvento, String descricao, String cliente, String endereco, LocalDate dataEvento) {
        this.nomeEvento = nomeEvento;
        this.descricao = descricao;
        this.cliente = cliente;
        this.endereco = endereco;
        this.dataEvento = dataEvento;
        this.itensEvento = new ArrayList<ItemEvento>();
    }

    public String getNomeEvento() {
        return nomeEvento;
    }

    public void setNomeEvento(String nomeEvento) {
        this.nomeEvento = nomeEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) {
        this.dataEvento = dataEvento;
    }

    public LocalTime getHoraEvento() {
        return horaEvento;
    }

    public void setHoraEvento(LocalTime horaEvento) {
        this.horaEvento = horaEvento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
