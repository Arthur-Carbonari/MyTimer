import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArgsParserTest {
	
	static private String[][] mockValidArgsArray = {{"1.1"}, {".1"}, {"2,3"}, {"03:12"}, {"10"}, {"5."} };
	static private String[][] parsedExpectedArgsArray = {  {"1", "1"} , {"0" , "1"}, {"2" , "3"} , {"03" , "12"}, {"0" , "10"} , {"5" , "0"}  };
	static private String[][] mockInvalidArgsArray = {{"1 1"}, {"123123123121"}, {"12>21"}, {"01;12"}, {"12-21"}, {"1*22"}, {}, {"12", "23"} };
	
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
	void testParseArgs() {
		String[] expectedOutput = {"5" , "10"};
		
		String[] actualOutput = ArgsParser.parseArgs(new String[] {"5.10"});
		
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testParseArgs2() {
		
		ArrayList<String[]> actualOutputList = new ArrayList<String[]>();
		
		for (String[] validArgs : mockValidArgsArray) {
			actualOutputList.add(ArgsParser.parseArgs(validArgs));
		}
		
		String[][] actualOutputArray = new String[0][0];
		
		actualOutputArray = actualOutputList.toArray(actualOutputArray);
		
		
		assertArrayEquals(parsedExpectedArgsArray, actualOutputArray);
	}

}
