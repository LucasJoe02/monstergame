package main.ui.gui;


import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;

import main.arena.Enemy;
import main.environment.GameEnvironment;
import main.item.Item;
import main.monster.Monster;
import main.monster.Squad;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.table.DefaultTableModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Color;

public class ArenaPanelControl implements PanelControl{
	
	private JPanel arenaPanel;
	private GraphicalUI gui;
	private GameEnvironment game;
	private JLabel errorLabel;
//	private JList enemySquadList;
	private JLabel battleOutputLabel;

	public ArenaPanelControl(GraphicalUI gui) {
		arenaPanel = new JPanel();
		this.gui = gui;
		this.game = this.gui.getGame();
		build();
	}
	
	public String[] enemyNameList(ArrayList<Enemy> enemies) {
		String[] enemyNames = new String[enemies.size()];
		for (int i = 0; i < enemies.size(); i++) {
			Enemy enemy = enemies.get(i);
			enemyNames[i] = enemy.getName()+".     Reward: "+enemy.getGold()+" gold, "+enemy.getPoints()+" points";
		}
		return enemyNames;
	}
	
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
		enemyNameList.setBounds(10, 80, 302, 53);
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
					battleOutputLabel.setText(output);
				}else if(squadFainted){
					errorLabel.setText("Cannot fight enemy if all of your monsters are fainted");
				}else {
					errorLabel.setText("An enemy must be selected");
				}
			}
		});
		battleButton.setBounds(10, 178, 211, 23);
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
		viewSquadButton.setBounds(10, 144, 211, 23);
		arenaPanel.add(viewSquadButton);
		
		JLabel battleResultsLabel = new JLabel("Battle Results:");
		battleResultsLabel.setBounds(10, 211, 201, 14);
		arenaPanel.add(battleResultsLabel);
		
		battleOutputLabel = new JLabel("");
		battleOutputLabel.setBounds(10, 236, 580, 23);
		arenaPanel.add(battleOutputLabel);
	}
	
	@Override
	public JPanel getPanel() {
		return arenaPanel;
	}
}
