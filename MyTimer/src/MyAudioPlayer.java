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
	private boolean isPlaying;
	
	public MyAudioPlayer() {};
	public MyAudioPlayer(String pathname) {
		loadAudioFile(pathname);
	}
	
	public boolean loadAudioFile(String pathname) {
		
		File audioFile = new File(pathname);
				
		try {
			audioStream = AudioSystem.getAudioInputStream(audioFile);
			
			audioClip = getAudioClip(audioStream);
			
			return true;
			
		} catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
			e.printStackTrace();
			return false;
		}
		
	}

	
	/**
	 * @throws LineUnavailableException
	 */
	private Clip getAudioClip(AudioInputStream audioStream) throws LineUnavailableException {
		AudioFormat format = audioStream.getFormat();
		DataLine.Info info = new DataLine.Info(Clip.class, format);
		
		return (Clip) AudioSystem.getLine(info);
	}
	
	public boolean playAudio() {
		
		try {
			audioClip.open(audioStream);
			audioClip.loop(10);
			isPlaying = true;
			return true;
		} catch (LineUnavailableException | IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean stopAudio() {
		
		audioClip.stop();
		return true;
	}
	
	public boolean isPlaying() {
		return isPlaying;
	}
	
	public boolean closeStreams() {
		
		try {
			audioClip.close();
			audioStream.close();
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}
	

}
