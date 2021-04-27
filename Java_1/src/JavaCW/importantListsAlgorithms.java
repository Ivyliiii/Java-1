package lists;

import java.util.ArrayList;

public class importantListsAlgorithms {
	
	public int sum(ArrayList<Integer> nums) {
		int count = 0;
		for(int i : nums) {
			count += i;
		}
		return count;
	}
	
	public int min(ArrayList<Integer> nums) {
		int min = nums.get(0);
		for(int i : nums) {
			if(i < min) {
				min = i;
			}
		}
		return min;
	}
	
	public ArrayList<Integer> fibonacci(int n){
		ArrayList<Integer> nums = new ArrayList<Integer>();
		if(n < 1) {
			return nums;
		}
		else if(n < 2) {
			nums.add(0);
		}
		else {
			nums.add(0);
			nums.add(1);
			int prev = 0;
			int previ = 1;
			for(int i = 2; i < n; i++) {
				nums.add(prev+previ);
				int temp = previ;
				previ += prev;
				prev = temp;
			}
		}
		return nums;
	}
	
	public static void main(String[] args) {
		importantListsAlgorithms run = new importantListsAlgorithms();
		ArrayList<Integer> nums = new ArrayList<Integer>();
		nums.add(5);
		nums.add(3);
		nums.add(4);
		nums.add(1);
		System.out.println(run.min(nums));
		System.out.println(run.fibonacci(9));
	}
	
}
