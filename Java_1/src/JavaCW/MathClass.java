package JavaCW;
public class MathClass {
	
	private int key;
	
	// an example method to use as a guideline
	public void halve(double x) {
		System.out.println(x/2);
	}
	
	// I'll give you the first method's outline to fill in. For the rest, you're in charge of 
	// declaring the entire method.
	
	public void square(int x) {
		System.out.println(x*x);
	}
	
	public void averageFive(int x, int y, int z, int a, int b) {
		System.out.println((double)(x+y+z+a+b) / 5);
		// [] : brackets
		// {} : braces
		// () : parenthesis
	}
	
	public void raiseToTheFourth(int x) {
		System.out.println(x*x*x*x);
	}
	
	public void setKey(int x) {
		key = x;
	}
	
	public void multiplyByKey(int x) {
		System.out.println(key * x);
	}
	
	public void keyCubed() {
		System.out.println(key * key * key);
	}
	
	public void makeInteger(double x) {
		System.out.println((int)x);
	}
	
	public void roundToNearestWhole(double x) {
		/*if (x%1 >= 0.5) {
			System.out.println((int)x + 1);
		}else {
			System.out.println((int)x);
		}
		*/
		double y = x + 0.5;
		System.out.println((int)y);
		
	}
	public static void main(String args[]) {
		
		MathClass tester = new MathClass();
		
		// example method
		// output: 4
		tester.halve(8);
		
		// you are in charge of making the rest of these work
		
		// output: 49
		tester.square(7);
		
		// output: 7
		tester.averageFive(7,10,5,7,6);
		
		// output: 81
		tester.raiseToTheFourth(3);
		
		// output: nothing, just save the number 4 as an instance variable
		tester.setKey(4);
		
		// output: 28
		tester.multiplyByKey(7);
		
		// output: 64
		tester.keyCubed();
		
		// output: 3
		tester.makeInteger(3.756);
		
		// output: 8
		tester.roundToNearestWhole(8.4);
	}

}

