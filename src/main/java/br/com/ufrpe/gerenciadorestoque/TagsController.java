package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.excecoes.TagJaExisteException;
import br.com.ufrpe.gerenciadorestoque.excecoes.TagNaoExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.controle.Fachada;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Tag;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class TagsController implements Initializable {
    @FXML
    private Button btnExcluir;

    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnNovaTag;

    @FXML
    private Button btnSalvar;

    @FXML
    private ColorPicker colorPicker;

    @FXML
    private ListView<Tag> listTags;

    @FXML
    private TextField txtFdNome;

    private Fachada fachada;

    ObservableList<Tag> tags;

    private Tag[] repTags;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        fachada = Fachada.getInstance();
        carregarTags();
    }

    public void carregarTags(){
        listTags.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
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

        repTags = fachada.getCadastroTags().getRepositorio().getTags();
        tags = FXCollections.observableArrayList(repTags);
        listTags.setItems(tags);
    }

    public void cadastrarNovaTag(ActionEvent event) {
        try{
            String nome = txtFdNome.getText();
            Color cor = colorPicker.getValue();

            Tag novaTag = new Tag(nome, cor);
            fachada.cadastrarTag(novaTag);

            carregarTags();

            txtFdNome.clear();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void excluirTag(ActionEvent event) {
        Tag tag = listTags.getSelectionModel().getSelectedItem();
        try{
            if(tag != null){
                fachada.removerTag(tag.getNome());
                carregarTags();
            }
        } catch (TagNaoExisteException e) {
            throw new RuntimeException(e);
        }
    }

    public void fecharJanela(){
        ScreenManager.getJanelaTags().close();
    }

    public void salvar(){
        ScreenManager scm = ScreenManager.getInstance();
        ObservableList<Tag> tagsSelecionadas = listTags.getSelectionModel().getSelectedItems();
        PecasController pecasController = scm.getPecasController();
        pecasController.carregarTags(tagsSelecionadas);
        fecharJanela();
        System.out.println(tagsSelecionadas.stream().toList());
    }
}

