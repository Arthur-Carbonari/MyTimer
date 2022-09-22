import java.io.File;
import java.io.IOException;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

public class MyAudioPlayer{
	
	private AudioInputStream audioStream;
	private Clip audioClip;
	
	public boolean loadAudioFile(String pathname) {
		
		File audioFile = new File(pathname);
		System.out.println(audioFile);
		
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			
			AudioFormat format = audioStream.getFormat();
			DataLine.Info info = new DataLine.Info(Clip.class, format);
			
			audioClip = (Clip) AudioSystem.getLine(info);
			
			return true;
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			return false;
		}
		
	}
	
	public boolean playAudio() {
		
		return false;
	}
	
	public boolean stopAudio() {
		
		return false;
	}
	
	public boolean isPlaying() {
		return false;
	}
	

}
