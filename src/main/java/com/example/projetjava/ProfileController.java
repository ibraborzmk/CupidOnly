package com.example.projetjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.*;
import java.util.Arrays;
import java.util.List;

public class ProfileController {
        @FXML
        public Button calendrierButton;
        @FXML
        public Button rdvButton;
        @FXML
        public Button profileButton;
        @FXML
        public Button resultatButton;
        public Button btnajout;
        public TextField nomtxt;
        public TextField mailtxt;
        public TextField prenomtxt;
        public TextField genretxt;
        public TextField ddntxt;
        public TableColumn colloneNom;
        public TableColumn collonePrenom;
        public TableColumn colloneMail;
        public TableColumn colloneGenre;
        public TableColumn colloneDDN;
        public TableView tableView;

        private ObservableList<String> champsList = FXCollections.observableArrayList();

        private ComboBox<String> comboBox;



        @FXML
        private TextField textField;

        @FXML
        private Button addButton;

        @FXML
        private void initialize() {
                remplirTableau();
                chargerDonnees();
        }


        @FXML
        private void handleAddButtonAction() {
                // Ajouter du code pour gérer l'action du bouton Ajouter ici
        }

        //goResulat doit fermer la fenetre actuelle et ouvrir la fenetre resultat
        public void goResultat(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) resultatButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("resultat.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("Resultat RDV");
                primaryStage.setScene(scene);
                primaryStage.show();

        }
        // goCalendrier doit fermer la fenetre actuelle et ouvrir la fenetre calendrier

        @FXML
        public void goCalendrier(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) calendrierButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calendrier.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 900, 600);
                Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("Page de Match ");
                primaryStage.setScene(scene);
                primaryStage.show();
        }


        public void goRdv(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) rdvButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rdv.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("Pade de RDV");
                primaryStage.setScene(scene);
                primaryStage.show();
        }

        public void goProfile(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) profileButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 700, 400);
                Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
                primaryStage.getIcons().add(icon);
                primaryStage.setTitle("P R O F I L E");
                primaryStage.setScene(scene);
                primaryStage.show();

        }




        public void ajoutprofile(ActionEvent actionEvent) {
                String nom = nomtxt.getText();
                String mail = mailtxt.getText();
                String prenom = prenomtxt.getText();
                String genre = genretxt.getText();
                String ddn = ddntxt.getText();

                List<String> infoAjout = Arrays.asList(nom, prenom, mail, genre, ddn);

                // ajout de la sous-liste à champlist
                champsList.add(infoAjout.toString());
                System.out.println(champsList);




// Création d'un nouvel objet Personne avec les valeurs des champs de texte
                Personne personne = new Personne(nom, prenom, mail, genre, ddn);

                // Ajout de la personne dans la TableView
                tableView.getItems().add(personne);
                sauvegarderDonnees(personne);

                // Lier les colonnes à la classe Personne
                colloneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                collonePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                colloneMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
                colloneGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
                colloneDDN.setCellValueFactory(new PropertyValueFactory<>("ddn"));


        }

        public class Personne {
                private String nom;
                private String prenom;
                private String mail;
                private String genre;
                private String ddn;

                public Personne(String nom, String prenom, String mail, String genre, String ddn) {
                        this.nom = nom;
                        this.prenom = prenom;
                        this.mail = mail;
                        this.genre = genre;
                        this.ddn = ddn;
                }

                public String getNom() {
                        return nom;
                }

                public void setNom(String nom) {
                        this.nom = nom;
                }

                public String getPrenom() {
                        return prenom;
                }

                public void setPrenom(String prenom) {
                        this.prenom = prenom;
                }

                public String getMail() {
                        return mail;
                }

                public void setMail(String mail) {
                        this.mail = mail;
                }

                public String getGenre() {
                        return genre;
                }

                public void setGenre(String genre) {
                        this.genre = genre;
                }

                public String getDdn() {
                        return ddn;
                }

                public void setDdn(String ddn) {
                        this.ddn = ddn;
                }


        }
        public void sauvegarderDonnees(Personne personne) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/java/donnees.txt", true))) {
                        // Écrire les valeurs de la personne dans le fichier
                        writer.write(personne.getNom() + "," + personne.getPrenom() + "," + personne.getMail()
                                + "," + personne.getGenre() + "," + personne.getDdn());
                        writer.newLine();
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }

        public void remplirTableau() {
                // Lier les colonnes à la classe Personne
                colloneNom.setCellValueFactory(new PropertyValueFactory<>("nom"));
                collonePrenom.setCellValueFactory(new PropertyValueFactory<>("prenom"));
                colloneMail.setCellValueFactory(new PropertyValueFactory<>("mail"));
                colloneGenre.setCellValueFactory(new PropertyValueFactory<>("genre"));
                colloneDDN.setCellValueFactory(new PropertyValueFactory<>("ddn"));
        }

        public void chargerDonnees() {
                try (BufferedReader reader = new BufferedReader(new FileReader("src/main/java/donnees.txt"))) {
                        String ligne;
                        while ((ligne = reader.readLine()) != null) {
                                String[] donnees = ligne.split(",");
                                if (donnees.length == 5) {
                                        String nom = donnees[0];
                                        String prenom = donnees[1];
                                        String mail = donnees[2];
                                        String genre = donnees[3];
                                        String ddn = donnees[4];

                                        Personne personne = new Personne(nom, prenom, mail, genre, ddn);
                                        tableView.getItems().add(personne);
                                }
                        }
                } catch (IOException e) {
                        e.printStackTrace();
                }
        }
}
