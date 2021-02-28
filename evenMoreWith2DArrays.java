package JavaHW;

public class evenMoreWith2DArrays {
	
	public void createString(char[][] arr) {
		String out = "";
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				out += arr[i][j];
			}
		}
		System.out.println(out);
	}
	
	public void display(int[][] arr) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "   ");
			}
			System.out.println();
		}
	}
	
	public void displayD(double[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "   ");
		}
	}
	
	public void triangleArray(int n) {
		int count = 1;
		int[][] arr = new int[n][];
		for(int i = 1; i < n+1; i++) {
			arr[i-1] = new int[i];
			for(int j = 0; j <i; j++) {
				arr[i-1][j] = count;
				count++;
			}
		}
		display(arr);
	}
	
	public void alternatingArray(int[][] arr) {
		int[][] out = new int[arr.length][];
		for(int i = 0; i < arr.length; i++) {
			out[i] = new int[(arr[i].length)*2];
			for(int j = 0; j < arr[i].length; j++) {
				out[i][j*2] = arr[i][j];
			}
		}
		display(out);
	}
	
	public void sum(double[][] arr) {
		double[] out = new double[arr.length];
		double sum = 0;
		int longestLength = 0;
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].length > longestLength) {
				longestLength = arr[i].length;
			}
		}
		for(int i = 0; i < longestLength; i++) {
			sum = 0;
			for(int j = 0; j < arr.length; j++) {
				sum += arr[j][i];
			}
			out[i] = sum;
		}
		displayD(out);
	} 
	
	public int[][] takeOutNumS(int[][] arr, int n) {
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] == n) {
					arr[i][j] = Integer.MAX_VALUE;
					return arr;
				}
			}
		}
		return arr;
	}
	
	public int findMin(int[][] arr) {
		int min = arr[0][0];
		for(int i = 0; i < arr.length; i++) {
			for(int j = 0; j < arr[i].length; j++) {
				if(arr[i][j] < min) {
					min = arr[i][j];
				}
			}
		}
		return min;
	}
	
	public void oppositeSort(int[][] arr) {
		int[][] out = new int[arr.length][];
		for(int i = 0; i < arr.length; i++) {
			out[i] = new int[arr[i].length];
			for(int j = 0; j < arr[i].length; j++) {
				int min = findMin(arr);
				out[i][j] = min;
				arr = takeOutNumS(arr, min);
			}
		}
		display(out);
	}
	
	public int[] oppositeSortArray(int[] arr) {
		int[] out = new int[arr.length];
		for(int i = 0; i < arr.length; i++) {
			int min = Integer.MAX_VALUE;
			for(int j = 0; j < arr.length; j++) {
				if(arr[j] < min) {
					min = arr[j];
				}
			}
			out[i] = min;
			for(int x = 0; x < arr.length; x++) {
				if(arr[x] == min) {
					arr[x] = Integer.MAX_VALUE;
					continue;
				}
			}
		}
		return out;
	}
	
	
	public static void main(String[] args) {
		evenMoreWith2DArrays run = new evenMoreWith2DArrays();
		char[][] arr = {{'h', 'o','w',' '}, {'a','r'}, {'e',' ','y','o','u'}};
		run.createString(arr);
		run.triangleArray(4);
		System.out.println();
		int[][] arr2 = {{2,3,1,2},{3,1,5,7,6},{6,9,4,1,3,2}};
		run.alternatingArray(arr2);
		System.out.println();
		double[][] arr3 = {{2.4,21,3.4},{3.6,8.9,7.5},{3.2,3.0, 9.2}};
		run.sum(arr3);
		
		System.out.println();
		
		run.oppositeSort(arr2);
	}
}
