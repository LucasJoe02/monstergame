package main.ui.gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.environment.GameEnvironment;
import main.monster.Monster;

import java.awt.CardLayout;

public class GraphicalUI {

	private JFrame frmMonsterFighter;
	private JPanel setupPanel;
	private SetupPanelControl setupControl;
	private JPanel menuPanel;
	private MenuPanelControl menuControl;
	private JPanel squadPanel;
	private SquadPanelControl squadControl;
	private JPanel inventoryPanel;
	private InventoryPanelControl inventoryControl;
	private JPanel shopPanel;
	private ShopPanelControl shopControl;
	private JPanel sellShopPanel;
	private SellShopPanelControl sellShopControl;
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
		
		setupControl = new SetupPanelControl(this);
		setupPanel = setupControl.getPanel();
		frmMonsterFighter.getContentPane().add(setupPanel, "setup");
		
	}
	
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
	}
	
	public JFrame getFrame() {
		return frmMonsterFighter;
	}
	
	public JPanel getSetupPanel() {
		setupPanel.removeAll();
		setupPanel.revalidate();
		setupPanel.repaint();
		setupControl.build();
		return setupPanel;
	}
	
	public JPanel getMenuPanel() {
		menuPanel.removeAll();
		menuPanel.revalidate();
		menuPanel.repaint();
		menuControl.build();
		return menuPanel;
	}
	
	public JPanel getSquadPanel() {
		squadPanel.removeAll();
		squadPanel.revalidate();
		squadPanel.repaint();
		squadControl.build();
		return squadPanel;
	}
	
	public JPanel getInventoryPanel() {
		inventoryPanel.removeAll();
		inventoryPanel.revalidate();
		inventoryPanel.repaint();
		inventoryControl.build();
		return inventoryPanel;
	}
	
	public JPanel getShopPanel() {
		shopPanel.removeAll();
		shopPanel.revalidate();
		shopPanel.repaint();
		shopControl.build();
		return shopPanel;
	}
	
	public JPanel getSellShopPanel() {
		sellShopPanel.removeAll();
		sellShopPanel.revalidate();
		sellShopPanel.repaint();
		sellShopControl.build();
		return sellShopPanel;
	}
	
	public GameEnvironment getGame() {
		return game;
	}
	
	public void pickMonsterName(Monster mons) {
		String result = JOptionPane.showInputDialog("Give your new monster a name or leave blank for default");
		if (result != null && result.length()>=1) {
	        mons.setName(result);
		}
	}
	
}
