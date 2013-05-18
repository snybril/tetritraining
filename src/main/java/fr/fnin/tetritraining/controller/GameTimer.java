/**
 * GameTimer.java
 * Created : 16 mai 2013 by thibaud
 */
package fr.fnin.tetritraining.controller;

/**
 * @author thibaud
 *
 */
public class GameTimer extends Thread {

	private int timeInterval;
	private GameController gameControl;
	public static int DEFAULT_TIME_INTERVAL = 500;
	private boolean stop;

	/**
	 * @return the timeInterval
	 */
	public synchronized int getTimeInterval() {
		return timeInterval;
	}
	
	public synchronized void stopIt() {
		stop=true;
	}


	/**
	 * @param timeInterval the timeInterval to set
	 */
	public synchronized void setTimeInterval(int timeInterval) {
		if (timeInterval>0)
		this.timeInterval = timeInterval;
	}

	/**
	 * 
	 */
	public GameTimer(GameController gc) {
		gameControl = gc;
		timeInterval = DEFAULT_TIME_INTERVAL;
	}

	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	public void run() {
		stop=false;
		try {
			while(!stop) {
				Thread.sleep(timeInterval);
				gameControl.endTurn();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
}


