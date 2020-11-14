package JavaCW;

//filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Polygon;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	Random rand = new Random();
	private Color randomColor;
	private int x, y, h, w;
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 1000, HEIGHT = 600;
	
	public void circlesSize(Graphics g) {
		
		g.setColor(Color.blue);
		
		for(int i = 0; i < 2; i++) {
			for (int j = 0; j < 10; j++) {
				g.fillOval(j*40+i*400, 300, j*5, j*5);
			}
		}
	}
	
	public void coloredRecs(Graphics g) {
		int blue = 0;
		for(int i = 0; i < 20; i++) {
			g.setColor(new Color(blue));
			g.fillRect(i*50, 290, 40, 20);
			
			blue += 15;
			if (blue > 225) {
				blue = 0;
			}
		}
	}
	
	public void checkerBoards(Graphics g){
		for (int i = 0; i*20 < HEIGHT; i++) {
			for (int j = 0; j*20 < WIDTH; j++)
				if ((j+i) % 2 == 0) {
					g.setColor(Color.BLACK);
					g.fillRect(20*j, i*20, 20, 20);
				}
				else {
					g.setColor(Color.WHITE);
					g.fillRect(20*j, i*20, 20, 20);
				}
		}
	}

	public void random() {
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		randomColor = new Color(r, g, b);
		x = rand.nextInt(1000);
		y = rand.nextInt(600);
		h = rand.nextInt(500);
		w = rand.nextInt(300);
	}
	
	public void randStuff(Graphics g) {
		for (int i = 0; i < 20; i++) {
			random();
			g.setColor(randomColor);
			g.fillRect(x, y, h, w);
		}
	}
	
	public void drawCircles(int n, Graphics g) {
		g.setColor(Color.blue);
		for (int i = 0; i < n; i++) {
			g.fillOval(i*WIDTH/n, HEIGHT/2, WIDTH/n, WIDTH/n);
		}
	}

	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// call your methods here
		//circlesSize(g);
		//coloredRecs(g);
		//checkerBoards(g);
		//randStuff(g);
		drawCircles(7,g);
		
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual program.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
			
	
			// draws
			//repaint();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new LoopGraphicsFiller();
	}

	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public LoopGraphicsFiller() {
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		this.setFocusable(true);
		
		run();
	}
}