package Model;

import java.util.ArrayList;
import java.util.List;

public class Piece_m {
    List<Case_m> listeCase= new ArrayList<>();
    String orientation;
    String image;

    public Piece_m(List<Case_m> liste, String orientation, String image){
        this.orientation = orientation;
        listeCase = liste;
        this.image=image;
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

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

}
