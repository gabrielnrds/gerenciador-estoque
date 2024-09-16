package br.com.ufrpe.gerenciadorestoque.negocio.controle;

public class Fachada {
    private CadastroPecas cadastroPecas;
    private CadastroEventos cadastroEventos;
    private CadastroMovimentacaoPecas cadastroMovimentacaoPecas;

    private static Fachada instance;

    private Fachada(){
        this.cadastroPecas = new CadastroPecas();
        this.cadastroEventos = new CadastroEventos();
        this.cadastroMovimentacaoPecas = new CadastroMovimentacaoPecas();
    }

    public static Fachada getInstance(){
        if(instance == null){
            instance = new Fachada();
        }
        return instance;
    }

    public CadastroEventos getCadastroEventos() {
        return this.cadastroEventos;
    }

    public CadastroPecas getCadastroPecas() {
        return this.cadastroPecas;
    }

    public CadastroMovimentacaoPecas getCadastroMovimentacaoPecas(){
        return this.cadastroMovimentacaoPecas;
    }
}

