package br.com.ufrpe.gerenciadorestoque;

import br.com.ufrpe.gerenciadorestoque.excecoes.PecaJaExisteException;
import br.com.ufrpe.gerenciadorestoque.negocio.controle.Fachada;
import br.com.ufrpe.gerenciadorestoque.negocio.entidades.Peca;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.lang.invoke.StringConcatException;
import java.net.URL;
import java.security.spec.ECField;
import java.util.ResourceBundle;

public class CadastroPecaController implements Initializable {
    @FXML
    private Button btnAdicionarTags;

    @FXML
    private Button btnSalvar;

    @FXML
    private Button btnSelecionarImagem;

    @FXML
    private Button btnVoltar;

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
    private ImageView imgPeca;

    @FXML
    private Label lblAviso;

    private Fachada fachada;

    private ScreenManager scm;

    public void voltar(){
        ScreenManager scm = ScreenManager.getInstance();
        scm.changeScreen("telaPecas.fxml", "Estoque de Peças");
    }


    public void salvarPeca(){
        try {
            String idPeca = txtFdId.getText();
            String nome = txtFdNome.getText();
            String descricao = txtAreaDescricao.getText();
            String localidade = txtFdLocalidade.getText();
            Image imagemPeca = imgPeca.getImage();
            Double valor = Double.parseDouble(txtFdValor.getText());
            Integer quantidade = Integer.parseInt(txtFdQuantidade.getText());
            Integer qtdMin = Integer.parseInt(txtFdQtdMin.getText());

            Peca peca = new Peca(idPeca, nome, descricao, valor, imagemPeca, qtdMin, quantidade, localidade);
            fachada.getCadastroPecas().cadastrar(peca);
            lblAviso.setText("Peça adicionada com sucesso!");

            txtFdId.clear();
            txtFdNome.clear();
            txtAreaDescricao.clear();
            txtFdLocalidade.clear();
            txtFdValor.clear();
            txtFdQuantidade.clear();
            txtFdQtdMin.clear();

        } catch (PecaJaExisteException pje){
            lblAviso.setText(pje.getMessage());
        } catch (Exception e){
            lblAviso.setText("Preencha todos os campos!");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.fachada = Fachada.getInstance();

    }
}
