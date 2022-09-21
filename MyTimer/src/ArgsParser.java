
public class ArgsParser {

	public static boolean isArgsValid(String[] args) {
		
		if(args.length != 1) return false;
		
		String arg = args[0];
		System.out.println(arg);
		
		if(!arg.matches("^\\d{1,3}([:.,]\\d{0,3})?$|^[:.,]\\d{1,3}$")) return false;
		
		return true;
	}

	public static int[] parseArgsToIntArray(String[] args) {
		
		return new int[2];
	}
}
