package com.ballgame.n0724;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class ball_listener implements MouseMotionListener {
	public ball ball;

	// 构造函数
	public ball_listener(ball ball) {
		this.ball = ball;

	}

	// 实现鼠标移动时，小球坐标改变
	public void mouseMoved(MouseEvent e) {
		// System.out.println("pppppp");
		int x = e.getX();
		int y = e.getY();
		ball.x = x + ball.R / 2;
		ball.y = y + ball.R / 2;
		ball.print();
		/*-ball.width/2;*/
	}

	public void mouseDragged(MouseEvent e) {

	}

}
