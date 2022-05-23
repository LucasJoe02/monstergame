package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.environment.GameEnvironment;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * This class implements a controller for a
 * JPanel that shows the main menu screen for the
 * game GUI.
 * This class builds the JPanel as well as handles
 * the methods that the JPanel needs to receive
 * input and display output.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class MenuPanelControl implements PanelControl{
	
	/**
	 * The JPanel that this MenuPanelControl implements.
	 */
	private JPanel menuPanel;
	/**
	 * The GraphicalUI that holds the gui frame and switching between panels.
	 */
	private GraphicalUI gui;
	/**
	 * The GameEnvironment of the currently running game.
	 */
	private GameEnvironment game;

	/**
	 * The constructor that takes in the GraphicalUI class
	 * and sets up a new JPanel for a game's main menu.
	 * @param gui the GraphicalUI that holds the GUI frame.
	 */
	public MenuPanelControl(GraphicalUI gui) {
		menuPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	@Override
	public void build() {
		JLabel titleLabel = new JLabel("Main Menu");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		menuPanel.add(titleLabel);
		menuPanel.setLayout(null);
		
		JButton shopButton = new JButton("Visit Shop");
		shopButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				gui.getShopPanel().setVisible(true);
			}
		});
		shopButton.setBounds(10, 243, 135, 55);
		menuPanel.add(shopButton);
		
		JButton inventoryButton = new JButton("View Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				gui.getInventoryPanel().setVisible(true);
			}
		});
		inventoryButton.setBounds(10, 177, 135, 55);
		menuPanel.add(inventoryButton);
		
		JButton squadButton = new JButton("View Squad");
		squadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				gui.getSquadPanel().setVisible(true);
			}
		});
		squadButton.setBounds(10, 111, 135, 55);
		menuPanel.add(squadButton);
		
		JButton arenaButton = new JButton("Enter Arena");
		arenaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				menuPanel.setVisible(false);
				gui.getArenaPanel().setVisible(true);
			}
		});
		arenaButton.setBounds(10, 309, 135, 55);
		menuPanel.add(arenaButton);
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nightEvents = game.sleep();
				if (nightEvents == "") {
					nightEvents = "Twas a peaceful night";
				}
				if (game.getDay() <= game.getMaxDays()) {
					menuPanel.setVisible(false);
					gui.getMenuPanel().setVisible(true);
					JOptionPane.showMessageDialog(gui.getFrame(),"<html>"+nightEvents);
				}else {
					menuPanel.setVisible(false);
					gui.getGameOverPanel().setVisible(true);
				}
			}
		});
		sleepButton.setBounds(463, 350, 127, 23);
		menuPanel.add(sleepButton);
		
		JLabel nameLabel = new JLabel(game.getPlayer().getName());
		nameLabel.setHorizontalAlignment(SwingConstants.LEFT);
		nameLabel.setBounds(20, 36, 157, 14);
		menuPanel.add(nameLabel);
		
		JLabel dayLabel = new JLabel("Day: "+game.getDay()+"/"+game.getMaxDays());
		dayLabel.setBounds(20, 61, 147, 14);
		menuPanel.add(dayLabel);
		
		JLabel goldLabel = new JLabel("Gold: "+game.getPlayer().getGold());
		goldLabel.setBounds(20, 86, 147, 14);
		menuPanel.add(goldLabel);
	}
	
	@Override
	public JPanel getPanel() {
		return menuPanel;
	}

}
