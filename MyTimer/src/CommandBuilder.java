
public class CommandBuilder {

	public static String getRunJavaClassCommand(String classPath, String className, String[] args) {
		
		StringBuilder stringBuilder = new StringBuilder("javaw -cp ");
		
		stringBuilder.append(classPath).append("; ").append(className);
		
		for (String arg : args) {
			stringBuilder.append(" ").append(arg);
		}
		
		
		return stringBuilder.toString();
	}

}
