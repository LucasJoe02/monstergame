package main.ui.gui;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.environment.GameEnvironment;

import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;


public class GameOverPanelControl implements PanelControl{
	
	private JPanel gamOverPanel;
	private GraphicalUI gui;
	private GameEnvironment game;

	public GameOverPanelControl(GraphicalUI gui) {
		gamOverPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	@Override
	public void build() {
		JLabel titleLabel = new JLabel("Game Over "+game.getPlayer().getName()+", Game Over");
		titleLabel.setHorizontalAlignment(SwingConstants.CENTER);
		titleLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		titleLabel.setBounds(10, 80, 580, 37);
		gamOverPanel.add(titleLabel);
		gamOverPanel.setLayout(null);	
		
		JButton btnNewButton = new JButton("Restart");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				gui.restart();
//				gamOverPanel.setVisible(false);
//				gui.getSetupPanel().setVisible(true);
			}
		});
		btnNewButton.setBounds(463, 350, 127, 23);
		gamOverPanel.add(btnNewButton);
		
		JLabel pointsLabel = new JLabel("Points: "+game.getPlayer().getPoints());
		pointsLabel.setHorizontalAlignment(SwingConstants.CENTER);
		pointsLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		pointsLabel.setBounds(10, 128, 580, 23);
		gamOverPanel.add(pointsLabel);
		
		JLabel lblNewLabel = new JLabel("<html><center><b>Credits</b><br>Created By<br>Celeste Turnock<br>Lucas Redding");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(20, 162, 570, 177);
		gamOverPanel.add(lblNewLabel);

	}
	
	@Override
	public JPanel getPanel() {
		return gamOverPanel;
	}
}
