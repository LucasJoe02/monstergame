package main.ui.gui;

import javax.swing.JPanel;

/**
 * This interface defines the functionality required
 * for the panel controllers to display panels to the
 * screen so that users can provide input to the game
 * and receive the output.
 * 
 * @author Lucas Redding
 * @version 1.1, May 2022.
 */
public interface PanelControl {
	/**
	 * Builds a panel for this class by placing swing objects such as labels, buttons and tables.
	 * Adds the functionality to the buttons on the panel.
	 */
	public void build();
	/**
	 * Returns the panel built by this panel control class.
	 * @return the JPanel built by this class
	 */
	public JPanel getPanel();
}
