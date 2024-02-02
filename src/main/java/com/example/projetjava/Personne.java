package com.example.projetjava;

import java.util.Random;

public class Personne {
    private int id  ;
    private String nom;
    private String prenom;
    private String mail;

    private String genre;

    private String ville ;

    private int age;
    private String sportPrefere;
    private String cuisinePreferee;
    private String animalPrefere;
    private String couleurPreferee;
    private String lienImageIA;

    public Personne(int id) {
        this.id = id;

        this.ville = genererVille();
        // Générer des noms aléatoires
        String[] noms = {
                "Dupont", "Lefebvre", "Martin", "Dubois", "Rousseau", "Gagnon", "Bouchard", "Tremblay", "Gagné", "Lavoie",
                "Roy", "Fortin", "Morin", "Pelletier", "Desjardins", "Bélanger", "Gauthier", "Leblanc", "Beaulieu", "Bergeron",
                "Girard", "Caron", "Ouellet", "Lemieux", "Poirier", "Rivard", "Côté", "Lapointe", "Simard", "Boucher",
                "Thibault", "Lachance", "Dion", "Marchand", "St-Pierre", "Gosselin", "Leclerc", "Hamel", "Vachon", "Turcotte",
                "Boivin", "Ménard", "Landry", "Paquette", "Perron", "Morissette", "Martel", "Bédard", "Couture", "Renaud"
        };

        String[] prenomsHomme = {"Jean", "Pierre", "Michel", "Paul", "Jacques", "David", "Thomas", "Patrick", "Éric", "Nicolas", "François", "Sébastien", "Vincent", "Robert", "Charles", "Marc", "Daniel", "Gérard", "Philippe", "Antoine", "Alain", "Thierry", "Christophe", "Bruno", "Romain", "Frédéric", "Yves", "Olivier", "Denis", "Hervé", "Alexandre", "Julien", "Christophe", "Georges", "Guillaume", "Luc", "Mathieu", "Emmanuel", "Louis", "Cédric", "Richard", "Yannick", "Fabrice", "Laurent", "Arnaud", "Maxime", "Jérôme", "Renaud"};

        String[] prenomsFemme = {"Marie", "Sophie", "Anne", "Émilie", "Isabelle", "Julie", "Catherine", "Valérie", "Caroline", "Nathalie", "Christine", "Sylvie", "Sandrine", "Élise", "Laura", "Claire", "Audrey", "Stéphanie", "Martine", "Hélène", "Alice", "Florence", "Mélanie", "Alexandra", "Virginie", "Laurence", "Manon", "Camille", "Élodie", "Jessica", "Mathilde", "Aurélie", "Lucie", "Pauline", "Charlotte", "Éva", "Sarah", "Léa", "Léna", "Océane", "Amélie", "Clémence", "Chloé", "Élizabeth", "Marion", "Vanessa", "Maëlle", "Aurore", "Emmanuelle", "Cécile"};

        Random random = new Random();
        this.nom = noms[random.nextInt(noms.length)];

        // Générer un genre aléatoire
        String[] genres = {"Homme", "Femme"};
        this.genre = genres[random.nextInt(genres.length)];

        if (genre.equals("Homme")) {
            this.prenom = prenomsHomme[random.nextInt(prenomsHomme.length)];
        } else if (genre.equals("Femme")) {
            this.prenom = prenomsFemme[random.nextInt(prenomsFemme.length)];
        }

        // Générer une adresse e-mail aléatoire
        this.mail = prenom.toLowerCase() + "." + nom.toLowerCase() + "@exemple.com";

        // Générer un âge entre 18 et 65
        this.age = random.nextInt(48) + 18;

        // Générer un sport préféré
        String[] sports = {"Football", "Tennis", "Natation", "Basketball"};
        this.sportPrefere = sports[random.nextInt(sports.length)];

        // Générer une cuisine préférée
        String[] cuisines = {"Italienne", "Française", "Japonaise", "Indienne"};
        this.cuisinePreferee = cuisines[random.nextInt(cuisines.length)];

        // Générer un animal domestique préféré
        String[] animaux = {"Chien", "Chat", "Oiseau", "Poisson"};
        this.animalPrefere = animaux[random.nextInt(animaux.length)];

        // Générer une couleur préférée
        String[] couleurs = {"Rouge", "Bleu", "Vert", "Jaune"};
        this.couleurPreferee = couleurs[random.nextInt(couleurs.length)];

        // Générer un lien vers une image créée par une intelligence artificielle
        this.lienImageIA = "https://this-person-does-not-exist.com/en";
    }

    private String genererVille() {

        String[] villes = {
                "Paris", "Marseille", "Lyon", "Toulouse", "Nice", "Nantes", "Strasbourg",
                "Montpellier", "Bordeaux", "Lille", "Rennes", "Reims", "Le Havre", "Cergy-Pontoise",
                "Saint-Étienne", "Toulon", "Angers", "Grenoble", "Dijon", "Nîmes"
                // Ajoutez plus de noms de villes ici si vous le souhaitez
        };
        Random random = new Random();
        int indexVille = random.nextInt(villes.length);
        return villes[indexVille];

    }

    // Getters et setters

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSportPrefere() {
        return sportPrefere;
    }

    public void setSportPrefere(String sportPrefere) {
        this.sportPrefere = sportPrefere;
    }

    public String getCuisinePreferee() {
        return cuisinePreferee;
    }

    public void setCuisinePreferee(String cuisinePreferee) {
        this.cuisinePreferee = cuisinePreferee;
    }

    public String getAnimalPrefere() {
        return animalPrefere;
    }

    public void setAnimalPrefere(String animalPrefere) {
        this.animalPrefere = animalPrefere;
    }

    public String getCouleurPreferee() {
        return couleurPreferee;
    }

    public String getLienImageIA() {
        return lienImageIA;
    }

    public void setLienImageIA(String lienImageIA) {
        this.lienImageIA = lienImageIA;
    }

    public void setCouleurPreferee(String couleurPreferee) {
        this.couleurPreferee = couleurPreferee;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public  String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;

    }


}