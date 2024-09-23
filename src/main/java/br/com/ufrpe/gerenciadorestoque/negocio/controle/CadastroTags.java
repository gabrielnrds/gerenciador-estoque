package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.dados.RepositorioTags;
import br.com.ufrpe.gerenciadorestoque.excecoes.TagJaExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.TagNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;

public class CadastroTags {
    private RepositorioTags repositorioTags;

    public CadastroTags(){
        this.repositorioTags = RepositorioTags.getInstance();
    }

    public void cadastrar(Tag tag) throws TagJaExisteException {
        if(tag != null){
            if(tag.getNome().isEmpty()){
                throw new IllegalArgumentException("Preencha o campo nome da tag.");
            }
            if(!this.repositorioTags.tagExiste(tag.getNome())){
                this.repositorioTags.cadastrar(tag);
            } else {
                throw new TagJaExisteException(tag.getNome());
            }
        } else {
            throw new IllegalArgumentException("Tag inválida.");
        }
    }

    public void remover(String nome) throws TagNaoExisteException {
        this.repositorioTags.remover(nome);
    }

    public RepositorioTags getRepositorio() {
        return repositorioTags;
    }
}

