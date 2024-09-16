package br.com.ufrpe.gerenciadorestoque;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class Aplicativo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        ScreenManager.setStage(stage);

        FXMLLoader fxmlLoader = new FXMLLoader(Aplicativo.class.getResource("telaPecas.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
