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
}
