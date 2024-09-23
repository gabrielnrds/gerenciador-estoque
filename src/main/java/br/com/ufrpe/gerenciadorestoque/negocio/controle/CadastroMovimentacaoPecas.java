package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioEventos;
import br.com.ufrpe.gerenciadorestoque.dados.RepositorioMovimentoPecas;
import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.excecoes.EventoNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.QtdSuperiorQueADisponivelException;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.MovimentacaoPeca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

public class CadastroMovimentacaoPecas {
    private RepositorioMovimentoPecas repositorioMovimentoPecas;
    private RepositorioEventos repositorioEventos;
    private RepositorioPecas repositorioPecas;

    public CadastroMovimentacaoPecas() {
        this.repositorioMovimentoPecas = RepositorioMovimentoPecas.getInstance();
        this.repositorioEventos = RepositorioEventos.getInstance();
        this.repositorioPecas = RepositorioPecas.getInstance();
    }

    public void registrarSaida(String nomeEvento, String idPeca, int quantidade) throws EventoNaoExisteException, PecaNaoExisteException, QtdSuperiorQueADisponivelException {
        if (nomeEvento == null || nomeEvento.isEmpty() || idPeca == null || idPeca.isEmpty()) {
            throw new IllegalArgumentException("Argumentos inválidos.");
        } else {
            Evento evento = repositorioEventos.procurarEvento(nomeEvento);
            Peca peca = repositorioPecas.procurarPeca(idPeca);

            if (evento == null) {
                throw new EventoNaoExisteException(nomeEvento);
            }
            if (peca == null) {
                throw new PecaNaoExisteException(idPeca);
            }
            if (quantidade <= 0) {
                throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
            }
            if (quantidade > peca.getQuantidade()) {
                throw new QtdSuperiorQueADisponivelException(peca.getQuantidade(), idPeca);
            }

            int quantidadeAtual = peca.getQuantidade() - quantidade;
            if (quantidadeAtual < 0) {
                quantidadeAtual = 0;
            }
            peca.setNumVezesUsada(peca.getNumVezesUsada() + 1);
            peca.setQuantidade(quantidadeAtual);

            repositorioPecas.atualizar(peca, peca.getNome(), peca.getDescricao(), peca.getValor(), peca.getQuantidade(), peca.getQuantidadeMin(), peca.getLocalEndereco(), peca.getTags());

            MovimentacaoPeca movimentacaoPeca = new MovimentacaoPeca(peca, quantidade, peca.getLocalEndereco(), evento.getEndereco(), evento);

            repositorioMovimentoPecas.cadastrar(movimentacaoPeca);
            repositorioMovimentoPecas.salvarArquivo();
        }
    }

    public void registrarEntrada(String idPeca, int quantidade) throws PecaNaoExisteException {
        if (idPeca == null || idPeca.isEmpty()) {
            throw new IllegalArgumentException("Argumentos inválidos.");
        } else {
            Peca peca = repositorioPecas.procurarPeca(idPeca);
            if (peca == null) {
                throw new PecaNaoExisteException(idPeca);
            }
            if (quantidade <= 0) {
                throw new IllegalArgumentException("A quantidade deve ser maior que zero.");
            }

            int quantidadeAtual = peca.getQuantidade() + quantidade;
            peca.setQuantidade(quantidadeAtual);

            repositorioPecas.atualizar(peca, peca.getNome(), peca.getDescricao(), peca.getValor(), peca.getQuantidade(), peca.getQuantidadeMin(), peca.getLocalEndereco(), peca.getTags());

            MovimentacaoPeca movimentacaoPeca = new MovimentacaoPeca(peca, quantidade, null, null, null);
        }
    }
}
