package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class CadastroEventoController implements Initializable {
    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnSalvar;

    @FXML
    private TableColumn<?, ?> colunaId;

    @FXML
    private TableColumn<?, ?> colunaQuantidade;

    @FXML
    private TableColumn<?, ?> colunaValor;

    @FXML
    private DatePicker dataEvento;

    @FXML
    private TableView<ItemEvento> listaItensEvento;

    @FXML
    private TextField txtCliente;

    @FXML
    private TextArea txtDescricao;

    @FXML
    private TextField txtEndereco;

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtNome;

    @FXML
    private TextField txtQtd;

    @FXML
    private TextField txtValor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
