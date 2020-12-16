// Angry Birds template provided by Mr. David

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.awt.image.BufferedImageOp;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class angrybird extends JPanel {
	
	// the width/height of the window - feel free to change these
	private final int W_WIDTH = 900, W_HEIGHT = 600;
	
	// the number of enemies in the game - feel free to change
	private final int NUM_ENEMIES = 6;
	
	// a constant for the gravitational pull on our 'bird' - again, feel free to change
	private final double GRAVITY = .4;
	
	// hints...
	private int[] enemyX = {490, 576, 456, 606, 787, 784};
	private int[] enemyY = {123, 245, 345, 442, 267, 390};
	private int enemySize = 100;
	private boolean[] dead;
	
	private final int ENEMYDIAM = 40, LAUNCHERDIAM = 25;

	// example for using images - delete/replace this!
	private Image Img1;
	private Image Img2;
	private Image Img3;
	private Image Img4;
	private Image grassImg2;
	private BufferedImage hammer;
	
	private double launcherX = W_WIDTH/9; 
	private double launcherY = 2*W_HEIGHT/3; 
	private double speedX, speedY;
	private boolean gravityOn = false;
	private int startX, startY;
	private int hammerSize = 100;
	private int radius = 20;
	private int locX;
	private int locY;
	private boolean locOk = true;
	
	
	// This function will generate random locations for the images
	/*private void randomLoc() {
		locOk = true;
		for (int i = 0; i < NUM_ENEMIES; i++) {
			locX = (int)((Math.random()*(W_WIDTH - enemySize)));
			locY = (int)((Math.random()*(W_HEIGHT - enemySize)));
			enemyX[i] = locX;
			enemyY[i] = locY;
		}

		
		for (int i = 1; i < enemyX.length; i++) {
			for (int j = 0; j < i; j++) {
				if (Math.abs(enemyX[i] - enemyX[j]) <= 100 || Math.abs(enemyX[i] - enemyY[j]) <= 100) {
					locOk = false;
				}
			}
		}
		if (!locOk) {
			randomLoc();
		}
	}*/

	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		// example of loading an image file - edit to suit your project
		try {
			
			grassImg2 = ImageIO.read(new File("grass2.png"));
			hammer = ImageIO.read(new File("hammer.png"));
			Img1 = ImageIO.read(new File("地鼠.png"));
			Img2 = ImageIO.read(new File("地鼠2号.png"));
			Img3 = ImageIO.read(new File("地鼠3号.png"));
			Img4 = ImageIO.read(new File("地鼠4号.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//randomLoc();
		
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		launcherX += speedX;
		launcherY += speedY;
		
		if (gravityOn) {
			speedY += GRAVITY;
		}
		if (launcherY >= W_HEIGHT) {
			launcherX = W_WIDTH/9; 
			launcherY = 2*W_HEIGHT/3;
			gravityOn = false;
			speedX = 0;
			speedY = 0;
		}
	}
	
	// check for any collisions between your 'bird' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
		// your code here
	}
	
	/*private int distance(int x1, int y1, int x2, int y2) {
		int dist;
		return dist;
	}*/
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	
	public void mousePressed(int mouseX, int mouseY) {
		startX = mouseX;
		startY = mouseY;

	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		
		int distDraggedX = mouseX - startX;
		int distDraggedY = mouseY - startY;
		
		speedX = -distDraggedX/10.0;
		speedY = -distDraggedY/10.0;
		gravityOn = true;
		
	}
	
	// draws everything in our project - the enemies, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		// example of how to draw an image - draws at (100, 100) with width/height of 40/40
		g.drawImage(grassImg2, 0, 0, W_WIDTH, W_HEIGHT, null);
		g.drawImage(Img1, enemyX[0], enemyY[0], enemySize, enemySize, null);
		g.drawImage(Img2, enemyX[1], enemyY[1], enemySize, enemySize, null);
		g.drawImage(Img3, enemyX[2], enemyY[2], enemySize, enemySize, null);
		g.drawImage(Img4, enemyX[3], enemyY[3], enemySize, enemySize, null);
		g.drawImage(Img3, enemyX[4], enemyY[4], enemySize, enemySize, null);
		g.drawImage(Img2, enemyX[5], enemyY[5], enemySize, enemySize, null);
		g.drawImage(hammer, (int)launcherX, (int)launcherY, hammerSize, hammerSize, null);
		g.setColor(Color.black);
		// your code here
	}
	
	
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			
			try {Thread.sleep(20);} 
			catch (InterruptedException e) {}
		}
	}
	
	public angrybird() {
		setup();
		
		JFrame frame = new JFrame();
		frame.setSize(W_WIDTH,W_HEIGHT);
		this.addMouseListener(new MouseListener() {
			public void mouseClicked(MouseEvent e) {}
			public void mousePressed(MouseEvent e) {
				angrybird.this.mousePressed(e.getX(),e.getY());	
			}
			public void mouseReleased(MouseEvent e) {
				angrybird.this.mouseReleased(e.getX(),e.getY());
			}
			public void mouseEntered(MouseEvent e) {}
			public void mouseExited(MouseEvent e) {}
		});
		frame.add(this);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		run();
	}
	public static void main(String[] args) {
		new angrybird();
	}
}