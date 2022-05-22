package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.environment.GameEnvironment;
import main.item.Item;
import main.monster.Monster;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;
import java.awt.Color;

public class ShopPanelControl implements PanelControl{
	
	private JPanel shopPanel;
	private JLabel errorLabel;
	private GraphicalUI gui;
	private GameEnvironment game;

	public ShopPanelControl(GraphicalUI gui) {
		shopPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	public void buyMons(int monsIndex) {
		int squadSize = game.getPlayer().getSquad().getMonsters().size();
		int monsterPrice = game.getShop().getMonsters().get(monsIndex).getPurchasePrice();
		int playerGold = game.getPlayer().getGold();
		if ( squadSize < 5 && playerGold >= monsterPrice) {
			game.getShop().purchaseMonster(monsIndex);
			gui.pickMonsterName(game.getPlayer().getSquad().getMonsters().get(squadSize));
			shopPanel.setVisible(false);
			gui.getShopPanel().setVisible(true);
			errorLabel.setText("");
		}else if(playerGold < monsterPrice){
			errorLabel.setText("Not enough gold!");
		}else {
			errorLabel.setText("Cannot own more than 4 monsters!");
		}
	}
	
	public void buyItem(int itemIndex) {
		int itemPrice = game.getShop().getItems().get(itemIndex).getPurchasePrice();
		int playerGold = game.getPlayer().getGold();
		if (playerGold >= itemPrice) {
			game.getShop().purchaseItem(itemIndex);
			shopPanel.setVisible(false);
			gui.getShopPanel().setVisible(true);
		}else {
			errorLabel.setText("Not enough gold!");
		}
	}
	
	@Override
	public void build() {
		JLabel titleLabel = new JLabel("Shop");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		shopPanel.add(titleLabel);
		shopPanel.setLayout(null);	
		
		JLabel goldLabel = new JLabel("Gold: "+game.getPlayer().getGold());
		goldLabel.setBounds(463, 11, 127, 14);
		shopPanel.add(goldLabel);
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopPanel.setVisible(false);
				gui.getMenuPanel().setVisible(true);
			}
		});
		btnNewButton.setBounds(463, 350, 127, 23);
		shopPanel.add(btnNewButton);
		
		ArrayList<JLabel> monsLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> monsPriceLabels = new ArrayList<JLabel>();
		ArrayList<JButton> monsButtons = new ArrayList<JButton>();
		
		ArrayList<JLabel> itemLabels = new ArrayList<JLabel>();
		ArrayList<JLabel> itemPriceLabels = new ArrayList<JLabel>();
		ArrayList<JButton> itemButtons = new ArrayList<JButton>();
		
		JLabel shopMons0Label = new JLabel((String) null);
		shopMons0Label.setBorder(new LineBorder(Color.BLACK, 1, true));
		shopMons0Label.setVerticalAlignment(SwingConstants.TOP);
		shopMons0Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopMons0Label.setBounds(10, 44, 179, 130);
		monsLabels.add(shopMons0Label);
		shopPanel.add(shopMons0Label);
		
		JLabel monsPrice0Label = new JLabel("Price:");
		monsPrice0Label.setBounds(10, 173, 80, 23);
		monsPriceLabels.add(monsPrice0Label);
		shopPanel.add(monsPrice0Label);
		
		JButton buyMons0Button = new JButton("Purchase");
		buyMons0Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyMons(0);
			}
		});
		buyMons0Button.setBounds(100, 173, 89, 23);
		monsButtons.add(buyMons0Button);
		buyMons0Button.setVisible(false);
		shopPanel.add(buyMons0Button);
		
		JLabel shopMons1Label = new JLabel((String) null);
		shopMons1Label.setBorder(new LineBorder(Color.BLACK, 1, true));
		shopMons1Label.setVerticalAlignment(SwingConstants.TOP);
		shopMons1Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopMons1Label.setBounds(199, 44, 179, 130);
		monsLabels.add(shopMons1Label);
		shopPanel.add(shopMons1Label);
		
		JLabel monsPrice1Label = new JLabel("Price:");
		monsPrice1Label.setBounds(199, 173, 80, 23);
		monsPriceLabels.add(monsPrice1Label);
		shopPanel.add(monsPrice1Label);
		
		JButton buyMons1Button = new JButton("Purchase");
		buyMons1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyMons(1);
			}
		});
		buyMons1Button.setBounds(289, 173, 89, 23);
		monsButtons.add(buyMons1Button);
		buyMons1Button.setVisible(false);
		shopPanel.add(buyMons1Button);
		
		JLabel shopMons2Label = new JLabel((String) null);
		shopMons2Label.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		shopMons2Label.setVerticalAlignment(SwingConstants.TOP);
		shopMons2Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopMons2Label.setBounds(388, 44, 179, 130);
		monsLabels.add(shopMons2Label);
		shopPanel.add(shopMons2Label);
		
		JLabel monsPrice2Label = new JLabel("Price:");
		monsPrice2Label.setBounds(388, 173, 80, 23);
		monsPriceLabels.add(monsPrice2Label);
		shopPanel.add(monsPrice2Label);
		
		JButton buyMons2Button = new JButton("Purchase");
		buyMons2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyMons(2);
			}
		});
		buyMons2Button.setBounds(478, 173, 89, 23);
		monsButtons.add(buyMons2Button);
		buyMons2Button.setVisible(false);
		shopPanel.add(buyMons2Button);
		
		JLabel shopItem0Label = new JLabel((String) null);
		shopItem0Label.setFont(new Font("Tahoma", Font.BOLD, 10));
		shopItem0Label.setVerticalAlignment(SwingConstants.TOP);
		shopItem0Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopItem0Label.setBorder(new LineBorder(Color.BLACK, 1, true));
		shopItem0Label.setBounds(10, 219, 133, 86);
		itemLabels.add(shopItem0Label);
		shopPanel.add(shopItem0Label);
		
		JLabel itemPrice0Label = new JLabel("Price:");
		itemPrice0Label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemPrice0Label.setBounds(10, 305, 44, 23);
		itemPriceLabels.add(itemPrice0Label);
		shopPanel.add(itemPrice0Label);
		
		JButton buyItem0Button = new JButton("Purchase");
		buyItem0Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(0);
			}
		});
		buyItem0Button.setBounds(54, 305, 89, 23);
		itemButtons.add(buyItem0Button);
		buyItem0Button.setVisible(false);
		shopPanel.add(buyItem0Button);
		
		JLabel shopItem1Label = new JLabel((String) null);
		shopItem1Label.setFont(new Font("Tahoma", Font.BOLD, 10));
		shopItem1Label.setVerticalAlignment(SwingConstants.TOP);
		shopItem1Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopItem1Label.setBorder(new LineBorder(Color.BLACK, 1, true));
		shopItem1Label.setBounds(153, 219, 133, 86);
		itemLabels.add(shopItem1Label);
		shopPanel.add(shopItem1Label);

		JLabel itemPrice1Label = new JLabel("Price:");
		itemPrice1Label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemPrice1Label.setBounds(153, 305, 44, 23);
		itemPriceLabels.add(itemPrice1Label);
		shopPanel.add(itemPrice1Label);
		
		JButton buyItem1Button = new JButton("Purchase");
		buyItem1Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(1);
			}
		});
		buyItem1Button.setBounds(199, 305, 89, 23);
		itemButtons.add(buyItem1Button);
		buyItem1Button.setVisible(false);
		shopPanel.add(buyItem1Button);
		
		JLabel shopItem2Label = new JLabel((String) null);
		shopItem2Label.setFont(new Font("Tahoma", Font.BOLD, 10));
		shopItem2Label.setVerticalAlignment(SwingConstants.TOP);
		shopItem2Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopItem2Label.setBorder(new LineBorder(Color.BLACK, 1, true));
		shopItem2Label.setBounds(296, 219, 133, 86);
		itemLabels.add(shopItem2Label);
		shopPanel.add(shopItem2Label);

		JLabel itemPrice2Label = new JLabel("Price:");
		itemPrice2Label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemPrice2Label.setBounds(298, 305, 44, 23);
		itemPriceLabels.add(itemPrice2Label);
		shopPanel.add(itemPrice2Label);
		
		JButton buyItem2Button = new JButton("Purchase");
		buyItem2Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(2);
			}
		});
		buyItem2Button.setBounds(340, 305, 89, 23);
		itemButtons.add(buyItem2Button);
		buyItem2Button.setVisible(false);
		shopPanel.add(buyItem2Button);
		
		JLabel shopItem3Label = new JLabel((String) null);
		shopItem3Label.setFont(new Font("Tahoma", Font.BOLD, 10));
		shopItem3Label.setVerticalAlignment(SwingConstants.TOP);
		shopItem3Label.setHorizontalAlignment(SwingConstants.CENTER);
		shopItem3Label.setBorder(new LineBorder(Color.BLACK, 1, true));
		shopItem3Label.setBounds(439, 219, 133, 86);
		itemLabels.add(shopItem3Label);
		shopPanel.add(shopItem3Label);

		JLabel itemPrice3Label = new JLabel("Price:");
		itemPrice3Label.setFont(new Font("Tahoma", Font.PLAIN, 10));
		itemPrice3Label.setBounds(439, 305, 44, 23);
		itemPriceLabels.add(itemPrice3Label);
		shopPanel.add(itemPrice3Label);
		
		JButton buyItem3Button = new JButton("Purchase");
		buyItem3Button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buyItem(3);
			}
		});
		buyItem3Button.setBounds(483, 305, 89, 23);
		itemButtons.add(buyItem3Button);
		buyItem3Button.setVisible(false);
		shopPanel.add(buyItem3Button);
		
		JButton sellShopButton = new JButton("Sell Items");
		sellShopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				shopPanel.setVisible(false);
				gui.getSellShopPanel().setVisible(true);
			}
		});
		sellShopButton.setBounds(10, 350, 127, 23);
		shopPanel.add(sellShopButton);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(147, 354, 302, 14);
		shopPanel.add(errorLabel);
		
		JLabel monsterLabel = new JLabel("Monsters");
		monsterLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		monsterLabel.setBounds(10, 29, 80, 14);
		shopPanel.add(monsterLabel);
		
		JLabel itemLabel = new JLabel("Items");
		itemLabel.setFont(new Font("Tahoma", Font.BOLD, 11));
		itemLabel.setBounds(10, 203, 90, 14);
		shopPanel.add(itemLabel);

		ArrayList<Monster> monsters = game.getShop().getMonsters();
		for (int i = 0; i < monsters.size(); i++) {
			monsLabels.get(i).setText(monsters.get(i).toStringHTML());
			monsPriceLabels.get(i).setText("Price: "+monsters.get(i).getPurchasePrice());
			monsButtons.get(i).setVisible(true);
		}
		
		ArrayList<Item> items = game.getShop().getItems();
		for (int i = 0; i < items.size(); i++) {
			itemLabels.get(i).setText(items.get(i).toStringHTML());
			itemPriceLabels.get(i).setText("Price: "+items.get(i).getPurchasePrice());
			itemButtons.get(i).setVisible(true);
		}
	}
	
	@Override
	public JPanel getPanel() {
		return shopPanel;
	}
}
