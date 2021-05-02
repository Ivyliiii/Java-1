package lists;

import java.util.ArrayList;

public class MoreListAlgorithms {
	public static ArrayList<ArrayList> randomNumbers(int n, int x){
		ArrayList<ArrayList> list = new ArrayList<ArrayList>();
		ArrayList<Integer> posNums = new ArrayList<Integer>();
		list.add(posNums);
		ArrayList<Integer> negNums = new ArrayList<Integer>();
		list.add(negNums);
		for(int i = 0; i < n; i ++) {
			int rand = (int) ((Math.random()*2*x)-x);
			if(rand > 0) {
				posNums.add(rand);
			}
			else {
				negNums.add(rand);
			}
		}
		return list;
	}
	
	public static void reverseList(ArrayList<Double> nums) {
		for(int i = 0; i < nums.size(); i++) {
			nums.add(i, nums.remove(nums.size()-1));
		}
	}
	
	public static void main(String[] args) {
		MoreListAlgorithms run = new MoreListAlgorithms();
		System.out.println(randomNumbers(10, 9));
		ArrayList<Double> listDouble = new ArrayList<Double>();
		listDouble.add(1.0);
		listDouble.add(3.4);
		listDouble.add(2.3);
		System.out.println(listDouble);
		reverseList(listDouble);
		System.out.println(listDouble);
		
	}
	
}
