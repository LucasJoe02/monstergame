package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;

import main.environment.GameEnvironment;
import main.item.Item;
import main.monster.Monster;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

/**
 * This class implements a controller for a
 * JPanel that shows the main inventory screen for the
 * game GUI.
 * This class builds the JPanel as well as handles
 * the methods that the JPanel needs to receive
 * input and display output.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class InventoryPanelControl implements PanelControl{
	
	/**
	 * The JPanel that this InventoryPanelControl implements.
	 */
	private JPanel inventoryPanel;
	/**
	 * The GraphicalUI that holds the gui frame and switching between panels.
	 */
	private GraphicalUI gui;
	/**
	 * The GameEnvironment of the currently running game.
	 */
	private GameEnvironment game;
	/**
	 * The JLabel that displays error messages in the inventory.
	 */
	private JLabel errorLabel;

	/**
	 * The constructor that takes in the GraphicalUI class
	 * and sets up a new JPanel for viewing the inventory.
	 * @param gui the GraphicalUI that holds the GUI frame.
	 */
	public InventoryPanelControl(GraphicalUI gui) {
		inventoryPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	@Override
	public void build() {
		
		ArrayList<Item> itemsList = game.getPlayer().getItems();
		ArrayList<Monster> monsList = game.getPlayer().getSquad().getMonsters();
		
		JLabel titleLabel = new JLabel("Your Inventory");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		inventoryPanel.add(titleLabel);
		inventoryPanel.setLayout(null);
		
		String[] itemNames = gui.itemNameList(itemsList);
		JList itemsNameList = new JList(itemNames);
		itemsNameList.setBounds(10, 80, 146, 293);
		inventoryPanel.add(itemsNameList);
		
		String[] monsterNames = gui.monsterNameList(monsList);
		JList monsNameList = new JList(monsterNames);
		monsNameList.setBounds(166, 80, 146, 293);
		inventoryPanel.add(monsNameList);
		
		JButton menuButton = new JButton("Main Menu");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventoryPanel.setVisible(false);
				gui.getMenuPanel().setVisible(true);
			}
		});
		menuButton.setBounds(463, 350, 127, 23);
		inventoryPanel.add(menuButton);
		
		JButton useItemButton = new JButton("Use Selected Item");
		useItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItemIndex = itemsNameList.getSelectedIndex();
				int selectedMonsIndex = monsNameList.getSelectedIndex();
				if (selectedItemIndex >= 0 && selectedMonsIndex >= 0) {
					game.useItemOnMonster(selectedItemIndex, selectedMonsIndex);
					inventoryPanel.setVisible(false);
					gui.getInventoryPanel().setVisible(true);
				}else {
					errorLabel.setText("Select both an item and a monster");
				}
			}
		});
		useItemButton.setBounds(322, 57, 171, 23);
		inventoryPanel.add(useItemButton);
		
		JLabel instructLabel = new JLabel("Select an item and a monster to use it on.");
		instructLabel.setBounds(10, 36, 236, 14);
		inventoryPanel.add(instructLabel);
		
		JLabel itemsLabel = new JLabel("Items");
		itemsLabel.setBounds(10, 61, 146, 14);
		inventoryPanel.add(itemsLabel);
		
		JLabel monsLabel = new JLabel("Monsters");
		monsLabel.setBounds(166, 61, 146, 14);
		inventoryPanel.add(monsLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(322, 91, 268, 14);
		inventoryPanel.add(errorLabel);
	}
	
	@Override
	public JPanel getPanel() {
		return inventoryPanel;
	}
}
