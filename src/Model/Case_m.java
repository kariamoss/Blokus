package Model;


public class Case_m {
    String couleur;
    int[] pos = new int[2];

    public Case_m(String couleur, int i, int j){
        this.couleur = couleur;
        pos[0] = i;
        pos[1] = j;
    }




    //Getters Setters
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int[] getPos() {
        return pos;
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public String getCouleur() {
        return couleur;
    }




}

