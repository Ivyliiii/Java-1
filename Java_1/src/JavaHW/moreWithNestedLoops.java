package JavaHW;


public class moreWithNestedLoops {
	
	public void numReversed(int n) {
		for (int i = 1; i <=n; i++) {
			for(int j = 0; j < n; j++) {
				if(i + j > 5) {
					System.out.print((i+j)%5);
				}
				else {
					System.out.print(i+j);
				}
			}
			System.out.println();
		}
	}
	
	public void triangle(int n) {
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print('X');
			}
			System.out.println();
		}
	}
	
	public void what_power(int x, int y) {
		for (int i = 1; Math.pow(x, i) <= y; i++) {
			if (Math.pow(x, i) == y) {
				System.out.println(i);
				break;
			}
		}
	}
	
	public void diamond(int n) {
		for (int i = 1; i <= n; i++) {
			for(int j = 1; j <= n-i+1; j++) {
				System.out.print(" ");
			}
			for(int x = 1; x <= i; x++) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
		for(int i = n-1; i >= 1; i--) {
			for(int j = 1; j <= n-i+1; j++) {
				System.out.print(" ");
			}
			for(int x = i; x > 0; x--) {
				System.out.print("*");
				System.out.print(" ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		moreWithNestedLoops runner = new moreWithNestedLoops();
		//runner.numReversed(5);
		//runner.triangle(4);
		//runner.what_power(2, 32);
		runner.diamond(5);
	}
}