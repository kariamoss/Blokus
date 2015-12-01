package Model;


import Helper.ListDoubleCircJoueur;

public class General_m {
    Joueur_m joueur1;
    Joueur_m joueur2;
    Joueur_m joueur3;
    Joueur_m joueur4;


    ListDoubleCircJoueur listJoueur = new ListDoubleCircJoueur();

    public General_m()
    {
        joueur1 = new Joueur_m("red", "Roger");
        joueur2 = new Joueur_m("blue", "Bernard");
        joueur3 = new Joueur_m("yellow", "Yvonne");
        joueur4 = new Joueur_m("green", "Gerard");

        listJoueur.append(joueur1);
        listJoueur.append(joueur2);
        listJoueur.append(joueur3);
        listJoueur.append(joueur4);

        selectJoueur(3);
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

    //Getters
    public Joueur_m getJoueur(int index) {
        return listJoueur.getJoueur(index);
    }
}


