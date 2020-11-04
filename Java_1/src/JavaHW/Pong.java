package JavaHW;

// Google for some of the random and timing things inside the code
// filler code for pong provided by Mr. David
// filled by Ivy

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Pong extends JPanel implements KeyListener {
	// rand is used to call random
	Random rand = new Random();
	// used to take user input
	Scanner in = new Scanner(System.in);
	
	// constants that are predefined and won't change as the program runs
	private final int WIDTH = 600, HEIGHT = 600, WINDOW_HEIGHT = 650;
	private final int PADDLE_WIDTH = 20, DIAM = 20;
	private int paddle_height1 = 100;
	private int paddle_height2 = 100;
	private int paddleSpeed1 = 4; 
	private int paddleSpeed2 = 4; 
	private int paddle_y2 = HEIGHT/2;
	private int paddle_y1 = HEIGHT/2;
	
	private int x = WIDTH/2,y= HEIGHT/2;
	private double speedX = 7, speedY = 2;
	
	private boolean timeF = true;
	
	private boolean hit = false;
	
	private boolean collide1 = false; 
	
	private boolean collide2 = false;
	
	private int point1 = 0; // this stores the points of the first player
	
	private int point2 = 0; // this stores the points of the second player
	
	private Color randomColor;
	
	private long startTime, endTime;
	
	private boolean gameOver = false;
	
	private int timePassedI = 0;
	
	private double timePassed = 0;
	
	private boolean restarted = false;
	
	private int markY1 = (int)(Math.random()*HEIGHT);

	// your instance variables here, I've given you a few 
	private boolean up1, down1, up2, down2; 		// booleans to keep track of paddle movement
	private boolean solo = false; // the default for the game will be multi-players
	
	
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
			if (y < paddle_y2+paddle_height2/2-DIAM/2) {
				paddle_y2 -= paddleSpeed2;
			}
			
			if (y > paddle_y2+paddle_height2/2-DIAM/2) {
				paddle_y2 += paddleSpeed2;	
			}
		}
		
		if (!solo) {
			checkX();
		}
		
		if (solo) {
			calcTime();
		}
		
	}
	
	// this checks for the time that has passed and calculates the level that the user is on based on it
	public void calcTime() {
		endTime = System.nanoTime(); // e
		timePassed = 0;
		timePassed = (endTime - startTime)/1000000000; // this changes it into seconds
		
		// after it gets close to 1 second, it is going to start making it one and showing it on the screen
		if (timePassed > 1/2) {
			timePassedI = (int)timePassed; // changes it into a int
		}
		
		// checks for collision on the left side
		if (collide1) {
			paddle_y2 = HEIGHT/2;
			paddle_y1 = HEIGHT/2;
			x = WIDTH/2;
			y = HEIGHT/2;
			try {
				Thread.sleep(100);
			} catch (Exception ex) {}
			gameOver = true;
			generateColor();
			startTime = 0;
			startTime = System.nanoTime(); // starts the timing again
			collide1 = false;
		}
	}
	
	// this checks for when the ball hits the other side of the screen
	public void checkX() {
		if (paddle_y1 <= markY1 && paddle_y1+paddle_height1 >= markY1) {
			hit = true;
			paddle_height1 += 5;
			markY1 = (int)(Math.random()*600);
		}
		if (paddle_y2 <= markY1 && paddle_y2+paddle_height2 >= markY1) {
			hit = true;
			paddle_height2 += 5;
			markY1 = (int)(Math.random()*600);
		}
	}
	
	// this void changes the scores of the players and also resets the location of the ball when one player scores.
	public void scorePoint() {
		if (!solo) {
			
			// checks for collisions on the right side and resets
			if (collide1) {
				point2 += 1;
				generateColor();
				collide1 = false;
				paddle_y2 = HEIGHT/2;
				paddle_y1 = HEIGHT/2;
				x = WIDTH/2;
				y = HEIGHT/2;
				speedX = 7;
				speedY = 2;
				paddle_height1 = 100;
				paddle_height2 = 100;
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {}
			}
			
			// checks for collisions on the right side and resets
			if (collide2) {
				point1 += 1;
				generateColor();
				collide2 = false;
				paddle_y2 = HEIGHT/2;
				paddle_y1 = HEIGHT/2;
				x = WIDTH/2;
				y = HEIGHT/2;
				speedX = 7;
				speedY = 2;
				paddle_height1 = 100;
				paddle_height2 = 100;
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {}
			}
			
			// after the height of the paddle reaches half of the width, the first user to do so gets 2 points
			if (paddle_height1 >= HEIGHT/2) {
				point1 += 2;
				generateColor();
				paddle_height1 = 100;
				paddle_height2 = 100;
			}
			
			// after the height of the paddle reaches half of the width, the first user to do so gets 2 points
			if (paddle_height2 >= HEIGHT/2) {
				point2 += 2;
				generateColor();
				try {
					Thread.sleep(500);
				} catch (Exception ex) {}
				paddle_height1 = 100;
				paddle_height2 = 100;
				paddle_y2 = HEIGHT/2;
				paddle_y1 = HEIGHT/2;
				x = WIDTH/2;
				y = HEIGHT/2;
				speedX = 7;
				speedY = 2;
				try {
					Thread.sleep(1000);
				} catch (Exception ex) {}
			}
		}
	}
	
	
	// this method checks if there are any bounces to take care of,
	// and if the ball has reached a left/right wall it adds to 
	// the corresponding player's score
	public void check_collisions() {
		
		// checks for collisions on the right paddle
		if (x <= PADDLE_WIDTH && y >= paddle_y1 && y <= (paddle_y1+paddle_height1)) {
				speedX = -speedX;
		}
		
		// checks collisions on the left paddle
		else if (x >= (WIDTH-PADDLE_WIDTH*2) && y >= paddle_y2 && y <= (paddle_y2+paddle_height2)) { 
				speedX = -speedX;
		}
		
		// this checks for collisions on the sides
		else {
		
			if (x >= WIDTH-DIAM) {
				speedX = -speedX;
				collide2 = true;
			}
			if ( x <= 0 ) {
				speedX = -speedX;
				collide1 = true;
			}
			if (y <= 0 || y >= HEIGHT-DIAM) {
				speedY = -speedY;
			}
		}
		
	}
	
	// this method generates a random color
	public void generateColor() {
		int r = rand.nextInt(256);
		int g = rand.nextInt(256);
		int b = rand.nextInt(256);
		randomColor = new Color(r, g, b);
	}
	

	// defines what we want to happen anytime we draw the game
	// you simply need to fill in a few parameters here
	public void paint(Graphics g) {
		
		// background color is gray
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		// draw your rectangles and circles here
		g.setColor(Color.BLUE);
		g.fillRect(0, paddle_y1, PADDLE_WIDTH, paddle_height1);
		g.fillRect(WIDTH-PADDLE_WIDTH, paddle_y2, PADDLE_WIDTH, paddle_height2);
		g.setColor(randomColor);
		g.fillOval(x, y, DIAM, DIAM); // this is the ball
		
		// writes the score of the game - you just need to fill the scores in
		Font f = new Font("Arial", Font.BOLD, 14);
		g.setFont(f);
		g.setColor(Color.red);
		if (!solo) {
			g.drawString("P1 Score: " + point1, WIDTH/5, 20);
			g.drawString("P2 Score: " + point2, WIDTH*3/5, 20);
		}
		// unless it is the first time running the code, a new x doesnt get drawn unless the previous x was hit
		if (!solo && (timeF || hit)) {
			g.setColor(Color.black);
			g.drawString("X",PADDLE_WIDTH/2, markY1);
			g.drawString("X", WIDTH-PADDLE_WIDTH/2, markY1);
			hit = false;
		}
		
		// this prints out the timer thing at the top of single player mode
		if (solo) {
			g.drawString(" " + timePassedI, WIDTH/2, 20);
		}
		
		if (gameOver) {
			try {
				Thread.sleep(500);
			} catch (Exception ex) {}
			gameOver = false;
			
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
			startTime = 0;
			startTime = System.nanoTime();
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
		paddle_height1 = 100;
		paddle_height2 = 100;
		paddleSpeed1 = 4; 
		paddleSpeed2 = 4; 
		paddle_y2 = HEIGHT/2;
		paddle_y1 = HEIGHT/2;
		x = WIDTH/2;
		y = HEIGHT/2;
		speedX = 7;
		speedY = 2;
		point1 = 0;
		point2 = 0;
		generateColor();
		restarted = true;

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
			if (restarted) {
				try {
					Thread.sleep(500);
				} catch (Exception ex) {}
				restarted = false;
			}
			move_ball();
			move_paddles();
			check_collisions();
			scorePoint();
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