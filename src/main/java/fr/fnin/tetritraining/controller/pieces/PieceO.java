/**
 * PieceO.java
 * Created : 15 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.controller.pieces;

import fr.fnin.tetritraining.commons.ImpossibleMoveException;
import fr.fnin.tetritraining.commons.Orientation;
import fr.fnin.tetritraining.commons.SquareValue;
import fr.fnin.tetritraining.commons.TetriGrid;

/**
 * @author thibaud
 *
 */
public class PieceO extends BasicPiece {

	/**
	 * Shape of the piece :
	 * B3
	 * 24
	 * 
	 * @param grid
	 * @param x
	 * @param y
	 * @param orientation
	 * @param color
	 * @throws ImpossibleMoveException
	 */
	public PieceO(TetriGrid grid, int x, int y, Orientation orientation,
			SquareValue color) throws ImpossibleMoveException {
		super(grid, x, y,orientation,color);
		
	}
	
	

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.controller.BasicPiece#init()
	 */
	@Override
	protected void init() throws ImpossibleMoveException {

		secondarySquaresX = new int[3];
		secondarySquaresY = new int[3];
		
		secondarySquaresX[0]=0;
		secondarySquaresY[0]=-1;
		secondarySquaresX[1]=1;
		secondarySquaresY[1]=0;
		secondarySquaresX[2]=1;
		secondarySquaresY[2]=-1;
	}

	
	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.controller.BasicPiece#rotation(fr.fnin.tetritraining.commons.Orientation)
	 */
	@Override
	protected void rotation(Orientation orientation) {
		// This method is useless (piece symmetrical)
	}
	
	

}
