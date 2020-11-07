package JavaHW;

import java.util.Scanner;

public class Morewithloops {
	Scanner in = new Scanner(System.in);
	
	// This is a indefinite method
	// This is going to have a linear runtime because the worst case scenario would be running m(the biggest number entered) times 
	public void GCD() {
		System.out.println("Enter 2 integers:");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int count = Math.min(num1, num2);
		while (count >= 1) {
			if ((num1/count)*count == num1 && (num2/count)*count == num2) {
				System.out.println("The GCD of the two numbers is " + count);
				break;
			}
			else {
				count--;
			}
		}
	}
	
	// I think this one is going to be indefinite
	// This method has a linear runtime
	public void LCM() {
		System.out.println("Enter 2 integers:");
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int count = Math.max(num1, num2);
		while (count <= num1*num2) {
			if((count/num1)*num1 == count && (count/num2)*num2 == count) {
				System.out.println("The LCM of the two numbers is " + count);
				break;
			}
			else {
				count++;
			}
		}
	}
	
	// This has a linear runtime
	// This is a indefinite method
	public void isPrime() {
		System.out.println("Enter 1 integer:");
		int num = in.nextInt();
		int count = 2;
		while (count < num) {
			if ((num/count)*count == num) {
				System.out.println("This is not a prime numer, it is factored by " + count);
				break;
			}
			else {
				count++;
			}
		}
		if (count == num) {
			System.out.println("This is a prime number!");
		}
	}
	
	// linear runtime
	// indefinite
	public void sayHi() {
		System.out.println("Enter a integer:");
		int times = in.nextInt();
		int count = 1;
		while (count <= times) {
			System.out.println("hi");
			count++;
		}
	}
	
	// linear runtime
	// This is a indefinite method
	public void divisible() {
		System.out.println("Enter a integer");
		int num = in.nextInt();
		int count = 1;
		while (count <= num) {
			if ((num/count)*count == num) {
				System.out.print(count + "\n");
				count++;
			}
			else {
				count++;
			}
		}
	}
	
	public void factorial() {
		System.out.println("Enter a integer");
		int num = in.nextInt();
		int product = 1;
		while (num > 0) {
			product = product*num;
			num--;
		}
		System.out.println(product);
	}
	
	public static void main(String[] args) {
		Morewithloops runner = new Morewithloops();
		runner.GCD();
		runner.LCM();
		runner.isPrime();
		runner.sayHi();
		runner.divisible();
		runner.factorial();
	}
}
