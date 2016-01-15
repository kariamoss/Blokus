package Vue;
import Helper.Color_v;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Created by Fox Mc-Tag on 29/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class PlayerCard_v {
    private JPanel componentPanel;
    private JPanel playerColor;
    private JPanel playerName;
    private JLabel playerName_l;
    private JPanel playerScore;
    private JLabel playerScore_l;


    public PlayerCard_v(){
        componentPanel= new JPanel();
        componentPanel.setOpaque(false);
    }

    public PlayerCard_v(String color, String playerName, int score){
        componentPanel= new JPanel();
        initComponent(color, playerName, String.valueOf(score));
    }


    private void initComponent(String color, String playerName, String score){
        initSubComponents(color, playerName, score);

        BoxLayout componentLayout= new BoxLayout(componentPanel, BoxLayout.X_AXIS);
        componentPanel.setLayout(componentLayout);

        Border playerCardBoarder = new LineBorder(new Color_v(0,0,0).getColor(), 2);
        componentPanel.setBorder(playerCardBoarder);

        mountSubComponents();
    }

    private void initSubComponents(String color, String name, String score){
        playerColor= new JPanel();
        playerColor.setOpaque(true);
        playerColor.setBackground(new Color_v(color).getColor());

        playerName= new JPanel();
        playerName.setBackground(new Color_v(color).getColor());
        playerScore= new JPanel();

        initLabels(color, name, score);
    }

    private void initLabels(String color, String playerName, String score){
        playerName_l= new JLabel(playerName);
        playerName_l.setOpaque(false);

        playerScore_l= new JLabel(score);
        playerScore_l.setOpaque(false);

        mountLabels();
    }

    private void mountLabels(){
        playerName_l.setHorizontalAlignment(JLabel.CENTER);
        playerName.add(playerName_l);

        playerScore_l.setHorizontalAlignment(JLabel.CENTER);
        playerScore.add(playerScore_l);
    }

    private void mountSubComponents(){
        //componentPanel.add(playerColor);
        componentPanel.add(playerName);
        //componentPanel.add(playerScore);
    }



    public JPanel getPlayerCard(){ return componentPanel; }



}
