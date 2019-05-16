package com.ballgame.n0724;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.Random;

public class ball {
	public ball(int x, int y, int speedX, int speedY, int R, Graphics go,
			MainFrame mf) {
		this.x = x;
		this.y = y;
		this.speedX = speedX;
		this.speedY = speedY;
		this.go = go;
		this.R = R;
		this.mf = mf;
		// this.list = list;
	}

//	public void clearball() {
//		g.setColor(mf.getContentPane().getBackground());
//		g.fillOval(x - R - speedX, y - R - speedY, R, R);
//  }
 
	public void printball() {
		//speedX+=2;
		//speedY+=2;
		crashwall();
		
		go.setColor(new Color(new Random().nextInt(255), new Random()
				.nextInt(255), new Random().nextInt(255)));
		go.fillOval(x - R, y - R , R, R);
	
	}
	public void print() {
		//speedX+=2;
		//speedY+=2;
		crashwall();
		
		go.setColor(Color.BLUE);
		go.fillOval(x - R, y - R , R, R);
		
		go.setColor(Color.RED);((Graphics2D) go).drawString(String.valueOf(this.R-25), 
				x-R, y -R/2);
	
	}
	
//	public void clear(){	
	
	//g.setColor(mf.getContentPane().getBackground());
	//g.fillOval(x - R, y - R , R, R);}
	
	
	
	public void crashwall(){
		//X
		if(x >= mf.getWidth()){
			 speedX *= -1;
		}else if(x - R <=0){
			speedX *= -1;
		}
		//Y
		if(y >= mf.getHeight()){
			speedY *= -1;
		}else if(y - R <=0){
			speedY *= -1;
		}
		///////////
		x+=speedX;
		y+=speedY;
	}
	
	
	// private ArrayList<ball>list;
 int x, y, speedX, speedY, R;
	private Graphics go;
	private MainFrame mf;
}
