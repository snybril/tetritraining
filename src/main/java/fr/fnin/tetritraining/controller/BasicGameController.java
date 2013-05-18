/**
 * BasicGameController.java
 * Created : 16 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.controller;

import java.awt.event.KeyEvent;
import java.util.Random;

import fr.fnin.tetritraining.commons.InformationPanel;
import fr.fnin.tetritraining.commons.Orientation;
import fr.fnin.tetritraining.commons.SquareValue;
import fr.fnin.tetritraining.commons.TetriGrid;
import fr.fnin.tetritraining.commons.TetriPiece;
import fr.fnin.tetritraining.controller.pieces.PieceI;
import fr.fnin.tetritraining.controller.pieces.PieceJ;
import fr.fnin.tetritraining.controller.pieces.PieceL;
import fr.fnin.tetritraining.controller.pieces.PieceO;
import fr.fnin.tetritraining.controller.pieces.PieceS;
import fr.fnin.tetritraining.controller.pieces.PieceT;
import fr.fnin.tetritraining.controller.pieces.PieceZ;
import fr.fnin.tetritraining.gui.BasicTetriGridViewer;

/**
 * @author thibaud
 *
 */
public class BasicGameController implements GameController {

	TetriPiece currentPiece;
	TetriGrid currentGrid;
	BasicTetriGridViewer currentGrafGrid;
	InformationPanel currentInfoPanel;
	
	private int score;
	private int nextLevel;


	private Random rand;
	private GameTimer gt;

	/**
	 * @param currentPiece
	 * @param currentGrid
	 * @param currentGrafGrid
	 */
	public BasicGameController(TetriGrid currentGrid,
			BasicTetriGridViewer currentGrafGrid,
			InformationPanel   panel) {
		super();
		this.currentGrid = currentGrid;
		this.currentGrafGrid = currentGrafGrid;
		currentInfoPanel = panel;
		rand = new Random();
		currentPiece= null;
		score=0;
		nextLevel=10;

		createPiece();
		currentGrafGrid.updateGrid(currentGrid);
		initGame();
	}
	
	public void initGame() {
		gt = new GameTimer(this);
		gt.setTimeInterval(500);
        gt.start();

		
	}

	private void createPiece() {
		try {
			currentPiece=null;
			switch(rand.nextInt(8)) {
			case 0 : currentPiece = new PieceI(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.GREEN);
			break;
			case 1 : currentPiece = new PieceJ(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.RED);
			break;
			case 2 : currentPiece = new PieceL(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.BLUE);
			break;
			case 3 : currentPiece = new PieceO(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.YELLOW);
			break;
			case 4 : currentPiece = new PieceS(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.PINK);
			break;
			case 5 : currentPiece = new PieceT(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.ORANGE);
			break;
			case 6 : currentPiece = new PieceZ(currentGrid, 5, 1,
					Orientation.DOWN, SquareValue.WHITE);
			break;
			}
		} catch (Exception exc) {
			//Impossible piece creation means end of game
			endGame();
		}
	}


	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.controller.GameController#endTurn()
	 */
	public synchronized void endTurn() {
		if (currentPiece!= null && !currentPiece.checkIfBlocked()) {
			currentPiece.goDown(currentGrid);
			currentGrafGrid.updateGrid(currentGrid);
		}  else {
			//1° check line completion
			score+=currentGrid.removeFullLines();
			currentGrafGrid.updateGrid(currentGrid);
			currentInfoPanel.setScore(score);
			if(score>=nextLevel) {
				gt.setTimeInterval((gt.getTimeInterval()+100)/2);
				nextLevel+=10;
			}
			
			//2° create a new piece
			createPiece();
			currentGrafGrid.updateGrid(currentGrid);
		}

	}
	
	public synchronized void endGame() {
		gt.stopIt();
		currentPiece=null;
		
		System.out.println("End of game, score : "+score);
	}

	/* (non-Javadoc)
	 * @see fr.fnin.tetritraining.controller.GameController#keyControl(fr.fnin.tetritraining.controller.GameKey)
	 */
	public void keyControl(GameKey key) {
		// test move keys
		if(currentPiece !=null && !currentPiece.checkIfBlocked()) {
			switch(key) {
			case KEY_LEFT : currentPiece.goLeft(currentGrid);
			break;
			case KEY_RIGHT : currentPiece.goRight(currentGrid);
			break;
			case KEY_UP : currentPiece.rotateLeft(currentGrid);
			break;
			case KEY_DOWN : currentPiece.goDown(currentGrid);
			break;
			case KEY_ROTATE_LEFT : currentPiece.rotateLeft(currentGrid);
			break;
			case KEY_ROTATE_RIGHT : currentPiece.rotateRight(currentGrid);
			break;
			}
			currentGrafGrid.updateGrid(currentGrid);
		}
		// test game control keys
		switch(key) {
		case KEY_PAUSE: // TODO 
			break;
		case KEY_QUIT: // TODO
			break;
		}
		if(currentPiece !=null && currentPiece.checkIfBlocked()) endTurn();
		
	}

}
