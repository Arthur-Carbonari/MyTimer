import java.util.Timer;

public class MyTimer {
	
	private long timeInMilliseconds;
	private Timer timer = new Timer();

	public MyTimer(int hours, int minutes) {
		
	}
	
	public boolean startTimer() {
		
		return false;
	}

	/**
	 * @return the Timer object
	 */
	public Timer getMyTimer() {
		return timer;
	}

	/**
	 * @return the timeInMilliseconds
	 */
	public long getTimeInMilliseconds() {
		return timeInMilliseconds;
	}

}
