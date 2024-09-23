package br.com.ufrpe.gerenciadorestoque.negocio.controle;

import br.com.ufrpe.gerenciadorestoque.excecoes.*;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;

import java.time.LocalDate;

public class Teste {
    public static void main(String[] args) {
        Fachada fachada = Fachada.getInstance();
        try{
            fachada.cadastrarPeca(new Peca("peca02", "Tapete vermelho", "Tapete vermelho 5m", 30.0, 0, 2, "casa", null));
            fachada.cadastrarPeca(new Peca("peca01", "Boleira", "Boleira prateada 45cm", 10.0, 2, 3, "casa", null));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            fachada.cadastrarPeca(new Peca("peca03", "Boleira", "Boleira dourada 45cm", 10.0, 0, 2, "casa", null));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
        try{
            fachada.cadastrarPeca(new Peca("", "Cadeira de plástico", "", 10.0, 10, 20, "Galpão", null));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try{
            fachada.cadastrarTag(new Tag("Retro"));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        System.out.println(fachada.listarRepositorioPecas());

        try {
            fachada.cadastrarEvento(new Evento("Aniversário de julia", "", "Julia", "Rua fulano de tal, 21", LocalDate.of(2024, 9, 25), null));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            fachada.cadastrarEvento(new Evento("Aniversário de julia", "dasdasd", "Roberto", "Rua fulano de tal, 50", LocalDate.of(2024, 9, 25), null));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            fachada.cadastrarEvento(new Evento("Casamento", "", "Ana Clara", "Rua fulano de tal, 21", LocalDate.of(2024, 9, 10), null));
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            fachada.adicionarItemEvento("Aniversário de julia", "peca01", 1);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }

        try {
            fachada.removerPeca("pn01");
            fachada.removerPeca("peca01");
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
