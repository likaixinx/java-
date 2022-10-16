package com.jgs.Utils;

import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @ClassName: com.jgs.Utils.Music
 * @author: likaixin
 * @create: 2022年10月16日 18:39
 * @description:
 */
public class Music extends Thread {


    Player player;
    String music;
    int num=0;

    public Music(String file) {
        this.music = file;
    }

    public void run() {
        try {
            play();
        } catch (FileNotFoundException | JavaLayerException e) {
            e.printStackTrace();
        }
    }

    public void play() throws FileNotFoundException, JavaLayerException {

        BufferedInputStream buffer = new BufferedInputStream(new FileInputStream(music));
        player = new Player(buffer);

        player.play();

    }

}
