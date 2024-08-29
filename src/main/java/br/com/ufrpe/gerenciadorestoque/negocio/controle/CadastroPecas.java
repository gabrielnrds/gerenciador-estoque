package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

public class CadastroPecas {
    private RepositorioPecas repositorio;

    public CadastroPecas(){
        this.repositorio = RepositorioPecas.getInstance();
    }
}
