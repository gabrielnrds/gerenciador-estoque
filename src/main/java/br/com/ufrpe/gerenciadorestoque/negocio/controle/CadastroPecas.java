package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioEventos;
import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaJaExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaReservadaException;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;

import java.util.ArrayList;

public class CadastroPecas {
    private RepositorioPecas repositorioPecas;
    private RepositorioEventos repositorioEventos;

    public CadastroPecas(){
        this.repositorioPecas = RepositorioPecas.getInstance();
        this.repositorioEventos = RepositorioEventos.getInstance();
    }

    public void cadastrar(Peca peca) throws PecaJaExisteException {
        if(peca != null){
            if(!this.existe(peca.getId())){
                this.repositorioPecas.cadastrar(peca);
            } else {
                throw new PecaJaExisteException(peca.getId());
            }
        } else {
            throw new IllegalArgumentException("Peca inválida.");
        }
    }

    public void remover(String id) throws PecaNaoExisteException, PecaReservadaException {
        Peca peca = this.repositorioPecas.procurarPeca(id);
        if(peca != null){
            if(pecaEstaReservada(peca)){
                throw new PecaReservadaException(peca.getId());
            }
            this.repositorioPecas.remover(id);
        } else {
            throw new PecaNaoExisteException(id);
        }
    }

    public void atualizar(String id, String novoNome, String novaDescricao, double novoValor, int novaQuantidade, int novaQtdMin, String novoLocalEndereco, ArrayList<Tag> novasTags) throws PecaNaoExisteException{
        Peca peca = repositorioPecas.procurarPeca(id);
        if(peca != null){
            if(novoNome == null || novoNome.isEmpty() || peca.getNome().equals(novoNome)){
                novoNome = peca.getNome();
            }
            if(novaDescricao == null || novaDescricao.isEmpty() || peca.getDescricao().equals(novaDescricao)){
                novaDescricao = peca.getDescricao();
            }
            if(novoValor < 0.0 || peca.getValor() == novoValor){
                novoValor = peca.getValor();
            }
            if(novaQuantidade < 0 || peca.getQuantidade() == novaQuantidade){
                novaQuantidade = peca.getQuantidade();
            }
            if(novaQtdMin < 0 || peca.getQuantidadeMin() == novaQtdMin){
                novaQtdMin = peca.getQuantidadeMin();
            }
            if(novoLocalEndereco == null || novoLocalEndereco.isEmpty() || peca.getLocalEndereco().equals(novoLocalEndereco)){
                novoLocalEndereco = peca.getLocalEndereco();
            }
            if(novasTags == null || peca.getTags().equals(novasTags)){
                novasTags = peca.getTags();
            }
            repositorioPecas.atualizar(peca, novoNome, novaDescricao, novoValor, novaQuantidade, novaQtdMin, novoLocalEndereco, novasTags);
        } else {
            throw new PecaNaoExisteException(id);
        }
    }

    public boolean existe(String id){
        return this.repositorioPecas.pecaExiste(id);
    }

    public boolean pecaEstaReservada(Peca peca) {
        boolean reservada = false;
        Evento[] repEventos = this.repositorioEventos.getEventos();
        for(Evento evento : repEventos){
            if(evento != null && !(evento.getItensEvento().isEmpty()) && !reservada){
                ArrayList<ItemEvento> itensEvento = evento.getItensEvento();
                for(ItemEvento item : itensEvento){
                    if(item.getPeca().equals(peca)){
                        reservada = true;
                        break;
                    }
                }
            }
        }
        return reservada;
    }

    public String listarRepositorioPecas(){
        return this.repositorioPecas.toString();
    }

    public ArrayList<Peca> buscarPecasPeloNome(String nome){
        return this.repositorioPecas.buscarPecasPeloNome(nome);
    }

    public RepositorioPecas getRepositorio() {
        return repositorioPecas;
    }
}
