package Test.player;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import main.environment.GameEnvironment;
import main.item.Item;
import main.item.ItemHeal;
import main.monster.Monster;
import main.player.Player;

class PlayerTest {


		
	
	
	@Test
	public void sellItemTest() {
		
		Player user = new Player();
		Item item = new ItemHeal();
		user.addItem(item);
		user.sellItem(0);
		assertEquals(0, user.getItems().size());
	}
	
	@Test
	public void itemsStringTest() {
		Player user = new Player();
		Item item = new ItemHeal();
		user.addItem(item);
		ArrayList<Item> items = user.getItems();
		String itemsString = new String();
		for (int index = 0; index < items.size(); index++) {
			itemsString += index+". "+items.get(index).getName()+"\n";
		}
		String testString = user.itemsString();
		assertEquals(itemsString, testString);
	}
}
