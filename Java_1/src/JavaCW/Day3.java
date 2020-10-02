package JavaCW;


public class Day3 {
	
	// Instance Variables (Global Variables) - it can be accessed anywhere in the class
	// You should simply make variables private for now. They take points if you store variables in public in the ap exam.
	private int x = 7;
	
	public void timesTwo() {
		
		int x = 5; /* This is a local variable - meaning that it can only accessed inside the method that it is created in
		* This variable cannot be accessed in other methods
		*/
		System.out.println("Times two is going to be " + x*2);
		
	}
	
	public void timesThree() {
		System.out.println("Times 3 is going to be " + x*3);
		
	}
	
	// Parameters in methods
	public void timesFour(int num) {
		System.out.println(num*3);
		
	}
	
	/* This is the main method
	 * Build runner object
	 * Have it run the runner object */
	
	public static void main(String[] args) {
		
		// You can name the variable "runner" other name
		Day3 runner = new Day3();
		runner.timesTwo();
		runner.timesThree();
		runner.timesFour(7);

	}

}