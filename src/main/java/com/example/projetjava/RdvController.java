package com.example.projetjava;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class RdvController {

    public TextField nomMadame;
    public TextField prenomMadame;
    public TextField mailMadame;
    public TextField nomMonsieur;
    public TextField prenomMonsieur;
    public TextField mailMonsieur;
    public Button ajoutrdv;




    @FXML
    public TableColumn genreMonsieur ;
    @FXML
    public TableColumn genreMadame ;
    @FXML
    public TableColumn colloneMadameNom ;
    @FXML
    public TableColumn colloneMadamePrenom ;
    @FXML
    public TableColumn colloneMadameMail ;
    @FXML
    public TableColumn  colloneMonsieurNom ;
    @FXML
    public TableColumn  colloneMonsieurPrenom ;
    @FXML
    public TableColumn colloneMonsieurMail ;
    public TableColumn colloneDate;
    public DatePicker dtPicker;
    @FXML
    private Button profileButton;

    @FXML
    private Button rdvButton;

    @FXML
    private Button resultatButton;

    @FXML
    private Button calendrierButton;

    @FXML
    private ImageView imageView1;

    @FXML
    private TableView tableView;






    @FXML
    private void goProfile() throws IOException {
        Stage stage = (Stage) profileButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 700, 400);
        Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Page de profil");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    private void goRdv() throws IOException {
        Stage stage = (Stage) rdvButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rdv.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 700, 400);
        Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Page de RDV");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void goResultat() throws IOException {
        Stage stage = (Stage) resultatButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("resultat.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 700, 400);
        Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Resultat de RDV");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    private void goCalendrier() throws IOException {
        Stage stage = (Stage) calendrierButton.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calendrier.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 900, 600);
        Image icon = new Image("file:///C:/Users/ibrah/OneDrive/Documents/2023 Cours/projetjava/src/main/java/icon.png");
        primaryStage.getIcons().add(icon);
        primaryStage.setTitle("Page de Calendrier");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void goajout(ActionEvent actionEvent) {

        // Récupérer les valeurs des TextField
        String genreMadameText = "Madame";
        String genreMonsieurText = "Monsieur";
        String nomMadameText = nomMadame.getText();
        String prenomMadameText = prenomMadame.getText();
        String mailMadameText = mailMadame.getText();
        String nomMonsieurText = nomMonsieur.getText();
        String prenomMonsieurText = prenomMonsieur.getText();
        String mailMonsieurText = mailMonsieur.getText();
        LocalDate selectedDate = dtPicker.getValue();

        // Formater la date en String
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String date = selectedDate.format(formatter);
        // Créer les objets Personne
        Personne madame = new Personne(genreMadameText, nomMadameText, prenomMadameText, mailMadameText);
        Personne monsieur = new Personne(genreMonsieurText, nomMonsieurText, prenomMonsieurText, mailMonsieurText);

        // Créer l'objet RendezVous
        RendezVous rendezVous = new RendezVous(monsieur, madame ,date);

        // Ajouter l'objet RendezVous au TableView
        tableView.getItems().add(rendezVous);

        // Effacer les champs de saisie après avoir ajouté les données
        nomMadame.clear();
        prenomMadame.clear();
        mailMadame.clear();
        nomMonsieur.clear();
        prenomMonsieur.clear();
        mailMonsieur.clear();

        // Associer les propriétés aux colonnes
        genreMadame.setCellValueFactory(new PropertyValueFactory<>("genreFemme"));
        colloneMadameNom.setCellValueFactory(new PropertyValueFactory<>("nomFemme"));
        colloneMadamePrenom.setCellValueFactory(new PropertyValueFactory<>("prenomFemme"));
        colloneMadameMail.setCellValueFactory(new PropertyValueFactory<>("mailFemme"));
        genreMonsieur.setCellValueFactory(new PropertyValueFactory<>("genreHomme"));
        colloneMonsieurNom.setCellValueFactory(new PropertyValueFactory<>("nomHomme"));
        colloneMonsieurPrenom.setCellValueFactory(new PropertyValueFactory<>("prenomHomme"));
        colloneMonsieurMail.setCellValueFactory(new PropertyValueFactory<>("mailHomme"));
        colloneDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        sauvegarderDonnees();
    }


    public void setHommeInfo(String nom, String prenom, String email) {
        nomMonsieur.setText(nom);
        prenomMonsieur.setText(prenom);
        mailMonsieur.setText(email);
    }

    public void setFemmeInfo(String nom, String prenom, String email) {
        nomMadame.setText(nom);
        prenomMadame.setText(prenom);
        mailMadame.setText(email);
    }


    public static class Personne {
        private final String genre ;
        private final String nom;
        private final String prenom;
        private final String mail;

        public Personne(String genre, String nom, String prenom, String mail) {

            this.genre = genre;
            this.nom = nom;
            this.prenom = prenom;
            this.mail = mail;
        }

        public String getGenre() {
            return genre;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getMail() {
            return mail;
        }
    }

    public class RendezVous {
        private Personne homme;
        private Personne femme;

        private String date ;

        public RendezVous(Personne homme, Personne femme , String date) {
            this.homme = homme;
            this.femme = femme;
            this.date = date;
        }

        public Personne getHomme() {
            return homme;
        }

        public void setHomme(Personne homme) {
            this.homme = homme;
        }

        public Personne getFemme() {
            return femme;
        }

        public void setFemme(Personne femme) {
            this.femme = femme;
        }

        // Méthodes pour obtenir les informations sur l'homme et la femme
        public String getGenreHomme() {
            return homme.getGenre();
        }

        public String getNomHomme() {
            return homme.getNom();
        }

        public String getPrenomHomme() {
            return homme.getPrenom();
        }

        public String getMailHomme() {
            return homme.getMail();
        }

        public String getGenreFemme() {
            return femme.getGenre();
        }

        public String getNomFemme() {
            return femme.getNom();
        }

        public String getPrenomFemme() {
            return femme.getPrenom();
        }

        public String getMailFemme() {
            return femme.getMail();
        }

        public String getDate() {
            return date;
        }
    }
    private void sauvegarderDonnees() {
        // Obtenez les données du TableView
        ObservableList<RendezVous> donnees = tableView.getItems();

        // Définissez le chemin du fichier texte
        String cheminFichier = "src/main/java/rendez-vous.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(cheminFichier))) {
            for (RendezVous rdv : donnees) {
                // Écrivez les données dans le fichier texte
                writer.newLine();
                writer.write("Genre Homme: " + rdv.getGenreHomme());
                writer.newLine();
                writer.write("Nom Homme: " + rdv.getNomHomme());
                writer.newLine();
                writer.write("Prénom Homme: " + rdv.getPrenomHomme());
                writer.newLine();
                writer.write("Mail Homme: " + rdv.getMailHomme());
                writer.newLine();
                writer.write("Genre Femme: " + rdv.getGenreFemme());
                writer.newLine();
                writer.write("Nom Femme: " + rdv.getNomFemme());
                writer.newLine();
                writer.write("Prénom Femme: " + rdv.getPrenomFemme());
                writer.newLine();
                writer.write("Mail Femme: " + rdv.getMailFemme());
                writer.newLine();
                writer.write("Date: " + rdv.getDate());
                writer.newLine();
            }

            System.out.println("Données sauvegardées dans le fichier : " + cheminFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors de la sauvegarde des données : " + e.getMessage());
        }
    }



    private void chargerDonnees() {
        // Chemin du fichier texte
        String cheminFichier = "src/main/java/rendez-vous.txt";

        try {
            List<String> lignes = Files.readAllLines(Path.of(cheminFichier));
            ObservableList<RendezVous> donnees = FXCollections.observableArrayList();
            int index = 0;

            while (index < lignes.size()) {
                String genreHomme = lignes.get(index++).substring(13);
                String nomHomme = lignes.get(index++).substring(10);
                String prenomHomme = lignes.get(index++).substring(14);
                String mailHomme = lignes.get(index++).substring(11);
                String genreFemme = lignes.get(index++).substring(14);
                String nomFemme = lignes.get(index++).substring(11);
                String prenomFemme = lignes.get(index++).substring(14);
                String mailFemme = lignes.get(index++).substring(12);
                String date = lignes.get(index++).substring(21);

                // Créer les objets Personne
                Personne homme = new Personne(genreHomme, nomHomme, prenomHomme, mailHomme);
                Personne femme = new Personne(genreFemme, nomFemme, prenomFemme, mailFemme);

                // Créer l'objet RendezVous
                RendezVous rendezVous = new RendezVous(homme, femme , date);

                donnees.add(rendezVous);

                index++; // Ignorer une ligne vide
            }

            tableView.setItems(donnees);

            System.out.println("Données chargées à partir du fichier : " + cheminFichier);
        } catch (IOException e) {
            System.err.println("Erreur lors du chargement des données : " + e.getMessage());
        }
    }
    @FXML
    private void initialize() {
        // Associer les propriétés aux colonnes
        genreMadame.setCellValueFactory(new PropertyValueFactory<>("genreFemme"));
        colloneMadameNom.setCellValueFactory(new PropertyValueFactory<>("nomFemme"));
        colloneMadamePrenom.setCellValueFactory(new PropertyValueFactory<>("prenomFemme"));
        colloneMadameMail.setCellValueFactory(new PropertyValueFactory<>("mailFemme"));
        genreMonsieur.setCellValueFactory(new PropertyValueFactory<>("genreHomme"));
        colloneMonsieurNom.setCellValueFactory(new PropertyValueFactory<>("nomHomme"));
        colloneMonsieurPrenom.setCellValueFactory(new PropertyValueFactory<>("prenomHomme"));
        colloneMonsieurMail.setCellValueFactory(new PropertyValueFactory<>("mailHomme"));
        colloneDate.setCellValueFactory(new PropertyValueFactory<>("date"));


        chargerDonnees();
    }


}
