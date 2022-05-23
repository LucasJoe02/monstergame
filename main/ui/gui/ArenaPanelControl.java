package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.monster.Monster;
import main.monster.Squad;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;

/**
 * This class implements a controller for a
 * JPanel that shows the arena screen for the
 * game GUI.
 * This class builds the JPanel as well as handles
 * the methods that the JPanel needs to receive
 * input and display output.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class ArenaPanelControl implements PanelControl{
	
	/**
	 * The JPanel that this ArenaPanelControl implements.
	 */
	private JPanel arenaPanel;
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
	 * The JLabel that displays the output of a battle.
	 */
	private JLabel battleOutputLabel;

	/**
	 * The constructor that takes in the GraphicalUI class
	 * and sets up a new JPanel for visiting the arena.
	 * @param gui the GraphicalUI that holds the GUI frame.
	 */
	public ArenaPanelControl(GraphicalUI gui) {
		arenaPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	/**
	 * Takes an ArrayList of enemies and returns an array of their
	 * names, and their reward.
	 * @param enemies the ArrayList of Enemy objects
	 * @return the array of Strings of the enemies names and rewards
	 */
	public String[] enemyNameList(ArrayList<Enemy> enemies) {
		String[] enemyNames = new String[enemies.size()];
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemyNames[i] = enemy.getName()+".     Reward: "
							+enemy.getGold()+" gold, "
							+enemy.getPoints()+" points";
		}
		return enemyNames;
	}
	
	/**
	 * Takes an ArrayList of monsters and returns them as an array of
	 * their String descriptions.
	 * @param monsters the ArrayList of Monster objects.
	 * @return the array of strings describing each monster
	 */
	public String[] enemySquadList(ArrayList<Monster> monsters) {
		String[] squadDesc = new String[monsters.size()];
		for (int i = 0; i < monsters.size(); i++) {
			squadDesc[i] = monsters.get(i).toStringHTML();
		}
		return squadDesc;
	}
	
	@Override
	public void build() {
		
		ArrayList<Enemy> enemiesList = game.getArena().getEnemies();
		
		JLabel titleLabel = new JLabel("Arena");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 157, 14);
		arenaPanel.add(titleLabel);
		arenaPanel.setLayout(null);
		
		String[] enemyNames = enemyNameList(enemiesList);
		JList enemyNameList = new JList(enemyNames);
		enemyNameList.setBounds(10, 80, 381, 53);
		arenaPanel.add(enemyNameList);
		
		JButton menuButton = new JButton("Main Menu");
		menuButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				arenaPanel.setVisible(false);
				gui.getMenuPanel().setVisible(true);
			}
		});
		menuButton.setBounds(463, 350, 127, 23);
		arenaPanel.add(menuButton);
		
		JButton battleButton = new JButton("Fight Selected Enemy");
		battleButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int selectedEnemyIndex = enemyNameList.getSelectedIndex();
				Squad playerSquad = game.getPlayer().getSquad();
				boolean squadFainted = playerSquad.getMonsters().get(playerSquad.getMonsters().size()-1).getIsFainted();
				if (selectedEnemyIndex >= 0  && !squadFainted) {
					String output = game.getArena().battle(selectedEnemyIndex);
					arenaPanel.setVisible(false);
					gui.getArenaPanel().setVisible(true);
					battleOutputLabel.setText("<html>"+output);
				}else if(squadFainted){
					errorLabel.setText("Cannot fight enemy if all of your monsters are fainted");
				}else {
					errorLabel.setText("An enemy must be selected");
				}
			}
		});
		battleButton.setBounds(10, 178, 302, 23);
		arenaPanel.add(battleButton);
		
		JLabel instructLabel = new JLabel("Select an enemy to fight");
		instructLabel.setBounds(10, 36, 236, 14);
		arenaPanel.add(instructLabel);
		
		JLabel enemiesLabel = new JLabel("Enemies");
		enemiesLabel.setBounds(10, 61, 146, 14);
		arenaPanel.add(enemiesLabel);
		
		errorLabel = new JLabel("");
		errorLabel.setForeground(Color.RED);
		errorLabel.setBounds(10, 350, 454, 23);
		arenaPanel.add(errorLabel);

		JButton viewSquadButton = new JButton("View Selected Enemy Squad");
		viewSquadButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (enemyNameList.getSelectedIndex() >= 0) {
					Enemy enemy = game.getArena().getEnemies().get(enemyNameList.getSelectedIndex());
					ArrayList<Monster> monsters = enemy.getSquad().getMonsters();
					String[] enemySquadDetails = enemySquadList(monsters);
					JOptionPane.showMessageDialog(gui.getFrame(), enemySquadDetails);
				}else {
					errorLabel.setText("Must select an enemy to view squad");
				}
			}
		});
		viewSquadButton.setBounds(10, 144, 302, 23);
		arenaPanel.add(viewSquadButton);
		
		JLabel battleResultsLabel = new JLabel("Battle Results:");
		battleResultsLabel.setBounds(10, 211, 201, 14);
		arenaPanel.add(battleResultsLabel);
		
		battleOutputLabel = new JLabel("");
		battleOutputLabel.setVerticalAlignment(SwingConstants.TOP);
		battleOutputLabel.setBounds(10, 236, 580, 102);
		arenaPanel.add(battleOutputLabel);
	}
	
	@Override
	public JPanel getPanel() {
		return arenaPanel;
	}
}
