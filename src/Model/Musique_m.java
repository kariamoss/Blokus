package Model;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.audio.AudioPlayer;
import sun.audio.AudioStream;


public class Musique_m extends Thread
{
    // Member
    private AudioStream as;
    private AudioPlayer p;
    private boolean playback;
    private String musicPath;

    public Musique_m(String path)
    {
        super();
        this.musicPath = path;
    }

    public void run() { startPlayback(); }

    private void setRandom()
    {
        File[] files = getTracks();
        try
        {
            String f = files[(int) (Math.random() * (files.length))].getAbsolutePath();
            System.out.println("Joue maintenant : " + f);
            as = new AudioStream(new FileInputStream(f));
        }
        catch (IOException ex)
        {
            Logger.getLogger(Musique_m.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void startPlayback()
    {
        playback = true;
        setRandom();
        p.player.start(as);
        try
        {
            do {} while (as.available() > 0 && playback);
            if (playback) { startPlayback(); }
        }
        catch (IOException ex)
        {
            Logger.getLogger(Musique_m.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void stopPlayback()
    {
        playback = false;
        p.player.stop(as);
    }

    private File[] getTracks()
    {
        File dir = new File(System.getProperty("user.dir") + musicPath);
        File[] a = dir.listFiles();
        ArrayList<File> list = new ArrayList<File>();
        for (File f : a)
            if (f.getName().substring(f.getName().length() - 3, f.getName().length()).equals("wav")) { list.add(f); }

        File[] ret = new File[list.size()];

        for (int i = 0; i < list.size(); i++)
            ret[i] = list.get(i);

        return ret;
    }
}
