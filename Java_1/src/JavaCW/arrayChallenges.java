package JavaCW;

public class arrayChallenges {
	public void indexWeightedSum(double[] nums) {
		double sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += i*nums[i];
		}
		System.out.println(sum);
	}
	
	public void printletter(char[] str) {
		String s = "";
		
		for (int i = 0; i < str.length; i++) {
			if (str[i] >= 'a' && str[i] <= 'z') {
				s += str[i];
			}
		}
		System.out.println(s);
	}
	
	public void mode(char[] str) {
		int mostIndex = 0;
		int appear = 0;
		int appearT = 0;
		for (int i = 0; i < str.length; i++) {
			appearT = 0;
			for (int j = 0; j < str.length; j++) {
				if (str[i] == str[j]) {
					appearT++;
				}
			}
			if (appearT > appear) {
				appear = appearT;
				mostIndex = i;
			}
		}
		System.out.println(str[mostIndex]);
	}

	public static void main(String[] args) {
		
		arrayChallenges run = new arrayChallenges();
		double[] nums = {4.0, 6.4, 2.6, 12.9};
		char[] letter = {'h', ';', 'H', '4', 'i', 'L'};
		char[] letters = {'h', 'b' , 't', 'd', 'd', 'c', 'e', 'b', 'b'};
		run.indexWeightedSum(nums);
		run.printletter(letter);
		run.mode(letters);
	}
	
	
}
