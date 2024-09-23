package br.com.ufrpe.gerenciadorestoque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicativo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenManager.setStagePrimario(stage);
        ScreenManager.setJanelaTags(new Stage());

        FXMLLoader fxmlLoader = new FXMLLoader(Aplicativo.class.getResource("telaPecas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        stage.setResizable(false);
        stage.setTitle("Gerenciador de Pecas e Eventos");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
