/**
 * GameController.java
 * Created : 16 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.controller;

/**
 * @author thibaud
 *
 */
public interface GameController {
	
	public void endTurn();
	
	public void keyControl(GameKey key);
	
	public void endGame();

}
