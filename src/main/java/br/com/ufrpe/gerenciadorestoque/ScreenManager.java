package br.com.ufrpe.gerenciadorestoque;

import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Scene;

public class ScreenManager {
    private static ScreenManager instance;
    private static Stage stage;
    private static Scene scene;

    private Scene telaPecas;
    private Scene telaEventos;
    private Scene telaCadastroEvento;
    private Scene telaNovaPeca;

    private CadastroPecaController cadastroPecaController;
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

    public static Stage getStage(){
        return stage;
    }

    public static void setStage(Stage stg){
        stage = stg;
    }

    public Scene getTelaCadastroEvento() {
        return this.telaCadastroEvento;
    }

    private void screenLoader(){
        try {
            FXMLLoader telaPecasPane = new FXMLLoader(getClass().getResource("telaPecas.fxml"));
            this.telaPecas = new Scene(telaPecasPane.load());
            this.pecasController = telaPecasPane.getController();

            FXMLLoader telaNovaPecaPane = new FXMLLoader(getClass().getResource("telaNovaPeca.fxml"));
            this.telaNovaPeca = new Scene(telaNovaPecaPane.load());
            this.cadastroPecaController = telaNovaPecaPane.getController();

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

    public void changeScreen(String fileNameFxml, String titleScreen){
        boolean max = stage.isMaximized();
        if(max) stage.setMaximized(false);

        switch (fileNameFxml){
            case "telaPecas.fxml" -> stage.setScene(telaPecas);
            case "telaNovaPeca.fxml" -> stage.setScene(telaNovaPeca);
            case "telaEventos.fxml" -> stage.setScene(telaEventos);
            case "telaCadastroEvento.fxml" -> stage.setScene(telaCadastroEvento);
        }
        stage.setTitle(titleScreen);

        if(max) stage.setMaximized(true);
    }
}
