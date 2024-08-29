package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

public class TesteMain {
    private RepositorioPecas repositorio;

    public TesteMain() {
        this.repositorio = RepositorioPecas.getInstance();
    }

    public static void main(String[] args){
        TesteMain teste = new TesteMain();

        System.out.println(teste.repositorio.listarPecas());
        System.out.println(teste.repositorio.buscarPecasPeloNome("metal"));
    }
}