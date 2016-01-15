package Model;

/**
 * Created by Mathieu on 20/11/2015.
 */
public class Plateau_m {
    private int taillePlateau = 20;
    private Case_m[][] plateau;


    General_m modelGeneral;


    public Plateau_m(General_m modelGeneral){
        genererPlateau(taillePlateau);
        this.modelGeneral = modelGeneral;

    }

    public Case_m[][] genererPlateau(int taillePlateau){

        plateau = new Case_m[taillePlateau][taillePlateau];
        for(int i=0; i<taillePlateau;i++){
            for(int j=0; j<taillePlateau;j++){
                plateau[i][j]= new Case_m("White",i,j, false);
            }
        }
        return plateau;

    }

    public Case_m getCase(int i, int j){
        return plateau[i][j];
    }


    public int getTaillePlateau() {
        return taillePlateau;
    }



    public Plateau_m getPlateau_m(){ return this; }

    public void setClickToFalse(int i, int j)
    {
        getCase(i, j).setClicked(false);
    }

    public void setClickToTrue(int i, int j)
    {
        for (int k=0;k<20;k++){
            for (int l=0;l<20;l++){
                getCase(k, l).setClicked(false);
                if (k==i && l==j) {
                    getCase(k, l).setClicked(true);
                }
            }
        }
    }




}