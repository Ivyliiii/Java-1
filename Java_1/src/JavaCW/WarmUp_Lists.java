package lists;

import java.util.ArrayList;

public class WarmUp_Lists {
	public int[] countFreq(String str){
		int[] freq = new int[26];
		for(int i = 0; i < str.length(); i++) {
			char let = Character.toLowerCase(str.charAt(i));
			if((int)let-96 < 26 && (int)let-96 > 0) {
				freq[(int)let-97]++;
			}
		}
		return freq;
	}
	
	public static void main(String[] args) {
		WarmUp_Lists run = new WarmUp_Lists();
		int[] freq = run.countFreq("How are you doing?");

		for(int i = 0; i < freq.length; i++) {
			System.out.println(freq[i]);
		}
	}
}
