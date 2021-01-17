package JavaHW;

public class introtoStrings {

	public void halfInput(String str) {
		System.out.println(str.substring(str.length()/2));
	}
	
	public void concatenate(String str, String str2) {
		str = str.substring(1);
		str2 = str2.substring(1);
		System.out.println(str + str2);
 	}
	
	public void adverb(String str) {
		if (str.substring(str.length()-2).equals("ly")) {
			System.out.println("yes");
		}
		else {
			System.out.println("no");
		}
	}
	
	public void contain(String str, String str2) {
		if (str.indexOf(str2) == -1) {
			System.out.println("no");
		}
		else {
			System.out.println("yes");
		}
	}
	
	public void backwards(String str) {
		String newS = "";
		for (int i = str.length()-1; i >= 0; i--) {
			newS += str.charAt(i);
		}
		System.out.println(newS);
	}
	
	public void wordSquare(String str) {
		String word = "";
		for (int i = 0; i < str.length(); i++) {
			word = "";
			for (int j = 0; j < str.length(); j++) {
				word += str.charAt((i+j)%5);
			}
			System.out.println(word);
		}
	}
	
	public static void main(String[] args) {
			
		introtoStrings run = new introtoStrings();
		run.halfInput("hi there");
		run.concatenate("hello", "there");
		run.adverb("blably");
		run.contain("huppo", "hi");
		run.backwards("java");
		run.wordSquare("hello");
	}
}

