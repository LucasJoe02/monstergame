package main.ui.gui;


import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import main.environment.GameEnvironment;

import java.awt.Font;


import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

/**
 * This class implements a controller for a
 * JPanel that shows the game over screen for the
 * game GUI.
 * This class builds the JPanel as well as handles
 * the methods that the JPanel needs to receive
 * input and display output.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class GameOverPanelControl implements PanelControl{

	/**
	 * The JPanel that this GameOverPanelControl implements.
	 */
	private JPanel gamOverPanel;
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
	 * and sets up a new JPanel for the game over screen.
	 * @param gui the GraphicalUI that holds the GUI frame.
	 */
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
