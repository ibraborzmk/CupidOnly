package com.example.projetjava;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ConnexionController {

        @FXML
        private TextField txtUsername;

        @FXML
        private PasswordField txtPassword;

        @FXML
        private Button btnSignin;

        @FXML
        private Label btnForgot;

        @FXML
        private Button btnSignup;

        @FXML
        private Label lblErrors;


        @FXML
        public void insciptiongo(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) btnSignup.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Inscription.fxml"));
                Scene scene = new Scene(fxmlLoader.load() , 780, 450);
                primaryStage.setTitle("I N S C R I P T I O N");
                primaryStage.setScene(scene);
                primaryStage.show();
        }


        public void Connexiongo(ActionEvent actionEvent) {
                String username = txtUsername.getText();
                String password = txtPassword.getText();

                // Créer une carte pour stocker les informations d'identification
                Map<String, String> credentials = new HashMap<>();
                credentials.put("", "");
                credentials.put("admin", "admin");
                credentials.put("user2", "password2");
                credentials.put("user3", "password3");

                // Vérifier si les informations d'identification sont correctes
                if (credentials.containsKey(username) && credentials.get(username).equals(password)) {
                        try {
                                Stage stage = (Stage) btnSignin.getScene().getWindow();
                                stage.close();
                                Stage primaryStage = new Stage();
                                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
                                Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                                Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
                                primaryStage.getIcons().add(icon);
                                primaryStage.setTitle("P R O F I L E");
                                primaryStage.setScene(scene);
                                primaryStage.show();
                        } catch (IOException e) {
                                e.printStackTrace();
                        }
                } else {
                        // Afficher un message d'erreur si les informations d'identification sont incorrectes
                        lblErrors.setText("Identifiant ou mot de passe incorrect");
                }
        }


        // Ajoutez d'autres méthodes de contrôleur si nécessaire



}
