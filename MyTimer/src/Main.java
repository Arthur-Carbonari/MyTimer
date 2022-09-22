import java.net.URL;
import java.net.URLDecoder;
import java.util.Scanner;
import java.util.TimerTask;

import com.sun.jdi.Method;

public class Main {


	public static void main(String[] args) {

		if(!ArgsParser.isArgsValid(args)) {
			System.out.println("Invalid argument for <alarm time>");
			System.out.println("Argument must be in the format HH.MM .MM HH. MM H.M (valid separators are: [,], [.], [:].");
			return;
		}
		
		int[] timeIntArray = ArgsParser.parseArgsToIntArray(args);

		System.out.println("Timer set to T - " + timeIntArray[0] + ":" + timeIntArray[1]);

		MyTimer myTimer = new MyTimer(timeIntArray[0], timeIntArray[1]);

		
		String pathTofile = Main.class.getResource("resources/alarm.wav").getPath();
		
		
		TimerTask myTimerTask = new TimerTask() {
			
			MyAudioPlayer myAudioPlayer = new MyAudioPlayer(pathTofile);
			Scanner in = new Scanner(System.in);
			
			@Override
			public void run() {
				
				myAudioPlayer.playAudio();
				System.out.println("Press enter to stop the alarm.");
				in.nextLine();
				myAudioPlayer.stopAudio();
				myAudioPlayer.closeStreams();
				in.close();
				System.exit(0);
			}
		};
		
		myTimer.startTimer(myTimerTask);
		
	}

}
