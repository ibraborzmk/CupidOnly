package com.example.projetjava;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
public class InscriptionControlleur {


    public Label lblErrors;
    public Button connecte;
    @FXML
        private TextField Nomtxt;

        @FXML
        private TextField Prenomtxt;

        @FXML
        private TextField Genretxt;

        @FXML
        private TextField Mailtxt;

        @FXML
        private Button btnSignup;

        // Le dictionnaire pour stocker les informations des utilisateurs
        private Map<String, String[]> users = new HashMap<>();

        @FXML
        private void initialize() {
            // Code d'initialisation (s'il y en a)
            btnSignup.setOnAction(e -> {
                String nom = Nomtxt.getText();
                String prenom = Prenomtxt.getText();
                String genre = Genretxt.getText();
                String mail = Mailtxt.getText();

                // Vérifier si l'utilisateur a rempli tous les champs
                if (nom.isEmpty() || prenom.isEmpty() || genre.isEmpty() || mail.isEmpty()) {
                    // Afficher un message d'erreur à l'utilisateur
                    System.out.println("Tous les champs doivent être remplis");
                    lblErrors.setText("Tous les champs doivent être remplis");
                    return;
                }

                // Stocker les informations de l'utilisateur dans une liste
                String[] userData = new String[]{nom, prenom, genre};

                // Stocker les informations de l'utilisateur dans le dictionnaire
                users.put(mail, userData);

                // Afficher un message de succès à l'utilisateur
                System.out.println("Utilisateur enregistré avec succès !");
                Stage stage = (Stage) btnSignup.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
                Scene scene = null;
                try {
                    scene = new Scene(fxmlLoader.load() , 700, 400);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
                primaryStage.setTitle("Page de Profile");
                primaryStage.setScene(scene);
                primaryStage.show();

            });
        }

    @FXML
    public void goInscription(ActionEvent actionEvent) throws IOException {


    }

    public void goconnecte(ActionEvent actionEvent) throws IOException {

        Stage stage = (Stage) connecte.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("connexion.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 700, 400);
        Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Page de connexion");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    // Ajouter des méthodes de gestion d'événements pour les boutons, etc.

    }

