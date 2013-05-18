/**
 * TetriPiece.java
 * Created : 13 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.commons;

/**
 * @author thibaud
 *
 */
public interface TetriPiece {
	
	public int getBaseX();
	
	public int getBaseY();
	
	public Orientation getOrientation();
	
	public void rotateLeft(TetriGrid grid);
	
	public void rotateRight(TetriGrid grid);
	
	public void goDown(TetriGrid grid);
	
	public void goLeft(TetriGrid grid);
	
	public void goRight(TetriGrid grid);
	
	public boolean checkIfBlocked();
	
}
