package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;

public class CadastroPecas {
    private RepositorioPecas repositorio;

    public CadastroPecas(RepositorioPecas instanciaRepositorio){
        this.repositorio = instanciaRepositorio;
    }

    public CadastroPecas(){
        this.repositorio = RepositorioPecas.getInstance();
    }
}
