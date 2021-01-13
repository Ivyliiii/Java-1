package JavaCW;

import java.util.Arrays;

public class warmUp {

	public void average(int[] arr) {
		double sum = 0;

		for (int i = 0; i < arr.length; i++) {
			sum += arr[i];
		}
		
		System.out.println(sum/arr.length);
		
	}
	
	public void trim(int[] arr) {
		int max = arr[0];
		int min = arr[0];
		
		for (int i = 1; i < arr.length; i++) {
			
			if (arr[i] > max) {
				max = arr[i];
			}
			if (arr[i] < min) {
				min = arr[i];
			}
			
		}
		
		int[] arrN = new int[arr.length-2];
		
		for (int i = 0, j = 0; i < arr.length; i++) {
			if (arr[i] != min && arr[i] != max) {
				arrN[j] = arr[i];
				j++;
			}
		}
		
		System.out.println(Arrays.toString(arrN));
		
		
	}
	
	public void fib(int n) {
		
		int [] sequence = new int[n];
		
		sequence[0] = 1;
		sequence[1] = 1;
	
		for (int i = 2; i < sequence.length; i++) {
			sequence[i] = sequence[i-1] + sequence[i-2];
		}
		
		System.out.println(Arrays.toString(sequence));
		
	}
	
	public void divisible(int[] arr) {
		
		String [] str = new String[arr.length-1];
		
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] % arr[i-1] == 0) {
				str[i-1] = "yes";
			}
			else {
				str[i-1] = "no";
			}
		}
		
		for (int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
		
	}
	
	public void risingAverage(int[] arr) {
		double[] nums = new double[arr.length];
		double sum = 0;
		nums[0] = arr[0];
		for(int i = 1; i < arr.length; i++) {
			sum = 0;
			for (int j = 0; j <= i; j++) {
				sum += arr[j];
			}
			nums[i] = sum/(i+1);
		}
		System.out.println(Arrays.toString(nums));
	}
	
	public void duplicates(int[] arr1, int[] arr2) {
		int repeats = 0;
		boolean repeat = false;
		for (int i = 0; i < arr1.length; i++) {
			repeat = false;
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					repeats++;
					repeat = true;
				}
			}
			if (!repeat) {
				arr1[i] = 0;
			}
			
		}
		
		int[] arr = new int[repeats-1];
		
		int j = 0;
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i] != 0) {
				arr[j] = arr1[i];
				j++;
			}
		}
		
		System.out.println(Arrays.toString(arr));
	}
	
	public void dotProduct(int[] arr1, int[] arr2) {
		int dotProduct = 0;
		int dot = 0;
		for(int i = 0; i < arr1.length; i++) {
			dot = (arr1[i])*(arr2[i]);
			dotProduct = dotProduct + dot;
			System.out.println(dot);
		}
		System.out.println(dotProduct);
	}
	
	public void printWords(String[] str) {
		for(int i = 0; i < str.length; i++) {
			System.out.print(str[i] + " ");
		}
	}

	public static void main(String[] args) {
		
		warmUp run = new warmUp();
		int[] nums = {4, 3, 2, 2};
		int[] nums2 = {1, 2, 3, 4, 12, 3, 2, 0};
		int[] arr = {3, 6, 7, 8};
		String[] str = {"Hi", "everyone", "how", "is" , "life?"};
		run.average(nums);
		run.trim(nums);
		run.fib(5);
		run.divisible(nums);
		System.out.println();
		run.risingAverage(nums);
		run.duplicates(nums, nums2);
		run.dotProduct(nums, arr);
		run.printWords(str);
	}
}
