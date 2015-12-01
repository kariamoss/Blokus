package Model;


import Helper.ListDoubleCircJoueur;

public class General_m {
    Joueur_m joueur0;
    Joueur_m joueur1;
    Joueur_m joueur2;
    Joueur_m joueur3;


    ListDoubleCircJoueur listJoueur = new ListDoubleCircJoueur();

    public General_m()
    {
        joueur0 = new Joueur_m("Red", "Roger");
        joueur1 = new Joueur_m("Blue", "Bernard");
        joueur2 = new Joueur_m("Yellow", "Yvonne");
        joueur3 = new Joueur_m("Green", "Gerard");

        listJoueur.append(joueur0);
        listJoueur.append(joueur1);
        listJoueur.append(joueur2);
        listJoueur.append(joueur3);

        selectJoueur(2);
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
        for(int i = 0; i< listJoueur.size; i++){
            listJoueur.getJoueur(i).setTourDeJeu(false);
        }
        listJoueur.find(joueurActif).next.value.setTourDeJeu(true);

    }

    //Getters
    public Joueur_m getJoueur(int index) {
        return listJoueur.getJoueur(index);
    }
}


