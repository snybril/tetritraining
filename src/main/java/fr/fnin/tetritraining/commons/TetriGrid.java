/**
 * TetriGrid.java
 * Created : 13 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.commons;

/**
 * @author thibaud
 *
 */
public interface TetriGrid {
	
	public int DEFAULT_WIDTH = 10;
	
	public int DEFAULT_HEIGHT = 20;
	
	public int getWidth();
	
	public int getHeight();
	
	/**
	 * Set all squares to EMPTY
	 */
	public void emptyGrid();
	
	/**
	 * 
	 * @param x
	 * @param y
	 * @param value
	 * @throws IndexOutOfBoundsException if coordinates are negative or superior to Grid Array
	 */
	public SquareValue getSquare(int x, int y) throws IndexOutOfBoundsException;
	
	public void setSquare(int x, int y, SquareValue value) throws IndexOutOfBoundsException;
	
	public SquareValue[] getLine(int y) throws IndexOutOfBoundsException;
	
	public void setLine(int y, SquareValue[] line) throws IndexOutOfBoundsException;

	/**
	 * 
	 * @return number of lines removed (to compute the score)
	 */
	public int removeFullLines();

}
