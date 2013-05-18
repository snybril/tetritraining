/**
 * BasicGrid.java
 * Created : 13 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.controller;

import java.awt.peer.LightweightPeer;

import fr.fnin.tetritraining.commons.SquareValue;
import fr.fnin.tetritraining.commons.TetriGrid;

/**
 * @author thibaud
 *
 */
public class BasicGrid implements TetriGrid {

	private SquareValue grid[][];
	private int width;
	private int height;
	
	public BasicGrid() {
		this(DEFAULT_WIDTH,DEFAULT_HEIGHT);
	}
	
	public BasicGrid(int maxWidth, int maxHeight) {
		width=maxWidth;
		height=maxHeight;
		
		grid = new SquareValue[height][width];
		emptyGrid();
	}
	
	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#getWidth()
	 */
	public int getWidth() {
		return width;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#getHeight()
	 */
	public int getHeight() {
		return height;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#emptyGrid()
	 */
	public void emptyGrid() {
		for(int i=0; i<height; i++)
			for(int j=0; j<width; j++)
				grid[i][j]=SquareValue.EMPTY;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#getSquare(int, int)
	 */
	public SquareValue getSquare(int x, int y) throws IndexOutOfBoundsException {
		return grid[y][x];
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#setSquare(int, int, fr.fnin.tetritraining.commons.SquareValue)
	 */
	public void setSquare(int x, int y, SquareValue value)
			throws IndexOutOfBoundsException {
		grid[y][x]=value;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#getLine(int)
	 */
	public SquareValue[] getLine(int y) throws IndexOutOfBoundsException {
		SquareValue[] tmp = new SquareValue[width];
		for(int i=0;i<width;i++)
			tmp[i]=grid[y][i];
		return tmp;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#setLine(int, fr.fnin.tetritraining.commons.SquareValue[])
	 */
	public void setLine(int y, SquareValue[] line)
			throws IndexOutOfBoundsException {
		grid[y]=line;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriGrid#removeBottomLines(int)
	 */
	public int removeFullLines() {
		int lineRemoved=0;
		for(int i=height-1;i>=lineRemoved;i--) {
			//System.out.println("line "+i);
			if(checkIfFull(i)) {
				//System.out.println(" --> seems to be full");
				lineRemoved++;
				for(int j=i;j>=lineRemoved;j--) {
					setLine(j, getLine(j-1));
					//System.out.println(" i : "+i+", j : "+j);
				}
				i++;
			}
		}
		//System.out.println("lines removed : "+lineRemoved);
		for(int i=lineRemoved-1;i>=0;i--)
			for(int j=0;j<width;j++)
				grid[i][j]=SquareValue.EMPTY;
		return lineRemoved;
	}
	
	private boolean checkIfFull(int index) {
		for(int i=0;i<width;i++)
			if(grid[index][i] == SquareValue.EMPTY)
				return false;
		return true;
	}
}
