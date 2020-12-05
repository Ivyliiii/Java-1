public class moreArrayPractice {
	
	public void display(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + "  ");
		}
	}
	
	public void average(int[] arr1) {
		double sum = 0;
		for (int i = 0; i < arr1.length; i++) {
			sum += arr1[i];
		}
		System.out.println(sum/arr1.length);
	}
	
	public void contain(char[] arr, char letter) {
		boolean printed = false;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == letter) {
				System.out.println("Contains!");
				printed = true;
				break;
			}
		}
		if (!printed) {
			System.out.println("Does Not Contain!");
		}
	}
	
	public void containStr(String[] arr, String str) {
		int position = -1;
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].equals(str)) {
				position = i;
				break;
			}
		}
		System.out.println(position);
	}
	
	public void common(int[] arr1, int[] arr2) {
		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr2.length; j++) {
				if (arr1[i] == arr2[j]) {
					arr2[j] = 0;
					System.out.print(arr1[i] + " ");
				}
			}
		}
	}
	
	public void printDigits(int num) {
		int digits = 0;
		int l = 0;
		for (int i = 0; Math.pow(10, i) < num; i++) {
			digits += 1;
		}
		int[] arr = new int[digits];
		for (int i = 0; i < digits; i++) {
			double x = Math.pow(10,i+1);
			arr[i] = (int)(((num%x) - l) / Math.pow(10, i));
			l = (int)(num%x);
		}
		for (int i = 0, j = digits-1; i < digits/2; i++, j--) {
			int temp = arr[i];
			arr[i] = arr[j];
			arr[j] = temp;
		}
		display(arr);
	}
	
	public void noDuplicates(int[] arr) {
		int num = 0;
		boolean repeat = false;
		for (int i = 0; i < arr.length; i++) {
			repeat = false;
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					repeat = true;
				}
			}
			if (!repeat) {
				num += 1;
			}
		}
		int[] arr1 = new int[num];
		int found = 0;
		for (int i = 0; i < arr.length; i++) {
			repeat = false;
			for(int j = 0; j < arr.length; j++) {
				if (arr[i] == arr[j] && i != j) {
					repeat = true;
				}
			}
			if (!repeat) {
				arr1[found] = arr[i];
				found += 1;
			}
		}
		
		display(arr1);
	}
	
	public static void main(String[] args) {
		moreArrayPractice run = new moreArrayPractice();
		//run.average(new int[] {3, 1, 6});
		//run.printDigits(39564);
		//run.noDuplicates(new int[] {2, 4, 6, 7, 3, 4, 6});
		//run.common(new int[] {4,1,7,3,4}, new int[] {8,2,3,4});
		//run.contain(new char[] {'i', 'g', 'o', 'd'}, 'e');
		run.containStr(new String[] {"mom", "dad", "me"}, "hi");
	}
}
