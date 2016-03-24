package Model;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

/**
 * Created by Lucas on 05/03/2016.
 */
public class NetworkManager {

    public General_m modelGeneral;
    Socket sock = null;

    public ObjectInputStream ois;
    public ObjectOutputStream oos;
    private boolean canPlay;

    public NetworkManager(General_m modelGeneral){
        this.modelGeneral = modelGeneral;
        canPlay = false;

    }


    public void connect() {
        try {
            sock = new Socket("127.0.0.1", 7002);
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        try {
            oos = new ObjectOutputStream(sock.getOutputStream());
            ois = new ObjectInputStream(sock.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }

        int numeroClient = 0;

        try{
            numeroClient = ois.read();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Je suis le client n° " + numeroClient);

    }

    public boolean canPlay() {
        return canPlay;
    }

    public void setCanPlay(boolean canPlay) {
        this.canPlay = canPlay;
    }

    public void sendRequest(int idAction, ArrayList<String> listParams){

    }
}
