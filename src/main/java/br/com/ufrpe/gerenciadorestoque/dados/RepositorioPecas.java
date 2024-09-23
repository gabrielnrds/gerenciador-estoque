package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;
import javafx.collections.ObservableList;
import javafx.scene.image.Image;

import java.io.*;
import java.util.ArrayList;

public class RepositorioPecas implements Serializable {
    @Serial
    private static final long serialVersionUID = -3267455839474040297L;

    private Peca[] pecas;
    private int proxima;

    private static RepositorioPecas instance;

    private RepositorioPecas(){
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

    public String toString(){
        String resultado = "Estoque de peças:\n";
        for(Peca peca : pecas){
            if(peca != null){
                resultado += peca.toString();
            }
        }
        return resultado;
    }

    public void cadastrar(Peca peca){
        this.pecas[proxima] = peca;
        proxima++;
        salvarArquivo();
    }

    public void remover(String id) throws PecaNaoExisteException {
        int i = procurarIndice(id);
        if(i != this.proxima){
            this.pecas[i] = this.pecas[this.proxima - 1];
            this.pecas[this.proxima - 1] = null;
            proxima--;
            salvarArquivo();
        } else {
            throw new PecaNaoExisteException(id);
        }
    }

    public void atualizar(Peca peca, String novoNome, String novaDescricao, double novoValor, int novaQuantidade, int novaQtdMin, String novoLocalEndereco, ArrayList<Tag> novasTags){
        int i = procurarIndice(peca.getId());

        if(i != proxima){
            Peca novaPeca = pecas[i];

            novaPeca.setNome(novoNome);
            novaPeca.setDescricao(novaDescricao);
            novaPeca.setValor(novoValor);
            novaPeca.setQuantidade(novaQuantidade);
            novaPeca.setQuantidadeMin(novaQtdMin);
            novaPeca.setLocalEndereco(novoLocalEndereco);
            novaPeca.setTags(novasTags);

            pecas[i] = novaPeca;
            salvarArquivo();
        }
    }

    public Peca procurarPeca(String id){
        Peca peca = null;
        if(id != null) {
            int i = procurarIndice(id);
            if (i != proxima) {
                peca = this.pecas[i];
            }
        }
        return peca;
    }

    public ArrayList<Peca> filtrarPorTag(Tag tag){
        ArrayList<Peca> resultado = new ArrayList<>(0);
        if(tag != null){
            for(Peca peca : this.pecas){
                if(peca != null && peca.getTags().contains(tag)){
                    resultado.add(peca);
                }
            }
        }
        return resultado;
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
        if(id == null){
            return false;
        }
        boolean existe = false;
        if(procurarIndice(id) != this.proxima){
            existe = true;
        }
        return existe;
    }

    public Peca[] getPecas(){
        return this.pecas;
    }
}