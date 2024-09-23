package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.excecoes.*;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;

import java.time.LocalDate;
import java.util.ArrayList;

public class Fachada {
    private CadastroPecas cadastroPecas;
    private CadastroEventos cadastroEventos;
    private CadastroMovimentacaoPecas cadastroMovimentacaoPecas;
    private CadastroTags cadastroTags;

    private static Fachada instance;

    private Fachada(){
        this.cadastroPecas = new CadastroPecas();
        this.cadastroEventos = new CadastroEventos();
        this.cadastroMovimentacaoPecas = new CadastroMovimentacaoPecas();
        this.cadastroTags = new CadastroTags();
    }

    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    public void cadastrarPeca(Peca peca) throws PecaJaExisteException {
        this.cadastroPecas.cadastrar(peca);
    }

    public void removerPeca(String id) throws PecaNaoExisteException, PecaReservadaException {
        this.cadastroPecas.remover(id);
    }

    public void atualizarPeca(String id, String novoNome, String novaDescricao, double novoValor, int novaQuantidade, int novaQtdMin, String novoLocalEndereco, ArrayList<Tag> novasTags) throws PecaNaoExisteException {
        this.cadastroPecas.atualizar(id, novoNome, novaDescricao, novoValor, novaQuantidade, novaQtdMin, novoLocalEndereco, novasTags);
    }

    public boolean pecaExiste(String id){
        return this.cadastroPecas.existe(id);
    }

    public boolean pecaEstaReservada(Peca peca) {
        return this.cadastroPecas.pecaEstaReservada(peca);
    }

    public String listarRepositorioPecas(){
        return this.cadastroPecas.listarRepositorioPecas();
    }

    public ArrayList<Peca> buscarPecasPeloNome(String nome){
        return this.cadastroPecas.buscarPecasPeloNome(nome);
    }

    public void cadastrarEvento(Evento evento) throws EventoJaExisteException {
        this.cadastroEventos.cadastrar(evento);
    }

    public void removerEvento(String nomeEvento) throws EventoNaoExisteException {
        this.cadastroEventos.remover(nomeEvento);
    }

    public void atualizarEvento(String nomeEvento, String novaDescricao, String novoCliente, String novoEndereco, LocalDate novaDataEvento, ArrayList<ItemEvento> novoItensEvento, double novoValor) throws EventoNaoExisteException {
        this.cadastroEventos.atualizar(nomeEvento, novaDescricao, novoCliente, novoEndereco, novaDataEvento, novoItensEvento, novoValor);
    }

    public void adicionarItemEvento(String nomeEvento, String idPeca, int quantidade) throws EventoNaoExisteException, PecaNaoExisteException, QtdSuperiorQueADisponivelException {
        this.cadastroEventos.adicionarItemEvento(nomeEvento, idPeca, quantidade);
        Peca peca = this.cadastroPecas.getRepositorio().procurarPeca(idPeca);
        this.cadastroPecas.atualizar(idPeca, null, null, peca.getValor(), peca.getQuantidade() - quantidade, peca.getQuantidadeMin(), null, null);
    }

    public void removerItemEvento(String nomeEvento, String idPeca) throws EventoNaoExisteException, PecaNaoExisteException {
        this.cadastroEventos.removerItemEvento(nomeEvento, idPeca);
    }

    public String listarRepositorioEventos(){
        return this.cadastroEventos.listarRepositorioEventos();
    }

    public CadastroEventos getCadastroEventos() {
        return this.cadastroEventos;
    }

    public CadastroPecas getCadastroPecas() {
        return this.cadastroPecas;
    }

    public CadastroMovimentacaoPecas getCadastroMovimentacaoPecas(){
        return this.cadastroMovimentacaoPecas;
    }

    public void cadastrarTag(Tag tag) throws TagJaExisteException {
        this.cadastroTags.cadastrar(tag);
    }

    public void removerTag(String nome) throws TagNaoExisteException {
        this.cadastroTags.remover(nome);
    }

    public CadastroTags getCadastroTags() {
        return cadastroTags;
    }
}

