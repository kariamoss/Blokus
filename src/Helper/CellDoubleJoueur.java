package Helper;

import Model.Joueur_m;

/**
 * Created by Lucas on 01/12/2015.
 */
public class CellDoubleJoueur {


    public CellDoubleJoueur prev;
    public CellDoubleJoueur next;
    public Joueur_m value;

    public CellDoubleJoueur(Joueur_m joueur)
    {
        this.value = joueur;
        next=null;
        prev=null;
    }
}
