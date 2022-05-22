package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTable;

import main.environment.GameEnvironment;
import main.item.Item;
import main.monster.Monster;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class SellShopPanelControl implements PanelControl{
	
	private JPanel sellShopPanel;
	private GraphicalUI gui;
	private GameEnvironment game;
	private JLabel errorLabel;

	public SellShopPanelControl(GraphicalUI gui) {
		sellShopPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	public String[] itemNameList(ArrayList<Item> items) {
		String[] itemNames = new String[items.size()];
		for (int i = 0; i < items.size(); i++) {
			itemNames[i] = items.get(i).getName();
		}
		return itemNames;
	}
	
	public String[] monsterNameList(ArrayList<Monster> monsters) {
		String[] monsNames = new String[monsters.size()];
		for (int i = 0; i < monsters.size(); i++) {
			monsNames[i] = monsters.get(i).getName();
		}
		return monsNames;
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
		
		String[] itemNames = itemNameList(itemsList);
		JList itemsNameList = new JList(itemNames);
		itemsNameList.setBounds(10, 80, 146, 259);
		sellShopPanel.add(itemsNameList);
		
		String[] monsterNames = monsterNameList(monsList);
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
