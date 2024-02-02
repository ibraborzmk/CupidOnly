package com.example.projetjava;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Random;

public class ResultatRdvController {

        public Button profileButton;
        public Button rdvButton;
        public Button resultatButton;
        public Button calendrierButton;
        public TextField textField;
        public Button RechercherButton;
        @FXML
        private TableView tableView;


        @FXML
        private TableColumn genreMadame;

        @FXML
        private TableColumn nomMadame;

        @FXML
        private TableColumn prenomMadame;

        @FXML
        private TableColumn genreMonsieur;

        @FXML
        private TableColumn nomMonsieur;

        @FXML
        private TableColumn prenomMonsieur;


        @FXML
        private TableColumn Situation;



        public void goResultat(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) resultatButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("resultat.fxml"));
                Scene scene = new Scene(fxmlLoader.load() , 700, 400);
                primaryStage.setTitle("Resulta de RDV");
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println("ok");

        }
        // goCalendrier doit fermer la fenetre actuelle et ouvrir la fenetre calendrier

        @FXML
        public void goCalendrier(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) calendrierButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calendrier.fxml"));
                Scene scene = new Scene(fxmlLoader.load() , 900, 600);
                primaryStage.setTitle("Page de Calendrier");
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println("ok");
        }


        public void goRdv(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) rdvButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rdv.fxml"));
                Scene scene = new Scene(fxmlLoader.load() , 700, 400);
                primaryStage.setTitle("Page de RDV");
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println("ok");
        }

        public void goProfile(ActionEvent actionEvent) throws IOException {
                Stage stage = (Stage) profileButton.getScene().getWindow();
                stage.close();
                Stage primaryStage = new Stage();
                FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
                Scene scene = new Scene(fxmlLoader.load() , 700, 400);
                primaryStage.setTitle("P R O F I L E");
                primaryStage.setScene(scene);
                primaryStage.show();
                System.out.println("ok");

        }

    public void gotText(ActionEvent actionEvent) {
    }

        public void goRecherche(ActionEvent actionEvent) {
                String searchText = textField.getText().trim().toLowerCase();
                ObservableList<Object> filteredData = FXCollections.observableArrayList();

                if (!searchText.isEmpty()) {
                        for (Object item : tableView.getItems()) {
                                String nom = getNom(item);
                                String prenom = getPrenom(item);


                                if (nom != null && nom.toLowerCase().contains(searchText)) {
                                        filteredData.add(item);
                                } else if (prenom != null && prenom.toLowerCase().contains(searchText)) {
                                        filteredData.add(item);
                                }
                        }
                } else {
                        filteredData.addAll(tableView.getItems());
                }

                tableView.setItems(filteredData);
        }

        private String getNom(Object item) {
                // Logique pour obtenir le nom à partir de l'objet
                // Remplacez cette logique par votre propre implémentation
                return null;
        }

        private String getPrenom(Object item) {
                // Logique pour obtenir le prénom à partir de l'objet
                // Remplacez cette logique par votre propre implémentation
                return null;
        }


        // ...

        public class Personne {
                private final StringProperty genre;
                private final StringProperty nom;
                private final StringProperty prenom;
                private final StringProperty email;

                public Personne(String genre, String nom, String prenom, String email) {
                        this.genre = new SimpleStringProperty(genre);
                        this.nom = new SimpleStringProperty(nom);
                        this.prenom = new SimpleStringProperty(prenom);
                        this.email = new SimpleStringProperty(email);
                }

                public String getGenre() {
                        return genre.get();
                }

                public StringProperty genreProperty() {
                        return genre;
                }

                public void setGenre(String genre) {
                        this.genre.set(genre);
                }

                public String getNom() {
                        return nom.get();
                }

                public StringProperty nomProperty() {
                        return nom;
                }

                public void setNom(String nom) {
                        this.nom.set(nom);
                }

                public String getPrenom() {
                        return prenom.get();
                }

                public StringProperty prenomProperty() {
                        return prenom;
                }

                public void setPrenom(String prenom) {
                        this.prenom.set(prenom);
                }

                public String getEmail() {
                        return email.get();
                }

                public StringProperty emailProperty() {
                        return email;
                }

                public void setEmail(String email) {
                        this.email.set(email);
                }

        }

        public class RendezVous {
                private Personne homme;
                private Personne femme;

                private String vdate ;

                public RendezVous(Personne homme,Personne femme , String vdate) {
                        this.homme = homme;
                        this.femme = femme;
                        this.vdate = vdate;
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

                public String getGenreFemme() {
                        return femme.getGenre();
                }

                public String getNomFemme() {
                        return femme.getNom();
                }

                public String getPrenomFemme() {
                        return femme.getPrenom();
                }

                public String getVdate() {
                        return vdate;
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

                                String vdate = situation(date);


                                // Créer les objets Personne
                                Personne homme = new Personne(genreHomme, nomHomme, prenomHomme, mailHomme);
                                Personne femme = new Personne(genreFemme, nomFemme, prenomFemme, mailFemme);

                                // Créer l'objet RendezVous


                                RendezVous rendezVous = new RendezVous(homme, femme , vdate);
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
                nomMadame.setCellValueFactory(new PropertyValueFactory<>("nomFemme"));
                prenomMadame.setCellValueFactory(new PropertyValueFactory<>("prenomFemme"));
                nomMonsieur.setCellValueFactory(new PropertyValueFactory<>("nomHomme"));
                prenomMonsieur.setCellValueFactory(new PropertyValueFactory<>("prenomHomme"));
                Situation.setCellValueFactory(new PropertyValueFactory<>("vdate"));


                chargerDonnees();
        }
        public  String situation(String inputDate) {
                String output = "";

                // Format de la date d'entrée
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");

                try {
                        // Conversion de la date d'entrée en objet Date
                        Date date = sdf.parse(inputDate);

                        // Date actuelle
                        Date currentDate = new Date();

                        // Vérification si la date est passée
                        if (currentDate.before(date)) {
                                output = "A venir";
                        } else {
                                Random random = new Random();
                                int randomNumber = random.nextInt(100) + 1; // Génère un nombre aléatoire entre 1 et 100

                                if (randomNumber <= 30) {
                                        output = "aboutit";
                                } else {
                                        output = "non-aboutit";
                                }
                        }
                } catch (ParseException e) {
                        e.printStackTrace();
                }

                return output;
        }

}

