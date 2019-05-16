package com.ballgame.n0724;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import com.ballgame.n0724.MainFrame;
import javazoom.jl.decoder.JavaLayerException;
import javazoom.jl.player.Player;

	public class music  extends Thread{
		 BufferedInputStream buffer;
		 public void run() {
		while(true) {
		try { 
			 java.net.URL muURL = MainFrame.class.getResource("ww.war");
			buffer = new BufferedInputStream(
				       new FileInputStream(muURL.toString()));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
			       try {
					new Player(buffer).play();
				} catch (JavaLayerException e) {
					e.printStackTrace();
				} 
		 	}
		 }
	}
