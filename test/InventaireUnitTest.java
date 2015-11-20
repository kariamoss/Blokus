import Model.Inventaire_m;
import org.junit.Assert;
import org.junit.Test;

public class InventaireUnitTest {
    @Test
    public void inventaireTest(){
        Inventaire_m inventaireRouge = new Inventaire_m("rouge");
        Inventaire_m inventaireJaune = new Inventaire_m("jaune");
        Assert.assertFalse(inventaireRouge.getPiece(1) == inventaireRouge.getPiece(2));
        Assert.assertFalse(inventaireRouge.getPiece(2) == inventaireJaune.getPiece(2));

        Assert.assertEquals(inventaireRouge.getPiece(2).getOrientation(), "Ouest");
        inventaireRouge.getPiece(1).setOrientation("Est");
        Assert.assertFalse(inventaireRouge.getPiece(1).getOrientation().equals("Ouest"));
        Assert.assertEquals(inventaireRouge.getPiece(1).getOrientation(),"Est");

        Assert.assertEquals(inventaireJaune.getPiece(1).getListeCase(),inventaireRouge.getPiece(1).getListeCase());
    }

}
