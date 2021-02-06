package JavaCW;

public class MoreWith2DArrays {

	public void display(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "  ");
			}
			System.out.println();
		}
	}
	
	public void oneToNSquared(int n) {
		int[][] arr = new int[n][n];
		int count = 1;
		for(int i = 0; i < n; i++) {
			for(int j = 0; j < n; j++) {
				arr[i][j] = count;
				count++;
			}
		}
		display(arr);
	}
	
	public void maximum(double[][] arr) {
		double max = arr[0][0];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] > max) {
					max = arr[i][j];
				}
			}
		}
		System.out.println(max);
	}
	
	public void sum(int[][] arr) {
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				sum += arr[i][j];
			}
		}
		System.out.println(sum);
	}
	
	public void lengthOfArray(int[][] arr) {
		int[][] out = new int[1][arr.length];
		int sum = 0;
		for(int i = 0; i < arr.length; i++) {
			sum = 0;
			for(int j = 0; j < arr.length; j++) {
				sum += arr[i][j];
			}
			out[0][i] = sum;
		}
		display(out);
	}
	
	public void ifMagic(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			if(!(arr[i].length == arr.length)) {
				System.out.println("hi");
				System.exit(0);
			}
		}
		int sum = 0;
		for(int j = 0; j < arr[0].length; j++) {
			sum += arr[0][j];
		}
		int sumRow = 0;
		for(int i = 0; i < arr.length; i++) {
			sumRow = 0;
			for(int j = 0; j < arr[i].length; j++) {
				sumRow += arr[i][j];
			}
			if(sumRow != sum) {
				System.out.println("false");
				System.exit(0);
			}
		}
		int sumCol = 0;
		for(int i = 0; i < arr.length; i++) {
			sumCol = 0;
			for(int j = 0; j < arr[i].length; j++) {
				sumCol += arr[j][i];
			}
			if(sumCol != sum) {
				System.out.println("false");
				System.exit(0);
			}
		}
		int sumDia = 0;
		int sumODia = 0;
		for(int i = 0, j = arr.length-1; i < arr.length; i++, j--) {
			sumDia += arr[i][i];
			sumODia += arr[j][j];
		}
		if (sumDia != sum || sumODia != sum) {
			System.out.println("false");
			System.exit(0);
		}
		System.out.println("true");
	}
	
	public void largestThreeXThree(int[][] arr) {
		int largestSum = 0;
		int topLeftIndexX = 0;
		int topLeftIndexY = 0;
		int currentSum = 0;
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				currentSum = 0;
				if(arr.length-i >= 3 && arr[i].length-j >= 3) {
					for(int a = 0; a < 3; a++) {
						for(int b = 0; b < 3; b++) {
							currentSum += arr[i+a][j+b];
						}
					}
					if(currentSum > largestSum) {
						largestSum = currentSum;
						topLeftIndexY = i;
						topLeftIndexX = j;
					}
				}
			}
		}
		System.out.println("(" + topLeftIndexY + ", " + topLeftIndexX + ")");
	}
	
	
	public static void main(String[] args) {
		MoreWith2DArrays run = new MoreWith2DArrays();
		
		int[][] arr = {{1, 2, 6}, {2,5,4}, {2,4,5}};
		double[][] doub = {{1.2, 3.4, 5.3}, {3.4,4}};
		int[][] arr1 = {{4,9,2}, {3,5,7}, {8,1,6}};
		int[][] arr2 = {{4,32,2}, 
						{3,5,7}, 
						{8,1,6}, 
						{4,5,6},
						{1,70,3}};
		run.display(arr);
		System.out.println();
		run.oneToNSquared(4);
		System.out.println();
		run.maximum(doub);
		System.out.println();
		run.sum(arr);
		System.out.println();
		run.lengthOfArray(arr);
		System.out.println();	
		run.ifMagic(arr1);
		System.out.println();	
		run.largestThreeXThree(arr2);
	}
}
