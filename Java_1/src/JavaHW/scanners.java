package JavaHW;

import java.util.Scanner;

public class scanners {
	Scanner in = new Scanner(System.in);
	private char command;
	private double num, num2;
	
	// This method saves the numbers that the user wants to work with by asking for them through input
	public void starters() {
		System.out.println("Please enter a double that you want to work with!");
		num = in.nextDouble();
		System.out.println("What do you want to do with it? Please input 's', 'e', 'd' or 'w' \ns. This will square root your number!"
				+ "\ne. This will print out the type of number you input \nd. This will ask for another number and check if it is a factor of the first"
				+ "\nw. This will ask for another input and check if they are within 3 of the first number.");
		command = in.next().charAt(0); //the user can input letters 's','e','d'and 'w'
		operate();
		
	}
	
	public void operate() {
		if (command == 's') {
			squareRoot();
			end();
		}
		else if (command == 'e') {
			kindOfNum();
			end();
		}
		else if (command == 'd') {
			isFactor();
			end();
		}
		else if (command == 'w') {
			isWithThree();
			end();
		}
		else {
			System.out.print("This is not a valid input, please enter again. ");
			starters();
		}
	}
	
	public void squareRoot() {
		System.out.println(Math.sqrt(num));
	}
	
	public void kindOfNum() {
		if (num/1 == num) {
			if (num%2 == 0) {
				System.out.println(num + " is an even integer!");
			}
			else {
				System.out.println(num + " is an odd integer!");
			}
		}
	
		else {
			System.out.println(num + " is not a whole number :((");
		}
	}
	
	public void isFactor() {
		num2 = in.nextDouble();
		if ((num%num2) == 0 || num2 == 1) {
			System.out.println("The second is a factor of the first");
		}
		else {
			System.out.println("This is not a factor");
		}
	}
	
	public void isWithThree() {
		num2 = in.nextDouble();
		if (Math.abs(num-num2) <= 3) {
			System.out.println("They are within 3 of each other!");
		}
		else {
			System.out.println("They are not within 3 of each other!");
		}
	}
	
	public void end() {
		System.out.println("This is the end of the program! Do you have something else to put into the operation?\na. Yes, I want to run it again!\nb. No, I am good!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			starters();
		}
		else if (answer == 'b') {
			System.out.println("Byeee");
		}
		else {
			System.out.println("I will take that as a no!");
		}
	}
	
	public static void main(String[] args) {
		scanners runner = new scanners();
		runner.starters();
	}
	
}
