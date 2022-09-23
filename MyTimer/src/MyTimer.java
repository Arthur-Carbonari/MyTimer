import java.util.Timer;
import java.util.TimerTask;

public class MyTimer {
	
	private long timeInMilliseconds;
	private Timer timer = new Timer();
	
	public MyTimer(String hoursString, String minutesString) {
		
		int hours = Integer.parseInt(hoursString);
		int minutes = Integer.parseInt(minutesString);
		
		minutes += hours * 60;
		
		timeInMilliseconds = minutes * 60_000;
	}

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
	
	
	public static void main(String[] args) {
		
		MyTimer myTimer = new MyTimer(args[0], args[1]);

		
		String pathTofile = Main.class.getResource("resources/alarm.wav").getPath();
		
		
		TimerTask myTimerTask = new TimerTask() {
			
			MyAudioPlayer myAudioPlayer = new MyAudioPlayer(pathTofile);
			
			@Override
			public void run() {
				
				myAudioPlayer.playAudio();
				TimerPopup.display("Time's Up");
				myAudioPlayer.stopAudio();
				myAudioPlayer.closeStreams();
				System.exit(0);
			}
		};
		
		myTimer.startTimer(myTimerTask);
	}

}
