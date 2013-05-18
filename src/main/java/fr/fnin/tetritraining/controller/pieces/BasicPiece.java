/**
 * BasicPiece.java
 * Created : 13 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.controller.pieces;

import fr.fnin.tetritraining.commons.ImpossibleMoveException;
import fr.fnin.tetritraining.commons.Orientation;
import fr.fnin.tetritraining.commons.SquareValue;
import fr.fnin.tetritraining.commons.TetriGrid;
import fr.fnin.tetritraining.commons.TetriPiece;

/**
 * @author thibaud
 *
 */
public class BasicPiece implements TetriPiece {

	private int currentX;
	private int currentY;
	private Orientation currentOrientation;
	private SquareValue currentColor;
	
	private boolean isBlocked;

	protected int secondarySquaresX[];
	protected int secondarySquaresY[];
	
	/**
	 * This is to override (setting secondary squares)
	 * @param grid
	 * @param x
	 * @param y
	 * @param orientation
	 * @param color
	 * @throws ImpossibleMoveException
	 */
	public BasicPiece (TetriGrid grid, int x, int y,
			Orientation orientation,
			SquareValue color) throws ImpossibleMoveException {
		
		currentX = x;
		currentY = y;
		
		isBlocked= false;

		currentOrientation = orientation;
		
		currentColor = color;

		init();

		rotation(currentOrientation);
		
		if (!checkPiece(x,y, grid) ) throw new ImpossibleMoveException();
		colorPosition(grid);
		
	}
	
	protected void init () throws ImpossibleMoveException {
		secondarySquaresX = new int[1];
		secondarySquaresY = new int[1];
	}

	
	/**
	 * This is to override (setting secondary squares)
	 * @param orientation
	 */
	protected void rotation(Orientation orientation){
		
		switch(orientation) {
		case DOWN : secondarySquaresX[0]=0;
		secondarySquaresY[0]=-1;
		break;
		
		case UP : secondarySquaresX[0]=0;
		secondarySquaresY[0]=1;
		break;
		
		case LEFT : secondarySquaresX[0]=-1;
		secondarySquaresY[0]=0;
		break;
		
		case RIGHT : secondarySquaresX[0]=1;
		secondarySquaresY[0]=0;
		break;		
		}
	}

	/**
	 * @param grid
	 */
	private void cleanPosition(TetriGrid grid) {
		grid.setSquare(currentX, currentY, SquareValue.EMPTY);
		for(int i=0;i<secondarySquaresX.length
				&& i<secondarySquaresY.length; i++) {
			grid.setSquare(currentX+secondarySquaresX[i], currentY+secondarySquaresY[i], SquareValue.EMPTY);			
		}
	}
	
	/**
	 * @param grid
	 */
	private void colorPosition(TetriGrid grid) {
		grid.setSquare(currentX, currentY, currentColor);
		for(int i=0;i<secondarySquaresX.length
				&& i<secondarySquaresY.length; i++) {
			grid.setSquare(currentX+secondarySquaresX[i], currentY+secondarySquaresY[i], currentColor);			
		}
	}

	private boolean checkPiece(int nextX, int nextY, TetriGrid grid) {
		if (!checkSquare(grid, nextX, nextY) )
			return false;
		for(int i=0;i<secondarySquaresX.length
				&& i<secondarySquaresY.length; i++) {
			if(!checkSquare(grid, nextX+secondarySquaresX[i], nextY+secondarySquaresY[i]))
				return false;
		}
		return true;
	}
	
	private boolean checkSquare(TetriGrid grid, int x, int y) {

		if (x<0 || x>=grid.getWidth())
				return false;
		
		if (y<0 || y>=grid.getHeight())
			return false;
		
		if (grid.getSquare(x, y) != SquareValue.EMPTY)
			return false;
		
		return true;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#getBaseX()
	 */
	public int getBaseX() {
		return currentX;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#getBaseY()
	 */
	public int getBaseY() {
		return currentY;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#getOrientation()
	 */
	public Orientation getOrientation() {
		return currentOrientation;
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#rotateLeft(fr.fnin.tetritraining.commons.TetriGrid)
	 */
	public void rotateLeft(TetriGrid grid) {
		cleanPosition(grid);
		Orientation oldOrient = currentOrientation;

		switch(currentOrientation) {
		case DOWN : currentOrientation=Orientation.LEFT;
		break;
		
		case UP : currentOrientation=Orientation.RIGHT;
		break;
		
		case LEFT : currentOrientation=Orientation.UP;
		break;
		
		case RIGHT : currentOrientation=Orientation.DOWN;
		break;		
		}
		rotation(currentOrientation);
		if(!checkPiece(currentX, currentY, grid)) {
			currentOrientation=oldOrient;
			rotation(currentOrientation);
		}
		colorPosition(grid);
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#rotateRight(fr.fnin.tetritraining.commons.TetriGrid)
	 */
	public void rotateRight(TetriGrid grid) {
		cleanPosition(grid);
		Orientation oldOrient = currentOrientation;
		switch(currentOrientation) {
		case DOWN : currentOrientation=Orientation.RIGHT;
		break;
		
		case UP : currentOrientation=Orientation.LEFT;
		break;
		
		case LEFT : currentOrientation=Orientation.DOWN;
		break;
		
		case RIGHT : currentOrientation=Orientation.UP;
		break;		
		}
		rotation(currentOrientation);
		if(!checkPiece(currentX, currentY, grid)) {
			currentOrientation=oldOrient;
			rotation(currentOrientation);
		}
			
		colorPosition(grid);
	}


	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#goDown(fr.fnin.tetritraining.commons.TetriGrid)
	 */
	public void goDown(TetriGrid grid) {
		cleanPosition(grid);
		if(checkPiece(currentX, currentY+1, grid))
			currentY++;
		else
			isBlocked=true;
			
		colorPosition(grid);
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#goLeft(fr.fnin.tetritraining.commons.TetriGrid)
	 */
	public void goLeft(TetriGrid grid) {
		cleanPosition(grid);
		if(checkPiece(currentX-1, currentY, grid))
			currentX--;
			
		colorPosition(grid);
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#goRight(fr.fnin.tetritraining.commons.TetriGrid)
	 */
	public void goRight(TetriGrid grid) {
		cleanPosition(grid);
		if(checkPiece(currentX+1, currentY, grid))
			currentX++;
			
		colorPosition(grid);
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.commons.TetriPiece#checkIfBlocked()
	 */
	public boolean checkIfBlocked() {
		return isBlocked;
	}
	
}
