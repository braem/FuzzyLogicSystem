import java.util.ArrayList;

/**
 * 
 * @author braemen
 *
 *
 *	TODO give each test its own folder of which holds the attempts
 */
public class Test
{
	private String testName;
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;

	@Override
	public String toString() {
		return testName;
	}
}
