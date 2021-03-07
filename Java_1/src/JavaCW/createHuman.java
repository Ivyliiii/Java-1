package JavaCW;

public class createHuman {
	
	private int age;
	private String name;
	private int height; //private in class; public everywhere
	
	public createHuman(int a, String n, int h) {
		age = a;
		name = n;
		height = h;
	}
	
	public int getAge() {
		return age;
	}
	
	public String getName() {
		return name;
	}
	
	public int getHeight() {
		return height;
	}
	
	public int setAge(int a) {
		age = a;
		return age;
	}
	
	public int getOlder() {
		age++;
		return age;
	}
	
	public String changeName(String newName) {
		name = newName;
		return name;
	}
	
	public boolean canVote(int year) {
		if(year%4 == 0 && age >= 18) {
			return true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		
		createHuman ivy = new createHuman(15, "ivy", 160);
		
		int x = ivy.getAge();
		System.out.println(x);
		String n = ivy.getName();
		System.out.println(n);
		int h = ivy.getHeight();
		System.out.println(h);
		x = ivy.setAge(18);
		System.out.println(x);
		x = ivy.getOlder();
		System.out.println(x);
		n = ivy.changeName("yvi");
		System.out.println(n);
		boolean canvote = ivy.canVote(2004);
		System.out.println(canvote);
		canvote = ivy.canVote(2005);
		System.out.println(canvote);
	}
	
}

