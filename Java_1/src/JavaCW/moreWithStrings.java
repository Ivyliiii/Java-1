package JavaCW;


public class moreWithStrings {
	
	public void firstsamelast(String str) {
		
		if (str.substring(0,2).equals(str.substring(str.length()-2, str.length()))) {
			System.out.println("True");
		}
		else {
			System.out.println("False");
		}
	}
	
	public void numberOfWords(String str) {
		
		int space = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				space++;
			}
		}
		System.out.println(space+1);
	}
	
	public void stringtoArray(String str){
		int space = 0;
		
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == ' ') {
				space++;
			}
		}

		String arr[] = new String[space+1];
		int added = 0;
		arr[0] = str.substring(0, str.indexOf(' '));
		added++;
		for (int i = str.indexOf(' '); i < str.length(); i++){
			
			for (int j = i+1; j< str.length(); j++) {
				if (str.charAt(j) == ' ') {
					arr[added] = str.substring(i+1, j);
					i = j;
					added++;
				}
			}
		}
		
		for (int j = str.length()-1; j > 0; j--) {
			if (str.charAt(j) == ' ') {
				arr[arr.length-1] = str.substring(j+1);
				break;
			}
		}
		
		for (int i = 0; i < space+1; i++) {
			System.out.println(arr[i]);
		}
	}
	
	public void notE(String str) {
		String output = "";
		for (int i = 0; i <str.length(); i++) {
			if (str.charAt(i) != 'e') {
				output += str.charAt(i);
			}
		}
		System.out.println(output);
	}
	
	public void longestBlock(String str) {
		int longest = 0;
		int indexL = 0;
		int longR = 0;
		for (int i = 0; i < str.length(); i++) {
			longR = 0;
			for (int j = i+1; j < str.length(); j++) {
				if (str.charAt(j) == str.charAt(i)) {
					longR++;
				}
				else {
					continue;
				}
			}
			if (longR > longest) {
				longest = longR;
			}
		}
		System.out.println(longest+1);
	}
	
	public void palindrome(String str) {
		boolean palindrome = true;
		
		for(int i = 0, j = str.length()-1; i < str.length()/2; i++, j--) {
			if(str.charAt(i) != str.charAt(j)) {
				palindrome = false;
			}
		}
		
		if (palindrome) {
			System.out.println("Yes, it is a palindrome.");
		}
		else {
			System.out.println("Nope, it is not.");
		}
	}
	
	public static void main(String[] args) {
		
		moreWithStrings run = new moreWithStrings();
		
		run.firstsamelast("edited");
		run.numberOfWords("How is life?");
		run.stringtoArray("AP CS is for nerds");
		run.notE("Life is never not hard");
		run.longestBlock("abbbcd");
		run.palindrome("1259521");
		
	}
}
