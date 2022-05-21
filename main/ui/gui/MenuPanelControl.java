package main.ui.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.environment.GameEnvironment;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MenuPanelControl {
	
	private JPanel menuPanel;
	private GraphicalUI gui;
	private GameEnvironment game;

	public MenuPanelControl(GraphicalUI gui) {
		menuPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	private void build() {
		JLabel titleLabel = new JLabel("Main Menu");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		menuPanel.add(titleLabel);
		menuPanel.setLayout(null);
		
		JButton shopButton = new JButton("Visit Shop");
		shopButton.setBounds(10, 160, 135, 55);
		menuPanel.add(shopButton);
		
		JButton inventoryButton = new JButton("View Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		inventoryButton.setBounds(10, 94, 135, 55);
		menuPanel.add(inventoryButton);
		
		JButton squadButton = new JButton("View Squad");
		squadButton.setBounds(10, 28, 135, 55);
		menuPanel.add(squadButton);
		
		JButton arenaButton = new JButton("Enter Arena");
		arenaButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		arenaButton.setBounds(10, 226, 135, 55);
		menuPanel.add(arenaButton);
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.setBounds(351, 266, 89, 23);
		menuPanel.add(sleepButton);
	}
	
	public JPanel getPanel() {
		return menuPanel;
	}

}
