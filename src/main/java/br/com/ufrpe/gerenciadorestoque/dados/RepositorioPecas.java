package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

import java.io.*;
import java.util.ArrayList;

public class RepositorioPecas implements Serializable {
    @Serial
    private static final long serialVersionUID = -3267455839474040297L;

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
            instance = carregarArquivo();
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

    public String listarPecas(){
        String resultado = "";
        for(Peca peca : this.pecas){
            if(peca != null){
                resultado += peca.toString();
            } else { break; }
        }
        return resultado;
    }

    private static RepositorioPecas carregarArquivo(){
        RepositorioPecas instanciaLocal = null;
        File in = new File("pecas.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            instanciaLocal = (RepositorioPecas) obj;

        } catch (Exception e){
            instanciaLocal = new RepositorioPecas();
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
            File out = new File("pecas.dat");
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
}