package main.ui.gui;

import javax.swing.JPanel;

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
