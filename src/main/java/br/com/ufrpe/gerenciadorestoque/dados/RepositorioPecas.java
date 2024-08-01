package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

import java.util.ArrayList;

public class RepositorioPecas {
    private Peca[] pecas;
    private int proxima;

    public RepositorioPecas(){
        this.pecas = new Peca[200];
        this.proxima = 0;
    }

    public void cadastrar(Peca peca){ //throws PecaJaExisteException
        this.pecas[proxima] = peca;
        proxima++;
    }

    public void removerPeca(int id){
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
            if(peca.getNomePeca().contains(nome)){
                resultado.add(peca);
            }
        }
        return resultado;
    }

    public int procurarIndice(int id){
        int indice;
        for(indice = 0; indice < this.proxima; indice++){
            if(this.pecas[indice].getIdPeca() == id){
                break;
            }
        }
        return indice;
    }

    public boolean pecaExiste (int id){
        boolean existe = false;
        if(procurarIndice(id) != this.proxima){
            existe = true;
        }
        return existe;
    }
}
