import Model.Inventaire_m;
import org.testng.Assert;
import org.testng.annotations.Test;

public class InventaireUnitTest {
    @Test
    public void inventaireTest(){
        Inventaire_m inventaireRouge = new Inventaire_m("rouge");
        Inventaire_m inventaireJaune = new Inventaire_m("jaune");
        Assert.assertFalse(inventaireRouge.getPiece1() == inventaireRouge.getPiece2());
        Assert.assertFalse(inventaireRouge.getPiece1() == inventaireJaune.getPiece1());

    }

}