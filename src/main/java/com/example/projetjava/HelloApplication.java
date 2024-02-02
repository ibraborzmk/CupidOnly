package com.example.projetjava;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
         FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connexion.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
        stage.getIcons().add(icon);
        stage.setTitle("Page de connexion");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }
}
