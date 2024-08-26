package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;

import java.util.ArrayList;

public class RepositorioTags {
    private Tag[] tags;
    private int proxima = 0;

    private static RepositorioTags instance;

    public RepositorioTags(){
        this.tags = new Tag[200];
        this.proxima = 0;
    }

    //singleton
    public static RepositorioTags getInstance(){
        if(instance == null){
            //Ler instancia do repositorio no arquivo.
        }
        return instance;
    }

    public void cadastrar(Tag tag){
        this.tags[proxima] = tag;
        proxima++;
    }

    public void remover(String nome){
        int i = procurarIndice(nome);
        if(i != this.proxima){
            this.tags[i] = this.tags[this.proxima - 1];
            this.tags[this.proxima - 1] = null;
            proxima--;
        }
    }

    public int procurarIndice(String nome){
        int indice;
        for(indice = 0; indice < this.proxima; indice++){
            if(this.tags[indice].getNome().equals(nome)){
                break;
            }
        }
        return indice;
    }

    public boolean tagExiste (String nome){
        boolean existe = false;
        if(procurarIndice(nome) != this.proxima){
            existe = true;
        }
        return existe;
    }

}
