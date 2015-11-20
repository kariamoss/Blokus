import Model.Inventaire_m;
import org.junit.Assert;
import org.junit.Test;

public class InventaireUnitTest {
    @Test
    public void inventaireTest(){
        Inventaire_m inventaireRouge = new Inventaire_m("rouge");
        Inventaire_m inventaireJaune = new Inventaire_m("jaune");
        Assert.assertFalse(inventaireRouge.getPiece1() == inventaireRouge.getPiece2());
        Assert.assertFalse(inventaireRouge.getPiece1() == inventaireJaune.getPiece1());

        Assert.assertEquals(inventaireRouge.getPiece1().getOrientation(), "Ouest");
        inventaireRouge.getPiece1().setOrientation("Est");
        Assert.assertFalse(inventaireRouge.getPiece1().getOrientation().equals("Ouest"));
        Assert.assertEquals(inventaireRouge.getPiece1().getOrientation(),"Est");

        Assert.assertEquals(inventaireJaune.getPiece1().getListeCase(),inventaireRouge.getPiece1().getListeCase());
    }

}
