import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ArgsParserTest {
	
	static String[][] mockValidArgsArray = {{"1.1"}, {".1"}, {"2,3"}, {"03:12"}, {"10"}};
	static String[][] mockInvalidArgsArray = {{"1 1"}, {"123123123121"}, {"12>21"}, {"01;12"}, {"12-21"}, {"1*22"}, {}, {"12", "23"} };
	
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
	void testIsArgsValid2() {
		
		boolean isInvalid = true;
		
		for (String[] mockArgs : mockInvalidArgsArray) {
			
			if(ArgsParser.isArgsValid(mockArgs)) {
				isInvalid = false;
				break;
			}
			
		}
		
		
		assertTrue(isInvalid);
	}

	@Test
	void testParseArgsToIntArray() {
		fail("Not yet implemented");
	}

}
