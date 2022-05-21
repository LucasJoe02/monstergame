package main.ui.gui;

import javax.swing.JLabel;
import javax.swing.JPanel;

import main.environment.GameEnvironment;

import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class MenuPanelControl implements PanelControl{
	
	private JPanel menuPanel;
	private GraphicalUI gui;
	private GameEnvironment game;

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
			}
		});
		shopButton.setBounds(10, 243, 135, 55);
		menuPanel.add(shopButton);
		
		JButton inventoryButton = new JButton("View Inventory");
		inventoryButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
			}
		});
		arenaButton.setBounds(10, 309, 135, 55);
		menuPanel.add(arenaButton);
		
		JButton sleepButton = new JButton("Sleep");
		sleepButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		sleepButton.setBounds(463, 350, 127, 23);
		menuPanel.add(sleepButton);
		
		JLabel lblNewLabel = new JLabel(game.getPlayer().getName());
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(20, 36, 157, 14);
		menuPanel.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Day: "+game.getDay()+"/"+game.getMaxDays());
		lblNewLabel_1.setBounds(20, 61, 147, 14);
		menuPanel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Gold: "+game.getPlayer().getGold());
		lblNewLabel_1_1.setBounds(20, 86, 147, 14);
		menuPanel.add(lblNewLabel_1_1);
	}
	
	@Override
	public JPanel getPanel() {
		return menuPanel;
	}

}
