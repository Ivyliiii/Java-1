package JavaCW;

//filler code for pong provided by Mr. David

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class LoopGraphicsFiller extends JPanel {
	
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
	
	public void randShape(Graphics g) {
		for (int i = 0; i < 21; i++) {
			if (i % 3 == 1) {
				g.fillOval(i*25, 290, 20, 20);
			}
			else if (i % 3 == 2) {
				g.fillRect(i*25, 290, 20, 20);
			}
			else {
				g.fillPolygon(new int[]{}, new int[]{i*25+10}, 3);
			}
		}
	}

	// defines what we want to happen anytime we draw the graphics
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// call your methods here
		//circlesSize(g);
		coloredRecs(g);
		
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