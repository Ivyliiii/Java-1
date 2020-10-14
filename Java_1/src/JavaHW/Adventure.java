// Adventure Project By Ivy 
// Inspiration from movies and short story.

package JavaHW;

import java.util.Scanner;

public class Adventure {
	Scanner in = new Scanner(System.in);
	
	private String name;
	private char character;
	private int count = 1; // this is counting the number of times that you have used your skill
	
	
	// This method takes the name of the user
	public void askName() {
		
		System.out.println("Welcome to the Adventures Game, are you ready?");
		System.out.println("a. I am totally ready! \nb. I am ready! Let's get started!(When you see such choices, please input the letter corresponding to"
				+ " please input the letter corresponding to your choice!)");
		String answer1 = in.next();
		System.out.println("I am glad that you are ready! What is your name?");
		name = in.next();
		System.out.println("Nice to meet you " + name + "!");
		charPick();
		
	}
	
	// This method allows the user to pick the character of the user, the choices are sorcerer, prophet, and elf
	public void charPick() {
		
		System.out.println("You can pick your character! Each character will correspond with "
				+ "a speical skill. Your choices are sorcerer, prophet, and elf! \na. Sorcerer \nb. Prophet \nc. Elf");
		character = in.next().charAt(0);
		charIntro();
	}
	
	// This method introduces the skills that your character has and also links to start the game.
	public void charIntro() {
		if (character == 'a') {
			System.out.println("Sorcerer it is! Guess what, throughout your adventure, you would be able to backtrack one time."
					+ " This means you can go back to your last choice and change what you have done! To activate this skill"
					+ " simply type the letter 's' while you are making a choice");
			start();
		}
		else if (character == 'b') {
			System.out.println("What a nice choice! Throughout your game, you would be able to activate your skill one time in order to"
					+ " predict consequences for one of your choices! To activate this, please type the letter 's' while you are currently making a choice!");
			start();
		}
		else if (character == 'c') {
			System.out.println("I would have done the exact same thing if I were you! Being an elf means that you would have two "
					+ "lives instead of one! After reviving, you will make your previous desicion again!");
			start();
		}
		else {
			inputError();
		}
	}
	
