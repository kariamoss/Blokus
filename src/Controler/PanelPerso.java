package Controler;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;


public class PanelPerso extends JPanel
{
    private BufferedImage background;

    public PanelPerso()
    {
        super();
        this.background = null;
    }

    /**
     * @param background
     */
    public PanelPerso(BufferedImage background)
    {
        super();
        this.background = background;
    }

    /**
     * @param background
     * @param layout
     */
    public PanelPerso(BufferedImage background, BorderLayout layout)
    {
        super(layout);
        this.background = background;
    }

    @Override
    protected void paintComponent(Graphics g)
    {
        super.paintComponent(g);
        if(background != null) { g.drawImage(background, 0, 0, null); }
    }
}
