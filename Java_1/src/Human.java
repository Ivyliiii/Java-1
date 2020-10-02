

public class Human {
	
	private char gender;
	private int age;
	
	public void setGender(char g) {
		gender = g;
	}
	
	public void getAge(int a) {
		age = a;
	}
	
	public void ifVote(int a) {
		age = a;
		
		if (a > 18) {
			System.out.println("You can vote now");
		}
		else {
			System.out.println("You may not vote just yet :(");
		}
	}
	
	public void ifTetanus() {
		if (age % 4 == 0) {
			System.out.println("You need to get a tetanus shot");
		}
		else {
			System.out.println("You are very luckkyyyy, no shots this year!");
		}
	}
	
	public void ifTodd() {
		if (age < 4) {
			if (gender == 'g') {
				System.out.println("You are a toddler girl");
			}
			else {
				System.out.println("You are a toddler boy");
			}
		}
		else {
			System.out.println("You are no longer a toddlerrr!!");
		}
	}
	
	public void ifTeen() {
		if (12 <= age && age <= 18) {
			System.out.println("You are a teenager");
		}
		else {
			System.out.println("You are not a teenager");
		}
	}
	
	public void ifTeammates(char c, int b) {
		if ((c == gender) && (Math.abs(b-age) <= 2)) {
			System.out.println("You guys can be teammates");
		}
		else {
			System.out.println("You guys cannot be teammates :((");
		}
	}
	
	public static void main(String[] args) {
		Human tester = new Human();
		tester.setGender('b');
		tester.ifVote(2);
		tester.ifTetanus();
		tester.ifTodd();
		tester.ifTeammates('b', 4);
		
	}
	
	
}
