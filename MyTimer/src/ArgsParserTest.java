import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArgsParserTest {
	
	static String[][] mockValidArgsArray = {{"1.1"}, {".1"}, {"2,3"}, {"03:12"}, {"11/11"}, {"10"}};

	@Test
	void testIsArgsValid() {
		
		boolean isValid = true;
		
		for (String[] mockArgs : mockValidArgsArray) {
			
			if(!ArgsParser.isArgsValid(mockArgs)) {
				isValid = false;
				break;
			}
			
		}
		
		
		assertTrue(isValid);
	}

	@Test
	void testParseArgsToIntArray() {
		fail("Not yet implemented");
	}

}
