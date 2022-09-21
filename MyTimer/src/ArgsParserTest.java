import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

class ArgsParserTest {
	
	static String[][] mockValidArgsArray = {{"1.1"}, {".1"}, {"2,3"}, {"03:12"}, {"10"}, {"5."} };
	static int[][] parsedExpectedArgsArray = {  {1, 1} , {0 , 1}, {2 , 3} , {3 , 12}, {3 , 12} , {0 , 10} , {5 , 0}  };
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
		int[] expectedOutput = {5 , 10};
		
		int[] actualOutput = ArgsParser.parseArgsToIntArray(new String[] {"5.10"});
		
		assertArrayEquals(expectedOutput, actualOutput);
	}
	
	@Test
	void testParseArgsToIntArray2() {
		
		ArrayList<int[]> actualOutputList = new ArrayList<int[]>();
		
		for (String[] validArgs : mockValidArgsArray) {
			actualOutputList.add(ArgsParser.parseArgsToIntArray(validArgs));
		}
		
		int[][] actualOutputArray = new int[0][0];
		
		actualOutputArray = actualOutputList.toArray(actualOutputArray);
		
		
		assertArrayEquals(parsedExpectedArgsArray, actualOutputArray);
	}

}
