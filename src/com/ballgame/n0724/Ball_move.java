package com.ballgame.n0724;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JOptionPane;

public class Ball_move implements Runnable {
	public Ball_move(MainFrame mf, Graphics g, ArrayList<ball> list,
			Image imageo, ball B) {// 构造传参
		
		this.mf = mf;
		this.B = B;
		this.g = g;
		this.list = list;
		this.imageo = imageo;
	}

	int r = 50;

	// public void mouseMoved(MouseEvent e) {
	// //System.out.println("bfkbfkiwekifnb");
	// int x=e.getX();
	// int y=e.getY();
	// ball ba = new ball(0, 0, 0, 0, 20, imageo.getGraphics(), mf);
	// list.add(ba);
	// ba.x=x-ba.R/2;
	// ba.y=y-ba.R/2;/*-ball.width/2;*/
	//
	// }

	public void run() {
		System.out.println("监听器" + list.size());
//		music m =  new music();
//		m.start();
		
		
		// g.drawImage(imageo, 0, 0, mf.getWidth(), mf.getHeight(), mf);
		while (true) {
			// ArrayList<ball> clearball = new ArrayList<ball>();
			// clearball代表要消除的小球

			crashball(list);// 清除小球

		
			for (int i = 0; i < list.size(); i++) {
				ball b = list.get(i);
				// b.clearball();
				b.printball();
				// ko = crashball(b);//ko是要被消除的小球
				// clearball.add(ko);
			}
			if(!judge()){
				JOptionPane.showMessageDialog(
						mf, "辣鸡，你被大球吃掉啦！得分："+String.valueOf(B.R-25));//m.stop();
					mf.main(null);mf.dispose();
				break;}
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			g.drawImage(imageo, 0, 0, mf.getWidth(), mf.getHeight(), mf);
			 java.net.URL imgURL = MainFrame.class.getResource("1.jpg");
			 ImageIcon image1 = new ImageIcon(imgURL);
//			ImageIcon image1 = new ImageIcon(
//					"src/com/ballgame/n0724/1.jpg");
			imageo.getGraphics().drawImage(image1.getImage(), 0, 0,
					mf.getWidth(), mf.getHeight(), mf);

			// 消除小球
			// for (int i = 0; i < clearball.size(); i++) {
			// ball b1 = clearball.get(i);
			// list.remove(b1);
			// if(b1!=null){b1.clear();}
			// }
			// clearball.clear();//清除该队列
		}
	}

	public void crashball(ArrayList<ball> balls) {
		for (int j = 0; j < balls.size(); j++) {
			ball b = balls.get(j);
			for (int i = 0; i < balls.size(); i++) {
				ball bb = balls.get(i);
				if (bb.equals(b)) {
					continue;
				} else {
					if (Math.sqrt(Math.abs(b.x - bb.x) * Math.abs(b.x - bb.x)
							+ Math.abs(b.y - bb.y) * Math.abs(b.y - bb.y)) <= Math
							.abs(b.R + bb.R) / 3) {
						if (b.R >= bb.R //&& b.R <= 300
								) {
							System.out.println("12312312312");
							b.R += bb.R / 5;
							list.remove(bb);
						} else if (b.R < bb.R //&& bb.R <= 300
								) {
							System.out.println("====");
							bb.R += b.R / 5;
							list.remove(b);
						}
					}

				}
			}
		}
	}

	private boolean judge() {
		for (int i = 0; i < list.size(); i++) {
			if (B == list.get(i)) {
				return true;
			}
		}
		return false;
	}

	private ball B;
	private Graphics g;
	private MainFrame mf;
	private ArrayList<ball> list;
	Image imageo;
}
