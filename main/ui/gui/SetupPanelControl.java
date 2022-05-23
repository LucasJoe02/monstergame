package main.ui.gui;


import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import main.environment.GameEnvironment;
import main.monster.Monster;
import main.monster.MonsterCreator;

import java.awt.Color;

import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

/**
 * This class implements a controller for a
 * JPanel that shows the setup screen for the
 * game GUI.
 * This class builds the JPanel as well as handles
 * the methods that the JPanel needs to receive
 * input and display output.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class SetupPanelControl implements PanelControl{

	/**
	 * The JPanel that this SetupPanelControl implements.
	 */
	private JPanel setupPanel;
	/**
	 * The GraphicalUI that holds the gui frame and switching between panels.
	 */
	private GraphicalUI gui;
	/**
	 * The JLabel showing the title of the panel.
	 */
	private JLabel titleLabel;
	/**
	 * The JLabel asking the user to input a name.
	 */
	private JLabel usernameLabel;
	/**
	 * The JLabel asking for the user to select an amount of days.
	 */
	private JLabel daysLabel;
	/**
	 * The JLabel asking the user to select a difficulty.
	 */
	private JLabel diffLabel;
	/**
	 * The JLabel showing the currently selected difficulty.
	 */
	private JLabel difficultyStatusLabel;
	/**
	 * The JSLider to select the difficulty.
	 */
	private JSlider diffSlider;
	/**
	 * The JLabel asking the player to select a start monster.
	 */
	private JLabel startMonsLabel;
	/**
	 * The JTextField for the user to fill out with their user name.
	 */
	private JTextField usernameField;
	/**
	 * The JLabel showing the currently selected max days.
	 */
	private JLabel maxDaysStatusLabel;
	/**
	 * The JSLider for the user to select the max amount of days.
	 */
	private JSlider daySlider;
	/**
	 * The JLabel that shows an error message if the wrong input
	 * is entered for the user name.
	 */
	private JLabel usernameError;
	/**
	 * The JLabel showing the first available start monster.
	 */
	private JLabel startMonsLabel0;
	/**
	 * The JLabel showing the second available start monster.
	 */
	private JLabel startMonsLabel1;
	/**
	 * The JLabel showing the third available start monster.
	 */
	private JLabel startMonsLabel2;
	/**
	 * The JSLider for the user to choose a start monster.
	 */
	private JSlider monsSlider;
	/**
	 * The ArrayList of available start monsters.
	 */
	private ArrayList<Monster> availableMonsters;
	/**
	 * The GameEnvironment of the currently running game.
	 */
	private GameEnvironment game;
	
	/**
	 * The constructor that takes in the GraphicalUI class
	 * and sets up a new JPanel for setting up a game.
	 * @param gui the GraphicalUI that holds the GUI frame.
	 */
	public SetupPanelControl(GraphicalUI gui) {
		setupPanel = new JPanel();
		this.gui = gui;
		this.game = gui.getGame();
		makeStarterMonsters();
		build();
	}
	
	/**
	 * Checks if a String name is longer than 3, shorter
	 * than 15 and contains no special characters.
	 * @param name the String name that is being checked
	 * @return a boolean value that is true if the name is valid
	 */
	private boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(name);
		boolean valid = false;
		if (!matcher.find() && name.length() <= 15 && name.length() >= 3) {
			valid = true;
		}
		return valid;
	}
	
	/**
	 * Initializes the available monsters list and fills it
	 * with generated common monsters.
	 */
	private void makeStarterMonsters() {
		MonsterCreator monsterCreator = new MonsterCreator();
		availableMonsters = new ArrayList<Monster>();
		for (int i = 0; i < 3; i++) {
			availableMonsters.add(monsterCreator.createCommon());
		}
	}
	
	@Override
	public void build() {
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isValidName(usernameField.getText())) {
					game.setDifficulty(diffSlider.getValue());
					game.setMaxDays(daySlider.getValue());
					Monster chosenMonster = availableMonsters.get(monsSlider.getValue());
					game.setPlayer(usernameField.getText(), chosenMonster);
					int squadSize = game.getPlayer().getSquad().getMonsters().size();
					gui.pickMonsterName(game.getPlayer().getSquad().getMonsters().get(squadSize-1));
					setupPanel.setVisible(false);
					gui.setupGame();
					gui.getMenuPanel().setVisible(true);
				}else {
					usernameError.setText("<html>Username must contain between 3 and 15 characters "
							+ "and must not include numbers or special characters.");
				}
			}
		});
		startButton.setBounds(476, 359, 114, 23);
		setupPanel.add(startButton);
		
		titleLabel = new JLabel("Setup");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 414, 14);
		setupPanel.add(titleLabel);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 36, 102, 14);
		setupPanel.add(usernameLabel);
		
		daysLabel = new JLabel("Days:");
		daysLabel.setBounds(10, 70, 46, 14);
		setupPanel.add(daysLabel);
		
		maxDaysStatusLabel = new JLabel("15");
		maxDaysStatusLabel.setBounds(66, 70, 29, 14);
		setupPanel.add(maxDaysStatusLabel);
		
		diffLabel = new JLabel("Difficulty:");
		diffLabel.setBounds(10, 117, 74, 14);
		setupPanel.add(diffLabel);
		
		difficultyStatusLabel = new JLabel("2");
		difficultyStatusLabel.setBounds(83, 117, 29, 14);
		setupPanel.add(difficultyStatusLabel);
		
		startMonsLabel = new JLabel("Starter Monster:");
		startMonsLabel.setBounds(10, 169, 179, 14);
		setupPanel.add(startMonsLabel);
		
		usernameField = new JTextField();
		usernameField.setBounds(116, 33, 153, 20);
		setupPanel.add(usernameField);
		usernameField.setColumns(10);
		
		daySlider = new JSlider();
		daySlider.setSnapToTicks(true);
		daySlider.setPaintTicks(true);
		daySlider.setMajorTickSpacing(1);
		daySlider.setMinimum(5);
		daySlider.setMaximum(15);
		daySlider.setBounds(116, 70, 153, 23);
		Hashtable<Integer, JLabel> maxDaysLabelTable = 
			      new Hashtable<Integer, JLabel>();
				  for (int i = 5 ; i <= 15 ; i++) {
					  maxDaysLabelTable.put(i, new JLabel(Integer.toString(i)) );
				  }
		daySlider.setLabelTable(maxDaysLabelTable);
		daySlider.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	 maxDaysStatusLabel.setText(""+((JSlider)e.getSource()).getValue());
	         }
		});
		setupPanel.add(daySlider);
		
		diffSlider = new JSlider();
		diffSlider.setPaintTrack(false);
		diffSlider.setMajorTickSpacing(1);
		diffSlider.setMinimum(1);
		diffSlider.setMaximum(2);
		diffSlider.setSnapToTicks(true);
		Hashtable<Integer, JLabel> difficultyLabelTable = 
			      new Hashtable<Integer, JLabel>();
				  difficultyLabelTable.put(1, new JLabel("Easy") );
				  difficultyLabelTable.put(2,new JLabel("Hard") );
		diffSlider.setLabelTable(difficultyLabelTable);
		diffSlider.setPaintTicks(true);
		diffSlider.setBounds(116, 117, 153, 23);
		diffSlider.addChangeListener(new ChangeListener() {
	         public void stateChanged(ChangeEvent e) {
	        	 difficultyStatusLabel.setText(""+((JSlider)e.getSource()).getValue());
	         }
		});
		setupPanel.add(diffSlider);
		
		setupPanel.setLayout(null);
		
		usernameError = new JLabel("");
		usernameError.setHorizontalAlignment(SwingConstants.LEFT);
		usernameError.setVerticalAlignment(SwingConstants.TOP);
		usernameError.setForeground(Color.RED);
		usernameError.setBounds(279, 21, 145, 89);
		setupPanel.add(usernameError);
		
		startMonsLabel0 = new JLabel(availableMonsters.get(0).toStringHTML());
		startMonsLabel0.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		startMonsLabel0.setHorizontalAlignment(SwingConstants.CENTER);
		startMonsLabel0.setVerticalAlignment(SwingConstants.TOP);
		startMonsLabel0.setBounds(10, 210, 179, 138);
		setupPanel.add(startMonsLabel0);
		
		startMonsLabel1 = new JLabel(availableMonsters.get(1).toStringHTML());
		startMonsLabel1.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		startMonsLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		startMonsLabel1.setVerticalAlignment(SwingConstants.TOP);
		startMonsLabel1.setBounds(199, 210, 179, 138);
		setupPanel.add(startMonsLabel1);
		
		startMonsLabel2 = new JLabel(availableMonsters.get(2).toStringHTML());
		startMonsLabel2.setBorder(new LineBorder(new Color(0, 0, 0), 1, true));
		startMonsLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		startMonsLabel2.setVerticalAlignment(SwingConstants.TOP);
		startMonsLabel2.setBounds(388, 210, 179, 138);
		setupPanel.add(startMonsLabel2);
		
		monsSlider = new JSlider();
		monsSlider.setPaintTrack(false);
		monsSlider.setSnapToTicks(true);
		monsSlider.setPaintTicks(true);
		monsSlider.setMaximum(2);
		monsSlider.setMajorTickSpacing(1);
		monsSlider.setBounds(95, 181, 393, 23);
		setupPanel.add(monsSlider);
	}
	
	@Override
	public JPanel getPanel() {
		return setupPanel;
	}
	
}
