package main.ui;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher; 
import java.util.regex.Pattern;

import main.arena.Arena;
import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.monster.Monster;
import main.monster.MonsterCreator;
import main.monster.Squad;

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
	
	/**
	 * Asks the user player to choose the ID of the monster they want to use their item on and then uses it.
	 * Prints a success message when item has been used.
	 * @param itemIndex the integer of the index in the player's inventory of the item to be used.
	 */
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
	
	/**
	 * Displays a string representation of the shop's list of monsters in stock.
	 * The monsters are displayed with their id and price above.
	 * If the shop is empty a print out tells the player.
	 */
	public void displayMonsterStock() {
		for (int i = 0; i < game.getShop().getMonsters().size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println("Price: "+game.getShop().getMonsters().get(i).getPurchasePrice());
			System.out.println(game.getShop().getMonsters().get(i));
		}
		if (game.getShop().getMonsters().size()==0) {
			System.out.println("\nMonster shop is empty.");
		}
	}
	
	/**
	 * Asks the user to input the Id of the monster they wish to buy.
	 * If the player has enough money and their squad is not full then the purchase is successful.
	 * Otherwise an error message is displayed to the player.
	 * Leaving the input blank will return the user to the buy shop.
	 */
	public void monsterShop(){
		System.out.println("Welcome to the monster shop. You have "+game.getPlayer().getGold()+" gold.");
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
	
	/**
	 * Displays a string representation of the shop's list of items in stock.
	 * The items are displayed with their id and price above.
	 * If the shop is empty a print out tells the player.
	 */
	public void displayItemStock(){
		for (int i = 0; i < game.getShop().getItems().size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println("Price: "+game.getShop().getItems().get(i).getPurchasePrice());
			System.out.println(game.getShop().getItems().get(i).getDesc());
		}
		if (game.getShop().getItems().size()==0) {
			System.out.println("\nItem shop is empty.");
		}
	}
	
	/**
	 * Asks the user to input the Id of the item they wish to buy.
	 * If the player has enough money then the purchase is successful.
	 * Otherwise an error message is displayed to the player.
	 * Leaving the input blank will return the user to the buy shop.
	 */
	public void itemShop() {
		System.out.println("Welcome to the item shop. You have "+game.getPlayer().getGold()+" gold.");
		displayItemStock();
		String itemIndexString;
		boolean buying = true;
		do {
			System.out.print("\nEnter the number of the item to buy."
							 + "\nleave blank to return to buy shop: ");
			itemIndexString = scanner.nextLine();
			if (itemIndexString == ""){
				buying = false;
				break;	
			}
		}while(!isInputNumValid(itemIndexString,0,game.getShop().getItems().size()-1));
		if (buying) {
			int itemIndex = Integer.parseInt(itemIndexString);
			int itemPrice = game.getShop().getItems().get(itemIndex).getPurchasePrice();
			int playerGold = game.getPlayer().getGold();
			if (playerGold >= itemPrice) {
				game.getShop().purchaseItem(itemIndex);
				System.out.println("Bought successfully!");	
			}else {
				System.out.println("Not enough gold!");
			}
		}
		buyShop();
	}
	
	/**
	 * Asks the user whether they want to buy items or monsters then displays the corresponding shop UI.
	 * If the input is left blank the user is moved back to the main shop UI.
	 */
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
		}else {
			visitShop();
		}
	}
	
	/**
	 * Asks the player whether they want to sell or buy at the shop, then moves to correct UI.
	 * if the input is left blank the user is moved back to main game loop.
	 */
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
					break;
				case 1:
					buyShop();
					break;
			}
		}else {
			gameLoop();
		}
	}
	
	/**
	 * Display's the squad of the given enemy with the index of each monster in the squad above it.
	 * @param enemy the Enemy that has the squad of monsters to display
	 */
	public void displayEnemySquad(Enemy enemy){
		for (int i = 0; i < enemy.getSquad().getMonsters().size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println(enemy.getSquad().getMonsters().get(i));
		}
	}
	
	/**
	 * Display's an enemy and their squad to the player and lets player choose if they want to fight the enemy.
	 * If the player decides to battle the enemy then a summary of the battle is printed to the player.]
	 * The player cannot fight the enemy if all their monsters are fainted.
	 * @param enemyIndex the integer index of the enemy being displayed in the arena's enemy array
	 */
	public void viewEnemyTeam(int enemyIndex){
		Arena arena = game.getArena();
		Enemy enemy = arena.getEnemies().get(enemyIndex);
		System.out.println("\nEnemy name: "+enemy.getName());
		System.out.println("Enemy squad: ");
		displayEnemySquad(enemy);
		String battleChoiceString;
		do {
			System.out.print("\nEnter 0 to fight enemy or 1 to return to arena: ");
			battleChoiceString = scanner.nextLine();
		}while(!isInputNumValid(battleChoiceString,0,1));
		int battleChoiceInt = Integer.parseInt(battleChoiceString);
		if (battleChoiceInt == 0) {
			Squad playerSquad = game.getPlayer().getSquad();
			if (playerSquad.getMonsters().get(playerSquad.getMonsters().size()-1).getIsFainted()==false) {
				System.out.println("\n"+arena.battle(enemyIndex));
			}else {
				System.out.println("\nCannot fight enemy if all your monsters are fainted");
			}
		}
		enterArena();
	}
	
	/**
	 * Displays a list of the available opponents that the player to challenge to a battle.
	 * Below the name of the enemy is the reward in gold and points for defeating them.
	 */
	public void viewOppenents() {
		ArrayList<Enemy> enemyList = game.getArena().getEnemies();
		for (int i = 0; i < enemyList.size(); i++) {
			System.out.println();
			System.out.println(i);
			System.out.println("Name: "+enemyList.get(i).getName());
			System.out.println("Reward: "+enemyList.get(i).getGold()+" gold");
			System.out.println("Points: "+enemyList.get(i).getPoints());
		}
		if (enemyList.size()==0) {
			System.out.println("\nArena is empty.");
		}
	}
	
	/**
	 * Displays a list of today's opponents in the arena and gives the player the option to get more information on each.
	 * The player can enter the number of the opponent for more information or leave input blank to return to the main menu.
	 */
	public void enterArena() {
		System.out.println("\nHi "+game.getPlayer().getName()+".");
		System.out.println("Below is a list of today's arena opponents. Each have a number above.");
		System.out.println("Enter the number of the oppenent below to get more information on the battle.");
		viewOppenents();
		
		String enemyIndexString;
		boolean viewingEnemy = true;
		do {
			System.out.println("Enter number of the oppenent you wish to get more information on.");
			System.out.print("(or enter nothing to return to main menu): ");
			enemyIndexString = scanner.nextLine();
			if (enemyIndexString == ""){
				viewingEnemy = false;
				break;	
			}
		}while(!isInputNumValid(enemyIndexString,0,game.getArena().getEnemies().size()-1));
		if (viewingEnemy) {
			int enemyIndex = Integer.parseInt(enemyIndexString);
			viewEnemyTeam(enemyIndex);
		}else {
			gameLoop();
		}

	}
	
	/**
	 * Displays an end screen to the player with their name and score in points.
	 */
	public void endScreen() {
		System.out.println("\nGame over "+game.getPlayer().getName()+", game over.");
		System.out.println("Points: "+game.getPlayer().getPoints());
	}
	
	/**
	 * Calls the sleep method from the game environment and prints out the night events.
	 * If the the game is complete (all days have passed) the end screen is called.
	 * Otherwise the player is returned to the main menu.
	 */
	public void sleep() {
		System.out.println();
		System.out.println(game.sleep());
		if (game.getDay() <= game.getMaxDays()) {
			gameLoop();
		}else {
			endScreen();
		}
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
				break;
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
