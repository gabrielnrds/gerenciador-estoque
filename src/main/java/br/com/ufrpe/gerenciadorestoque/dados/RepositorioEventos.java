package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;

public class RepositorioEventos {
    private Evento[] eventos;
    private int proxima;

    private static RepositorioEventos instance;

    public RepositorioEventos(){
        this.eventos = new Evento[200];
        this.proxima = 0;
    }

    public static RepositorioEventos getInstance(){
        if(instance == null){
            //ler instancia do repositorio no arquino
        }
        return instance;
    }

    public void cadastrar(Evento evento){
        this.eventos[proxima] = evento;
        proxima++;
    }

    public void remover(String nome){
        int i = procurarIndice(nome);
        if(i != this.proxima){
            this.eventos[i] = this.eventos[this.proxima - 1];
            this.eventos[this.proxima - 1] = null;
            proxima--;
        }
    }

    public int procurarIndice(String nome){
        int indice;
        for(indice = 0; indice < this.proxima; indice++){
            if(this.eventos[indice].getNomeEvento().equals(nome)){
                break;
            }
        }
        return indice;
    }

    public boolean eventoExiste(String nome){
        boolean existe = false;
        if(procurarIndice(nome) != this.proxima){
            existe = true;
        }
        return existe;
    }
}


