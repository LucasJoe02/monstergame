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
 * JPanel that shows the sell shop screen for the
 * game GUI.
 * This class builds the JPanel as well as handles
 * the methods that the JPanel needs to receive
 * input and display output.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class SellShopPanelControl implements PanelControl{

	/**
	 * The JPanel that this SellShopPanelControl implements.
	 */
	private JPanel sellShopPanel;
	/**
	 * The GraphicalUI that holds the gui frame and switching between panels.
	 */
	private GraphicalUI gui;
	/**
	 * The GameEnvironment of the currently running game.
	 */
	private GameEnvironment game;
	/**
	 * The JLabel that displays error messages in the sell shop.
	 */
	private JLabel errorLabel;

	/**
	 * The constructor that takes in the GraphicalUI class
	 * and sets up a new JPanel for viewing the sell shop.
	 * @param gui the GraphicalUI that holds the GUI frame.
	 */
	public SellShopPanelControl(GraphicalUI gui) {
		sellShopPanel = new JPanel();
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
		sellShopPanel.add(titleLabel);
		sellShopPanel.setLayout(null);
		
		JLabel goldLabel = new JLabel("Gold: "+game.getPlayer().getGold());
		goldLabel.setBounds(463, 11, 127, 14);
		sellShopPanel.add(goldLabel);
		
		String[] itemNames = gui.itemNameList(itemsList);
		JList itemsNameList = new JList(itemNames);
		itemsNameList.setBounds(10, 80, 146, 259);
		sellShopPanel.add(itemsNameList);
		
		String[] monsterNames = gui.monsterNameList(monsList);
		JList monsNameList = new JList(monsterNames);
		monsNameList.setBounds(191, 80, 146, 259);
		sellShopPanel.add(monsNameList);
		
		JButton menuButton = new JButton("Main Menu");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sellShopPanel.setVisible(false);
				gui.getMenuPanel().setVisible(true);
			}
		});
		menuButton.setBounds(463, 350, 127, 23);
		sellShopPanel.add(menuButton);
		
		JButton sellItemButton = new JButton("Sell Selected Item");
		sellItemButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedItemIndex = itemsNameList.getSelectedIndex();
				if (selectedItemIndex >= 0) {
					game.getShop().sellItem(selectedItemIndex);
					sellShopPanel.setVisible(false);
					gui.getSellShopPanel().setVisible(true);
				}else {
					errorLabel.setText("Select an item to sell");
				}
			}
		});
		sellItemButton.setBounds(10, 350, 171, 23);
		sellShopPanel.add(sellItemButton);
		
		JButton sellMonsterButton = new JButton("Sell Selected Monster");
		sellMonsterButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedMonsIndex = monsNameList.getSelectedIndex();
				int monstersAmount = game.getPlayer().getSquad().getMonsters().size();
				if (selectedMonsIndex >= 0 && monstersAmount > 1) {
					game.getShop().sellMonster(selectedMonsIndex);
					sellShopPanel.setVisible(false);
					gui.getSellShopPanel().setVisible(true);
				}else if (selectedMonsIndex >= 0){
					errorLabel.setText("Cannot sell last monster");
				}else {
					errorLabel.setText("Select a monster to sell");
				}
			}
		});
		sellMonsterButton.setBounds(191, 350, 171, 23);
		sellShopPanel.add(sellMonsterButton);
		
		JLabel instructLabel = new JLabel("Select an item or monster to sell");
		instructLabel.setBounds(10, 36, 236, 14);
		sellShopPanel.add(instructLabel);
		
		JLabel itemsLabel = new JLabel("Items");
		itemsLabel.setBounds(10, 61, 146, 14);
		sellShopPanel.add(itemsLabel);
		
		JLabel monsLabel = new JLabel("Monsters");
		monsLabel.setBounds(191, 61, 146, 14);
		sellShopPanel.add(monsLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(347, 80, 243, 14);
		sellShopPanel.add(errorLabel);
		
	}
	
	@Override
	public JPanel getPanel() {
		return sellShopPanel;
	}
}
