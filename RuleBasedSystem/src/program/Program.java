package program;

/**
 * 
 * @author braem
 *
 * Where the program begins (where the .jar starts from)
 * Creates the login window
 */
public class Program
{
	public static void main(String[] args) {
		LoginWindow window = new LoginWindow();
		window.enable();
	}
}
