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
		fail("Not yet implemented");
	}

	@Test
	void testStopAudio() {
		fail("Not yet implemented");
	}

	@Test
	void testIsPlaying() {
		fail("Not yet implemented");
	}

}
