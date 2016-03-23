package Model;

import Vue.General_v;

public class ThreadEcouteIA extends Thread{
    IA_m ia_m;
    General_v general_v;
    General_m general_m;

    public void run() {
        long start = System.currentTimeMillis();
        // boucle tant que la durée de vie du thread est < à 5 secondes
        while(true) {
            // traitement

            try {
                if(general_m.tourSuivant) ia_m.runIA();
                Thread.sleep(500);
            }
            catch (InterruptedException ex) {}
        }
    }

    public void initThread(IA_m ia_m, General_m general_m, General_v general_v){
        this.general_m = general_m;
        this.general_v = general_v;
        this.ia_m = ia_m;
    }
}