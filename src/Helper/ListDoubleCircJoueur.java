package Helper;

import Model.Joueur_m;

public class ListDoubleCircJoueur {

    public CellDoubleJoueur head;
    public int size;

    public ListDoubleCircJoueur() {
        head = null;
        size = 0;
    }

    public CellDoubleJoueur find(Joueur_m value) {
        if( head == null) return null;
        CellDoubleJoueur c = head;
        while (c.value != value) {
            c = c.next;
            if (c == head) return null;
        }
        return c;
    }

    public CellDoubleJoueur get(int index) {
        if ((index <0) || (index >= size)) return null;

        CellDoubleJoueur c = head;
        if (index <= size/2) {
            for(int i=0;i<index;i++) {
                c = c.next;
            }
        }
        else {
            for(int i=size;i>index;i--) {
                c = c.prev;
            }
        }
        return c;
    }

    public Joueur_m getJoueur(int index) {
        if ((index <0) || (index >= size)) return null;

        CellDoubleJoueur c = head;
        if (index <= size/2) {
            for(int i=0;i<index;i++) {
                c = c.next;
            }
        }
        else {
            for(int i=size;i>index;i--) {
                c = c.prev;
            }
        }
        return c.value;
    }

    public CellDoubleJoueur prepend(Joueur_m value) {
        CellDoubleJoueur c = append(value);
        head = c;

        return c;
    }

    public CellDoubleJoueur append(Joueur_m value) {
        CellDoubleJoueur newCell = new CellDoubleJoueur(value);
        if (size == 0) {
            head = newCell;
            head.next = head;
            head.prev = head;
        }
        else {
            CellDoubleJoueur end = head.prev;
            newCell.prev = end;
            newCell.next = head;
            end.next = newCell;
            head.prev = newCell;
        }
        size += 1;
        return newCell;
    }

    public void insert(Joueur_m value, int index) {

        if (index >= size) {
            append(value);
        }
        else if (index <= 0) {
            prepend(value);
        }
        else {
            CellDoubleJoueur newCell = new CellDoubleJoueur(value);
            CellDoubleJoueur c = get(index);
            newCell.prev = c.prev;
            newCell.next = c;
            c.prev.next = newCell;
            c.prev = newCell;
            size += 1;
        }
    }

    public void replace(Joueur_m value, int index) {
        CellDoubleJoueur c = get(index);
        if (c != null) {
            c.value = value;
        }
    }

    public CellDoubleJoueur removeAt(int index) {
        CellDoubleJoueur c = get(index);
        if (c != null) {
            c.prev.next = c.next;
            c.next.prev = c.prev;
            if (c == head) {
                head = c.next;
            }
            size -= 1;
        }
        return c;
    }

    public CellDoubleJoueur remove(Joueur_m value) {
        CellDoubleJoueur c = find(value);
        if (c != null) {
            c.prev.next = c.next;
            c.next.prev = c.prev;
            if (c == head) {
                head = c.next;
            }
            size -= 1;
        }
        return c;
    }

    public void print() {
        CellDoubleJoueur c = head;
        for(int i=0;i<size;i++) {
            System.out.print(c.value+" -> ");
            c = c.next;
        }
        System.out.println();
    }
}

