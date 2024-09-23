package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioEventos;
import br.com.ufrpe.gerenciadorestoque.excecoes.*;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;

import java.time.LocalDate;
import java.util.ArrayList;

public class CadastroEventos {
    private CadastroPecas cadastroPecas;
    private RepositorioEventos repositorioEventos;
    private RepositorioPecas repositorioPecas;

    public CadastroEventos(){
        this.repositorioEventos = RepositorioEventos.getInstance();
        this.repositorioPecas = RepositorioPecas.getInstance();
    }

    public void cadastrar(Evento evento) throws EventoJaExisteException {
        if(evento != null){
            if(!existe(evento.getNome())){
                this.repositorioEventos.cadastrar(evento);
            } else {
                throw new EventoJaExisteException(evento.getNome());
            }
        } else {
            throw new IllegalArgumentException("Evento inválido.");
        }
    }

    public void adicionarItemEvento(String nomeEvento, String idPeca, int quantidade) throws PecaNaoExisteException, QtdSuperiorQueADisponivelException, EventoNaoExisteException{
        if(idPeca == null || idPeca.isEmpty()){
            throw new IllegalArgumentException("Id de peça inválido!");
        }
        if(nomeEvento == null || nomeEvento.isEmpty()){
            throw new IllegalArgumentException("Nome do evento inválido!");
        }
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade da peça deve ser maior que zero.");
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
            ItemEvento novoItem = new ItemEvento(peca, quantidade);
            evento.addItem(novoItem);
            evento.setValor(evento.getValor() + novoItem.getValor());
            peca.setQuantidade(peca.getQuantidade() - quantidade);
            atualizar(nomeEvento, null, null, null, null, evento.getItensEvento(), evento.getValor());
    }

    public void removerItemEvento(String nomeEvento, String idPeca) throws PecaNaoExisteException, EventoNaoExisteException {
        if(idPeca == null || idPeca.isEmpty()){
            throw new IllegalArgumentException("Id de peça inválido!");
        }
        if(nomeEvento == null || nomeEvento.isEmpty()){
            throw new IllegalArgumentException("Nome do evento inválido!");
        }
        Evento evento = this.repositorioEventos.procurarEvento(nomeEvento);
        Peca peca = this.repositorioPecas.procurarPeca(idPeca);
        if(peca == null){
            throw new PecaNaoExisteException(idPeca);
        }
        if(evento == null){
            throw new EventoNaoExisteException(nomeEvento);
        }
        ArrayList<ItemEvento> itensEvento = evento.getItensEvento();
        for (ItemEvento item : itensEvento){
            if(item != null && item.getPeca().getId().equals(peca.getId())){
                evento.rmvItem(item);
                evento.setValor((evento.getValor() - item.getValor()));
            }
        }
        atualizar(nomeEvento, null, null, null, null, evento.getItensEvento(), evento.getValor());
    }

    public void remover(String nome) throws EventoNaoExisteException {
        this.repositorioEventos.remover(nome);
    }

    public void atualizar(String nomeEvento, String novaDescricao, String novoCliente, String novoEndereco, LocalDate novaDataEvento, ArrayList<ItemEvento> novoItensEvento, double novoValor) throws EventoNaoExisteException {
        Evento evento = repositorioEventos.procurarEvento(nomeEvento);
        if(evento != null){
            if(novoCliente == null || novoCliente.isEmpty() || evento.getCliente().equals(novoCliente)){
                novoCliente = evento.getCliente();
            }
            if(novaDescricao == null || novaDescricao.isEmpty() || evento.getDescricao().equals(novaDescricao)){
                novaDescricao = evento.getDescricao();
            }
            if(novoValor < 0.0 || evento.getValor() == novoValor){
                novoValor = evento.getValor();
            }
            if(novoEndereco == null || novoEndereco.isEmpty() || evento.getEndereco().equals(novoEndereco)){
                novoEndereco = evento.getEndereco();
            }

            if(novaDataEvento == null || novaDataEvento.isBefore(LocalDate.now()) || evento.getDataEvento().equals(novaDataEvento)){
                novaDataEvento = evento.getDataEvento();
            }
            if(novoItensEvento == null || evento.getItensEvento().equals(novoItensEvento)){
                novoItensEvento = evento.getItensEvento();
            }
            repositorioEventos.atualizar(evento, novaDescricao, novoCliente, novoEndereco, novaDataEvento, novoItensEvento, novoValor);
        } else {
            throw new EventoNaoExisteException(nomeEvento);
        }
    }

    public String listarRepositorioEventos(){
        return this.repositorioEventos.toString();
    }

    public boolean existe(String nome){
        return this.repositorioEventos.eventoExiste(nome);
    }

    public RepositorioEventos getRepositorioEventos() {
        return repositorioEventos;
    }
}
