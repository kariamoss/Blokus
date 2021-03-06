package Model;

import Helper.ListDoubleCirc;

import java.util.ArrayList;
import java.util.List;

public class Piece_m {
    List<Case_m> listeCase= new ArrayList<>();
    ListDoubleCirc listeOrientation = new ListDoubleCirc();
    boolean isSelected;
    String orientation;
    String image;
    boolean used;
    int positionI = -1;
    int positionJ = -1;
    int numero;
    boolean miroir;

    public Piece_m(List<Case_m> liste, String orientation, String image, int numero){
        this.orientation = orientation;
        for (Case_m aListe : liste) {
            listeCase.add(aListe);
        }
        this.image=image;
        isSelected = false;
        listeOrientation.append("Ouest");
        listeOrientation.append("Nord");
        listeOrientation.append("Est");
        listeOrientation.append("Sud");

        this.numero = numero;
        used = false;
        miroir = false;
    }

    public List<Case_m> getListeCase() {
        return listeCase;
    }

    public void setListeCase(List<Case_m> listeCase) {
        this.listeCase = listeCase;
    }

    public void rotateLeft(){
        orientation =  listeOrientation.find(orientation).prev.value;
    }
    public void rotateRight(){
        orientation =  listeOrientation.find(orientation).next.value;
    }

    public boolean isSelected(){
        return isSelected;
    }

    public void setPieceSelection(boolean select){
        isSelected = select;
    }



    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isUsed() {
        return used;
    }

    public void setUsed(boolean used) {
        this.used = used;
    }

    public int getPositionI() {
        return positionI;
    }

    public void setPositionI(int positionI) {
        this.positionI = positionI;
    }

    public int getPositionJ() {
        return positionJ;
    }

    public void setPositionJ(int positionJ) {
        this.positionJ = positionJ;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public void setMiroir(boolean miroir) {
        this.miroir = miroir;
    }

    public boolean isMiroir() {
        return miroir;
    }
}
