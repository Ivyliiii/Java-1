package JavaCW;

public class introTo2DArrays {
	
	// Answers:
	/* A. 6
	 * B. 1
	 * C. IndexOutOfBounds
	 * D. 3
	 * E. 'k'
	 * F. IndexOutOfBounds
	 * G. 105
	 * H. 'k'
	 * I. Error
	 */
	
	public void display(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + " ");
			}
			System.out.println();
		}
	}
	
	public void squareArray(int n) {
		
		int[][] arr = new int[n][n];
		display(arr);
		
	}
	
	public void dimensions(int[][] arr) {
		System.out.println("Columns: "+ arr.length);
		System.out.println("Rows: " + arr[0].length);
	}
	
	public void integar2D(int a, int b, int c, int d, int e, int f) {
		int[][] arr = new int[3][];
		arr[0] = new int[1];
		arr[1] = new int[2];
		arr[2] = new int[3];
		arr[0][0] = a;
		arr[1][0] = b;
		arr[1][1] = c;
		arr[2][0] = d;
		arr[2][1] = e;
		arr[2][2] = f;
		display(arr);
	}
	
	public static void main(String[] args) {
		
		introTo2DArrays run = new introTo2DArrays();
		run.squareArray(4);
		int[][] arr = new int[5][4];
		run.dimensions(arr);
		run.integar2D(1,2,3,4,5,6);
	}

}
