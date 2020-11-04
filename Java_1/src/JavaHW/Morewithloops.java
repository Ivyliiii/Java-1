package JavaHW;

import java.util.Scanner;

public class Morewithloops {
	Scanner in = new Scanner(System.in);
	// This is going to have a linear runtime because the worst case scenario would be running m(the biggest number entered) times 
	public void GCD() {
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
	
	public void LCM() {
		int num1 = in.nextInt();
		int num2 = in.nextInt();
		int count = Math.max(num1, num2);
		while (count <= num1*num2) {
			if((count/num1)*num1 == count && (count/num2)*num2 == count) {
				System.out.println("The LCM of the two numbers is " + count);
				break;
			}
			else {
				count--;
			}
		}
	}
	
	public void magicSquare() {
		int n = in.nextInt();
		int found = 0;
		int count = 36;
		int x = 0;
		while(found < n) {
			if (Math.pow((int)Math.sqrt(count),2) == count)
				while (Math.pow((int)Math.sqrt(count),2) == count) {
					while (x < count) {
						if 
					}
				}
			}
		}

	public static void main(String[] args) {
		Morewithloops runner = new Morewithloops();
		//runner.GCD();
		runner.LCM();
	}
}
