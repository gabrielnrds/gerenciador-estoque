package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.negocio.controle.Fachada;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
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

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class EventosController implements Initializable {

    @FXML
    private Button btnAdicionarEvento;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnEstoque;

    @FXML
    private Button btnEventos;

    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnMovimentacoes;

    @FXML
    private TableColumn<Evento, String> colunaCliente;

    @FXML
    private TableColumn<Evento, LocalDate> colunaData;

    @FXML
    private TableColumn<Evento, String> colunaEndereco;

    @FXML
    private TableColumn<Evento, String> colunaNome;

    @FXML
    private TableColumn<Evento, Double> colunaValor;

    @FXML
    private TableView<Evento> tabelaEventos;

    @FXML
    private TextField txtFdBuscar;

    private ObservableList<Evento> eventos;

    public void irParaTelaEstoque() {
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaPecas.fxml", "Estoque de Peças");
    }

    public void adicionarEvento(){
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaCadastroEvento.fxml", "Novo Evento");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Fachada fachada = Fachada.getInstance();

        colunaNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaValor.setCellValueFactory(new PropertyValueFactory<>("valor"));
        colunaCliente.setCellValueFactory(new PropertyValueFactory<>("cliente"));
        colunaData.setCellValueFactory(new PropertyValueFactory<>("dataEvento"));
        colunaEndereco.setCellValueFactory(new PropertyValueFactory<>("endereco"));

        Evento[] rep = fachada.getCadastroEventos().getRepositorioEventos().getEventos();
        eventos = FXCollections.observableArrayList(rep);

        tabelaEventos.setItems(eventos);
    }
}
