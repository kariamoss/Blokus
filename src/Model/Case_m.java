package Model;


public class Case_m {
    String couleur;
    int[] pos = new int[2];
    boolean isClicked;

    public Case_m(String couleur, int i, int j) {
        this.couleur = couleur;
        pos[0] = i;
        pos[1] = j;
    }

    public Case_m(String couleur, int i, int j, boolean isClicked) {
        this.couleur = couleur;
        pos[0] = i;
        pos[1] = j;
        this.isClicked=false;
    }

    //Getters Setters
    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public int getPosI() {
        return pos[0];
    }

    public int getPosJ() {
        return pos[1];
    }

    public void setPos(int[] pos) {
        this.pos = pos;
    }

    public String getCouleur() {
        return couleur;
    }

    public boolean isClicked() {
        return isClicked;
    }

    public void setClicked(boolean clicked) {
        isClicked = clicked;
    }
}