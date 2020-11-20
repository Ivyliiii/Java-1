package JavaHW;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class fallingBlocks extends JPanel {
	
	private int WIDTH = 800, HEIGHT = 600, NUMBLOCKS = 50;

	private int[] x = new int[NUMBLOCKS];
	private int[] y = new int[NUMBLOCKS];
	private int[] speed = new int [NUMBLOCKS];
	private int[] red = new int [NUMBLOCKS];
	private int[] green = new int [NUMBLOCKS];
	private int[] blue = new int [NUMBLOCKS];
	private int[] randomColor = new int [NUMBLOCKS];
	
	// fills in your arrays with random x and y values
	public void initializeArrays() {
		
		for (int i = 0; i < x.length; i++){
			x[i] = (int)(Math.random()*WIDTH);
		}
		
		for (int j = 0; j < speed.length; j++) {
			speed[j] = (int)(Math.random()*10) + 5; //this is magic numbers, but i want to make sure that no clocks are too short
		}
	}
	
	// change your arrays here to make the blocks move
	public void moveblocks() {
		for(int i = 0; i < NUMBLOCKS; i++) {
			y[i] += speed[i];
			if (y[i] >= HEIGHT) {
				y[i] = 0;
			}
		}
	}
	
	public void generateColor() {
		for (int i = 0; i < NUMBLOCKS; i++) {
			red[i] = (int)(Math.random()*256);
			green[i] = (int)(Math.random()*256);
			blue[i] = (int)(Math.random()*256);
		}
	}

	// change the last part of this method!
	public void paint(Graphics g) {
		// give a white background
		g.setColor(Color.white);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// color the rectangles blue - you can change this
	
		for (int i = 0; i < x.length; i++) {
			g.setColor(new Color(red[i], green[i], blue[i]));
			g.fillRect(x[i], y[i], 10, 10);
		}
	}
	
	// ******** DON'T TOUCH BELOW CODE ***************
	
	// don't touch this method!
	public fallingBlocks() {
		initializeArrays();
		generateColor();
		JFrame frame = new JFrame();
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.setVisible(true);

		while (true) {
			moveblocks();
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

			WIDTH = frame.getSize().width;
			HEIGHT = frame.getSize().height;
		}
	}

	// don't touch this method!
	public static void main(String[] args) {
		new fallingBlocks();
	}

}