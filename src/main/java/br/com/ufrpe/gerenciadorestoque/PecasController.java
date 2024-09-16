package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.controle.Fachada;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PecasController implements Initializable {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnCadastrarPeca;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnTelaEstoque;

    @FXML
    private Button btnTelaEventos;

    @FXML
    private Button btnTelaMovimentacoes;

    @FXML
    private TableView<Peca> tabelaPecas;

    @FXML
    private TableColumn<Peca, String> colunaId;

    @FXML
    private TableColumn<Peca, String> colunaLocalidade;

    @FXML
    private TableColumn<Peca, String> colunaNome;

    @FXML
    private TableColumn<Peca, Integer> colunaQtdMin;

    @FXML
    private TableColumn<Peca, Integer> colunaQuantidade;

    @FXML
    private TableColumn<Peca, Double> colunaValor;

    @FXML
    private TextField txtFdBuscar;

    private ObservableList<Peca> pecas;

    private Fachada fachada;

    public void irParaTelaEventos(){
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaEventos.fxml", "Gerenciar Eventos");
    }

    public void irPraTelaCadastroPecas(){
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaNovaPeca.fxml", "Nova Peça");
    }

    public void buscar(){
        String stringBusca = txtFdBuscar.getText();
        if(stringBusca != null && !stringBusca.isEmpty()){
            tabelaPecas.setItems(FXCollections.observableArrayList(fachada.getCadastroPecas().buscarPecasPeloNome(stringBusca)));
        }
    }

    public void excluir(){
        TableView.TableViewSelectionModel<Peca> selectionModel = tabelaPecas.getSelectionModel();
        try {
            Peca pecaExcluir = selectionModel.getSelectedItem();
            fachada.getCadastroPecas().remover(pecaExcluir.getId());
            atualizarTabela();
        } catch (PecaNaoExisteException pne){
            pne.printStackTrace();
        }
    }

    public void atualizarTabela(){
        Peca[] rep = fachada.getCadastroPecas().getRepositorio().getPecas();
        pecas = FXCollections.observableArrayList(rep);
        tabelaPecas.setItems(pecas);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fachada = Fachada.getInstance();

        colunaId.setCellValueFactory(new PropertyValueFactory<>("id"));
        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaLocalidade.setCellValueFactory(new PropertyValueFactory<>("localEndereco"));
        colunaQuantidade.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
        colunaQtdMin.setCellValueFactory(new PropertyValueFactory<>("quantidadeMin"));

        Peca[] rep = fachada.getCadastroPecas().getRepositorio().getPecas();
        pecas = FXCollections.observableArrayList(rep);

        tabelaPecas.setItems(pecas);
    }
}