package br.com.ufrpe.gerenciadorestoque.negocio.entidades;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;

public class Evento implements Serializable {
    @Serial
    private static final long serialVersionUID = 4212167967755L;

    private String nome;
    private String descricao;
    private String cliente;
    private String endereco;
    private LocalDate dataEvento;
    private ArrayList<ItemEvento> itensEvento;
    private double valor;

    public Evento(String nome, String descricao, String cliente, String endereco, LocalDate dataEvento, ArrayList<ItemEvento> itensEvento) {
        this.setNome(nome);
        this.setDescricao(descricao);
        this.setCliente(cliente);
        this.setEndereco(endereco);
        this.setDataEvento(dataEvento);
        this.setItensEvento(itensEvento);
        this.setValor(calcularValor());
    }

    public String toString() {
        String string = "Nome: %s | Descrição: %s | Cliente: %s | Endereco: %s%nPeças do evento: %s \n";
        StringBuilder itens = new StringBuilder();
        for(ItemEvento item : this.itensEvento){
            itens.append(item.toString()).append("\n");
        }
        String resultado;
        resultado = String.format(string, this.nome, this.descricao, this.cliente, this.endereco, itens);
        return resultado;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) throws IllegalArgumentException {
        if(nome != null && !nome.isEmpty()){
            this.nome = nome;
        } else {
            throw new IllegalArgumentException("Nome inválido.");
        }

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

    public void setCliente(String cliente) throws IllegalArgumentException {
        if(cliente != null && !cliente.isEmpty()){
            this.cliente = cliente;
        } else {
            throw new IllegalArgumentException("Cliente inválido.");
        }

    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) throws IllegalArgumentException {
        if(endereco != null && !endereco.isEmpty()){
            this.endereco = endereco;
        } else {
            throw new IllegalArgumentException("Endereço inválido.");
        }

    }

    public LocalDate getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(LocalDate dataEvento) throws IllegalArgumentException {
        if(dataEvento != null && !dataEvento.isBefore(LocalDate.now())){
            this.dataEvento = dataEvento;
        } else {
            throw new IllegalArgumentException("Data do evento inválida.");
        }
    }

    public ArrayList<ItemEvento> getItensEvento(){
        return this.itensEvento;
    }

    public void setItensEvento(ArrayList<ItemEvento> itensEvento) throws IllegalArgumentException{
        if(itensEvento != null && !itensEvento.isEmpty()){
            this.itensEvento = itensEvento;
        } else {
            this.itensEvento = new ArrayList<ItemEvento>(0);
        }
    }

    public void addItem(ItemEvento item){
        if(item != null && !itensEvento.contains(item)){
            this.itensEvento.add(item);
        }
    }

    public void rmvItem(ItemEvento item){
        if(item != null){
            this.itensEvento.remove(item);
        }
    }

    private double calcularValor(){
        double valor = 0.0;
        for(ItemEvento item : this.itensEvento){
            if(item != null && item.getValor() < 0){
                valor += item.getValor();
            }
        }
        return valor;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) throws IllegalArgumentException {
        if(valor >= 0.0){
            this.valor = valor;
        } else {
            throw new IllegalArgumentException("Valor do evento inválido.");
        }
    }
}
