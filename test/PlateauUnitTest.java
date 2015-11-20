import Model.Plateau_m;
import junit.framework.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Mathieu on 13/11/2015.
 */
public class PlateauUnitTest {
    @Test
    public void testGenererPlateau(){
        Plateau_m plateau = new Plateau_m();

        plateau.genererPlateau(plateau.getTaillePlateau(),plateau.getNbCases());
        Assert.assertEquals(plateau.getNbCases(),400);
        Assert.assertEquals(plateau.getTaillePlateau(),20);
    }
}