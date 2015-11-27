import Helper.ListDoubleCirc;
import Model.Inventaire_m;
import Model.Piece_m;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by Jehan on 26/11/2015.
 */
public class ControlButtonUnitTest {

    @Test //CE TEST MARCHE
    public void selectionPieceTest(){
        Inventaire_m inventaireTest = new Inventaire_m("blue");
        Assert.assertFalse(inventaireTest.getPiece(1).isSelected());
        inventaireTest.selectPiece(1);
        inventaireTest.selectPiece(2);
        Assert.assertFalse(inventaireTest.getPiece(1).isSelected());
        Assert.assertTrue(inventaireTest.getPiece(2).isSelected());
    }

    @Test //CE TEST MARCHE
    public void rotationPieceTest(){
        Inventaire_m inventaireTest = new Inventaire_m("blue");
        inventaireTest.getPiece(1).rotateLeft();
        Assert.assertTrue(inventaireTest.getPiece(1).getOrientation() == "Sud");
        inventaireTest.getPiece(1).rotateRight();
        Assert.assertTrue(inventaireTest.getPiece(1).getOrientation() == "Ouest");
    }


    @Test //CE TEST MARCHE
    public void ListDoubleCircTest(){
        ListDoubleCirc liste = new ListDoubleCirc();
        liste.append("Ouest");
        liste.append("Nord");
        liste.append("Est");
        liste.append("Sud");
        Assert.assertEquals(liste.find("Ouest").prev.value, "Sud");
    }


}