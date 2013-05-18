/**
 * BasicTetriGridViewer.java
 * Created : 13 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.gui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;

import fr.fnin.tetritraining.commons.TetriGrid;

/**
 * @author thibaud
 *
 */
public class BasicTetriGridViewer extends JPanel {
	

	private TetriGrid currentGrid;
	private int heightSpace;
	private int widthSpace;
	
	
	public void updateGrid(TetriGrid grid) {
		currentGrid = grid;
		this.repaint();
	}
	
	private void drawEmptyGrid(Graphics2D g2d) {
	    g2d.setColor(Color.DARK_GRAY);
	    g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
	    // 1° Show the grid
	    g2d.setColor(Color.WHITE);

	    for(int i=0; i<=currentGrid.getHeight(); i++)
	    	g2d.drawLine(widthSpace, (i+1)*heightSpace, widthSpace*(currentGrid.getWidth()+1), (i+1)*heightSpace);
	    
	    for(int i=0; i<=currentGrid.getWidth(); i++)
	    	g2d.drawLine((i+1)*widthSpace, heightSpace, (i+1)*widthSpace, heightSpace*(currentGrid.getHeight()+1));
	}
	
	private void drawGridContent(Graphics2D g2d) {

		
		for(int i=0; i < currentGrid.getHeight(); i++) {
			for(int j=0; j < currentGrid.getWidth(); j++) {
				switch(currentGrid.getSquare(j, i)) {
				case EMPTY : g2d.setColor(Color.BLACK);
				break;
				case SPECIAL : g2d.setColor(Color.BLACK);
				break;
				case RED : g2d.setColor(Color.RED);
					break;
				case GREEN : g2d.setColor(Color.GREEN);
				break;
				case BLUE : g2d.setColor(Color.BLUE);
				break;
				case WHITE : g2d.setColor(Color.WHITE);
				break;
				case BLACK : g2d.setColor(Color.BLACK);
				break;
				case YELLOW : g2d.setColor(Color.YELLOW);
				break;
				case ORANGE : g2d.setColor(Color.ORANGE);
				break;
				case PINK : g2d.setColor(Color.PINK);
				break;
				case GREY : g2d.setColor(Color.GRAY);
				}
				g2d.fillRoundRect((j+1)*widthSpace+2,(i+1)*heightSpace+2,
						widthSpace-4, heightSpace-4,
			    		widthSpace/4, heightSpace/4);		
			}
		}
	    
	    g2d.setColor(Color.WHITE);

	    for(int i=0; i<=currentGrid.getHeight(); i++)
	    	g2d.drawLine(widthSpace, (i+1)*heightSpace, widthSpace*(currentGrid.getWidth()+1), (i+1)*heightSpace);
	    
	    for(int i=0; i<=currentGrid.getWidth(); i++)
	    	g2d.drawLine((i+1)*widthSpace, heightSpace, (i+1)*widthSpace, heightSpace*(currentGrid.getHeight()+1));
	    
	    		
	}


	  public void paintComponent(Graphics g) {
		    clear(g);
		    Graphics2D g2d = (Graphics2D)g;
		    
			heightSpace = this.getHeight()/(currentGrid.getHeight()+2);
			widthSpace = this.getWidth()/(currentGrid.getWidth()+2);
		    
			drawEmptyGrid(g2d);
			
			drawGridContent(g2d);
		}

		  protected void clear(Graphics g) {
		    super.paintComponent(g);
		  }

}
