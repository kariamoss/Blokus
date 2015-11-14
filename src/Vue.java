
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Jehan Milleret on 29/04/2015.
 */
public class Vue extends JFrame {
    protected Model model;
    protected JPanel fenetre;

    public Vue(Model model){
        this.model = model;
        setTitle("Blokus");
        initAttribute();
        setSize(800, 600);
        setContentPane(fenetre);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void initAttribute() {

        fenetre = new JPanel();
    }

    public void display() {

        setVisible(true);
    }

}
