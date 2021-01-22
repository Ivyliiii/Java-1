package JavaCW;

public class GroupStringWork {
	
	public void outLongest(String[] arr) {
		int longestIndex = 0;
		for (int i = 1; i < arr.length; i++) {
			if (arr[i].length() > arr[longestIndex].length()) {
				longestIndex = i;
			}
		}
		System.out.println(arr[longestIndex]);
	}
	
	public String pigLatinO(String str) {
		String nStr = "";
		nStr += str.substring(1, str.length());
		nStr += str.charAt(0);
		nStr += "ay";
		return nStr;
	}
	
	public void challengeOutLongest(String str) {
		int firstLet = 0;
		String nstr = "";
		for (int i = 0; i < str.length(); i++) {
			
			if(str.charAt(i) == ' ') {
				nstr += pigLatinO(str.substring(firstLet, i));
				nstr += " ";
				firstLet = i+1;
			}
		}
		nstr += pigLatinO(str.substring(firstLet));
		System.out.println(nstr);
	}
	
	public void pigLatin(String str) {
		String nStr = "";
		nStr += str.substring(1, str.length());
		nStr += str.charAt(0);
		nStr += "ay";
		System.out.println(nStr);
	}
	
	public void replace(String str, char letter) {
		String nstr = "";
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) != letter) {
				nstr += str.charAt(i);
			}
			else {
				nstr += '$';
			}
		}
		System.out.println(nstr);
	}
	
	public static void main(String[] args) {
		
		GroupStringWork run = new GroupStringWork();
		String[] arr = {"hi", "hello", "bye"};
		run.outLongest(arr);
		run.replace("hello", 'l');
		run.pigLatin("pig");
		run.challengeOutLongest("Hi how is life");
		
	}
}
