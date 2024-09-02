package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.MovimentacaoPeca;

import java.io.*;

public class RepositorioMovimentoPecas implements Serializable {
    @Serial
    private static final long serialVersionUID = 56221355430000L;

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
            instance = carregarArquivo();
        }
        return instance;
    }

    private static RepositorioMovimentoPecas carregarArquivo(){
        RepositorioMovimentoPecas instanciaLocal = null;
        File in = new File("movimentos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            instanciaLocal = (RepositorioMovimentoPecas) obj;

        } catch (Exception e){
            instanciaLocal = new RepositorioMovimentoPecas();
        } finally {
            if(ois != null){
                try{
                    ois.close();
                } catch (IOException e){}
            }
        }
        return instanciaLocal;
    }

    public void salvarArquivo(){
        if(instance != null){
            File out = new File("movimentos.dat");
            FileOutputStream fos = null;
            ObjectOutputStream oos = null;

            try {
                fos = new FileOutputStream(out);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(instance);
            } catch (Exception e){
                e.printStackTrace();
            } finally {
                if(oos != null){
                    try {
                        oos.close();
                    } catch (IOException e){}
                }
            }
        }
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
