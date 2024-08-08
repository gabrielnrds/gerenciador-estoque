package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.MovimentacaoPeca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

import java.util.ArrayList;

public class RepositorioMovimentoPecas {
    private MovimentacaoPeca[] movimentos;
    private int proxima;

    private static RepositorioMovimentoPecas instance;

    public RepositorioMovimentoPecas(){
        this.movimentos = new MovimentacaoPeca[200];
        this.proxima = 0;
    }

    //singleton
    public static RepositorioMovimentoPecas getInstance(){
        if(instance == null){
            //Ler instancia do repositorio no arquivo.
        }
        return instance;
    }

    public void cadastrar(MovimentacaoPeca movimentacao){
        this.movimentos[proxima] = movimentacao;
        proxima++;
    }

    public void removerMovimentacao(int num){
        int i = procurarIndice(num);
        if(i != this.proxima){
            this.movimentos[i] = this.movimentos[this.proxima - 1];
            this.movimentos[this.proxima - 1] = null;
            proxima--;
        }
    }

    public int procurarIndice(int num){
        int indice;
        for(indice = 0; indice < this.proxima; indice++){
            if(this.movimentos[indice].getNumMovimentacao() == num){
                break;
            }
        }
        return indice;
    }

    public boolean movimentacaoExiste(int num){
        boolean existe = false;
        if(procurarIndice(num) != this.proxima){
            existe = true;
        }
        return existe;
    }
}
