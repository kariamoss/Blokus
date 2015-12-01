package Model;

/**
 * Created by Jehan on 26/11/2015.
 */
public class Joueur_m {
    Inventaire_m inventaire;
    String couleur;
    boolean enJeu;
    boolean tourDeJeu;
    int score;
    String nom;

    public Joueur_m(String couleur, String nom){
        this.couleur = couleur;
        inventaire = new Inventaire_m(couleur);
        this.nom = nom;
        enJeu = true;
        tourDeJeu = false;
        score = 0;
    }




    // GETTERS / SETTERS

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Inventaire_m getInventaire() {
        return inventaire;
    }

    public void setInventaire(Inventaire_m inventaire) {
        this.inventaire = inventaire;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public boolean isEnJeu() {
        return enJeu;
    }

    public void setEnJeu(boolean enJeu) {
        this.enJeu = enJeu;
    }

    public boolean isTourDeJeu() {
        return tourDeJeu;
    }

    public void setTourDeJeu(boolean tourDeJeu) {
        this.tourDeJeu = tourDeJeu;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }



}

