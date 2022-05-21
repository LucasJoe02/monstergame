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

public class SetupPanelControl {

	private JPanel setupPanel;
	private GraphicalUI gui;
	private JLabel titleLabel;
	private JLabel usernameLabel;
	private JLabel daysLabel;
	private JLabel diffLabel;
	private JLabel difficultyStatusLabel;
	private JSlider diffSlider;
	private JLabel startMonsLabel;
	private JTextField usernameField;
	private JLabel maxDaysStatusLabel;
	private JSlider daySlider;
	private JLabel usernameError;
	private JLabel startMonsLabel0;
	private JLabel startMonsLabel1;
	private JLabel startMonsLabel2;
	private JSlider diffSlider_1;
	private ArrayList<Monster> availableMonsters;
	private GameEnvironment game;
	
	public SetupPanelControl(GraphicalUI gui) {
		setupPanel = new JPanel();
		this.gui = gui;
		this.game = gui.getGame();
		makeStarterMonsters();
		build();
	}
	
	private boolean isValidName(String name) {
		Pattern pattern = Pattern.compile("[^a-zA-Z]");
		Matcher matcher = pattern.matcher(name);
		boolean valid = false;
		if (!matcher.find() && name.length() <= 15 && name.length() >= 3) {
			valid = true;
		}
		return valid;
	}
	
	private void makeStarterMonsters() {
		MonsterCreator monsterCreator = new MonsterCreator();
		availableMonsters = new ArrayList<Monster>();
		for (int i = 0; i < 3; i++) {
			availableMonsters.add(monsterCreator.createCommon());
		}
	}
	
	private void build() {
		JButton startButton = new JButton("Start Game");
		startButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (isValidName(usernameField.getText())) {
					game.setDifficulty(diffSlider.getValue());
					game.setMaxDays(daySlider.getValue());
					Monster chosenMonster = availableMonsters.get(diffSlider_1.getValue());
					game.setPlayer(usernameField.getText(), chosenMonster);
					setupPanel.setVisible(false);
					gui.createMenu();
					gui.getMenu().setVisible(true);
				}else {
					usernameError.setText("<html>Username must contain between 3 and 15 characters "
							+ "and must not include numbers or special characters.");
				}
			}
		});
		startButton.setBounds(488, 359, 102, 23);
		setupPanel.add(startButton);
		
		titleLabel = new JLabel("Setup");
		titleLabel.setFont(new Font("Tahoma", Font.PLAIN, 11));
		titleLabel.setBounds(10, 11, 414, 14);
		setupPanel.add(titleLabel);
		
		usernameLabel = new JLabel("Username:");
		usernameLabel.setBounds(10, 36, 74, 14);
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
		difficultyStatusLabel.setBounds(68, 117, 16, 14);
		setupPanel.add(difficultyStatusLabel);
		
		startMonsLabel = new JLabel("Starter Monster:");
		startMonsLabel.setBounds(10, 170, 102, 14);
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
		startMonsLabel0.setHorizontalAlignment(SwingConstants.CENTER);
		startMonsLabel0.setVerticalAlignment(SwingConstants.TOP);
		startMonsLabel0.setBounds(10, 210, 179, 138);
		setupPanel.add(startMonsLabel0);
		
		startMonsLabel1 = new JLabel(availableMonsters.get(1).toStringHTML());
		startMonsLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		startMonsLabel1.setVerticalAlignment(SwingConstants.TOP);
		startMonsLabel1.setBounds(199, 210, 179, 138);
		setupPanel.add(startMonsLabel1);
		
		startMonsLabel2 = new JLabel(availableMonsters.get(2).toStringHTML());
		startMonsLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		startMonsLabel2.setVerticalAlignment(SwingConstants.TOP);
		startMonsLabel2.setBounds(388, 210, 179, 138);
		setupPanel.add(startMonsLabel2);
		
		diffSlider_1 = new JSlider();
		diffSlider_1.setPaintTrack(false);
		diffSlider_1.setSnapToTicks(true);
		diffSlider_1.setPaintTicks(true);
		diffSlider_1.setMaximum(2);
		diffSlider_1.setMajorTickSpacing(1);
		diffSlider_1.setBounds(92, 188, 393, 23);
		setupPanel.add(diffSlider_1);
	}

	public JPanel getPanel() {
		return setupPanel;
	}
	
}
