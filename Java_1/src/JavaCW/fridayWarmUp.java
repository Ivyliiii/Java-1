package JavaCW;

import JavaHW.Morewithloops;

public class fridayWarmUp {
	public void printDigits(int n) {
		for (int x = 1; n != 0; x++) {
			System.out.println((int)(((n % (Math.pow(10, x))))/(Math.pow(10, x-1))));
			n -= n%(Math.pow(10, x));
		}
	}
	
	public void printRect(int x, int y) {
		for(int i = 1; i <= y; i++) {
			for(int j = 1; j <= x; j++) {
				System.out.print("X");
			}
			System.out.println();
		}
	}
	
	public void printFactors(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				if (i/j*j == i) {
					System.out.print(j + " ");
				}
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		fridayWarmUp runner = new fridayWarmUp();
		runner.printDigits(285);
		runner.printRect(4, 5);
		runner.printFactors(8);
	}

}
