package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;
import java.io.*;

public class RepositorioTags implements Serializable {
    @Serial
    private static final long serialVersionUID = 26854313216006L;

    private Tag[] tags;
    private int proxima;

    private static RepositorioTags instance;

    private RepositorioTags(){
        this.tags = new Tag[200];
        this.proxima = 0;
    }

    //singleton
    public static RepositorioTags getInstance(){
        if(instance == null){
            instance = carregarArquivo();
        }
        return instance;
    }

    private static RepositorioTags carregarArquivo(){
        RepositorioTags instanciaLocal = null;
        File in = new File("tags.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            instanciaLocal = (RepositorioTags) obj;

        } catch (Exception e){
            instanciaLocal = new RepositorioTags();
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
            File out = new File("tags.dat");
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
