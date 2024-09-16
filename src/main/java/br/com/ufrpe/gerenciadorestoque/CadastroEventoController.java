package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.excecoes.EventoJaExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.QtdSuperiorQueADisponivelException;
import br.com.ufrpe.gerenciadorestoque.negocio.controle.Fachada;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Evento;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.ItemEvento;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
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
    private TableColumn<ItemEvento, String> colunaId;

    @FXML
    private TableColumn<ItemEvento, Integer> colunaQuantidade;

    @FXML
    private TableColumn<ItemEvento, Double> colunaValor;

    @FXML
    private DatePicker dataEvento;

    @FXML
    private TableView<ItemEvento> tabelaItensEvento;

    @FXML
    private TextField txtFdCliente;

    @FXML
    private TextArea txtFdDescricao;

    @FXML
    private TextField txtFdEndereco;

    @FXML
    private TextField txtFdId;

    @FXML
    private TextField txtFdNome;

    @FXML
    private TextField txtFdQtd;

    @FXML
    private TextField txtFdValor;
    
    private ObservableList<ItemEvento> itens;

    @FXML
    private Label lblMsg;

    public void cancelar(){
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaEventos.fxml", "Gerenciar Eventos");
    }

    public void salvarEvento(){
        try{
            String nome = txtFdNome.getText();
            String cliente = txtFdCliente.getText();
            LocalDate data = dataEvento.getValue();
            String descricao = txtFdDescricao.getText();
            String endereco = txtFdEndereco.getText();
            ArrayList itensEvento = new ArrayList<>(itens);

            if(nome.isEmpty() || cliente.isEmpty() || data == null || descricao.isEmpty() || endereco.isEmpty()){
                lblMsg.setText("Preencha todos os campos!");
            } else {
                try{
                    Evento evento = new Evento(nome, descricao, cliente, endereco, data);
                    Fachada fachada = Fachada.getInstance();
                    fachada.getCadastroEventos().cadastrar(evento);
                } catch (EventoJaExisteException eje){
                    lblMsg.setText(eje.getMessage());
                }
            }
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }
}
