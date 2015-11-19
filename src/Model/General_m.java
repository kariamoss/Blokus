package Model;


public class General_m {
    Inventaire_m inventaireRouge;
    Inventaire_m inventaireJaune;
    Inventaire_m inventaireVert;
    Inventaire_m inventaireBleu;

    public General_m(){
        inventaireBleu = new Inventaire_m("Bleu");
        inventaireRouge = new Inventaire_m("Rouge");
        inventaireJaune = new Inventaire_m("Jaune");
        inventaireVert = new Inventaire_m("Vert");
    }
}


