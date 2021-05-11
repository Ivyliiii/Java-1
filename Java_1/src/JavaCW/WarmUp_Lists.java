package lists;

import java.util.ArrayList;

public class WarmUp_Lists {
	public ArrayList<Integer> countFreq(String str){
		ArrayList<Integer> freq = new ArrayList<Integer>();
		for(int i = 0; i < 26; i++) {
			freq.add(0);
		}
		for(int i = 0; i < str.length(); i++) {
			char let = Character.toLowerCase(str.charAt(i));
			if((int)let-96 < 26 && (int)let-96 > 0) {
				freq.set((int)let-97, freq.get((int)let-97)+1);
			}
		}
		return freq;
	}
	
	public static void main(String[] args) {
		WarmUp_Lists run = new WarmUp_Lists();
		System.out.println(run.countFreq("How are you doing?"));
	}
}
