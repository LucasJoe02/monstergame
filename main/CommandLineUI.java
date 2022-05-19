/**
 * 
 */
package main;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

/**
 * This class implements a command line UI
 * that the player interacts with to receive
 * output from the game. The player can use
 * this command line to setup the game, view
 * stats, view squad, visit the shop and arena
 * and progress through the game.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class CommandLineUI {

	/**
	 * The gameEnvironment that provides the functionality of the game and controls the game objects. 
	 */
	private GameEnvironment game;
	/**
	 * A scanner object that allows the UI to read input from the user in the command line.
	 */
	private Scanner scanner;
	
	/**
	 * Constructor that initializes the game and scanner objects.
	 * The scanner object reads from the standard input to take user input from the command line.
	 */
	public CommandLineUI() {
		game = new GameEnvironment();
		scanner = new Scanner(System.in);
	}
	
	/**
	 * Checks if the name input by the user is a valid name for the game.
	 * Creates a regular expression pattern that is the set of all strings
	 * except those that contain only letters.
	 * Creates a matcher that compares the given name with the regular expression pattern.
	 * If the name is not in the pattern then it must contain only letters.
	 * If the name is only letters and is between 3 and 15 characters long (inclusive) then
	 * the method returns true, else it returns false.
	 * @param name the name to be checked for validity
	 * @return boolean that describes if the given name was valid.
	 */
	private boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(name);
		boolean valid = false;
		if (!matcher.find() && name.length() <= 15 && name.length() >= 3) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * Checks if the number input by the user is valid based on a lower and upper bound (inclusive) for the number.
	 * Try's changing the input string number into an integer and then checks if it is made up of
	 * number characters and is between the lower and upper bounds (inclusive).
	 * If the number is between the bounds then the method returns true.
	 * If the try catch block fails or the number is not in the bounds then the method returns false.
	 * @param num the string being checked to see if it is a valid number.
	 * @param lower the lower bound (inclusive) of a valid number.
	 * @param lower the upper bound (inclusive) of a valid number.
	 * @return boolean that describes if the given number was valid.
	 */
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
	
	/**
	 * Asks for a user name from the user through the standard input and reads the user input and returns the user name.
	 * Checks first if the name that was input is valid.
	 * If the input name was invalid then prints out to the standard input what the constraints of a valid name are and
	 * asks again for the user to input a user name.
	 * @return the valid name input by the user.
	 */
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
	
	/**
	 * Asks the user for the amount of days they want the game to run for through the standard input, 
	 * reads the user input and returns the amount of days.
	 * Checks first if the amount of days that was input is valid.
	 * An amount of days is valid if it is between 5 and 15 (inclusive).
	 * If the input amount of days was invalid then prints out to the standard input what the 
	 * constraints of a valid amount of days are and asks again for the user to input an amount of days.
	 * @return the valid amount of days input by the user.
	 */
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
	
	/**
	 * Asks the player for input to rename a given monster.
	 * @param monster the Monster the user is choosing a new name for.
	 * @return the monster that is the renamed Monster
	 */
	public Monster pickMonsterName(Monster monster) {
		System.out.print("Enter a name for your Monster (leave blank for default name): ");
		String newMonsterName = scanner.nextLine();
		if (newMonsterName != "") {monster.setName(newMonsterName);}
		return monster;
	}
	
	/**
	 * Asks for the user to select a starter monster from a given list of monsters, then returns the monster chosen.
	 * The available monsters is set as a list of newly created common monsters.
	 * The list of monsters is printed to the standard input along with their id numbers.
	 * The user is asked to input the id number of their chosen starter monster and then the input checked for validity.
	 * Once the input from the player is valid the chosen monster is returned.
	 * @return the chosen starter monster.
	 */
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
		}while(!isInputNumValid(monsterIndexString,0,availableMonsters.size()-1));
		int monsterIndex = Integer.parseInt(monsterIndexString);
		chosenMonster = availableMonsters.get(monsterIndex);
		chosenMonster = pickMonsterName(chosenMonster);
		return chosenMonster;
	}
	
	/**
	 * Asks for the user to input a difficulty from 1 to 2.
	 * 1 is easy and 2 is hard.
	 * The input is checked to see if it meets the restrictions.
	 * Once the input is valid it is returned as an integer describing the chosen difficulty.
	 * @return the integer representation of the chosen difficulty.
	 */
	public int chooseDifficulty() {
		int difficulty;
		String difficultyInputString;
		do {
			System.out.print("Enter a difficulty level from 1 to 2 (1-Easy,2-Hard): ");
			difficultyInputString = scanner.nextLine();
		}while(!isInputNumValid(difficultyInputString,1,2));
		difficulty = Integer.parseInt(difficultyInputString);
		return difficulty;
	}
	
	/**
	 * One by one calls the methods associated with setting up the game and stores their outputs to set the starting game environment.
	 */
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
		
		game.setDifficulty(difficulty);
		game.setMaxDays(days);
		game.setPlayer(userName, chosenMonster);
		gameLoop();
	}
	
	
	/**
	 * Displays to the command line all of the available daily options for the user.
	 * Each option has a number ID above it used when the player selects one of the options.
	 */
	public void displayDailyOptions() {
		System.out.println("Below is a list of available daily options.");
		System.out.println("Above each option is it's number.");
		System.out.println("Enter the number of the option you wish to select below.\n");
		System.out.println("0\nView your monster squad.\n");
		System.out.println("1\nView your item inventory.\n");
		System.out.println("2\nVisit the shop.\n");
		System.out.println("3\nEnter the battle arena.\n");
		System.out.println("4\nGo to sleep.\n");
	}
	
	/**
	 * Displays a string representation of the user player's squad of monsters.
	 * Each monster is displayed with its index in the squad above it.
	 */
	public void displaySquad() {
		for (int i = 0; i < game.getPlayer().getSquad().getMonsters().size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println(game.getPlayer().getSquad().getMonsters().get(i));
		}
	}
	
	/**
	 * Displays a list of all of the user player's squad of monsters.
	 * The monsters and their stats are displayed in the order they battle in.
	 * On pressing enter the game loop is called to return to the main game loop.
	 */
	public void viewSquad() {
		System.out.println("\nHi "+game.getPlayer().getName()+".");
		System.out.println("Below is a description of each of your monsters\nIn the same order they will fight in battles.");
		displaySquad();
		System.out.println("\nPress enter to return to the main menu.");
		scanner.nextLine();
		gameLoop();
	}
	
	/**
	 * Displays a string representation of the user player's inventory of items.
	 * The items are displayed with their name above their description.
	 * Each item is displayed with its index in the inventory above it.
	 */
	public void displayInventory() {
		for (int i = 0; i < game.getPlayer().getItems().size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println(game.getPlayer().getItems().get(i).getName());
			System.out.println(game.getPlayer().getItems().get(i).getDesc());
		}
		if (game.getPlayer().getItems().size()==0) {
			System.out.println("\nInventory is empty.");
		}
	}
	
	public void useItem(int itemIndex) {
		System.out.println("Which of your monsters would you like to use "+game.getPlayer().getItems().get(itemIndex).getName()+" on?");
		displaySquad();
		String monsterIndexString;
		boolean usingItem = true;
		do {
			System.out.print("\nEnter the number of the monster or leave blank to cancel: ");
			monsterIndexString = scanner.nextLine();
			if (monsterIndexString == ""){
				usingItem = false;
				break;	
			}
		}while(!isInputNumValid(monsterIndexString,0,game.getPlayer().getSquad().getMonsters().size()-1));
		if (usingItem) {
			int monsterIndex = Integer.parseInt(monsterIndexString);
			game.useItemOnMonster(itemIndex, monsterIndex);
			System.out.println("\nMonster has been successfully upgraded!");
			System.out.println(game.getPlayer().getSquad().getMonsters().get(monsterIndex));
		}
		viewInventory();
	}
	
	/**
	 * Displays a list of all of the user player's inventory of items.
	 * The player is given the option to pick an item to use and which monster to use it on.
	 * On an empty input the game loop is called to return to the main game loop.
	 */
	public void viewInventory() {
		System.out.println("\nHi "+game.getPlayer().getName()+".");
		System.out.println("Below is a description of each of your items");
		System.out.println("Above each item is its number. To use an item enter its number below.");
		displayInventory();
		String itemIndexString;
		boolean usingItem = true;
		do {
			System.out.print("\nEnter the number of the item you wish to use or"
							 + "\nleave blank to return to main menu: ");
			itemIndexString = scanner.nextLine();
			if (itemIndexString == ""){
				usingItem = false;
				break;	
			}
		}while(!isInputNumValid(itemIndexString,0,game.getPlayer().getItems().size()-1));
		if (usingItem) {
			int itemIndex = Integer.parseInt(itemIndexString);
			useItem(itemIndex);
		}else {
			gameLoop();
		}
	}
	
	/**
	 * Displays a list of the user player's items and monsters and lets them pick one to sell.
	 * The player sells an item by entering its Id number.
	 * The player can return to shop without selling by pressing enter with no input.
	 */
	public void sellShop() {
		System.out.println("\nHi "+game.getPlayer().getName()+".");
		System.out.println("Welcome to the sell shop. You have "+game.getPlayer().getGold()+" gold.");
		System.out.println("Below is a list of all your items and monsters with their number above.");
		System.out.println("Enter below the number of the item or monster you wish to sell.");
		displayInventory();
		int itemsAmount = game.getPlayer().getItems().size();
		int monstersAmount = game.getPlayer().getSquad().getMonsters().size();
		for (int i = 0; i < monstersAmount; i++) {
			System.out.println();
			System.out.println(i+itemsAmount);
			System.out.println(game.getPlayer().getSquad().getMonsters().get(i));
		}
		String sellIndexString;
		boolean selling = true;
		do {
			System.out.print("\nEnter the number of the item/monster to sell."
							 + "\nleave blank to return to main shop: ");
			sellIndexString = scanner.nextLine();
			if (sellIndexString == ""){
				selling = false;
				break;	
			}
		}while(!isInputNumValid(sellIndexString,0,itemsAmount+monstersAmount-1));
		if (selling) {
			int sellIndex = Integer.parseInt(sellIndexString);
			if (sellIndex < itemsAmount) {
				game.getShop().sellItem(sellIndex);
				System.out.println("Sold successfully!");
			}else {
				if (monstersAmount > 1) {
					game.getShop().sellMonster(sellIndex-itemsAmount);
					System.out.println("Sold successfully!");
				}else {
					System.out.println("Cannot sell last monster!");
				}
			}
		}
		visitShop();
	}
	
	public void displayMonsterStock() {
		for (int i = 0; i < game.getShop().getMonsters().size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println("Price: "+game.getShop().getMonsters().get(i).getPurchasePrice());
			System.out.println(game.getShop().getMonsters().get(i));
		}
	}
	
	public void monsterShop(){
		System.out.println("Welcome to the monster shop");
		displayMonsterStock();
		String monsterIndexString;
		boolean buying = true;
		do {
			System.out.print("\nEnter the number of the monster to buy."
							 + "\nleave blank to return to buy shop: ");
			monsterIndexString = scanner.nextLine();
			if (monsterIndexString == ""){
				buying = false;
				break;	
			}
		}while(!isInputNumValid(monsterIndexString,0,game.getShop().getMonsters().size()-1));
		if (buying) {
			int monsterIndex = Integer.parseInt(monsterIndexString);
			int squadSize = game.getPlayer().getSquad().getMonsters().size();
			int monsterPrice = game.getShop().getMonsters().get(monsterIndex).getPurchasePrice();
			int playerGold = game.getPlayer().getGold();
			if ( squadSize < 5 && playerGold >= monsterPrice) {
				game.getShop().purchaseMonster(monsterIndex);
				System.out.println("Bought successfully!");
				pickMonsterName(game.getPlayer().getSquad().getMonsters().get(squadSize));
			}else if (squadSize < 5 && playerGold < monsterPrice) {
				System.out.println("Not enough gold!");
			}else {
				System.out.println("Cannot own more than 4 monsters!");
			}
		}
		buyShop();
	}
	
	public void itemShop() {
		
	}
	
	public void buyShop() {
		String shopTypeIndexString;
		boolean enterShop = true;
		do {
			System.out.print("\nEnter 0 to browse monsters and 1 for items."
							 + "\nleave blank to return to main shop: ");
			shopTypeIndexString = scanner.nextLine();
			if (shopTypeIndexString == ""){
				enterShop = false;
				break;	
			}
		}while(!isInputNumValid(shopTypeIndexString,0,1));
		if (enterShop) {
			int sellIndex = Integer.parseInt(shopTypeIndexString);
			if(sellIndex == 0) {
				monsterShop();
			}else {
				itemShop();
			}
		}
		visitShop();
	}
	
	public void visitShop() {
		System.out.println("\nHi "+game.getPlayer().getName()+".");
		System.out.println("Welcome to the shop. You have "+game.getPlayer().getGold()+" gold.");
		String shopChoiceString;
		boolean enteringShop = true;
		do {
			System.out.println("Enter 0 to sell back to the shop or 1 to buy from the shop");
			System.out.print("(or enter nothing to return to main menu): ");
			shopChoiceString = scanner.nextLine();
			if (shopChoiceString == ""){
				enteringShop = false;
				break;	
			}
		}while(!isInputNumValid(shopChoiceString,0,1));
		if (enteringShop) {
			int shopIndex = Integer.parseInt(shopChoiceString);
			switch(shopIndex) {
				case 0:
					sellShop();
				case 1:
					buyShop();
				default:
					visitShop();
			}
		}else {
			gameLoop();
		}
	}
	
	public void enterArena() {
		
	}
	
	public void sleep() {
		
	}
	
	/**
	 * The main loop of the game UI.
	 * Displays the game day and player's gold to the user and then displays all of the available daily options to the user.
	 * Reads and parses input from the player to decide which UI to call based on what option the user chooses.
	 */
	public void gameLoop() {
		System.out.println("\nDay: "+game.getDay()+"/"+game.getMaxDays()+
						   "\nGold: "+game.getPlayer().getGold());
		String inputOptionString;
		displayDailyOptions();
		do {
			System.out.print("Enter number of chosen option (from 0 to 4): ");
			inputOptionString = scanner.nextLine();
		}while(!isInputNumValid(inputOptionString,0,4));
		int inputOption = Integer.parseInt(inputOptionString);
		switch(inputOption) {
			case 0:
				viewSquad();
				break;
			case 1:
				viewInventory();
				break;
			case 2:
				visitShop();
				break;
			case 3:
				enterArena();
				break;
			case 4:
				sleep();
				break;
			default:
				gameLoop();
		}
	}

	/**
	 * The main method to create and launch the game from the command line interface.
	 * @param args the string command line arguments
	 **/
	public static void main(String[] args) {
		CommandLineUI ui = new CommandLineUI();
		ui.setup();

	}
}
