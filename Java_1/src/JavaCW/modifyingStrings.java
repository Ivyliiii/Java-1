package JavaCW;

public class modifyingStrings {
	public void quick(String str) {
		str = str.substring(0, str.length()-2);
		str += "est";
		System.out.println(str);
	}
	
	public void changePre(String str) {
		str = str.substring(3);
		str = "un" + str;
		System.out.println(str);
	}
	
	public void replace(String str, char a, char b) {
		for(int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == a) {
				System.out.println("hi");
				str = str.substring(0,i) + b + str.substring(i+1);
			}
		}
		System.out.println(str);
	}
	
	
	// I think we have done this problem before
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
	
	public void Adreplace(String str, String str2, String str3) {
		
		String newString = "";
		for(int i = 0; i < (str.length()-str2.length()+1); i++) {
			if(str.substring(i, str2.length()+i).equals(str2)) {
				newString = str.substring(0,i) + str3;
			}
		}
		System.out.println(newString);
		
	}
	
	public void upperToLower(String str) {
		String newString = "";
		int j = -1;
		for(int i = 0; i < str.length(); i++) {
			if((str.charAt(i) >= 'A') && (str.charAt(i) <= 'Z')) {
				newString += (char)(str.charAt(i)+32);
				j = i;
			}
			else {
				newString += str.charAt(i);
			}
		}
		System.out.println(newString);
	}
	public static void main(String[] args) {
		
		modifyingStrings run = new modifyingStrings();
		
		run.quick("quickly");
		run.changePre("predisposed");
		run.replace("Hello", 'l', 'c');
		run.stringtoArray("Today is another day");
		run.Adreplace("Class", "ss", "sses");
		run.upperToLower("hI eVErYoNe");
	}
}
