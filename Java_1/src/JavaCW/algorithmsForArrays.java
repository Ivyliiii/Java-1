package JavaCW;


public class algorithmsForArrays {

	public void duplicates(int[] arr1, int[] arr2) {
		
		for (int i = 0; i < arr1.length; i++) {
			
			for (int j = 0; j < arr2.length; j++) {
				
				if (arr1[i] == arr2[j]) {
					
					System.out.println(arr2[j]);
					
				}
			}
		}
	}
	public static void main(String[] args) {
		algorithmsForArrays run = new algorithmsForArrays();
		run.duplicates(new int[] {3, 1, 6}, new int[] {3, 5, 8});
	}
}
