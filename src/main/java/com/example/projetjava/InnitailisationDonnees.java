package com.example.projetjava;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class InnitailisationDonnees {
    public static int nb = 20 ;
    public static void main(String[] args) throws IOException {
        List<Personne> personnes = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            Personne personne = new Personne(i);
            personnes.add(personne);
        }

        // Afficher les informations des personnes
        for (Personne personne : personnes) {
            System.out.print("Nom : " + personne.getNom());
            System.out.println("Prénom : " + personne.getPrenom());
            System.out.println("E-mail : " + personne.getMail());
            System.out.println("Genre : " + personne.getGenre());
            System.out.println("Âge : " + personne.getAge());
            System.out.println("Sport préféré : " + personne.getSportPrefere());
            System.out.println("Cuisine préférée : " + personne.getCuisinePreferee());
            System.out.println("Animal préféré : " + personne.getAnimalPrefere());
            System.out.println("Couleur préférée : " + personne.getCouleurPreferee());
            System.out.println("Lien vers une image créée par une IA : " + personne.getLienImageIA());
            System.out.println();
        }

        try {
            FileWriter writer = new FileWriter("src/main/java/donnees.txt");
            for (Personne personne : personnes) {
                writer.write(personne.getNom() + ",");
                writer.write(personne.getPrenom() + ",");
                writer.write(personne.getMail() + ",");
                writer.write(personne.getGenre() + ",");
                writer.write(+personne.getAge() + "      ");
                writer.write("\n");
            }
            writer.close();
            System.out.println("Les données ont été sauvegardées dans le fichier donnees.txt.");
        } catch (
                IOException e) {
            System.out.println("Une erreur s'est produite lors de la sauvegarde des données.");
            e.printStackTrace();
        }



        try {
            FileWriter writer = new FileWriter("src/main/java/donneesTotale.txt");
            for (Personne personne : personnes) {
                writer.write(personne.getNom() + ",");
                writer.write(personne.getPrenom() + ",");
                writer.write(personne.getMail() + ",");
                writer.write(personne.getGenre() + ",");
                writer.write(personne.getVille() + ",");
                writer.write(+personne.getAge() + ",");
                writer.write(personne.getSportPrefere() + ",");
                writer.write(personne.getCuisinePreferee() + ",");
                writer.write(personne.getAnimalPrefere() + ",");
                writer.write(personne.getCouleurPreferee() + ",");
                writer.write("\n");
            }
            writer.close();
            System.out.println("Les données ont été sauvegardées dans le fichier donneesTotale.txt.");
        } catch (
                IOException e) {
            System.out.println("Une erreur s'est produite lors de la sauvegarde des données.");
            e.printStackTrace();
        }














        FileWriter writer = new FileWriter("src/main/java/rendez-vous.txt");
        Set<String> rendezVousUniques = new HashSet<>();
        int rendezVousCompteur = 0;


        while (rendezVousCompteur < nb) {
            int randomYear = ThreadLocalRandom.current().nextInt(2022, 2024);
            int randomMonth = ThreadLocalRandom.current().nextInt(1, 13);
            int randomDay = ThreadLocalRandom.current().nextInt(1, LocalDate.of(randomYear, randomMonth, 1).lengthOfMonth() + 1);
            LocalDate randomDate = LocalDate.of(randomYear, randomMonth, randomDay);
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
            String Date = randomDate.format(formatter);
            Personne homme = null;
            Personne femme = null;

            for (Personne personne : personnes) {
                if (personne.getGenre().equals("Homme") && homme == null && !rendezVousUniques.contains(personne.getNom())) {
                    homme = personne;
                } else if (personne.getGenre().equals("Femme") && femme == null && !rendezVousUniques.contains(personne.getNom())) {
                    femme = personne;
                }
                if (homme != null && femme != null) {
                    break;
                }
            }

            if (homme != null && femme != null) {
                rendezVousUniques.add(homme.getNom());
                rendezVousUniques.add(femme.getNom());

                writer.write("Genre Homme: " + homme.getGenre() + "\n");
                writer.write("Nom Homme: " + homme.getNom() + "\n");
                writer.write("Prénom Homme: " + homme.getPrenom() + "\n");
                writer.write("Mail Homme: " + homme.getMail() + "\n");
                writer.write("Genre Femme: " + femme.getGenre() + "\n");
                writer.write("Nom Femme: " + femme.getNom() + "\n");
                writer.write("Prénom Femme: " + femme.getPrenom() + "\n");
                writer.write("Mail Femme: " + femme.getMail() + "\n");
                writer.write("Date du rendez-vous: " + Date +  "\n");
                writer.write("\n");
                System.out.println("Les données ont été sauvegardées dans le fichier rendez-vous.txt.");

                rendezVousCompteur++;
            }
        }

        writer.close();
    }

    }

