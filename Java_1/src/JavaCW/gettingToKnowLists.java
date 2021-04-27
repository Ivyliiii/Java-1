package lists;

import java.util.ArrayList;

public class gettingToKnowLists {
	
	public static ArrayList<Character> remove(ArrayList<Character> arr){
		ArrayList<Character> out = new ArrayList<Character>();
		for(int i = 0; i < arr.size(); i++) {
			if(i%2 == 1) {
				out.add(arr.get(i));
			}
		}
		return out;
	}
	
	public static ArrayList<String> reverse(ArrayList<String> arr){
		ArrayList<String> out = new ArrayList<String>();
		for(String s : arr) {
			out.add(0, s);
		}
		return out;
	}
	
	public static ArrayList<Double> doubleNums(ArrayList<Double> nums){
		ArrayList<Double> out = new ArrayList<Double>();
		for(Double n : nums) {
			out.add(n*2);
		}
		return out;
	}
	
	public static  ArrayList<Character> reversedAlph(int n){
		ArrayList<Character> out = new ArrayList<Character>();
		for(int i = 0; i < n; i ++) {
			if(i%2 == 0) {
				out.add(0,(char)(i+97));
			}
			else {
				out.add((char)(i+97));
			}
		}
		return out;
	}
	
	public static void main(String[] args) {
		ArrayList<Character> listChar = new ArrayList<Character>();
		listChar.add('d');
		listChar.add('k');
		listChar.add('e');
		listChar.add('p');
		listChar.add('w');
		listChar.add('s');
		listChar.add('f');
		System.out.println(remove(listChar));
		ArrayList<String> listString = new ArrayList<String>();
		listString.add("lists");
		listString.add("are");
		listString.add("great");
		System.out.println();
		System.out.println(reverse(listString));
		ArrayList<Double> listDouble = new ArrayList<Double>();
		listDouble.add(0.2);
		listDouble.add(4.1);
		listDouble.add(7.8);
		System.out.println();
		System.out.println(doubleNums(listDouble));
		System.out.println();
		System.out.println(reversedAlph(6));

	}
	
}
