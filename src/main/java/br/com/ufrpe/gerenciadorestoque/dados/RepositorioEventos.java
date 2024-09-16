package br.com.ufrpe.gerenciadorestoque.dados;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import java.io.*;

public class RepositorioEventos implements Serializable {
    @Serial
    private static final long serialVersionUID = 6770477833356L;

    private Evento[] eventos;
    private int proxima;

    private static RepositorioEventos instance;

    private RepositorioEventos(){
        this.eventos = new Evento[200];
        this.proxima = 0;
    }

    public static RepositorioEventos getInstance(){
        if(instance == null){
            instance = carregarArquivo();
        }
        return instance;
    }

    private static RepositorioEventos carregarArquivo(){
        RepositorioEventos instanciaLocal = null;
        File in = new File("eventos.dat");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try{
            fis = new FileInputStream(in);
            ois = new ObjectInputStream(fis);
            Object obj = ois.readObject();
            instanciaLocal = (RepositorioEventos) obj;

        } catch (Exception e){
            instanciaLocal = new RepositorioEventos();
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
            File out = new File("eventos.dat");
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

    public Evento procurarEvento(String nome){
        Evento evento = null;
        if(nome != null) {
            int i = procurarIndice(nome);
            if (i != proxima) {
                evento = this.eventos[i];
            }
        }
        return evento;
    }

    public int procurarIndice(String nome){
        int indice;
        for(indice = 0; indice < this.proxima; indice++){
            if(this.eventos[indice].getNome().equals(nome)){
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

    public Evento[] getEventos() {
        return eventos;
    }
}


