public class LineSlope {
	
	// you'll probably want some instance variables... (4 coordinates and a slope)
	private double cOne, cTwo, cThree, cFour, slope;

	// use the parameters to assign your instance variables
	public void set_coordinates (double x1, double y1, double x2, double y2) {
		cOne = x1;
		cTwo = y1;
		cThree = x2;
		cFour = y2;
	}
	
	// calculate the slope using your instance variables
	public void calculate_slope () {
		
		slope = (cFour - cTwo)/(cThree - cOne);
		
	}

	// print the slope you calculated in calculate_slope
	public void display_slope () {
		
		System.out.println("The slope of the line is " + slope);
		
	}
	
	public static void main(String[] args) {
		
		LineSlope runner = new LineSlope();
		
		// this line should have a slope of 2
		runner.set_coordinates(3, 3, 7, 11);
		runner.calculate_slope();
		runner.display_slope();
		
		// this line should have a slope of -.75
		runner.set_coordinates(0, -2, -4, 1);
		runner.calculate_slope();
		runner.display_slope();
		

	}
}