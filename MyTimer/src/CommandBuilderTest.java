import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CommandBuilderTest {

	@Test
	void testGetRunJavaClassCommand() {
		
		String expected = "javaw -cp C:/test; Test 1 2";
		String[] args = {"1" , "2"};
		
		String actual = CommandBuilder.getRunJavaClassCommand("C:/test", "Test", args);
		
		assertEquals(expected, actual);
	}
	
	@Test
	void testGetRunJavaClassCommand2() {
		String expected = "javaw -cp /C:/Users/arthu/git/MyTimer/MyTimer/bin/; MyTimer 5 6";
		
		String[] args = {"5", "6"};
		
		String actual = CommandBuilder.getRunJavaClassCommand("/C:/Users/arthu/git/MyTimer/MyTimer/bin/", "MyTimer", args);
	
		assertEquals(expected, actual);
	}

}
