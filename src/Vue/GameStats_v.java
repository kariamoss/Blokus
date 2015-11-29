package Vue;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Fox Mc-Tag on 27/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class GameStats_v {
    private JPanel gameStats;



    public GameStats_v(){
        initGameStats();
    }

    public GameStats_v(int nbPlayers){
        initGameStats(nbPlayers);
    }



        private void initGameStats(){
            gameStats= new JPanel();
            gameStats.setLayout(new BoxLayout(gameStats, BoxLayout.Y_AXIS));
            mountGameStats(4);
        }
        private void initGameStats(int nbPlayers){
            gameStats= new JPanel();
            gameStats.setLayout(new BoxLayout(gameStats, BoxLayout.Y_AXIS));
            mountGameStats(nbPlayers);
        }
            private void mountGameStats(int nbPlayers){
                for (int i= 0; i < nbPlayers; i++){
                    gameStats.add(new PlayerCard_v().getPlayerCard());
                }
            }



    public JPanel getGameStats(){ return gameStats; }




}
