package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioPecas;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

public class TesteMain {
    private RepositorioPecas repositorio;

    public TesteMain() {
        this.repositorio = new RepositorioPecas();
    }

    public static void main(String[] args){
        TesteMain teste = new TesteMain();

        Peca peca1 = new Peca("peca1", "mesa madeira");
        Peca peca2 = new Peca("peca2", "mesa metal");
        Peca peca3 = new Peca("peca3", "Balao n1");
        teste.repositorio.cadastrar(peca1);
        teste.repositorio.cadastrar(peca2);
        teste.repositorio.cadastrar(peca3);
        System.out.println(teste.repositorio.buscarPecasPeloNome("mesa"));
        System.out.println(teste.repositorio.pecaExiste("peca1"));
    }
}