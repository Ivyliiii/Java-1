package JavaHW;


public class forLoops {
	
	public void letters() {
		for (int i = 65; i <= 90; i++) {
				System.out.println((char)i);
		}
	}
		
	public void multiplicationTable() {
		for (int i = 1; i < 13; i++) {
			for (int j = 1; j < 13; j++) {
				System.out.print(i*j + "  ");
			}
			System.out.print("\n");
		}
	}
		
	public void primeNums(int n) {
		boolean prime = true;
		for (int i = n; i > 1; i--) {
			prime = true;
			for (int j = 2;j < i; j++) {
				if (i % j == 0) {
					prime = false;
				}
			}
			if (prime) {
				System.out.println(i);
			}
		}
	}
	
	public void printSum(int x) {
		int sum = 0;
		for (x = x; x > 0; x--) {
			sum += x;
		}
		System.out.println(sum);
	}
	
	public void xStars(int n) {
		for(int i=1;i<=n*2-1;i++){
			for(int j=1;j<=n*2-1;j++) {
				if(j==i || j==n*2-i)
					System.out.print('*');
					System.out.print(" ");
	        }
		System.out.println();
	    }  
	}
	
	public static void main(String[] args) {
		forLoops runner = new forLoops();
		runner.letters();
		runner.multiplicationTable();
		runner.primeNums(10);
		runner.printSum(7);
		runner.xStars(4);

	}
			
}
