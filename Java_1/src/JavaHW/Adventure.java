package JavaHW;

import java.util.Scanner;

public class Adventure {
	Scanner in = new Scanner(System.in);
	
	private String name;
	
	public void askName() {
		System.out.println("Welcome to the Adventures Game, are you ready?");
		System.out.println("a. I am totally ready! \nb. I am ready! Let's get started!");
		String answer1 = in.next();
		System.out.println("I am glad that you are ready! What is your name?");
		name = in.next();
		System.out.println("W");
		
	}
	
	public static void main(String[] args) {
		Adventure runner = new Adventure();
		runner.askName();
		
	}
	
}
