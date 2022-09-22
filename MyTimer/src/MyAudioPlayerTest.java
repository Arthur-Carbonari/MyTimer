import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MyAudioPlayerTest {
	
	
	MyAudioPlayer testAudioPlayer;
	String validFilePath = "./audioFiles/test.wav";
	String invalidFilePath = "adadads";
	
	@BeforeEach
	void setup() {
		testAudioPlayer = new MyAudioPlayer();
	}

	@Test
	void testLoadAudioFile() {
		
		boolean isLoaded = testAudioPlayer.loadAudioFile(validFilePath);
		
		assertTrue(isLoaded);
		
	}
	
	@Test
	void testLoadAudioFile2() {
		
		boolean isLoaded = testAudioPlayer.loadAudioFile(invalidFilePath);
		
		assertFalse(isLoaded);
	}

	@Test
	void testPlayAudio() {
		testAudioPlayer.loadAudioFile(validFilePath);
		
		assertTrue(testAudioPlayer.playAudio());
		boolean isPlaying = testAudioPlayer.isPlaying();
		
		assertTrue(isPlaying);
	}

	@Test
	void testStopAudio() {
		testAudioPlayer.loadAudioFile(validFilePath);
		
		assertTrue(testAudioPlayer.playAudio());
		boolean isPlaying = testAudioPlayer.isPlaying();
		
		assertTrue(isPlaying);
		
		assertTrue(testAudioPlayer.stopAudio());
		
		assertTrue(isPlaying);
	}

	@Test
	void testIsPlaying() {
		testAudioPlayer.loadAudioFile(validFilePath);
		
		assertTrue(testAudioPlayer.playAudio());
		boolean isPlaying = testAudioPlayer.isPlaying();
		
		assertTrue(isPlaying);
	}
	
	@Test
	void testIsPlaying2() {
		testAudioPlayer.loadAudioFile(validFilePath);
		
		assertFalse(testAudioPlayer.isPlaying());
		
	}
	
	@Test
	void testCloseStreams() {
		testAudioPlayer.loadAudioFile(validFilePath);
		
		assertTrue(testAudioPlayer.closeStreams());
	}

}
