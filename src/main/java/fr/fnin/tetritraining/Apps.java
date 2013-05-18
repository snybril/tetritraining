/**
 * Apps.java
 * Created : 14 mai 2013 by thibaud
 */
package fr.fnin.tetritraining;

import java.awt.BorderLayout;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JLabel;

import fr.fnin.tetritraining.commons.ImpossibleMoveException;
import fr.fnin.tetritraining.commons.InformationPanel;
import fr.fnin.tetritraining.commons.Orientation;
import fr.fnin.tetritraining.commons.SquareValue;
import fr.fnin.tetritraining.commons.TetriGrid;
import fr.fnin.tetritraining.commons.TetriPiece;
import fr.fnin.tetritraining.controller.BasicGameController;
import fr.fnin.tetritraining.controller.BasicGrid;
import fr.fnin.tetritraining.controller.GameController;
import fr.fnin.tetritraining.controller.GameKey;
import fr.fnin.tetritraining.controller.pieces.BasicPiece;
import fr.fnin.tetritraining.controller.pieces.PieceI;
import fr.fnin.tetritraining.controller.pieces.PieceJ;
import fr.fnin.tetritraining.controller.pieces.PieceL;
import fr.fnin.tetritraining.controller.pieces.PieceO;
import fr.fnin.tetritraining.controller.pieces.PieceS;
import fr.fnin.tetritraining.controller.pieces.PieceT;
import fr.fnin.tetritraining.controller.pieces.PieceZ;
import fr.fnin.tetritraining.gui.BasicTetriGridViewer;
import fr.fnin.tetritraining.gui.BorderPanel;
import fr.fnin.tetritraining.gui.UIKeyListener;

/**
 * @author thibaud
 *
 */
public class Apps extends JFrame{
	
	public Apps(String txt) {
		super(txt);
		//2. Optional: What happens when the frame closes?
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//3. Create components and put them in the frame.
		BasicTetriGridViewer grilleGraf = new BasicTetriGridViewer();
		BasicGrid grille = new BasicGrid();
		
		BorderPanel panelDroit = new BorderPanel();
		getContentPane().add(panelDroit, BorderLayout.EAST);
		getContentPane().add(grilleGraf, BorderLayout.CENTER);

		//4. Size the frame.
		setSize(400, 600);
		setLocationRelativeTo(null);
		setVisible(true);
		
		//grille.setSquare(1, 3, SquareValue.BLUE);
		//grille.setSquare(2, 3, SquareValue.GREEN);
		//grille.setSquare(3, 3, SquareValue.RED);
		grilleGraf.updateGrid(grille);
		GameController gc = new BasicGameController(grille,grilleGraf,
				(InformationPanel)panelDroit);
		UIKeyListener keyListener = new UIKeyListener(gc);
		this.addKeyListener(keyListener);
			
		
//		TetriPiece piece=null;
//		try {
//			Random rand = new Random();
//			while(true) {
//			
//			switch(rand.nextInt(8)) {
//			case 0 : piece = new PieceI(grille, 5, 2,
//					Orientation.DOWN, SquareValue.GREEN);
//			break;
//			case 1 : piece = new PieceJ(grille, 5, 1,
//					Orientation.DOWN, SquareValue.RED);
//			break;
//			case 2 : piece = new PieceL(grille, 5, 1,
//					Orientation.DOWN, SquareValue.BLUE);
//			break;
//			case 3 : piece = new PieceO(grille, 5, 0,
//					Orientation.DOWN, SquareValue.YELLOW);
//			break;
//			case 4 : piece = new PieceS(grille, 5, 0,
//					Orientation.DOWN, SquareValue.PINK);
//			break;
//			case 5 : piece = new PieceT(grille, 5, 0,
//					Orientation.DOWN, SquareValue.ORANGE);
//			break;
//			case 6 : piece = new PieceZ(grille, 5, 0,
//					Orientation.DOWN, SquareValue.GREY);
//			break;
//			}
//			pieceLoop(piece, grille, grilleGraf);
			
		}
			


			
		/*	piece = new BasicPiece(grille, 5, 10,
					Orientation.DOWN, SquareValue.BLUE);
			testPiece(piece,grille,grilleGraf);
			
			piece = new PieceO(grille, 5, 10,
					Orientation.DOWN, SquareValue.GREEN);
			testPiece(piece,grille,grilleGraf);
			
			piece = new PieceI(grille, 5, 10,
					Orientation.DOWN, SquareValue.RED);
			testPiece(piece,grille,grilleGraf);
			piece = new PieceZ(grille, 5, 1,
					Orientation.DOWN, SquareValue.BLUE);
			
			//testPiece(piece,grille,grilleGraf);

		} catch (ImpossibleMoveException e) {
			System.out.println("Sortie de la boucle principale, fin de la partie ?");
			e.printStackTrace();
		}
	}*/
	
	/**
	 * Loop until a piece reachs Impossible move
	 * @param piece
	 * @param grille
	 * @param grilleGraf
	 */
	void pieceLoop(TetriPiece piece,
			TetriGrid grille,
			BasicTetriGridViewer grilleGraf) {
//
//		UIKeyListener keyListener = new UIKeyListener();
//		this.addKeyListener(keyListener);
//		
//		try {
//
//		while(true) {
//			
//			// 1° Wait until move
//			Thread.sleep(500);
//			
//			// 2° Check user input, Move the piece accordingly, reset the key 
//			switch(keyListener.getCurrentKey()) {
//			case LEFT : piece.goLeft(grille);
//			break;
//			case RIGHT : piece.goRight(grille);
//			break;
//			case DOWN : piece.goDown(grille);
//			break;
//			case RRIGHT : piece.rotateRight(grille);
//			break;
//			}
//			grilleGraf.updateGrid(grille);
//			keyListener.resetCurrentKey();
//			
//			
//			// 3° Move the piece down
//			piece.goDown(grille);
//			grilleGraf.updateGrid(grille);
//		}
//
//		} catch (Exception e) {
//			System.out.println("Piece Stopped, go to next one");
//			e.printStackTrace();
//		}
	}
	
	
	void testPiece(TetriPiece piece,
			TetriGrid grille,
			BasicTetriGridViewer grilleGraf) {
		grille.emptyGrid();
		try {
			
			for(int i=0; i<2;i++) {
				Thread.sleep(500);
				piece.goDown(grille);	
				grilleGraf.updateGrid(grille);
			}
//			for(int i=0; i<4;i++) {
//				Thread.sleep(500);
//				piece.goLeft(grille);	
//				grilleGraf.updateGrid(grille);
//			}
//			for(int i=0; i<4;i++) {
//				Thread.sleep(500);
//				piece.goRight(grille);	
//				grilleGraf.updateGrid(grille);
//			}
			
			for(int i=0; i<4;i++) {
				Thread.sleep(2000);
				piece.rotateRight(grille);	
				grilleGraf.updateGrid(grille);
			}
			
			for(int i=0; i<4;i++) {
				Thread.sleep(300);
				piece.rotateLeft(grille);	
				grilleGraf.updateGrid(grille);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apps app = new Apps("Tetris programming Training");
	}

}
