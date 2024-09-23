package br.com.ufrpe.gerenciadorestoque;

import javafx.fxml.FXMLLoader;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.scene.Scene;

import java.io.IOException;

public class ScreenManager {
    private static ScreenManager instance;
    private static Stage stagePrimario;
    private static Stage janelaTags;
    private static Scene scene;

    private Scene telaTags;
    private Scene telaPecas;
    private Scene telaEventos;
    private Scene telaCadastroEvento;


    private TagsController tagsController;
    private PecasController pecasController;
    private EventosController eventosController;
    private CadastroEventoController cadastroEventoController;

    public ScreenManager(){
        this.screenLoader();
    }

    public static ScreenManager getInstance(){
        if(instance == null){
            instance = new ScreenManager();
        }
        return instance;
    }

    public static Stage getStagePrimario(){
        return stagePrimario;
    }

    public static void setStagePrimario(Stage stg){
        stagePrimario = stg;
    }

    public static Stage getJanelaTags() {
        return janelaTags;
    }

    public static void setJanelaTags(Stage janelaTags) {
        ScreenManager.janelaTags = janelaTags;
    }

    public Scene getTelaPecas() {
        return telaPecas;
    }

    public Scene getTelaEventos() {
        return telaEventos;
    }

    public Scene getTelaCadastroEvento() {
        return telaCadastroEvento;
    }

    public PecasController getPecasController() {
        return pecasController;
    }

    public EventosController getEventosController() {
        return eventosController;
    }

    public Scene getTelaTags() {
        return telaTags;
    }

    public void setTelaTags(Scene telaTags) {
        this.telaTags = telaTags;
    }

    public TagsController getTagsController() {
        return tagsController;
    }

    public void setTagsController(TagsController tagsController) {
        this.tagsController = tagsController;
    }

    public CadastroEventoController getCadastroEventoController() {
        return cadastroEventoController;
    }

    private void screenLoader(){
        try {
            FXMLLoader telaTagsPane = new FXMLLoader(getClass().getResource("telaTags.fxml"));
            this.telaTags = new Scene(telaTagsPane.load(), 406, 302);
            this.tagsController = telaTagsPane.getController();
            janelaTags.initModality(Modality.APPLICATION_MODAL);
            janelaTags.setResizable(false);
            janelaTags.setTitle("Tags");
            janelaTags.setScene(telaTags);

            FXMLLoader telaPecasPane = new FXMLLoader(getClass().getResource("telaPecas.fxml"));
            this.telaPecas = new Scene(telaPecasPane.load());
            this.pecasController = telaPecasPane.getController();

            FXMLLoader telaEventosPane = new FXMLLoader(getClass().getResource("telaEventos.fxml"));
            this.telaEventos = new Scene(telaEventosPane.load());
            this.eventosController = telaEventosPane.getController();

            FXMLLoader telaCadastroEventoPane = new FXMLLoader(getClass().getResource("telaCadastroEvento.fxml"));
            this.telaCadastroEvento = new Scene(telaCadastroEventoPane.load());
            this.cadastroEventoController = telaCadastroEventoPane.getController();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void janelaTags(){
        janelaTags.setScene(telaTags);
        janelaTags.showAndWait();
    }

    public void changeScreen(String fileNameFxml, String titleScreen){
        boolean max = stagePrimario.isMaximized();
        if(max) stagePrimario.setMaximized(false);

        switch (fileNameFxml){
            case "telaPecas.fxml" -> stagePrimario.setScene(telaPecas);
            case "telaEventos.fxml" -> stagePrimario.setScene(telaEventos);
            case "telaCadastroEvento.fxml" -> stagePrimario.setScene(telaCadastroEvento);
        }
        stagePrimario.setTitle(titleScreen);

        if(max) stagePrimario.setMaximized(true);
    }
}
