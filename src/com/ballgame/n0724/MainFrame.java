package com.ballgame.n0724;
import javax.swing.JOptionPane;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

//import login.buttonlistenner;

public class MainFrame extends JFrame {
	public static void main(String[] args) {
		MainFrame mf = new MainFrame();
		mf.into();
	}
	public void into(){
		final JFrame open = new JFrame();
		open.setTitle("球球大作战2.0");
		open.setSize(300, 500);
		open.setLocationRelativeTo(null);
		open.setResizable(false);
		open.setDefaultCloseOperation(3);
		open.setLayout(new FlowLayout());
		//空标签
		JLabel kong = new JLabel();
		kong.setPreferredSize(new Dimension(300,300));
		open.add(kong);
		open.setVisible(true);		
		//添加开始按钮
		Button start = new Button("start the game");
		start.setPreferredSize(new Dimension(200,50));
		open.add(start);
		//添加帮助按钮
		Button help = new Button("help");
		help.setPreferredSize(new Dimension(200,50));
		open.add(help);
		//添加帮助按钮
		Button more= new Button("more");
		more.setPreferredSize(new Dimension(200,50));
		open.add(more);
		//添加监听
		start.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//主程序
				open.dispose();
				MainFrame mf = new MainFrame();
				mf.initUI();
			}
		});
		//添加图片
	 java.net.URL imgURL = MainFrame.class.getResource("1.jpg");
	 ImageIcon icon = new ImageIcon(imgURL);
	//	ImageIcon icon = new ImageIcon("src/com/ballgame/n0724/1.jpg");
		kong.getGraphics().drawImage(icon.getImage(), 0, 0, 300, 300, null);
		//添加监听
		help.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new  JOptionPane().showMessageDialog(open, "嘉俊君正在抓紧开发...");
				}
		});
		more.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new  JOptionPane().showMessageDialog(open, "嘉俊君正在抓紧开发...");
				}
		});
	}

	public void initUI() {
		this.setTitle("小球游戲2.0");
		this.setSize(1400, 700);
		this.setDefaultCloseOperation(3);
		this.setLocationRelativeTo(null);
		this.setResizable(false);
		this.setVisible(true);

		Image imageo = this.createImage(this.getWidth(), this.getHeight());
		
		ball B = new ball(0,0,  0, 0,25 ,imageo.getGraphics(),  this);
		Ball_move i = new Ball_move(this, this.getGraphics(), list, imageo,B);

		list.add(B);
		ball_listener q = new ball_listener(B);
		this.addMouseMotionListener(q);
		Thread o = new Thread(i);
		o.start();
		ballAI ai = new ballAI(imageo.getGraphics(), this, list,B);
		ai.start();

	}
	
	private ArrayList<ball> list = new ArrayList<ball>();
}
