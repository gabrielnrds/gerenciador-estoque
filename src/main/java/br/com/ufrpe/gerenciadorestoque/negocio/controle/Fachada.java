package br.com.ufrpe.gerenciadorestoque.negocio.controle;

public class Fachada {
    private CadastroPecas pecas;

    private static Fachada instance;

    private Fachada(){
        this.pecas = new CadastroPecas();
    }

    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }
}

