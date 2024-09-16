package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioEventos;
import br.com.ufrpe.gerenciadorestoque.excecoes.*;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;

import java.util.ArrayList;
import java.util.List;

public class CadastroEventos {
    private RepositorioEventos repositorioEventos;
    private RepositorioPecas repositorioPecas;

    public CadastroEventos(){
        this.repositorioEventos = RepositorioEventos.getInstance();
        this.repositorioPecas = RepositorioPecas.getInstance();
    }

    public void cadastrar(Evento evento) throws EventoJaExisteException {
        if(evento != null){
            if(!this.existe(evento.getNome())){
                this.repositorioEventos.cadastrar(evento);
                this.repositorioEventos.salvarArquivo();
            } else {
                throw new EventoJaExisteException(evento.getNome());
            }
        } else {
            throw new IllegalArgumentException("Evento inválido.");
        }
    }

    public void adicionarItemEvento(String nomeEvento, String idPeca, int quantidade) throws PecaNaoExisteException, QtdSuperiorQueADisponivelException, EventoNaoExisteException{
        if(idPeca == null || idPeca == ""){
            throw new IllegalArgumentException("Id de peça inválido!");
        }
        if(nomeEvento == null || nomeEvento == ""){
            throw new IllegalArgumentException("Nome do evento inválido!");
        }
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
        }
        Evento evento = this.repositorioEventos.procurarEvento(nomeEvento);
        Peca peca = this.repositorioPecas.procurarPeca(idPeca);
        if(peca == null){
            throw new PecaNaoExisteException(idPeca);
        }
        if(evento == null){
            throw new EventoNaoExisteException(nomeEvento);
        }
        if(quantidade > peca.getQuantidade()){
            throw new QtdSuperiorQueADisponivelException(peca.getQuantidade(), peca.getId());
        }
            ItemEvento item = new ItemEvento(peca, quantidade);
            evento.addItem(item);
    }

    public void removerItemEvento(Evento evento, ItemEvento item){
        if(repositorioEventos.eventoExiste(evento.getNome()) && item != null){
            evento.rmvItem(item);
        }
    }

    public void remover(String nome){
        this.repositorioEventos.remover(nome);
        this.repositorioEventos.salvarArquivo();
    }

    public boolean existe(String nome){
        return this.repositorioEventos.eventoExiste(nome);
    }

    public RepositorioEventos getRepositorioEventos() {
        return repositorioEventos;
    }
}
