import static org.junit.jupiter.api.Assertions.*;

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
		fail("Not yet implemented");
	}

	@Test
	void testGetMyTimer() {
		fail("Not yet implemented");
	}

	@Test
	void testGetTimeInMilliseconds() {
		fail("Not yet implemented");
	}

}
