package main.ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.environment.GameEnvironment;
import main.monster.Monster;

import java.awt.CardLayout;

/**
 * This class implements a graphical UI
 * that the player interacts with to receive
 * output from the game. The player can use
 * this GUI to setup the game, view
 * stats, view squad, visit the shop and arena
 * and progress through the game.
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public class GraphicalUI {

	/**
	 * The JFrame that holds the GUI for the game.
	 */
	private JFrame frmMonsterFighter;
	/**
	 * The JPanel that holds the setup GUI.
	 */
	private JPanel setupPanel;
	/**
	 * The controller instance to hold methods that implement the setup GUI.
	 */
	private SetupPanelControl setupControl;
	/**
	 * The JPanel that holds the main menu GUI.
	 */
	private JPanel menuPanel;
	/**
	 * The controller instance to hold methods that implement the menu GUI.
	 */
	private MenuPanelControl menuControl;
	/**
	 * The JPanel that holds the view player squad GUI.
	 */
	private JPanel squadPanel;
	/**
	 * The controller instance to hold methods that implement the view
	 * squad GUI.
	 */
	private SquadPanelControl squadControl;
	/**
	 * The JPanel that holds the view player inventory GUI.
	 */
	private JPanel inventoryPanel;
	/**
	 * The controller instance to hold methods that implement the view
	 * inventory GUI.
	 */
	private InventoryPanelControl inventoryControl;
	/**
	 * The JPanel that holds the shop GUI.
	 */
	private JPanel shopPanel;
	/**
	 * The controller instance to hold methods that implement the shop GUI.
	 */
	private ShopPanelControl shopControl;
	/**
	 * The JPanel that holds the sell shop GUI.
	 */
	private JPanel sellShopPanel;
	/**
	 * The controller instance to hold methods that implement the sell
	 * shop GUI.
	 */
	private SellShopPanelControl sellShopControl;
	/**
	 * The JPanel that holds the arena GUI.
	 */
	private JPanel arenaPanel;
	/**
	 * The controller instance to hold methods that implement the arena GUI.
	 */
	private ArenaPanelControl arenaControl;
	/**
	 * The JPanel that holds the game over GUI.
	 */
	private JPanel gameOverPanel;
	/**
	 * The controller instance to hold methods that implement the game
	 * over GUI.
	 */
	private GameOverPanelControl gameOverControl;
	/**
	 * The gameEnvironment that provides the functionality of the game and
	 * controls the game objects.
	 */
	private GameEnvironment game;

	/**
	 * Launch the application.
	 * @param args the launch arguments
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

		setupControl = new SetupPanelControl(this);
		setupPanel = setupControl.getPanel();
		frmMonsterFighter.getContentPane().add(setupPanel, "setup");
	}

	/**
	 * setup all of the panels that hold the GUI for different aspects
	 * of the game.
	 */
	public void setupGame() {
		menuControl = new MenuPanelControl(this);
		menuPanel = menuControl.getPanel();
		frmMonsterFighter.getContentPane().add(menuPanel, "menu");

		squadControl = new SquadPanelControl(this);
		squadPanel = squadControl.getPanel();
		frmMonsterFighter.getContentPane().add(squadPanel, "squad");

		inventoryControl = new InventoryPanelControl(this);
		inventoryPanel = inventoryControl.getPanel();
		frmMonsterFighter.getContentPane().add(inventoryPanel, "inventory");

		shopControl = new ShopPanelControl(this);
		shopPanel = shopControl.getPanel();
		frmMonsterFighter.getContentPane().add(shopPanel, "shop");

		sellShopControl = new SellShopPanelControl(this);
		sellShopPanel = sellShopControl.getPanel();
		frmMonsterFighter.getContentPane().add(sellShopPanel, "sell shop");

		arenaControl = new ArenaPanelControl(this);
		arenaPanel = arenaControl.getPanel();
		frmMonsterFighter.getContentPane().add(arenaPanel, "arena");

		gameOverControl = new GameOverPanelControl(this);
		gameOverPanel = gameOverControl.getPanel();
		frmMonsterFighter.getContentPane().add(gameOverPanel, "game over");
	}

	/**
	 * Gets the JFrame that holds the game GUI.
	 * @return the JFrame that holds the game GUI
	 */
	public JFrame getFrame() {
		return frmMonsterFighter;
	}
	
	/**
	 * Refreshes and gets the JPanel that holds the setup GUI.
	 * @return the JPanel that holds the setup GUI
	 */
	public JPanel getSetupPanel() {
		setupPanel.removeAll();
		setupPanel.revalidate();
		setupPanel.repaint();
		setupControl.build();
		return setupPanel;
	}

	/**
	 * Refreshes and gets the JPanel that holds the menu GUI.
	 * @return the JPanel that holds the menu GUI
	 */
	public JPanel getMenuPanel() {
		menuPanel.removeAll();
		menuPanel.revalidate();
		menuPanel.repaint();
		menuControl.build();
		return menuPanel;
	}

	/**
	 * Refreshes and gets the JPanel that holds the view squad GUI.
	 * @return the JPanel that holds the view squad GUI
	 */
	public JPanel getSquadPanel() {
		squadPanel.removeAll();
		squadPanel.revalidate();
		squadPanel.repaint();
		squadControl.build();
		return squadPanel;
	}
	
	/**
	 * Refreshes and gets the JPanel that holds the view inventory GUI.
	 * @return the JPanel that holds the view inventory GUI
	 */
	public JPanel getInventoryPanel() {
		inventoryPanel.removeAll();
		inventoryPanel.revalidate();
		inventoryPanel.repaint();
		inventoryControl.build();
		return inventoryPanel;
	}
	
	/**
	 * Refreshes and gets the JPanel that holds the shop GUI.
	 * @return the JPanel that holds the shop GUI
	 */
	public JPanel getShopPanel() {
		shopPanel.removeAll();
		shopPanel.revalidate();
		shopPanel.repaint();
		shopControl.build();
		return shopPanel;
	}
	
	/**
	 * Refreshes and gets the JPanel that holds the sell shop GUI.
	 * @return the JPanel that holds the sell shop GUI
	 */
	public JPanel getSellShopPanel() {
		sellShopPanel.removeAll();
		sellShopPanel.revalidate();
		sellShopPanel.repaint();
		sellShopControl.build();
		return sellShopPanel;
	}
	
	/**
	 * Refreshes and gets the JPanel that holds the arena GUI.
	 * @return the JPanel that holds the arena GUI
	 */
	public JPanel getArenaPanel() {
		arenaPanel.removeAll();
		arenaPanel.revalidate();
		arenaPanel.repaint();
		arenaControl.build();
		return arenaPanel;
	}
	
	/**
	 * Refreshes and gets the JPanel that holds the game over GUI.
	 * @return the JPanel that holds the game over GUI
	 */
	public JPanel getGameOverPanel() {
		gameOverPanel.removeAll();
		gameOverPanel.revalidate();
		gameOverPanel.repaint();
		gameOverControl.build();
		return gameOverPanel;
	}
	
	/**
	 * Restarts the program by deleting the current window and
	 * initializing a new GUI.
	 */
	public void restart() {
		frmMonsterFighter.dispose();
		GraphicalUI window = new GraphicalUI();
		window.frmMonsterFighter.setVisible(true);
	}
	
	/**
	 * Gets the game environment associated with this GUI.
	 * @return the GameEnvironment associated with this GUI
	 */
	public GameEnvironment getGame() {
		return game;
	}
	
	/**
	 * Displays a pop up pane over the main GUI frame and
	 * asks the user to input a name for a given monster.
	 * If left blank the monster will keep its default
	 * name.
	 * @param mons the Monster that the new name is for
	 */
	public void pickMonsterName(Monster mons) {
		String result = JOptionPane.showInputDialog("Give your new monster a name or leave blank for default");
		if (result != null && result.length()>=1) {
	        mons.setName(result);
		}
	}
	
}
