public class NumberExercise {
	private double num;
	
	public void setNumber(int theirNumber) {
		//Choose a number
		
		// This is a set method that transfers a local variable into a global variable
		num = theirNumber;
	}
	
	public void display() {
		System.out.println("Your number is " + num);
	}
		
	
	public void change(int theirNumber) {
		num = theirNumber;
	}
	
	public static void main(String[] args) {
		NumberExercise runner = new NumberExercise();
		runner.setNumber(2);
		runner.display();
		runner.change(3);
		
	}
}
