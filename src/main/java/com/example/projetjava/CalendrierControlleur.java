package com.example.projetjava;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CalendrierControlleur {

    public Button goResultat;
    public Button goRdv;
    public Button goMatche;
    public Button goProfile;
    private String hommeNom;
        private String hommePrenom;
        private String hommeEmail;
        private String femmeNom;
        private String femmePrenom;
        private String femmeEmail;

        // Autres éléments de la classe RDVController

    @FXML
    private ImageView profile1Image;

    @FXML
    private ImageView profile2Image;

    @FXML
    private TextField profile1Name;

    @FXML
    private TextField profile2Name;

    @FXML
    private TextField profile1Age;

    @FXML
    private TextField profile2Age;

    @FXML
    private TextField profile1Location;

    @FXML
    private TextField profile2Location;

    @FXML
    private TextArea profile1Hobbies;

    @FXML
    private TextArea profile2Hobbies;

    @FXML
    private Button matchButton;

    @FXML
    private ProgressBar matchingScoreBar;

    @FXML
    private Button viewProfile1Button;

    @FXML
    private Button viewProfile2Button;

    private List<Profile> profiles; // Liste pour stocker les profils chargés à partir du fichier
    private int currentIndex = 0; // Indice du profil actuellement affiché

    @FXML
    private void initialize() {
        // Initialisations ou gestionnaires d'événements peuvent être ajoutés ici
        loadProfilesFromFile();
        showNextProfile();
    }


        public void goMatch(ActionEvent actionEvent) throws IOException {
            Profile profile = profiles.get(currentIndex);

            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rdv.fxml"));
            Scene scene = new Scene(fxmlLoader.load(), 700, 400);
            Stage primaryStage = new Stage();
            primaryStage.setTitle("Page de RDV");
            primaryStage.setScene(scene);

            String nom = null;
            String prenom = null;
            String mail = null;
            if (profile1Name.getText() != null && !profile1Name.getText().isEmpty()) {
                String[] mots = profile1Name.getText().split(" ");
                if (mots.length >= 2) {
                    nom = mots[0];
                    prenom = mots[1];
                    mail = mots[2];
                }
            }
            String nom2 = null;
            String prenom2 = null;
            String mail2 = null;
            if (profile2Name.getText() != null && !profile2Name.getText().isEmpty()) {
                String[] mots = profile2Name.getText().split(" ");
                if (mots.length >= 2) {
                    nom2 = mots[0];
                    prenom2 = mots[1];
                    mail2 = mots[2];
                }
            }

            RdvController rdvController = fxmlLoader.getController();
            rdvController.setHommeInfo(nom, prenom, mail);
            rdvController.setFemmeInfo(nom2, prenom2, mail2);

            primaryStage.show();

            Stage stage = (Stage) matchButton.getScene().getWindow();
            stage.close();

            System.out.println("ok");

        }


    public void goNext(ActionEvent actionEvent) {
        currentIndex++; // Passer au profil suivant

        if (currentIndex >= profiles.size()) {
            // Si on atteint la fin de la liste, revenir au premier profil
            currentIndex = 0;
        }

        showNextProfile();
    }

    private void loadProfilesFromFile() {
        profiles = new ArrayList<>();

        try {
            File file = new File("src/main/java/donneesTotale.txt");
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(",");

                String nom = data[0];
                String prenom = data[1];
                String email = data[2];
                String sexe = data[3];
                String ville = data[4];
                int age = Integer.parseInt(data[5]);
                String hobbies = data[6];
                String nationalite = data[7];
                String animalPrefere = data[8];
                String couleurPreferee = data[9];
                Profile profile = new Profile(nom, prenom, email, sexe, ville, age, hobbies, nationalite, animalPrefere, couleurPreferee);
                profiles.add(profile);
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void showNextProfile() {
        Profile profile = profiles.get(currentIndex);
        if (profile.getSexe().equalsIgnoreCase("Homme")) {
            // Remplir le profil 1 (homme)
            profile1Name.setText(profile.getNom() + " " + profile.getPrenom() + " " + profile.getEmail());
            profile1Age.setText(String.valueOf(profile.getAge()));
            profile1Location.setText(profile.getVille());
            profile1Hobbies.setText("Sport : " + profile.getHobbies() + "\n" + "Animal préféré : " + profile.getAnimalPrefere() + "\n" + "Couleur préférée : " + profile.getCouleurPreferee() + "\n" + "Cuisine : " + profile.getNationalite());
        } else if (profile.getSexe().equalsIgnoreCase("Femme")) {
            // Remplir le profil 2 (femme)
            profile2Name.setText(profile.getNom() + " " + profile.getPrenom() + " " + profile.getEmail());
            profile2Age.setText(String.valueOf(profile.getAge()));
            profile2Location.setText(profile.getVille());
            profile2Hobbies.setText("Sport : " + profile.getHobbies() + "\n" + "Animal préféré : " + profile.getAnimalPrefere() + "\n" + "Couleur préférée : " + profile.getCouleurPreferee() + "\n" + "Cuisine : " + profile.getNationalite());
        }
    }

    public void goprofil(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goProfile.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("profile.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 700, 400);
        primaryStage.setTitle("Page de profil");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("ok");
    }

    public void gomtc(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goMatche.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("calendrier.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 600);
        primaryStage.setTitle("Page de Calendrier ");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("ok");
    }

    public void gorslt(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goResultat.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rdv.fxml"));
        Scene scene = new Scene(fxmlLoader.load() , 700, 400);
        primaryStage.setTitle("Page de RDV");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("ok");
    }

    public void gordv(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) goRdv.getScene().getWindow();
        stage.close();
        Stage primaryStage = new Stage();
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("rdv.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 400);
        primaryStage.setTitle("Pade de RDV");
        primaryStage.setScene(scene);
        primaryStage.show();
        System.out.println("ok");
    }

    public class Profile {
        private String nom;
        private String prenom;
        private String email;
        private String sexe;
        private String ville;
        private int age;
        private String hobbies;
        private String nationalite;
        private String animalPrefere;
        private String couleurPreferee;

        public Profile(String nom, String prenom, String email, String sexe, String ville, int age, String hobbies, String nationalite, String animalPrefere, String couleurPreferee) {
            this.nom = nom;
            this.prenom = prenom;
            this.email = email;
            this.sexe = sexe;
            this.ville = ville;
            this.age = age;
            this.hobbies = hobbies;
            this.nationalite = nationalite;
            this.animalPrefere = animalPrefere;
            this.couleurPreferee = couleurPreferee;
        }

        public String getNom() {
            return nom;
        }

        public String getPrenom() {
            return prenom;
        }

        public String getEmail() {
            return email;
        }

        public String getSexe() {
            return sexe;
        }

        public String getVille() {
            return ville;
        }

        public int getAge() {
            return age;
        }

        public String getHobbies() {
            return hobbies;
        }

        public String getNationalite() {
            return nationalite;
        }

        public String getAnimalPrefere() {
            return animalPrefere;
        }

        public String getCouleurPreferee() {
            return couleurPreferee;
        }
    }
    public void setFemmeInfo(String nom, String prenom, String email) {
        femmeNom = nom;
        femmePrenom = prenom;
        femmeEmail = email;
    }
    public void setHommeInfo(String nom, String prenom, String email) {
        hommeNom = nom;
        hommePrenom = prenom;
        hommeEmail = email;
    }
}


