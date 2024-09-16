package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.excecoes.*;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstance();
        //fachada.getCadastroEventos().cadastrar(new Evento(String nome, String descricao, String cliente, String endereco, ArrayList< ItemEvento > itensEvento, LocalDate dataEvento));
        //Peca(String id, String nome, String descricao, double valor, Image fotoPeca, int quantidadeMin, int quantidade, String localEndereco) {
        try{
            fachada.getCadastroPecas().cadastrar(new Peca("peca00", "Cadeira de plástico", "cadeira branca de plastico", 10, null, 20, 30, "casa"));
            fachada.getCadastroPecas().cadastrar(new Peca("peca09", "Painel de madeira", "Painel de madeira 2 metros", 45, null, 3, 3, "casa"));
            fachada.getCadastroEventos().cadastrar(new Evento("Aniverário", "", "José", "Space Center, rua sla oq, 234", LocalDate.now()));
            fachada.getCadastroEventos().adicionarItemEvento("Aniversário", "peca01", 10);
            System.out.println(fachada.getCadastroPecas().getRepositorio().procurarPeca("peca00"));
        } catch (QtdSuperiorQueADisponivelException | EventoNaoExisteException | PecaNaoExisteException | PecaJaExisteException | EventoJaExisteException e){
            System.out.println(e.getMessage());
        }

    }
}
