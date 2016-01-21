package Vue;

import Model.Joueur_m;

import javax.swing.*;
import java.util.ArrayList;

/**
 * Created by Fox Mc-Tag on 27/11/2015.
 * Property of Mc-Tag's corporation, all rights reserved.
 */
public class GameStats_v {
    private JPanel gameStats;

    //Builds a game stats board using "nbPlayers" and names provided in the "playersNames" buffer.
    //Whatever the type of "playersNames"...
    /*public GameStats_v(String[] playersColors, String[] playersNames){
        initGameStats(playersColors, playersNames);
    }

    public GameStats_v(ArrayList<String>playersColors, ArrayList<String> playersNames){
        initGameStats( playersColors.toArray(new String[playersColors.size()]),
                playersNames.toArray(new String[playersNames.size()]) );
    }*/

    //Builds a game stats board using instances of "Joueur_m"...wrapped into whatever...
    //Whatever the type of "playersNames"...
    public GameStats_v(Joueur_m[] players){
        initGameStats(getPlayersColors(players), getPlayersNames(players), getPlayersScore(players));
    }

    public GameStats_v(ArrayList<Joueur_m> players){
        Joueur_m[] playersIntoTab= players.toArray(new Joueur_m[players.size()]);
        initGameStats(getPlayersColors(playersIntoTab), getPlayersNames(playersIntoTab), getPlayersScore(playersIntoTab));

    }

    private String[] getPlayersColors(Joueur_m[] players){
        String[] playersColors= new String[players.length];
        for (int i= 0; i < playersColors.length; i++){
            playersColors[i]= players[i].getCouleur();
        }

        return playersColors;
    }
    private int[] getPlayersScore(Joueur_m[] players){
        int[] playersScore= new int[players.length];
        for (int i= 0; i < playersScore.length; i++){
            playersScore[i]= players[i].getScore();
        }
        return playersScore;
    }

    private String[] getPlayersNames(Joueur_m[] players){
        String[] playersNames= new String[players.length];
        for (int i= 0; i < playersNames.length; i++){
            playersNames[i]= players[i].getNom();
        }

        return playersNames;
    }



    private void initGameStats(){
        gameStats= new JPanel();

        gameStats.setLayout(new BoxLayout(gameStats, BoxLayout.Y_AXIS));
        gameStats.setOpaque(false);

        //mountGameStats(4);
    }
    private void initGameStats(String[] playersColors,String[] playersNames, int[] playersScore){
        gameStats= new JPanel();
        gameStats.setLayout(new BoxLayout(gameStats, BoxLayout.Y_AXIS));
        mountGameStats(playersNames.length, playersColors, playersNames, playersScore);
    }
    private void mountGameStats(int nbPlayers){
        for (int i= 0; i < nbPlayers; i++){
            gameStats.add(new PlayerCard_v().getPlayerCard());
        }
    }
    private void mountGameStats(int nbPlayers, String[] playersColors, String[] playersNames, int[] playersScore){
        for (int i= 0; i < nbPlayers; i++){
            gameStats.add(new PlayerCard_v(playersColors[i], playersNames[i], playersScore[i]).getPlayerCard());
        }
    }

    public void updateGameStats(Joueur_m[] players){
        gameStats.removeAll();
        for (int i= 0; i < players.length; i++){
            gameStats.add(new PlayerCard_v(getPlayersColors(players)[i],
                    getPlayersNames(players)[i], getPlayersScore(players)[i]).getPlayerCard());
        }
        gameStats.validate();
        gameStats.repaint();


    }

    public JPanel getGameStats(){ return gameStats; }


}
