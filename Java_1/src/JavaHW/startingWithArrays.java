package JavaHW;
import java.util.Scanner;

public class startingWithArrays {
	Scanner in = new Scanner(System.in);
	
	public void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}

	public void oneToN(int num) {
		int[] arr = new int[num];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = i+1;
		}
		display(arr);
	}
	
	public void swap(int[] arr) {
		int f = arr[0];
		arr[0] = arr[arr.length-1];
		arr[arr.length-1] = f;
		display(arr);
	}
	
	public void userArray() {
		System.out.println("Please Enter 7 Integers:");
		int[] arr = new int[7];
		int user;
		for (int i = 0; i < 7; i++) {
			user = in.nextInt();
			arr[i] = user;
		}
		display(arr);
		
	}
	
	public void reverse(int[] arr) {
		int temp;
		for (int i = 0, j = arr.length-1; i < arr.length/2; i++, j--) {
			temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		display(arr);
	}

	public static void main(String[] args) {
		startingWithArrays run = new startingWithArrays();
		run.display(new int[] {2,3,5,7});
		System.out.println();
		run.oneToN(5);
		System.out.println();
		run.swap(new int[] {2,3,5,7});
		System.out.println();
		run.userArray();
		System.out.println();
		run.reverse(new int[] {2,3,5,7,6,8,7,8,9});
	}
}
