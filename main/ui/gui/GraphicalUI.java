package main.ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import main.environment.GameEnvironment;

import java.awt.CardLayout;

public class GraphicalUI {

	private JFrame frmMonsterFighter;
	private JPanel setupPanel;
	private JPanel menuPanel;
	private JPanel squadPanel;
	private GameEnvironment game;
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphicalUI window = new GraphicalUI();
					window.frmMonsterFighter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public GraphicalUI() {
		game = new GameEnvironment(); 
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmMonsterFighter = new JFrame();
		frmMonsterFighter.setResizable(false);
		frmMonsterFighter.setTitle("Monster Fighter");
		frmMonsterFighter.setBounds(100, 100, 614, 428);
		frmMonsterFighter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmMonsterFighter.getContentPane().setLayout(new CardLayout(0, 0));
		
		setupPanel = (new SetupPanelControl(this)).getPanel();
		frmMonsterFighter.getContentPane().add(setupPanel, "name_4315045860299");
		
	}
	
	public void setupGame() {
		menuPanel = (new MenuPanelControl(this)).getPanel();
		frmMonsterFighter.getContentPane().add(menuPanel, "name_4317081042700");
		squadPanel = (new SquadPanelControl(this).getPanel());
		frmMonsterFighter.getContentPane().add(squadPanel, "name_4317081042699");
	}
	
	public JPanel getMenu() {
		return menuPanel;
	}
	
	public JPanel getSquadPanel() {
		return squadPanel;
	}
	
	public GameEnvironment getGame() {
		return game;
	}
	
}