	// This method is the official start of the game. This is the first choice that the user makes. It is a simple Yes or no choice of whether to go into a store or not
	public void start() {
		System.out.println("Welcome! You are in the middle of a desolated town. In front of you is a store that hasn't been used a long time, it is very dark inside. "
				+ "Do you want to go inside? \na.Yes! \nb.No way!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			insideStore();
		}
		else if (answer == 'b') {
			outsideA();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				inputError(); // You cannot redo your last choice because this is your first choice within the game
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you chose to go inside, you will see a piece on the ground. Otherwise, as you skan across your surroundings, you find someone looking at you.");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					insideStore();
				}
				else if (answer == 'b') {
					outsideA();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		else {
			inputError();
		}
	}
	
	// This happens if the author picks 'a' in the previous method. This is going to be a choice that leads to the user getting a warning or not getting a warning.
	public void insideStore() {
		System.out.println("You found the door to be not locked...\nInside, you found the store to be all brocken down, even the window was brocken."
				+ "You also see a sharp piece of glass that could be used as a weapon, do you want to pick it up? \na.Yes \nb.No");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			afterPickUpGlassA();
		}
		else if (answer == 'b') {
			seeingMap();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1; // this subtracts the times you have used your skill, you cannot use if more if you already did once
				start();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("You just used your only chance of knowing whats going to happen next! If you choose to pick"
						+ " up the glass, you would find a note under it that says 'Stay out of this place' written in red. "
						+ "If not, you would walk to a map on the wall.");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					afterPickUpGlassA();
				}
				else if (answer == 'b') {
					seeingMap();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		else {
			inputError();
		}
		
	}
	
	// This method gets called after the user picks of the glass, you will make the choice of wether or not to go outside.
	public void afterPickUpGlassA() {
		System.out.println("After picking up the piece of glass, you finger was accidently cut. You drop the sharp thing right away. However, "
				+ "you see a note written on a piece of paper that says 'Get out of there!' Do you want to turn around and go outside? \na.Yes \nb.No, lets walk a bit more!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			outsideB();
		}
		else if (answer == 'b') {
			seeingMap();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				insideStore();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you keep going in the store, you are going to find a map that shows you where everything is. Outside, there will be a guy staring at you.");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					outsideB();
				}
				else if (answer == 'b') {
					seeingMap();
				}
				else {
					inputError();
				}
			}
			
			else {
				inputError();
			}
			
		}
		else {
			inputError();
		}
		
	}
	
	// Since there are two ways to end up at this method, when we are calling the last choice, there are going to be different places that it leads to. This method follows not going to the store at first. 
	public void outsideA() {
		System.out.println("Outside of the store, you scan around your surroundings. Near the corner of the street, you find someone spying at you while"
				+ " holding a newspaper. Do you want to go up to him? \na.Yes, lets go talke to him! \nb.No, we should head the other way!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			meetGuy();
		}
		else if (answer == 'b') {
			otherWayB();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				start();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you choose to go to the man, you will find that he is reading a Newspaper from October 15, 1920. If you choose to turn the other way"
						+ " you will find a huge crowd of people.");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					meetGuy();
				}
				else if (answer == 'b') {
					otherWayB();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		else {
			inputError();
		}
	}
	
	// Following up on the previous function, this method gets called from where you leave the store and come outside. This means that if you choose to redo your decision, it is going to take you to afterPickingUpGlassA to make that choice again!
	public void outsideB() {
		System.out.println("Outsied of the store, you scan around your surroundings. Near the corner of the street, you find someone spying at you while"
				+ " holding a newspaper. Do you want to go up to him? \na.Yes, lets go talk to him! \nb.No, we should head the other way!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			meetGuy();
		}
		else if (answer == 'b') {
			otherWayB();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				afterPickUpGlassA();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you choose to go to the man, you will find that he is reading a Newspaper from October 15, 1920. If you choose to turn the other way"
						+ " you will find a huge crowd of people.");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					meetGuy();
				}
				else if (answer == 'b') {
					otherWayB();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		else {
			inputError();
		}
	}
	
	// There is only one decision that gets you to meet the men since outsideA and outsideB basically means the same thing in this case. This method allows you to make the choice of asking questions. It leads either to going to the lottery or being discovered.
	public void meetGuy() {
		System.out.println("Just as you walked up to the guy near the corner, he realizes someone is coming and looks right into your eyes. He asks:'Why are you here? Aren't you supposed to go to the lottery?"
				+ " I have been watching you for a long time, don't you want to earn the final prize?' What do you want to say? \na. 'What lottery?' \nb. 'Where is the lottery'");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			moreQuestions();
		}
		else if (answer == 'b') {
			System.out.println("The guy points to the street next to the store that you came from.");
			otherWayA();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				outsideB();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you choose to say 'What lottery,' you will be able to learn more about the lottery. If you pick option b, you will end up going right there!");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					moreQuestions();
				}
				else if (answer == 'b') {
					System.out.println("The guy points to the street next to the store that you came from.");
					otherWayA();
				}
				else {
					inputError();
				}
				
			}
			else {
				inputError();
			}
		}
		else {
			inputError();
		}
	}
	
	// This function allows you to ask more questions to the man. If you asks too many, the man is going to suspect your true identity.
	public void moreQuestions() {
		System.out.println("The man said:'Did you seriously forget, today is the day of the biggest party of the year. And the lottery is always on the morning of the big party'"
				+ "What do you want to ask now? \na. 'What is the final prize?' \nb. 'Where is the lottery'");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			System.out.println("The man looks at you and calls one of his friends. After talking talking a bit, they arrest for knowing too much about the town's secrets.");
			if (character == 'c' && count > 0) {
				System.out.println("How lucky you are! You will now go back to your last choice to try to change your fate!");
				moreQuestions();
			}
			else {
				gameEnds();
			}
		}
		else if (answer == 'b') {
			System.out.println("The man points towards the alley next to the store");
			otherWayB();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				meetGuy();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you pick the first choice, you will be arrested. If you choose to ask where the lottery is, you will go to the lottery.");
				answer = in.next().charAt(0);
				if (answer == 'a') {
					System.out.println("The man looks at you and calls one of his friends. After talking talking a bit, they arrest for knowing too much about the town's secrets.");
					if (character == 'c' && count > 0) {
						System.out.println("How lucky you are! You will now go back to your last choice to try to change your fate!");
						moreQuestions();
					}
					else {
						gameEnds();
					}
				}
				else if (answer == 'b') {
					System.out.println("The man points towards the alley next to the store");
					otherWayB();
				}
				else {
					inputError();
				}
				
			}
			else {
				inputError();
			}
			
		}
		else {
			inputError();
		}
	}

	// This method asks the user to decide whether or not to leave the store. The user might be killed if not. 
	public void seeingMap() {
		System.out.println("You suddenly see a very interesting map that was pinned to the wall. You walk right up to it. You see a map that you do not recognize at all, but you see a small part that is circle"
				+ "d out in neon-yellow. Recalling what you saw on the streets, you found that this circled place is right next to the store you are in right now. Do you still want to stay in the store.? "
				+ "\na. Yes, I want to look more! \nb. No, we should leave as fast as possible.");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			System.out.println("I am very sorry, but you just died because a ghost that came out of nowhere in the store took the piece of glass"
					+ " that you saw on the way and killed you!");
			if (character == 'c' && count > 0) {
				System.out.println("How lucky you are! You will now go back to your last choice to try to change your fate!");
				count -= 1;
				seeingMap();
			}
			else {
				gameEnds();
			}
			
		}
		else if (answer == 'b') {
			outsideB();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				afterPickUpGlassA();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you choose to stay here, a ghost will come out and the game will end. If you choose to go outside, you will see a creepy man looking at you.");
				answer = in.next().charAt(0);
				if (answer == 'a') {
					System.out.println("I am very sorry, but you just died because a ghost that came out of nowhere in the store took the piece of glass"
							+ " that you saw on the way and killed you!");
					gameEnds();// it is no longer necessary to check if the user is an elf bc we know that he/she is a prophet
				}
				else if (answer == 'b') {
					outsideB();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		else {
			inputError();
		}
	}
	
	// This method asks the user whether or not to go up and take a slip of paper. If the user does not, he/she would be killed.
	public void otherWayA() {
		System.out.println("You moved down to alley along the side of the store to a crowd of people! As you approached the crowd to see what they are all watching, some one next to you said "
				+ ": 'Have you picked a slip of paper yet?' You said:'I haven't, what are you guys doing right here?' The woman said:'Oh, did you forget that its the day of the lottery. You should "
				+ " tell the guy up there that you haven't gotten a slip yet!' Do you want to do as the woman says? \na. Yes \nb. No, I am gonna wait a bit more!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			getSlip();
		}
		else if (answer == 'b') {
			System.out.println("As you decided to wait a bit more, the woman next to you reports you to the slip-giving guy. You got arrested for not following the town tradition of picking a slip of paper.");
			if (character == 'c' && count > 0) {
				System.out.println("How lucky you are! You will now go back to your last choice to try to change your fate!");
				count -= 1;
				otherWayA();
			}
			else {
				gameEnds();
			}
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				meetGuy();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you chose to get a slip, you face the decision of picking one slip out of two. If you wait a bit longer, people around you will find out that you do not belong here!");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					getSlip();
				}
				else if (answer == 'b') {
					System.out.println("As you decided to wait a bit more, the woman next to you reports you to the slip-giving guy. You got arrested for not following the tradition");
					gameEnds();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		
		else {
			inputError();
		}
			
	}
	
	// This method allows you to make the choice of getting a slip of paper or not. This is different from the first few otherWay Functions because the returning to last choice would be different. In this case, the last choice is to meet the guy again.
	public void otherWayB() {
		System.out.println("You moved down to alley along the side of the store to a crowd of people! As you approached the crowd to see what they are all watching, some one next to you said "
				+ ": 'Have you picked a slip of paper yet?' \nYou said:'I haven't, what are you guys doing right here?' \nThe woman said:'Oh, did you forget that its the day of the lottery. You should "
				+ " tell the guy up there that you haven't gotten a slip yet!' \nDo you want to do as the woman says? \na. Yes \nb. No, I am gonna wait a bit more!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			getSlip();
		}
		else if (answer == 'b') {
			System.out.println("As you decided to wait a bit more, the woman next to you reports you to the slip-giving guy. You got arrested for not following the town tradition of picking a slip of paper.");
			if (character == 'c' && count > 0) {
				System.out.println("How lucky you are! You will now go back to your last choice to try to change your fate!");
				count -= 1;
				otherWayB();
			}
			else {
				gameEnds();
			}
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				outsideA();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you chose to get a slip, you face the decision of picking one slip out of two. If you wait a bit longer, people around you will find out that you do not belong here!");
				count -= 1;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					getSlip();
				}
				else if (answer == 'b') {
					System.out.println("As you decided to wait a bit more, the woman next to you reports you to the slip-giving guy. You got arrested for not following the tradition");
					if (character == 'c' && count > 0) {
						
					}
					gameEnds();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		}
		
		else {
			inputError();
		}
			
	}
	
	// This method is for making choice of which piece of paper pick. If you choose to pick the first, you will be stoned. If you picked the second, you have a chance at winning the game.
	public void getSlip() {
		System.out.println("You walked up to the man to get a slip of paper. He holds out a box to you. Inside the box, you feel two pieces of paper. Do you want to pick up the first one or"
				+ " the second one? \na.First One \nb.Second One");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			System.out.println("Unfortunately, you picked the slip of paper with a black dot on it. People watch you nonchalantly as kids stone you to death!");
			if (character == 'c' && count > 0) {
				System.out.println("How lucky you are! You will now go back to your last choice to try to change your fate!");
				count -= 1;
				getSlip();
			}
			else {
				gameEnds();
			}
		}
		else if (answer == 'b') {
			leavingOrNot();
		}
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				otherWayB();
			}
			else if (character == 'b' && count > 0) {
				count -= 1;
				System.out.println("Picking the first slip of paper will have a black dot, but the second means an empty piece of paper.");
				answer = in.next().charAt(0);
				if (answer == 'a') {
					System.out.println("Unfortunately, you picked the slip of paper with a black dot on it. People watch you nonchalantly as kids stone you to death!");
					gameEnds();
				}
				else if (answer == 'b') {
					leavingOrNot();
				}
				else {
					inputError();
				}
			}
			else {
				inputError();
			}
		
		}
		else {
			inputError();
		}
	}
	
	// This loop is the last one where you will be able to make a choice on whether or not to leave the town. Either ways, the game ends after this loop.
	public void leavingOrNot() {
		System.out.println("Fortunately, you picked a blank slit of paper out of the box. As you return to the woman's side, she says that you don't have to be here anymore. Do you want to leave?"
				+ " \na.Yes \nb.No");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			System.out.println("Congratulations, you have successfully escaped this place! As you climb on the bux out of the town, you wonder if you are going to come back again, but when you checked the maps"
					+ " for the name of the town after you got home, you realize that the town doesn't exist at all!");
			gameEnds();
		}
		else if (answer == 'b') {
			System.out.println("Suddenly, some guy in the crown shouts that you don't belong in the town at all. Since he picked the slip of paper with a dot, he blames you for picking the last empty slip. "
					+ "Everyone in town got mad at you for intruding their festival. Instead of stoning the one with the black slip, they decided to stone you to death.");
		
			if (character != 'c' || count < 1) {
				gameEnds();
			}
			else {
				System.out.println("Fortunately, you can make you choice again!");
				leavingOrNot();
			}
		}
		
		else if (answer == 's') {
			if (character == 'a' && count > 0) {
				count -= 1;
				getSlip();
			}
			else if (character == 'b' && count > 0) {
				System.out.println("If you chose to leave, you will be able to win as you leave the place unharmed. If you chose to stay, you will be stoned to death as people in town "
						+ "realizes that you are not part of the community");
				count -= 0;
				answer = in.next().charAt(0);
				if (answer == 'a') {
					System.out.println("Congratulations, you have successfully escaped this place! As you climb on the bux out of the town, you wonder if you are going to come back again, but when you checked the maps"
							+ " for the name of the town after you got home, you realize that the town doesn't exist at all!");
					gameEnds();
				}
				else if (answer == 'b') {
					System.out.println("Suddenly, some guy in the crown shouts that you don't belong in the town at all. Since he picked the slip of paper with a dot, he blames you for picking the last empty slip. "
							+ "Everyone in town got mad at you for intruding their festival. Instead of stoning the one with the black slip, they decided to stone you to death.");
				}
			}
			else {
				inputError();
			}
		}
		
		else {
			inputError();
		}
			
	}
	
	//Whenever there is an input error, this function is called. If the input is not valid, the game ends, and you will have to start all over from the beginning.
	public void inputError() {
		System.out.println("Please enter a valid choice! I think you will have to start over again!");
		gameEnds();
	}
	
	// No matter did you win or lose the game, this is where it is going to take you. You are also given the choice of playing again.
	public void gameEnds() {
		System.out.println("Sorry, this is the end of the game! Thanks for playing, I hope you had fun! \nDo you want to play again? \na.Yes! \nb.No, I am good!");
		char answer = in.next().charAt(0);
		if (answer == 'a') {
			askName();
		}
		else if (answer == 'b'){
			System.out.println("I'll see you next time!");
		}
	}
	
	// This is the main function. Only one method is called because this leads to the other methods.
	public static void main(String[] args) {
		Adventure runner = new Adventure();
		runner.askName();
		
	}
	
}
