
public class ArgsParser {

	public static boolean isArgsValid(String[] args) {
		
		if(args.length != 1) return false;
		
		String arg = args[0];
		
		if(!arg.matches("^\\d{1,3}([:.,]\\d{0,3})?$|^[:.,]\\d{1,3}$")) return false;
		
		return true;
	}

	public static int[] parseArgsToIntArray(String[] args) {
		
		String timeString = args[0];
		
		int[] intArray = {0 , 0};
		
		if(timeString.matches("^[,.:]?\\d{1,3}$")) {
			
			timeString = timeString.replaceAll("[,.:]", "");
			
			intArray[1] = Integer.parseInt(timeString);
			
			return intArray;
		}
		
		if(timeString.matches("^\\d{1,3}[:.,]\\d{0,3}$")) {
			
			String[] splitTimeString = timeString.split("[:.,]", 2);
						
			if(splitTimeString[1] == "") splitTimeString[1] = "0";
			
			intArray[0] = Integer.parseInt(splitTimeString[0]);
			intArray[1] = Integer.parseInt(splitTimeString[1]);
			return intArray;
		}
		
		
		throw new IllegalArgumentException("Argument in the wrong format.");
		
	}
}
