package Model;


import Helper.ListDoubleCircJoueur;

import javax.swing.*;

public class General_m {
    Joueur_m joueur0;
    Joueur_m joueur1;
    Joueur_m joueur2;
    Joueur_m joueur3;

    private String musiquePath = "/musique";
    private boolean musiqueEtat;


    ListDoubleCircJoueur listJoueur = new ListDoubleCircJoueur();

    int nbJoueuEnJeu;

    public JButton[] tabButtonInventaire;
    public JButton overviewButton;

    public Plateau_m modelPlateau;

    public General_m()
    {
        joueur0 = new Joueur_m("Red", "Roger");
        joueur1 = new Joueur_m("Blue", "Bernard");
        joueur2 = new Joueur_m("Yellow", "Yvonne");
        joueur3 = new Joueur_m("Green", "Gerard");

        nbJoueuEnJeu = 4;
        musiqueEtat = true;

        listJoueur.append(joueur0);
        listJoueur.append(joueur1);
        listJoueur.append(joueur2);
        listJoueur.append(joueur3);

        selectJoueur(0);

        modelPlateau = new Plateau_m(this);
    }

    public void selectJoueur(int index){
        for(int i = 0; i< listJoueur.size; i++){
            listJoueur.getJoueur(i).setTourDeJeu(false);
        }
        listJoueur.getJoueur(index).setTourDeJeu(true);
    }


    public Joueur_m selectJoueurActif(){
        for(int i = 0; i< listJoueur.size; i++){
            if(listJoueur.getJoueur(i).isTourDeJeu()){
                return listJoueur.getJoueur(i);
            }
        }
        return null;
    }

    public void joueurSuivant()
    {
        Joueur_m joueurActif = selectJoueurActif();
        //On met tous les joueur à faux
        for(int i = 0; i< listJoueur.size; i++){
            listJoueur.getJoueur(i).setTourDeJeu(false);
        }

        //On met le bon joueur à vrai (regarde si le joueur suivant n'est pas éliminé
        do {
            joueurActif = listJoueur.find(joueurActif).next.value;
        }while(!joueurActif.isEnJeu());
        joueurActif.setTourDeJeu(true);
    }

    public boolean isMusiquePlayed() { return musiqueEtat; }

    public void setMusiqueEtat(boolean state) { musiqueEtat = state; }

    //Getters
    public Joueur_m getJoueur(int index) {
        return listJoueur.getJoueur(index);
    }

    public String getMusiquePath() { return musiquePath; }


    public Plateau_m getModelPlateau() {
        return modelPlateau;
    }

    public int getNbJoueuEnJeu() {
        return nbJoueuEnJeu;
    }

    public void setNbJoueuEnJeu() {
        nbJoueuEnJeu--;
    }

    public Joueur_m getJoueurByScore(int score){
        for(int i=0;i<4;i++)
        {
            Joueur_m joueur = getJoueur(i);
            if (joueur.getScore()==score)
                return joueur;
        }
        return null;
    }
}


