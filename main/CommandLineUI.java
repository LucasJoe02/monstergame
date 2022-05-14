/**
 * 
 */
package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/**
 * @author Lucas Redding
 *
 */
public class CommandLineUI {

	private GameEnvironment game;
	private Scanner scanner;
	
	/**
	 * 
	 */
	public CommandLineUI() {
		game = new GameEnvironment();
		scanner = new Scanner(System.in);
	}
	
	private boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(name);
		boolean valid = false;
		if (!matcher.find() && name.length() <= 15 && name.length() >= 3) {
			valid = true;
		}
		return valid;
	}
	
	private boolean isInputNumValid(String num,int lower,int upper) {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(num);
		boolean valid = false;
		try {
			int daysInt = Integer.parseInt(num);
			if (matcher.find() && daysInt >= lower && daysInt <= upper) {
				valid = true;
			}
		}catch (Exception e) {
			
		}
		return valid;
	}
	
	public String inputName() {
		System.out.print("Enter Username: ");
		String userName = scanner.nextLine();
		while(!isValidName(userName)) {
			System.out.println("Username must contain between 3 and 15 characters\n"
					+ "and must not include numbers or special characters.");
			System.out.print("Enter Username: ");
			userName = scanner.nextLine();
		}
		return userName;
	}
	
	public int inputDays() {
		int days;
		System.out.println("How many days would you like the game to last?");
		String daysString;
		do {
			System.out.print("(Must be between 5 and 15 days): ");
			daysString = scanner.nextLine();
		}while(!isInputNumValid(daysString,5,15));
		days = Integer.parseInt(daysString);
		return days;
	}
	
	public Monster chooseStartMonster() {
		Monster chosenMonster;
		System.out.println("\nBelow is a list of available monsters for your team.");
		System.out.println("Above each monster is it's number.");
		System.out.println("Enter the number of the monster you want to be your starter below.");
		MonsterCreator monsterCreator = new MonsterCreator();
		ArrayList<Monster> availableMonsters = new ArrayList<Monster>();
		for (int i = 0; i < 3; i++) {
			System.out.println();
			System.out.println(i);
			availableMonsters.add(monsterCreator.createCommon());
			System.out.println(availableMonsters.get(i));
		}
		String monsterIndexString;
		do {
			System.out.print("(Enter number of chosen monster): ");
			monsterIndexString = scanner.nextLine();
		}while(!isInputNumValid(monsterIndexString,0,2));
		int monsterIndex = Integer.parseInt(monsterIndexString);
		chosenMonster = availableMonsters.get(monsterIndex);
		return chosenMonster;
	}
	
	public int chooseDifficulty() {
		int difficulty;
		String difficultyInputString;
		do {
			System.out.print("Enter a difficulty level from 1 to 3 (1-Easy,2-Medium,3-Hard): ");
			difficultyInputString = scanner.nextLine();
		}while(!isInputNumValid(difficultyInputString,1,3));
		difficulty = Integer.parseInt(difficultyInputString);
		return difficulty;
	}
	
	public void setup() {
		String userName;
		int days;
		Monster chosenMonster;
		int difficulty;
		
		userName = inputName();
		System.out.println("Hi! "+userName+".");
		days = inputDays();
		chosenMonster = chooseStartMonster();
		difficulty = chooseDifficulty();
		
		
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommandLineUI ui = new CommandLineUI();
		ui.setup();

	}

}
