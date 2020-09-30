package JavaHW;

public class SA4 {
	
	private double d;
	
	// create your methods here
	public void distance(double x1, double y1, double x2, double y2) {
		double p1 = Math.pow((x2-x1), 2); 
		double p2 = Math.pow((y2-y1), 2);
		d = Math.sqrt(p1+p2);
		System.out.println(d);
	}
	
	public void quadratic(int a, int b, int c) {
		double bPart = 2*a;
		double part1_1 = Math.pow(b,2)-(4*a*c);
		double part1 = Math.sqrt(part1_1)/bPart;
		double part2 = (-1*b)/bPart;
		System.out.println("Solution 1: " + (part2 + part1) + "\nSolution 2: " + (part2-part1));
	}
	
	public void charAverage(char a, char b) {
		int average = (a+b)/2;
		System.out.println("The average of the two characters is " + (char)average);
	}
	
	public static void main(String[] args) {
		
		SA4 tester = new SA4();
		
		// prints out the distance between two points
		// output should be 6.83
		tester.distance(1, -2.5, 3.1, 4);
		
		// prints out a solution to y = ax^2 + bx + c, where the 
		// three parameters are a, b, and c. Use the quadratic equation
		// output should be 2 or -2 (challenge: give both solutions)
		tester.quadratic(1, 0, -4);
		
		// prints out the 'average' of two characters
		// output should be 'W'
		tester.charAverage('m', 'A');
	}

}
