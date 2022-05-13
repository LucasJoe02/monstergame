/**
 * 
 */
package main;
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
		Pattern pattern = Pattern.compile("[a-zA-Z]");
		Matcher matcher = pattern.matcher(name);
		boolean valid = false;
		if (matcher.find() && name.length() <= 15 && name.length() >= 3) {
			valid = true;
		}
		return valid;
	}
	
	private boolean isValidDays(String days) {
		Pattern pattern = Pattern.compile("[0-9]");
		Matcher matcher = pattern.matcher(days);
		boolean valid = false;
		try {
			int daysInt = Integer.parseInt(days);
			if (matcher.find() && daysInt >= 5 && daysInt <= 15) {
				valid = true;
			}
		}catch (Exception e) {
			
		}
		return valid;
	}
	
	public void setup() {
		System.out.print("Enter Username: ");
		String userName = scanner.nextLine();
		while(!isValidName(userName)) {
			System.out.println("Username must contain between 3 and 15 characters\n"
					+ "and must not include numbers or special characters.");
			System.out.print("Enter Username: ");
			userName = scanner.nextLine();
		}
		
		System.out.println("Hi! "+userName+".");
		System.out.println("How many days would you like the game to last?");
		String days;
		do {
			System.out.println("(Must be between 5 and 15 days): ");
			days = scanner.nextLine();
		}while(!isValidDays(days));
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		CommandLineUI ui = new CommandLineUI();
		ui.setup();

	}

}
