// Angry Birds template provided by Mr. David
// Music Code by StackOverFlow
// Random Pictures From the Internet

import java.awt.Color;
import java.awt.Font;

import java.io.File;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class angrybird extends JPanel {
	
	// the width/height of the window - feel free to change these
	private final int W_WIDTH = 900, W_HEIGHT = 600;
	
	// the number of enemies in the game - feel free to change
	private final int NUM_ENEMIES_SECOND = 3;
	
	// a constant for the gravitational pull on our 'bird' - again, feel free to change
	private final double GRAVITY = .4;
	
	// hints...
	private double[] enemyX = {490, 576, 456, 606, 787, 784};
	private double[] enemyY = {123, 245, 345, 442, 267, 390};
	private double[] enemyXSecond = new double[3];
	private double[] enemyYSecond = new double [3];
	private int enemySizeSecond = 80;
	private int enemySize = 100;
	private boolean[] dead = {false, false, false, false, false, false};
	private int[] rotateSecond = {0, 0, 0};

	// example for using images - delete/replace this!
	private Image Img1;
	private Image Img1Rotate;
	private Image Img1right;
	private Image Img1left;
	private Image Img2;
	private Image Img2Rotate;
	private Image Img2right;
	private Image Img2left;
	private Image Img3;
	private Image Img3Rotate;
	private Image Img3right;
	private Image Img3left;
	private Image Img4;
	private Image Img4Rotate;
	private Image Img4right;
	private Image Img4left;
	private Image Img5;
	private Image Img5Rotate;
	private Image Img5right;
	private Image Img5left;
	private Image Img6;
	private Image Img6Rotate;
	private Image Img6right;
	private Image Img6left;
	private Image Img1R;
	private Image Img2R;
	private Image Img3R;
	private Image Img4R;
	private Image Img5R;
	private Image Img6R;
	private Image grassImg2;
	private Image hammer;
	private Image hammerleft;
	private Image hammerR;
	private Image hammerright;
	private Image hammerN;
	
	boolean firstTime = true;
	private int enemyFallSpeed = 9;
	private double launcherX = W_WIDTH/9; 
	private double launcherY = 2*W_HEIGHT/3; 
	private double speedX, speedY;
	private boolean gravityOn = false;
	private int startX, startY;
	private int hammerSize = 100;
	private int radius = 50;
	private boolean[] rotate = {false, false, false, false, false, false};
	private double countRotate[] = new double[rotate.length];
	private double[] enemyYSpeed = {4, 4, 4};
	private boolean[] falled = {false, false, false};
	private int rangeO = 3;
	private int rangeT = 7;
	private int rangeTh = 11;
	private int modNumber = 16;
	private double hammercount = 0;
	private boolean movingMode = false;
	private int hundred = 100;
	private int limit = 300;
	private int randomRange = 150;
	private int limitA = 50;
	private int enemyFallSpeedSecond = 11;
	private int shotsTaken = 0;
	private int countW = 6;
	private int font = 15;
	private int stringX = 40;
	private int string2X = 70;
	private double forceRatio = 10.0;
	
	
	
	// This function will generate random locations for the images
	private void randomLoc() {
		
		for(int i = 0; i < NUM_ENEMIES_SECOND; i++) {
			enemyXSecond[i] = (Math.random()*randomRange+limit+i*2*hundred);
			enemyYSecond[i] = (Math.random()*(W_HEIGHT-limitA-enemySizeSecond - limitA)+limitA);
		}

	}

	
	// this method is for setting up any arrays that need filling in and loading images. 
	// This method will run once at the start of the game.
	public void setup() {

		try {
			grassImg2 = ImageIO.read(new File("grass2.png"));
			hammer = ImageIO.read(new File("hammer.png"));
			hammerN = ImageIO.read(new File("hammer.png"));
			hammerleft = ImageIO.read(new File("hammerleft.png"));
			hammerright = ImageIO.read(new File("hammerright.png"));
			hammerR = ImageIO.read(new File("hammerR.png"));
			Img1 = ImageIO.read(new File("地鼠.png"));
			Img1Rotate = ImageIO.read(new File("地鼠rotate.png"));
			Img1left = ImageIO.read(new File("地鼠left.png"));
			Img1right = ImageIO.read(new File("地鼠right.png"));
			Img2 = ImageIO.read(new File("地鼠2号.png"));
			Img2Rotate = ImageIO.read(new File("地鼠2号rotate.png"));
			Img2left = ImageIO.read(new File("地鼠2号left.png"));
			Img2right = ImageIO.read(new File("地鼠2号right.png"));
			Img3 = ImageIO.read(new File("地鼠3号.png"));
			Img3Rotate = ImageIO.read(new File("地鼠3号 rotate.png"));
			Img3left = ImageIO.read(new File("地鼠3号left.png"));
			Img3right = ImageIO.read(new File("地鼠3号right.png"));
			Img4 = ImageIO.read(new File("地鼠4号.png"));
			Img4Rotate = ImageIO.read(new File("地鼠4号rotate.png"));
			Img4left = ImageIO.read(new File("地鼠4号left.png"));
			Img4right = ImageIO.read(new File("地鼠4号right.png"));
			Img5 = ImageIO.read(new File("地鼠.png"));
			Img5Rotate = ImageIO.read(new File("地鼠rotate.png"));
			Img5left = ImageIO.read(new File("地鼠left.png"));
			Img5right = ImageIO.read(new File("地鼠right.png"));
			Img6 = ImageIO.read(new File("地鼠2号.png"));
			Img6Rotate = ImageIO.read(new File("地鼠2号rotate.png"));
			Img6left = ImageIO.read(new File("地鼠2号left.png"));
			Img6right = ImageIO.read(new File("地鼠2号right.png"));
			Img1R = ImageIO.read(new File("地鼠.png"));
			Img2R = ImageIO.read(new File("地鼠2号.png"));
			Img3R = ImageIO.read(new File("地鼠3号.png"));
			Img4R = ImageIO.read(new File("地鼠4号.png"));
			Img5R = ImageIO.read(new File("地鼠.png"));
			Img6R = ImageIO.read(new File("地鼠2号.png"));
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	// move your 'bird' and apply any gravitational pull 
	public void moveBird() {
		launcherX += speedX;
		launcherY += speedY;
		
		if (gravityOn) {
			speedY += GRAVITY;
		}
		if (launcherY >= W_HEIGHT || launcherX >= W_WIDTH) {
			launcherX = W_WIDTH/9; 
			launcherY = 2*W_HEIGHT/3;
			gravityOn = false;
			hammercount = 0;
			speedX = 0;
			speedY = 0;
		}
	}
	
	// check for any collisions between your 'bird' and the enemies.
	// if there is a collision, address it
	public void checkHits() {
		for (int i = 0; i < enemyX.length; i++) {
			if (distance(launcherX, launcherY, enemyX[i], enemyY[i]) <= radius) {
				dead[i] = true;
			}
		}
	}
	
	// This function checks for collisions in the second part of the game
	public void checkHitsSecond() {
		for (int i = 0; i < NUM_ENEMIES_SECOND; i++) {
			if (distance(launcherX, launcherY, enemyXSecond[i], enemyYSecond[i]) <= radius) {
				falled[i] = true;
			}
		}
		falling();
	}
	
	// This is the function that is called when enemies fall in the second part of the game
	public void falling() {
		for(int i = 0; i < NUM_ENEMIES_SECOND; i++) {
			if(falled[i] == true) {
				enemyYSecond[i] += enemyFallSpeedSecond;
				rotateSecond(i);
			}
		}
	}
	
	// This is just a function that is called when enemies fall
	public void fall(int x) {
		enemyY[x] += enemyFallSpeed;
		rotate[x] = true;
	}
	
	// This function starts the second part of the game and calls the second sound affect
	public void activateSpecialMode() {
		int deadNumber = 0;
		for(int i = 0; i < dead.length; i++) {
			if(dead[i]) {
				deadNumber++;
			}
		}
		if(deadNumber > 5 && !movingMode) {
			movingMode = true;
			pMusic("Warning-Recording.wav");
			movingMode();
		}
	}
	
	// This is the distance formula that is used to calculate the distance between the launcher and the enemies
	private double distance(double x1, double y1, double x2, double y2) {
		double dist;
		dist = Math.sqrt(Math.pow(x1-x2, 2)+ Math.pow(y1-y2, 2));
		return dist;
	}
	
	// what you want to happen at the moment when the 
	// mouse is first pressed down.
	public static void pMusic(String sound) {
		File audioFile = new File(sound);
		try {
			AudioInputStream audioStream = AudioSystem.getAudioInputStream(audioFile);
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			Clip audioClip = (Clip) AudioSystem.getLine(info);
			audioClip.open(audioStream);
			audioClip.start();
		} catch (UnsupportedAudioFileException ex) {
			System.out.println("The specified audio file is not supported.");
			ex.printStackTrace();
		} catch (LineUnavailableException ex) {
			System.out.println("Audio line for playing back is unavailable.");
			ex.printStackTrace();
		} catch (IOException ex) {
			System.out.println("Error playing the audio file.");
			ex.printStackTrace();
		}
	}
	
	// this is the storing of start location of the user's mouse
	public void mousePressed(int mouseX, int mouseY) {
		pMusic("Slingshot-recording.wav");
		startX = mouseX;
		startY = mouseY;
		shotsTaken++;
	}
	
	// what you want to happen when the mouse button is released
	public void mouseReleased(int mouseX, int mouseY) {
		int distDraggedX = mouseX - startX;
		int distDraggedY = mouseY - startY;
		
		
		speedX = -distDraggedX/forceRatio;
		speedY = -distDraggedY/forceRatio;
		gravityOn = true;
		
	}
	
	// This function calls to generate random locations for the enemies in the second part of the game
	// It also sets the game up
	public void movingMode() {
		randomLoc();
		if (launcherY >= W_HEIGHT || launcherX >= W_WIDTH) {
			launcherX = W_WIDTH/9; 
			launcherY = 2*W_HEIGHT/3;
			gravityOn = false;
			hammercount = 0;
			speedX = 0;
			speedY = 0;
		}
		upDownMove();
	}
	
	// This function moves the enemies up and down in the second part of the game
	public void upDownMove() {
		for(int i = 0; i < NUM_ENEMIES_SECOND; i++) {
			if (enemyYSecond[i] >=  W_HEIGHT-limitA-enemySizeSecond || enemyYSecond[i] <= limitA) {
				enemyYSpeed[i] = -enemyYSpeed[i];
			}
			enemyYSecond[i] += enemyYSpeed[i];
		}
	}
	
	// This long tedious thing rotates the enemy images when they fall
	public void rotate(int x) {
		if (countRotate[x]%modNumber < rangeO) {
			if (x == 0) {
				Img1 = Img1R;
			}
			if (x == 1) {
				Img2 = Img2R;
			}
			if (x == 2) {
				Img3 = Img3R;
			}
			if (x == 3) {
				Img4 = Img4R;
			}
			if (x == 4) {
				Img5 = Img5R;
			}
			if (x == 5) {
				Img6 = Img6R;
			}
			countRotate[x]++;
		}
		else if (countRotate[x]%modNumber < rangeT) {
			if (x == 0) {
				Img1 = Img1right;
			}
			if (x == 1) {
				Img2 = Img2right;
			}
			if (x == 2) {
				Img3 = Img3right;
			}
			if (x == 3) {
				Img4 = Img4right;
			}
			if (x == 4) {
				Img5 = Img5right;
			}
			if (x == 5) {
				Img6 = Img6right;
			}
			countRotate[x]++;
		}
		else if (countRotate[x]%modNumber < rangeTh) {
			if (x == 0) {
				Img1 = Img1Rotate;
			}
			if (x == 1) {
				Img2 = Img2Rotate;
			}
			if (x == 2) {
				Img3 = Img3Rotate;
			}
			if (x == 3) {
				Img4 = Img4Rotate;
			}
			if (x == 4) {
				Img5 = Img5Rotate;
			}
			if (x == 5) {
				Img6 = Img6Rotate;
			}
			countRotate[x]++;
		}
		else {
			if (x == 0) {
				Img1 = Img1left;
			}
			if (x == 1) {
				Img2 = Img2left;
			}
			if (x == 2) {
				Img3 = Img3left;
			}
			if (x == 3) {
				Img4 = Img4left;
			}
			if (x == 4) {
				Img5 = Img5left;
			}
			if (x == 5) {
				Img6 = Img6left;
			}
			countRotate[x]++;
		}
		
	}
	
	// THis function is responsible for rotating the enemies from the second part of the game while they are falling
	public void rotateSecond(int x) {
		if(rotateSecond[x]%modNumber < rangeO) {
			if(x == 0) {
				if (x == 0) {
					Img1 = Img1R;
				}
				if (x == 1) {
					Img2 = Img2R;
				}
				if (x == 2) {
					Img3 = Img3R;
				}
				rotateSecond[x]++;
			}
			else if (countRotate[x]%modNumber < rangeT) {
				if (x == 0) {
					Img1 = Img1right;
				}
				if (x == 1) {
					Img2 = Img2right;
				}
				if (x == 2) {
					Img3 = Img3right;
				}
				rotateSecond[x]++;
			}
			else if (countRotate[x]%modNumber < rangeTh) {
				if (x == 0) {
					Img1 = Img1Rotate;
				}
				if (x == 1) {
					Img2 = Img2Rotate;
				}
				if (x == 2) {
					Img3 = Img3Rotate;
				}
				rotateSecond[x]++;
			}
			else {
				if (x == 0) {
					Img1 = Img1left;
				}
				if (x == 1) {
					Img2 = Img2left;
				}
				if (x == 2) {
					Img3 = Img3left;
				}
				rotateSecond[x]++;
			}
			
		}
	}
	
	// This function is responsible for rotating the hammer while it is moving
	public void rotateHammer() {
		double hammerRotate = 1.5;
		if (hammercount%modNumber < rangeO) {
			hammer = hammerN;
			hammercount += hammerRotate;
		}
		else if(hammercount%modNumber < rangeT) {
			hammer = hammerright;
			hammercount += hammerRotate;
		}
		else if (hammercount%modNumber < rangeTh) {
			hammer = hammerR;
			hammercount += hammerRotate;
		}
		else {
			hammer = hammerleft;
			hammercount += hammerRotate;
		}
	}
	
	// draws everything in our project - the enemies, your 'bird', 
	// and anything else that is present in the game
	public void paint(Graphics g) {
		int count = 0;
		// example of how to draw an image - draws at (100, 100) with width/height of 40/40
		
		if(!movingMode) {
			for (int i = 0; i < rotate.length; i++) {
				if (rotate[i] == true) {
					rotate(i);
				}
			}
			
			for(int i = 0; i < dead.length; i++) {
				if (dead[i] == true) {
					fall(i);
					count++;
				}
			}
			
			if (gravityOn) {
				rotateHammer();
			}
	 
			g.drawImage(grassImg2, 0, 0, W_WIDTH, W_HEIGHT, null);
			g.drawImage(Img1, (int)enemyX[0],(int) enemyY[0], enemySize, enemySize , null);
			g.drawImage(Img2, (int)enemyX[1], (int)enemyY[1], enemySize, enemySize, null);
			g.drawImage(Img3, (int)enemyX[2], (int)enemyY[2], enemySize, enemySize, null);
			g.drawImage(Img4, (int)enemyX[3], (int)enemyY[3], enemySize, enemySize, null);
			g.drawImage(Img5, (int)enemyX[4], (int)enemyY[4], enemySize, enemySize, null);
			g.drawImage(Img6, (int)enemyX[5], (int)enemyY[5], enemySize, enemySize, null);
			g.drawImage(hammer, (int)launcherX, (int)launcherY, hammerSize, hammerSize, null);
			g.setColor(Color.black);
			Font f = new Font("Arial", Font.BOLD, font);
			g.setFont(f);
			g.drawString("Enemies Down: " +  count , W_WIDTH/9, stringX);
			g.drawString("Shots Taken:" + shotsTaken, W_WIDTH/9, string2X);
		}
		
		else {
			
			for (int i = 0; i < falled.length; i++) {
				if (falled[i] == true) {
					rotate(i);
				}
			}
			if(firstTime) {
				Img1 = Img1R;
				Img2 = Img2R;
				Img3 = Img3R;
				firstTime = false;
			}
			
			g.drawImage(grassImg2, 0, 0, W_WIDTH, W_HEIGHT, null);
			g.drawImage(hammer, (int)launcherX, (int)launcherY, hammerSize, hammerSize, null);
			g.drawImage(Img1, (int)enemyXSecond[0], (int)enemyYSecond[0], enemySizeSecond, enemySizeSecond, null);
			g.drawImage(Img2, (int)enemyXSecond[1], (int)enemyYSecond[1], enemySizeSecond, enemySizeSecond, null);
			g.drawImage(Img3, (int)enemyXSecond[2], (int)enemyYSecond[2], enemySizeSecond, enemySizeSecond, null);
			int countB = 0;
			for (int i = 0; i < falled.length; i++) {
				if(falled[i] == true) {
					countB++;
				}
			}
			g.drawString("Enemies Down: " + (countW + countB) , W_WIDTH/9, stringX);
			g.drawString("Shots Taken:" + shotsTaken, W_WIDTH/9, string2X);
		}
			
	}
	
	// ************** DON'T TOUCH THE BELOW CODE ********************** //
	
	public void run() {
		while (true) {
			moveBird();
			checkHits();
			repaint();
			activateSpecialMode();
			if(movingMode) {
				checkHitsSecond();
				upDownMove();
			}
			
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