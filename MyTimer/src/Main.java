import java.io.IOException;

public class Main {


	public static void main(String[] args) {

		if(!ArgsParser.isArgsValid(args)) {
			System.out.println("Invalid argument for <alarm time>");
			System.out.println("Argument must be in the format HH.MM .MM HH. MM H.M (valid separators are: [,], [.], [:].");
			return;
		}
		
		String[] parsedArgs = ArgsParser.parseArgs(args);
		
		System.out.println("Timer set to T - " + parsedArgs[0] + ":" + parsedArgs[1]);
		
		String myTimerAbsolutePath = Main.class.getResource("MyTimer.class").getPath().replaceFirst("MyTimer.class", "");
		
		String command = CommandBuilder.getRunJavaClassCommand(myTimerAbsolutePath, "MyTimer", parsedArgs);
		
		try {
			Runtime.getRuntime().exec(command);
		} catch (IOException e) {
			System.out.println("Error while trying to run MyTimer command.");
			e.printStackTrace();
		}
		
	}

}
