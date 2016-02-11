package Model;


import Helper.Chargement;
import Helper.ListDoubleCircJoueur;
import Helper.Sauvegarde;
import Vue.GameStats_v;

public class General_m {
    Joueur_m joueur0;
    Joueur_m joueur1;
    Joueur_m joueur2;
    Joueur_m joueur3;



    protected Sauvegarde sauvegarde;

    private boolean musiqueEtat;


    ListDoubleCircJoueur listJoueur = new ListDoubleCircJoueur();



    public GameStats_v gameStats;
    public Chargement chargement;
    public Plateau_m modelPlateau;

    public General_m()
    {
        joueur0 = new Joueur_m("Red", "Roger");
        joueur1 = new Joueur_m("Blue", "Bernard");
        joueur2 = new Joueur_m("Yellow", "Yvonne");
        joueur3 = new Joueur_m("Green", "Gerard");

        musiqueEtat = true;

        listJoueur.append(joueur0);
        listJoueur.append(joueur1);
        listJoueur.append(joueur2);
        listJoueur.append(joueur3);

        selectJoueur(0);

        modelPlateau = new Plateau_m(this);

        chargement = new Chargement(this);

        sauvegarde = new Sauvegarde();
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

    public void setJoueurActif(String color){
        Joueur_m joueurActif = getJoueurByColor(color);

        for(int i = 0; i< listJoueur.size; i++){
            listJoueur.getJoueur(i).setTourDeJeu(false);
        }

        do {
            joueurActif = listJoueur.find(joueurActif).value;
        }while(!joueurActif.isEnJeu());
        joueurActif.setTourDeJeu(true);
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
        sauvegarde.sauvegardeEtatTourJoueur(joueurActif.getCouleur());
    }

    public boolean isMusiquePlayed() { return musiqueEtat; }

    public void setMusiqueEtat(boolean state) { musiqueEtat = state; }

    //Getters
    public Joueur_m getJoueur(int index) {
        return listJoueur.getJoueur(index);
    }

    public String getMusiquePath() {
        return "/musique"; }


    public Plateau_m getModelPlateau() {
        return modelPlateau;
    }

    public int getNbJoueurEnJeu() {
        int nb = 0;
        for (int i=0; i < 4 ; i++){
            if( listJoueur.getJoueur(i).isEnJeu())
                nb++;
        }
        return nb;
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

    public void setGameStats(){
        Joueur_m tab[] = new Joueur_m[4];
        tab[0] = joueur0;
        tab[1] = joueur1;
        tab[2] = joueur2;
        tab[3] = joueur3;

        gameStats.updateGameStats(tab);
    }
    public Sauvegarde getSauvegarde() {
        return sauvegarde;
    }

    public Joueur_m getJoueurByColor(String couleur){
        for (int i=0; i < 4 ; i++){
            if( listJoueur.getJoueur(i).getCouleur().equals(couleur))
                return  listJoueur.getJoueur(i);
        }
        return null;
    }
}


