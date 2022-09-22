import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
	
	private long timeInMilliseconds;
	private Timer timer = new Timer();

	public MyTimer(int hours, int minutes) {
		
		minutes += hours * 60;
		
		timeInMilliseconds = minutes * 60_000;
	}
	public boolean startTimer(TimerTask timerTask) {
		
		try {
			timer.schedule(timerTask, timeInMilliseconds);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @return the Timer object
	 */
	public Timer getTimer() {
		return timer;
	}

	/**
	 * @return the timeInMilliseconds
	 */
	public long getTimeInMilliseconds() {
		return timeInMilliseconds;
	}

}
