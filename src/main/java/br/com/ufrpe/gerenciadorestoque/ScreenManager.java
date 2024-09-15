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


    private CadastroEventoController cadastroEventoController;

    private static ScreenManager getInstance(){
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


    private void screenLoader(){
        try {
            FXMLLoader telaPecasPane = new FXMLLoader(getClass().getResource("telaPecas.fxml"));
            this.telaPecas = new Scene(telaPecasPane.load());
            //this.telaPecasController = telaPecasPane.getController();

        }catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public void changeScreen(String fileNameFxml, String titleScreen){
        boolean max = stage.isMaximized();
        if(max) stage.setMaximized(false);

        switch (fileNameFxml){
            case "telaPecas.fxml" -> stage.setScene(telaPecas);
        }
        stage.setTitle(titleScreen);

        if(max) stage.setMaximized(true);
    }
}
