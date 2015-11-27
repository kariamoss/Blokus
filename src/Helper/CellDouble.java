package Helper;

public class CellDouble {

    public CellDouble prev;
    public String value;
    public CellDouble next;


    public CellDouble(String value) {
        this.value = value;
        next = null;
        prev = null;
    }
}
