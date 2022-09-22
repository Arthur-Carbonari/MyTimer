import static org.junit.jupiter.api.Assertions.*;

import java.util.Timer;
import java.util.TimerTask;

import org.junit.jupiter.api.Test;

class MyTimerTest {

	@Test
	void testMyTimer() {
		
		MyTimer myTimer = new MyTimer(0, 0);
		
		assertEquals(MyTimer.class, myTimer.getClass());
	}
	
	@Test
	void testMyTimer2() {
		
		long expectedTime = 180000;
		MyTimer myTimer = new MyTimer(0, 3);
		
		assertEquals(expectedTime, myTimer.getTimeInMilliseconds());
	}
	
	@Test
	void testMyTimer3() {
		
		long expectedTime = 3780000;
		MyTimer myTimer = new MyTimer(1, 3);
		
		assertEquals(expectedTime, myTimer.getTimeInMilliseconds());
	}
	

	@Test
	void testStartTimer() {
		
		MyTimer myTimer = new MyTimer(2, 5);
		
		assertFalse(myTimer.startTimer(null));	
	}
	
	@Test
	void testStartTimer2() {
		
		MyTimer myTimer = new MyTimer(0, 0);
		
		TimerTask mockTast = new TimerTask() {
			
			@Override
			public void run() {
			}
		};
		
		
		assertTrue(myTimer.startTimer(mockTast));
	}
	
	@Test
	void testStartTimer3() {
		
		MyTimer myTimer = new MyTimer(1, 3);
		
		TimerTask mockTast = new TimerTask() {
			
			@Override
			public void run() {
				assertTrue(true);
			}
		};
		
		myTimer.startTimer(mockTast);
		myTimer.startTimer(mockTast);
		
		int expected = 2;
		
		myTimer.getTimer().cancel();
		int actual = myTimer.getTimer().purge();
		
		assertEquals(expected, actual);
	}
	

	@Test
	void testGetTimer() {

		MyTimer myTimer = new MyTimer(2, 5);
		
		assertEquals(Timer.class, myTimer.getTimer().getClass());

	}
	
	@Test
	void testGetTimer2() {
		
		MyTimer myTimer = new MyTimer(3, 6);
		
		assertSame(myTimer.getTimer(), myTimer.getTimer());
		
	}

	@Test
	void testGetTimeInMilliseconds() {
		long expectedTime = 7500000;
		
		MyTimer myTimer = new MyTimer(2, 5);
		
		long actualTime = myTimer.getTimeInMilliseconds();
		
		assertEquals(expectedTime, actualTime);
	}

}
