/**
 * BorderPanel.java
 * Created : 18 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.gui;

import java.awt.BorderLayout;
import java.awt.LayoutManager;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fr.fnin.tetritraining.commons.InformationPanel;

/**
 * @author thibaud
 *
 */
public class BorderPanel extends JPanel implements InformationPanel{
	
	JLabel currentScore;

	/**
	 * 
	 */
	public BorderPanel() {
		JLabel label = new JLabel("Score :");
		currentScore = new JLabel("0");
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

		add(label);
		add(currentScore);
	}
	
	public void setScore(int newSore) {
		currentScore.setText(String.valueOf(newSore));
	}

	/**
	 * @param layout
	 */
	public BorderPanel(LayoutManager layout) {
		super(layout);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param isDoubleBuffered
	 */
	public BorderPanel(boolean isDoubleBuffered) {
		super(isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param layout
	 * @param isDoubleBuffered
	 */
	public BorderPanel(LayoutManager layout, boolean isDoubleBuffered) {
		super(layout, isDoubleBuffered);
		// TODO Auto-generated constructor stub
	}

}
