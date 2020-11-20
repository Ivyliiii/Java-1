package JavaCW;

public class ArrayStuff {
	
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i]+ " ");
		}
	}

	public static void main(String[] args) {
		
		// you can never change the size of an array
		// arrays are more efficient
		int[] arr = {1, 4, 6};
		
		// the array will contain 6 numbers
		// this is going to be full of zeros rn
		int[] arr2 = new int[6];
		
		// runtime error:
		// System.out.println(arr[6]);
		
		arr2[1] = 7;
		
		// Java does not print out arrays, but that is not useful to us at all
		//System.out.print(arr);
		
		// This is how to print out the things in an array
		printArray(arr);
		
	}
}
