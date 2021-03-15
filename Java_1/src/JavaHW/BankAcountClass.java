package JavaHW;
import java.util.Scanner;

public class BankAcountClass {
	private String name;
	private double savings;
	private double interest; //assuming that it is a decimal rather than a percentage
	
	public BankAcountClass(String n, int s, double i) {
		name = n;
		savings = s;
		interest = i;
	}
	
	public double getsavings() {
		return savings;
	}
	
	public String getname() {
		return name;
	}
	
	public double getinterest() {
		return interest;
	}
	
	public BankAcountClass(String n, double i) {
		name = n;
		savings = 0;
		interest = i;
	}
	
	public void deposit(int n) {
		savings += n;
	}
	
	public void withdraw(int n) {
		savings -= n;
	}
	
	public void addInterest() {
		savings += savings*interest;
	}
	
	public String toString() {
		return name + ", " + savings + ", " + interest;
	}
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		BankAcountClass user2 = new BankAcountClass("stmarks", 10000, 0.05);
		BankAcountClass user3 = new BankAcountClass("nobody", 0.1);
		
		System.out.println(user2);
		System.out.println();
		System.out.println(user3);
		
		
		System.out.println("Please enter your name!");
		String user = s.nextLine();
		
		System.out.println("Please enter your interest!");
		double interest = s.nextDouble();
		
		System.out.println("Please enter the current amount of money you have in your bank account!");
		int savings = s.nextInt();
		
		BankAcountClass user1 = new BankAcountClass(user, savings, interest);
		
		boolean run = true;
		while(run) {
			System.out.println();
			System.out.println("Do you want to complete any other actions? To deposit, press'd'. To "
					+ "withdraw money, press 'w'. To add in the interest, press 'i'. If you are "
					+ "done, press 'q'.");
			char input = s.next().charAt(0);
			if(input == 'd') {
				System.out.println("How much money do you want to deposit?");
				user1.deposit(s.nextInt());
				System.out.println(user1.getsavings());
				System.out.print(user1.getname() + ", you now have " + user1.getsavings());
	
			}
			
			else if(input == 'w') {
				System.out.println("How much money do you want to withdraw?");
				user1.withdraw(s.nextInt());
				System.out.print(user1.getname() + ", you now have " + user1.getsavings());
				
			}
			
			else if(input == 'i') {
				System.out.println("What is your new interest?");
				user1.addInterest();
				System.out.print(user1.getname() + ", you now have " + user1.getsavings());
			}
			
			else if(s.next().charAt(0) == 'q') {
				run = false;
			}
			
			else {
				System.out.println("INVALID INPUT! Please enter again! Do you want to complete any other actions? To deposit, press'd'. To "
						+ "withdraw money, press 'w'. To add in the interest, press 'i'. If you are "
						+ "done, press 'q'.");
			}
		}
	}
}
