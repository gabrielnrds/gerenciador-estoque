package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaJaExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

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

    public boolean existe(String id){
        return this.repositorio.pecaExiste(id);
    }
}
