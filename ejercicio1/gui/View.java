package examen.ejercicio1.gui;

import javax.swing.JPanel;

public abstract class View extends JPanel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected App appController;

	public View(App appController) {
		this.appController = appController;
	}
}
