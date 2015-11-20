package Model;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class Plateau_m {
    private int taillePlateau;
    private int nbCases;
    private Case_m[][] plateau;



    public Plateau_m(){
        taillePlateau=20;
        nbCases=400;

    }

    public Case_m[][] genererPlateau(int taillePlateau, int nbCases){
        plateau = new Case_m[taillePlateau][taillePlateau];
        for(int i=0; i<taillePlateau-1;i++){
            for(int j=0; j<taillePlateau-1;j++){
                plateau[i][j]= new Case_m("blanc",i,j);

            }
        }
        return plateau;

    }

    public int getNbCases() {
        return nbCases;
    }

    public void setNbCases(int nbCases) {
        this.nbCases = nbCases;
    }

    public int getTaillePlateau() {
        return taillePlateau;
    }
}