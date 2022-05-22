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

public class SquadPanelControl implements PanelControl{
	
	private JPanel squadPanel;
	private GraphicalUI gui;
	private GameEnvironment game;

	public SquadPanelControl(GraphicalUI gui) {
		squadPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	@Override
	public void build() {
		JLabel titleLabel = new JLabel("Your Squad");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		squadPanel.add(titleLabel);
		squadPanel.setLayout(null);	
		
		JButton btnNewButton = new JButton("Main Menu");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				squadPanel.setVisible(false);
				gui.getMenuPanel().setVisible(true);
			}
		});
		btnNewButton.setBounds(463, 350, 127, 23);
		squadPanel.add(btnNewButton);
		
		ArrayList<JLabel> squadLabels = new ArrayList<JLabel>();
		
		JLabel squadMons0 = new JLabel((String) null);
		squadMons0.setVerticalAlignment(SwingConstants.TOP);
		squadMons0.setHorizontalAlignment(SwingConstants.CENTER);
		squadMons0.setBounds(10, 36, 179, 138);
		squadLabels.add(squadMons0);
		squadPanel.add(squadMons0);
		
		JLabel squadMons1 = new JLabel((String) null);
		squadMons1.setVerticalAlignment(SwingConstants.TOP);
		squadMons1.setHorizontalAlignment(SwingConstants.CENTER);
		squadMons1.setBounds(199, 36, 179, 138);
		squadLabels.add(squadMons1);
		squadPanel.add(squadMons1);
		
		JLabel squadMons2 = new JLabel((String) null);
		squadMons2.setVerticalAlignment(SwingConstants.TOP);
		squadMons2.setHorizontalAlignment(SwingConstants.CENTER);
		squadMons2.setBounds(10, 185, 179, 138);
		squadLabels.add(squadMons2);
		squadPanel.add(squadMons2);
		
		JLabel squadMons3 = new JLabel((String) null);
		squadMons3.setVerticalAlignment(SwingConstants.TOP);
		squadMons3.setHorizontalAlignment(SwingConstants.CENTER);
		squadMons3.setBounds(199, 185, 179, 138);
		squadLabels.add(squadMons3);
		squadPanel.add(squadMons3);
		
		ArrayList<Monster> monsters = game.getPlayer().getSquad().getMonsters();
		for (int i = 0; i < monsters.size(); i++) {
			squadLabels.get(i).setText(monsters.get(i).toStringHTML());
		}
	}
	
	@Override
	public JPanel getPanel() {
		return squadPanel;
	}
}
