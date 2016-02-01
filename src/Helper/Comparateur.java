package Helper;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jehan on 29/01/2016.
 */
public class Comparateur implements Comparator {

    Map map;

    public Comparateur(Map map) {
        this.map = map;
    }

    public int compare(Object keyA, Object keyB) {
        Comparable valueA = (Comparable) map.get(keyA);
        Comparable valueB = (Comparable) map.get(keyB);
        return valueB.compareTo(valueA);
    }
}