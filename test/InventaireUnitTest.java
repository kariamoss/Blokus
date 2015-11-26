import Model.Case_m;
import Model.Inventaire_m;
import Model.Piece_m;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InventaireUnitTest {
    @Test
    public void inventaireTest(){
        Inventaire_m inventaireRouge = new Inventaire_m("Red");
        Inventaire_m inventaireJaune = new Inventaire_m("Yellow");
        Assert.assertFalse(inventaireRouge.getPiece(1) == inventaireRouge.getPiece(2));
        Assert.assertFalse(inventaireRouge.getPiece(2) == inventaireJaune.getPiece(2));


        Assert.assertTrue(inventaireJaune.getPiece(1).getListeCase().get(1).getCouleur() == "Yellow");

        Assert.assertEquals(inventaireRouge.getPiece(2).getOrientation(), "Ouest");
        inventaireRouge.getPiece(1).setOrientation("Est");
        Assert.assertFalse(inventaireRouge.getPiece(1).getOrientation().equals("Ouest"));
        Assert.assertEquals(inventaireRouge.getPiece(1).getOrientation(),"Est");

        Assert.assertFalse(inventaireJaune.getPiece(1).getListeCase() == inventaireRouge.getPiece(1).getListeCase());
    }

}
