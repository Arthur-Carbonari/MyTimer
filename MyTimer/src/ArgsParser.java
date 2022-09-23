
public class ArgsParser {

	public static boolean isArgsValid(String[] args) {
		
		if(args.length != 1) return false;
		
		String arg = args[0];
		
		if(!arg.matches("^\\d{1,3}([:.,]\\d{0,3})?$|^[:.,]\\d{1,3}$")) return false;
		
		return true;
	}

	public static String[] parseArgs(String[] args) {
		
		String timeString = args[0];
		
		String[] parsedArray = {"0" , "0"};
		
		if(timeString.matches("^[,.:]?\\d{1,3}$")) {
			
			String minutes = timeString.replaceAll("[,.:]", "");
			
			parsedArray[1] = minutes;
			
			return parsedArray;
		}
		
		if(timeString.matches("^\\d{1,3}[:.,]\\d{0,3}$")) {
			
			String[] splitTimeString = timeString.split("[:.,]", 2);
						
			if(splitTimeString[1] == "") splitTimeString[1] = "0";
			
			parsedArray[0] = splitTimeString[0];
			parsedArray[1] = splitTimeString[1];

			return parsedArray;
		}
		
		
		throw new IllegalArgumentException("Argument in the wrong format.");
		
	}
}
