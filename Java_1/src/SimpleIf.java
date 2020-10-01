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
		
		if (letter > 97) {
			System.out.println("lowercase");
		}
		
		else if (letter > 65 ) {
			System.out.println("lowercase");
		}
		
		else {
			System.out.println("neither");
		}
	}
	
	public void divByTen(int x) {
		
		if (x % 10 == 0) {
			System.out.println("divisible by 10");
		}
		
		else {
			System.out.println("not");
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
		tester.upperLower('Q');
		tester.divByTen(400);
		tester.maximum(8.9, 3.4, 10.1);
	}
}