package program;

/**
 * Where the program begins (where the .jar starts from)
 * Creates the login window
 * 
 * @author Braemen
 * @version 1.0
 */
public class Program
{
	/**
	 * Main method. Starts the program.
	 * 
	 * @param args      List of arguments. Not used.
	 */
   public static void main(String[] args) {
		ChoiceWindow window = new ChoiceWindow();
		window.setResizable(false);
		window.enable();
	}
}
