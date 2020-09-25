public class OperationWorksheet {
	
	double average;
	
	public void character_ization(int x) {
		
		System.out.println((char) x);
		
	}
	
	public void lastDigit(int y) {
		
		System.out.println("The units digit is " + y % 10);
		
	}
	
	public void average(double a, double b) {
		
		average = (a + b) / 2;
		
		System.out.println("The average is " + average);
		
	}
	
	public static void main(String[] args) {
		
		OperationWorksheet runner = new OperationWorksheet();
		
		// This should print out 'a'
		runner.character_ization(97);
		
		// This should print out 'A'
		runner.character_ization(65);
		
		// This should print out 9
		runner.lastDigit(1000009);
		
		// This should print out 7.3
		runner.average(6.1, 8.5);
		
	}
		
	
}
