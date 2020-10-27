package JavaHW;

//filler code for pong provided by Mr. David 
// we could do an input color
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
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	
	Scanner in = new Scanner(System.in);
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 20, PADDLE_HEIGHT = 100;
	private int paddleSpeed1 = 4; 
	private int paddleSpeed2 = 4; 
	private int paddle_y2 = HEIGHT/2;
	private int paddle_y1 = HEIGHT/2;
	
	private int x = WIDTH/2,y= HEIGHT/2, speedX = 7, speedY = 2;
	
	int markY1, markY2;
	
	private int time = 1;
	
	boolean hit;

	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false;
	
	
	// this method moves the ball at each timestep
	public void move_ball() {
		x += speedX;
		y += speedY;
	}
	
	// this method moves the paddles at each timestep
	public void move_paddles() {
		if (up2 && !solo) {
			paddle_y2 += paddleSpeed2;
		}
		if (down2 && !solo) {
			paddle_y2 -= paddleSpeed2;
		}
		if (up1) {
			paddle_y1 += paddleSpeed1;
		}
		if (down1) {
			paddle_y1 -= paddleSpeed1;
		}
		if (solo) {
	
			if (y < paddle_y2+PADDLE_HEIGHT/2-DIAM/2) {
				paddle_y2 -= paddleSpeed2;
			}
			if (y > paddle_y2+PADDLE_HEIGHT/2-DIAM/2) {
				paddle_y2 += paddleSpeed2;	
			}
		}
		if (!solo && hit) {
			checkX();
		}
		
	}
	
	public void checkX() {
		if (!solo) {
			markY1 = (int)(Math.random()*600);
			markY2 = (int)(Math.random()*600);
			System.out.println(markY1);
			System.out.println(markY2);
			if (paddle_y1 == markY1) {
				hit = true;
				paddleSpeed1 += 1;
			}
			if (paddle_y2 == markY2) {
				hit = true;
				paddleSpeed2 += 1;
			}
		}
	}
	
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		if (x <= PADDLE_WIDTH && y >= paddle_y1 && y <= (paddle_y1+PADDLE_HEIGHT)) {
				speedX = -speedX;
		}
		else if (x >= (WIDTH-PADDLE_WIDTH*2) && y >= paddle_y2 && y <= (paddle_y2+PADDLE_HEIGHT)) { 
				speedX = -speedX;
		}
		else {
		
			if (x >= WIDTH-DIAM || x <= 0 ) {
				speedX = -speedX;
			}
			if (y <= 0 || y >= HEIGHT-DIAM) {
				speedY = -speedY;
			}
		}
		
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		g.setColor(Color.BLUE);
		g.fillRect(0, paddle_y1, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.fillRect(WIDTH-PADDLE_WIDTH, paddle_y2, PADDLE_WIDTH, PADDLE_HEIGHT);
		g.setColor(Color.YELLOW);
		g.fillOval(x, y, DIAM, DIAM); // this is the ball
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		g.drawString("P1 Score: ", WIDTH/5, 20);
		g.drawString("P2 Score: ", WIDTH*3/5, 20);
		if (!solo && (hit || time == 1)) {
			g.setColor(Color.green);
			g.drawString("X",PADDLE_WIDTH/2, markY1);
			g.drawString("X", WIDTH-PADDLE_WIDTH/2, markY2);
			System.out.println("Drawn");
			time += 1;
		}
	}

	// defines what we want to happen if a keyboard button has 
	// been pressed - you need to complete this
	public void keyPressed(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// changes paddle direction based on what button is pressed
		if (keyCode == KeyEvent.VK_DOWN) {
			up2 = true;
		}
		
		if (keyCode == KeyEvent.VK_UP) {
			down2 = true;
		}


		if (e.getKeyChar() == 'w') {
			down1 = true;
		}
		
		if (e.getKeyChar() =='s') {
			up1 = true;
		}
			
		// turn 1-player mode on
		if (e.getKeyChar() == '1') {
			solo = true;
		}
			
			
		// turn 2-player mode on
		if (e.getKeyChar() == '2') {
			solo = false;
		}
	}

	// defines what we want to happen if a keyboard button
	// has been released - you need to complete this
	public void keyReleased(KeyEvent e) {
		
		int keyCode = e.getKeyCode();
		
		// stops paddle motion based on which button is released
		if (keyCode == KeyEvent.VK_UP) {
			down2 = false;
		}
		if (keyCode == KeyEvent.VK_DOWN) {
			up2 = false;
		}

		if(e.getKeyChar() == 'w') {
			down1 = false;
		}
			
		
		if (e.getKeyChar() == 's') {
			up1 = false;
		}
	}
	
	// restarts the game, including scores
	public void restart() {

		// code here
	}

	//////////////////////////////////////
	//////////////////////////////////////
	
	// DON'T TOUCH THE BELOW CODE
	
	
	// this method runs the actual game.
	public void run() {

		// while(true) should rarely be used to avoid infinite loops, but here it is ok because
		// closing the graphics window will end the program
		while (true) {
	
			// draws the game
			repaint();
			
			// we move the ball, paddle, and check for collisions
			// every hundredth of a second
			move_ball();
			move_paddles();
			check_collisions();
			
			//rests for a hundredth of a second
			try {
				Thread.sleep(10);
			} catch (Exception ex) {}
		}
	}
	
	// very simple main method to get the game going
	public static void main(String[] args) {
		new Pong();
	}

	// does complicated stuff to initialize the graphics and key listeners
	// DO NOT CHANGE THIS CODE UNLESS YOU ARE EXPERIENCED WITH JAVA
	// GRAPHICS!
	public Pong() {
		JFrame frame = new JFrame();
		JButton button = new JButton("restart");
		frame.setSize(WIDTH, WINDOW_HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.add(this);
		frame.add(button, BorderLayout.SOUTH);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				restart();
				Pong.this.requestFocus();
			}
		});
		this.addKeyListener(this);
		this.setFocusable(true);
		
		run();
	}
	
	// method does nothing
	public void keyTyped(KeyEvent e) {}
}