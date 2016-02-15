import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * 
 * @author braemen
 *
 *
 *	TODO give each test its own folder of which holds the attempts
 */
public class Test {

	private String testName;
	private ArrayList<Question> questions;

	@Override
	public String toString() {
		return testName;
	}
	
}
