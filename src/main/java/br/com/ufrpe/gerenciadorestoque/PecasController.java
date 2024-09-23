package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.excecoes.PecaNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.PecaReservadaException;
import br.com.ufrpe.gerenciadorestoque.negocio.controle.Fachada;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.util.Callback;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class PecasController implements Initializable {

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnEditar;

    @FXML
    private Button btnRemover;

    @FXML
    private Button btnSalvarPeca;

    @FXML
    private Button btnTags;

    @FXML
    private Button btnTelaEventos;

    @FXML
    private Button btnTelaMovimentacoes;

    @FXML
    private Button btnTelaPecas;

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
    private TableView<Peca> tabelaPecas;

    @FXML
    private TextField txtFdBuscar;

    @FXML
    private TextArea txtAreaDescricao;

    @FXML
    private TextField txtFdId;

    @FXML
    private TextField txtFdLocalidade;

    @FXML
    private TextField txtFdNome;

    @FXML
    private TextField txtFdQtdMin;

    @FXML
    private TextField txtFdQuantidade;

    @FXML
    private TextField txtFdValor;

    @FXML
    private ListView<Tag> listTags;

    private ObservableList<Peca> pecas;

    private ObservableList<Tag> tags;

    private Fachada fachada;

    @FXML
    public void abrirTelaTags(ActionEvent event) throws IOException {
        ScreenManager scm = ScreenManager.getInstance();
        scm.janelaTags();
    }

    @FXML
    public void irParaTelaEventos(ActionEvent event){
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaEventos.fxml", "Gerenciar Eventos");
    }

    @FXML
    public void buscar(ActionEvent event){
        String stringBusca = txtFdBuscar.getText();
        if(stringBusca != null && !stringBusca.isEmpty()){
            tabelaPecas.setItems(FXCollections.observableArrayList(fachada.buscarPecasPeloNome(stringBusca)));
        }
    }

    @FXML
    public void removerPeca(ActionEvent event){
        TableView.TableViewSelectionModel<Peca> selectionModel = tabelaPecas.getSelectionModel();
        try {
            Peca peca = selectionModel.getSelectedItem();
            fachada.removerPeca(peca.getId());
            atualizarTabela(event);
        } catch (PecaNaoExisteException pne){
            System.out.println(pne.getMessage());
        } catch (PecaReservadaException pre) {
            System.out.println(pre.getMessage());
        }
    }

    @FXML
    public void cadastrarPeca(ActionEvent event){
        try {
            String idPeca = txtFdId.getText();
            String nome = txtFdNome.getText();
            String descricao = txtAreaDescricao.getText();
            String localidade = txtFdLocalidade.getText();
            Double valor = Double.parseDouble(txtFdValor.getText());
            Integer quantidade = Integer.parseInt(txtFdQuantidade.getText());
            Integer qtdMin = Integer.parseInt(txtFdQtdMin.getText());
            ArrayList<Tag> tags = new ArrayList<>(listTags.getItems());

            Peca peca = new Peca(idPeca, nome, descricao, valor, qtdMin, quantidade, localidade, tags);
            fachada.cadastrarPeca(peca);

            txtFdId.clear();
            txtFdNome.clear();
            txtAreaDescricao.clear();
            txtFdLocalidade.clear();
            txtFdValor.clear();
            txtFdQuantidade.clear();
            txtFdQtdMin.clear();
            listTags.getItems().clear();

            atualizarTabela(event);
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    @FXML
    public void atualizarTabela(ActionEvent event){
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

    public void setTags(ObservableList<Tag> tags) {
        this.listTags.setItems(tags);
    }

    public void carregarTags(ObservableList<Tag> tags){
        listTags.setCellFactory(new Callback<ListView<Tag>, ListCell<Tag>>() {
            @Override
            public ListCell<Tag> call(ListView<Tag> tagListView) {
                return new ListCell<Tag>() {
                    @Override
                    protected void updateItem(Tag tag, boolean empty){
                        super.updateItem(tag, empty);
                        if (empty || tag == null){
                            setText(null);
                        } else {
                            setText(tag.getNome());
                        }
                    }
                };
            }
        });
        listTags.setItems(tags);
    }
}