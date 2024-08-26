package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

import java.util.ArrayList;

public class RepositorioPecas {
    private Peca[] pecas;
    private int proxima;

    private static RepositorioPecas instance;

    public RepositorioPecas(){
        this.pecas = new Peca[200];
        this.proxima = 0;
    }

    //singleton
    public static RepositorioPecas getInstance(){
        if(instance == null){
            //Ler instancia do repositorio no arquivo.
        }
        return instance;
    }

    public void cadastrar(Peca peca){ //throws PecaJaExisteException
        this.pecas[proxima] = peca;
        proxima++;
    }

    public void remover(String id){
        int i = procurarIndice(id);
        if(i != this.proxima){
            this.pecas[i] = this.pecas[this.proxima - 1];
            this.pecas[this.proxima - 1] = null;
            proxima--;
        }
    }

    public ArrayList<Peca> buscarPecasPeloNome(String nome){
        ArrayList<Peca> resultado = new ArrayList<>(0);
        for(Peca peca : this.pecas){
            if(peca != null && peca.getNome().contains(nome)){
                resultado.add(peca);
            }
        }
        return resultado;
    }

    public int procurarIndice(String id){
        int indice;
        for(indice = 0; indice < this.proxima; indice++){
            if(this.pecas[indice].getId().equals(id)){
                break;
            }
        }
        return indice;
    }

    public boolean pecaExiste (String id){
        boolean existe = false;
        if(procurarIndice(id) != this.proxima){
            existe = true;
        }
        return existe;
    }
}
