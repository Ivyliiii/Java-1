package JavaCW;
public class SimpleIf {

	
	public void posNeg(int num) {
		
		if (num > 0) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	public void evenOdd(int num) {
		
		if (num % 2 == 0) {
			System.out.println("even");
		}
		else {
			System.out.println("odd");
		}
		
	}
	
	public void upperLower(char letter) {
		
		if (letter >= 97) {
			System.out.println("Lowercase");
		}
		else if (letter >= 65) {
			System.out.println("Uppercase");
		}
		else {
			System.out.println("Neither");
		}
	}
	
	public void divByTen(int num) {
		
		if (num % 10 == 0) {
			System.out.println("Divisable by 10");
		}
		else {
			System.out.println("Add " + (10-(num%10)) + "to make it divisable");
		}
	}
	
	public void maximum(double x, double y, double z) {
		
		if (x > y) {
			if (x > z) {
				System.out.println(x);
			}
			else {
				System.out.println(z);
			}
		}
		else {
			if (y > z) {
				System.out.println(y);
			}
			else {
				System.out.println(z);
			}
	
		}
	}
	
	public static void main(String[] args) {
		SimpleIf tester = new SimpleIf();
		
		tester.posNeg(-13);
		tester.evenOdd(8);
		tester.upperLower('Z');
		tester.divByTen(400);
		tester.maximum(18.1, 16.5, 17.1);
	}
}