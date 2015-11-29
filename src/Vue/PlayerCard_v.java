package Vue;
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
        initComponent();
    }



    private void initComponent(){
        initSubComponents();

        BoxLayout componentLayout= new BoxLayout(componentPanel, BoxLayout.X_AXIS);
        componentPanel.setLayout(componentLayout);

        Border playerCardBoarder = new LineBorder(new Color_v(0,0,0).getColor(), 2);
        componentPanel.setBorder(playerCardBoarder);

        mountSubComponents();
    }
        private void initSubComponents(){
            playerColor= new JPanel();
            playerColor.setBackground(new Color_v().getColor());

            playerName= new JPanel();
            playerName.setBackground(new Color_v(108,108,108).getColor());

            playerScore= new JPanel();
            playerScore.setBackground(new Color_v(208,208,208).getColor());

            initLabels();
        }
            private void initLabels(){
                playerName_l= new JLabel("new_player");
                playerName_l.setOpaque(false);

                playerScore_l= new JLabel(String.valueOf(0));
                playerScore_l.setOpaque(false);

                mountLabels();
            }
            private void mountLabels(){
                playerName_l.setHorizontalAlignment(JLabel.CENTER);
                playerName.add(playerName_l);

                playerName_l.setHorizontalAlignment(JLabel.CENTER);
                playerScore.add(playerScore_l);
            }
        private void mountSubComponents(){
            componentPanel.add(playerColor);
            componentPanel.add(playerName);
            componentPanel.add(playerScore);
        }



    public JPanel getPlayerCard(){ return componentPanel; }



}
