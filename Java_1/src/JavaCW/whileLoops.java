package JavaCW;

import java.util.Scanner;

public class whileLoops {
	Scanner in = new Scanner(System.in);
	boolean nice;
	
	// Print out the integers between two integers
	/* I think this would be indefinite because you don't really know 
	how many times it is going to run beforehand*/
	public void numbersBetween() {
		
		System.out.println("Please enter two numbers! Enter the smaller number first!");
		int sNum = in.nextInt(); // this is the smaller of the two nums
		int bNum = in.nextInt(); // this is the bigger one
		int count = sNum;
		
		if (bNum<sNum) {
			System.out.println("Please enter the samll number fist!");
			sNum = in.nextInt(); 
			bNum = in.nextInt();
		}
		
		else {
			while (count <= bNum) {
				System.out.println(count);
				count++;
			}
		}
	}
	// This method will take two doubles as input and take the exponent of the first and then multiply by the second
	// This has a definite finite loop because you know that this is going to run 6 times
	public void exponentsWithBase() {
		System.out.println("Please enter two doubles. The first number should be the base, and the second should be the coefficient");
		double b = in.nextDouble(); // this is the base 
		double a = in.nextDouble(); // this is going to be the coefficient
		int x = 0;
		while (x <= 5) {
			System.out.println(a*Math.pow(b,x));
			x++;
		}
	}

	// This is a method that would check if an input is a perfect square
	// Indefinite because you don't know how many times it is going to execute
	public void ifSquareRootable() {
		System.out.println("Enter a number that you want to check for whether or not it is a perfect square");
		int num = in.nextInt();
		int count = 1;
		while (count*count <= num) {
			if (count*count == num) {
				System.out.println("Your number is a perfect square! It is " + count + "^2! and -" + count + "^2!");
				nice = true;
				break;
			}
			else {
				count++;
			}
		}
		if (!nice) {
			System.out.println("This is not a perfect square:(((");
		}
	}
	
	public static void main(String[] args) {
		whileLoops runner = new whileLoops();
		runner.numbersBetween();
		runner.exponentsWithBase();
		runner.ifSquareRootable();
	}
}
