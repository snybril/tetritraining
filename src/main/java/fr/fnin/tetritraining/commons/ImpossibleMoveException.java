/**
 * ImpossibleMoveException.java
 * Created : 13 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.commons;

/**
 * @author thibaud
 *
 */
public class ImpossibleMoveException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6761021927172288698L;
	  public ImpossibleMoveException() { super(); }
	  public ImpossibleMoveException(String message) { super(message); }
	  public ImpossibleMoveException(String message, Throwable cause) { super(message, cause); }
	  public ImpossibleMoveException(Throwable cause) { super(cause); }
}
