package com.ballgame.n0724;
import java.applet.AudioClip; 
import java.io.*; 
import java.applet.Applet; 
import java.awt.Frame; 
import java.net.MalformedURLException; 
import java.net.URL; 
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Graphics;
import java.io.File;
import java.net.URI;
import java.util.ArrayList;
import java.util.Random;

public class ballAI extends Thread{
	public ballAI( Graphics go, MainFrame mf,ArrayList<ball>list, ball B) {
	//	this.x = x;
	//	this.y = y;
	//	this.speedX = speedX;
	//	this.speedY = speedY;
		this.go = go;
		this.mf = mf; 
		this.list = list;
		this.B =B;
	}
	public void run(){
		
		while(true){	
			
			int R;
			int x = new Random().nextInt(mf.getWidth());
			int y = new Random().nextInt(mf.getHeight());
			int speedX = new Random().nextInt(5)+1;
			int speedY = new Random().nextInt(5)+1;
	if(Math.abs(x-B.x)<=B.R||Math.abs(y-B.y)<=B.R){continue;}
	if(B==null){ R = new Random().nextInt(30)+10;	}
	else{ R = new Random().nextInt(30)-10+B.R;System.out.println("B.R = " + B.R);}
			//创建小球并放入队列中
			ball b =  new ball(x,y,  speedX,  speedY,R ,go,  mf);
			list.add(b);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	private ball B;
	private ArrayList<ball>list;                                                                                                          
	//private int x, y, speedX, speedY, R;
	private Graphics go;
	private MainFrame mf;
}
