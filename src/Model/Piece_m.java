package Model;

import java.util.ArrayList;
import java.util.List;

public class Piece_m {
    List<Case_m> listeCase= new ArrayList<>();
    String orientation;

    public Piece_m(List<Case_m> liste, String orientation){
        this.orientation = orientation;
        listeCase = liste;
    }

    public List<Case_m> getListeCase() {
        return listeCase;
    }

    public void setListeCase(List<Case_m> listeCase) {
        this.listeCase = listeCase;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }
}
