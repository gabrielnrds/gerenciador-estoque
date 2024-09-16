package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaJaExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import javafx.scene.image.Image;

import java.util.ArrayList;

public class CadastroPecas {
    private RepositorioPecas repositorio;

    public CadastroPecas(){
        this.repositorio = RepositorioPecas.getInstance();
    }

    public void cadastrar(Peca peca) throws PecaJaExisteException {
        if(peca != null){
            if(!this.existe(peca.getId())){
                this.repositorio.cadastrar(peca);
                this.repositorio.salvarArquivo();
            } else {
                throw new PecaJaExisteException(peca.getId());
            }
        } else {
            throw new IllegalArgumentException("Peca inválida.");
        }
    }

    public void remover(String id) throws PecaNaoExisteException {
        this.repositorio.remover(id);
        this.repositorio.salvarArquivo();
    }

    public void atualizar(Peca peca, String novoNome, String novaDescricao, double novoValor, Image novaFotoPeca, int novaQuantidade, int novaQtdMin, String novoLocalEndereco, int numVezesUsada) throws PecaNaoExisteException{
        if(repositorio.pecaExiste(peca.getId())){
            if(novoNome.isEmpty() || peca.getNome().equals(novoNome)){
                novoNome = peca.getNome();
            }
            if(novaDescricao.isEmpty() || peca.getDescricao().equals(novaDescricao)){
                novaDescricao = peca.getDescricao();
            }
            if(novoValor < 0.0 || peca.getValor() == novoValor){
                novoValor = peca.getValor();
            }
            if(novaFotoPeca.equals(peca.getFotoPeca())){
                novaFotoPeca = peca.getFotoPeca();
            }
            if(novaQuantidade < 0 || peca.getQuantidade() == novaQuantidade){
                novaQuantidade = peca.getQuantidade();
            }
            if(novaQtdMin < 0 || peca.getQuantidadeMin() == novaQtdMin){
                novaQtdMin = peca.getQuantidadeMin();
            }
            if(novoLocalEndereco.isEmpty() || peca.getLocalEndereco().equals(novoLocalEndereco)){
                novoLocalEndereco = peca.getLocalEndereco();
            }
            if(numVezesUsada < 0 || peca.getNumVezesUsada() == numVezesUsada){
                numVezesUsada = peca.getNumVezesUsada();
            }
            repositorio.atualizar(peca, novoNome, novaDescricao, novoValor, novaFotoPeca, novaQuantidade, novaQtdMin, novoLocalEndereco, numVezesUsada);
            repositorio.salvarArquivo();
        } else {
            throw new PecaNaoExisteException(peca.getId());
        }
    }

    public RepositorioPecas getRepositorio() {
        return repositorio;
    }



    public ArrayList<Peca> buscarPecasPeloNome(String nome){
        return this.repositorio.buscarPecasPeloNome(nome);
    }

    public boolean existe(String id){
        return this.repositorio.pecaExiste(id);
    }
}
