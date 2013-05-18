/**
 * UIKeyListener.java
 * Created : 15 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.gui;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import fr.fnin.tetritraining.commons.Orientation;
import fr.fnin.tetritraining.controller.GameController;
import fr.fnin.tetritraining.controller.GameKey;

/**
 * Translate keyboard keys to game control keys
 * 
 * @author Thibaud
 */
public class UIKeyListener implements KeyListener {
	
	private GameController gameControl;


	public UIKeyListener(GameController gc) {
		gameControl = gc;
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyPressed(java.awt.event.KeyEvent)
	 */
	public void keyPressed(KeyEvent key) {
		
		switch(key.getKeyCode()) {
		case KeyEvent.VK_LEFT : //System.out.println("Key Left Pressed ");
		gameControl.keyControl(GameKey.KEY_LEFT);
		break;
		case KeyEvent.VK_RIGHT : //System.out.println("Key Right Pressed ");
			gameControl.keyControl(GameKey.KEY_RIGHT);
		break;
		case KeyEvent.VK_UP : //System.out.println("Key Up Pressed ");
			gameControl.keyControl(GameKey.KEY_UP);
		break;
		case KeyEvent.VK_DOWN : //System.out.println("Key Down Pressed ");
			gameControl.keyControl(GameKey.KEY_DOWN);
		break;
		case KeyEvent.VK_SPACE : //System.out.println("Key Down Pressed ");
			gameControl.keyControl(GameKey.KEY_PAUSE);
		break;
		case KeyEvent.VK_CONTROL : //System.out.println("Key Down Pressed ");
			gameControl.keyControl(GameKey.KEY_ROTATE_LEFT);
		break;
		case KeyEvent.VK_ALT : //System.out.println("Key Down Pressed ");
			gameControl.keyControl(GameKey.KEY_ROTATE_RIGHT);
		break;
		case KeyEvent.VK_Q : //System.out.println("Key Down Pressed ");
			gameControl.keyControl(GameKey.KEY_QUIT);
		break;
		}
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyReleased(java.awt.event.KeyEvent)
	 */
	public void keyReleased(KeyEvent arg0) {
		//System.out.println("Key Released");
		
	}

	/* (non-Javadoc)
	 * @see java.awt.event.KeyListener#keyTyped(java.awt.event.KeyEvent)
	 */
	public void keyTyped(KeyEvent arg0) {
		//System.out.println("Key Typed");
		
	}


}
