package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioEventos;
import br.com.ufrpe.gerenciadorestoque.excecoes.*;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;

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

    public void adicionarItemEvento(String idPeca, int quantidade) throws PecaNaoExisteException, QtdSuperiorQueADisponivelException{
        if(idPeca == null || idPeca == ""){
            throw new IllegalArgumentException("Id de peça inválido!");
        }
        if(quantidade <= 0){
            throw new IllegalArgumentException("A quantidade deve ser maior que 0.");
        }
        Peca peca = this.repositorioPecas.procurarPeca(idPeca);
        if(peca != null){
            if(quantidade > peca.getQuantidade()){
                throw new QtdSuperiorQueADisponivelException(peca.getQuantidade(), peca.getId());
            }
            ItemEvento item = new ItemEvento(peca, quantidade);
            //continuar daqui
        }else{
            throw new PecaNaoExisteException(idPeca);
        }
    }

    public void remover(String nome){
        this.repositorioEventos.remover(nome);
        this.repositorioEventos.salvarArquivo();
    }

    public boolean existe(String nome){
        return this.repositorioEventos.eventoExiste(nome);
    }

}
