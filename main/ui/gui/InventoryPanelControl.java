package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JPanel;

import main.environment.GameEnvironment;
import main.monster.Monster;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class InventoryPanelControl implements PanelControl{
	
	private JPanel inventoryPanel;
	private GraphicalUI gui;
	private GameEnvironment game;

	public InventoryPanelControl(GraphicalUI gui) {
		inventoryPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	@Override
	public void build() {
		JLabel titleLabel = new JLabel("Your Inventory");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		inventoryPanel.add(titleLabel);
		inventoryPanel.setLayout(null);	
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				inventoryPanel.setVisible(false);
				gui.getMenuPanel().setVisible(true);
			}
		});
		btnNewButton.setBounds(463, 350, 127, 23);
		inventoryPanel.add(btnNewButton);
	}
	
	@Override
	public JPanel getPanel() {
		return inventoryPanel;
	}
}
