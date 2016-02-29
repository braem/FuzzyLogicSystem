package structures;
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

	public Test(String testName, ArrayList<Question> normalQuestions, ArrayList<Question> bonusQuestions) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = bonusQuestions;
	}
	
	@Override
	public String toString() {
		return testName;
	}

	public ArrayList<Question> getNormalQuestions() {
		return normalQuestions;
	}

	public void setNormalQuestions(ArrayList<Question> normalQuestions) {
		this.normalQuestions = normalQuestions;
	}

	public ArrayList<Question> getBonusQuestions() {
		return bonusQuestions;
	}

	public void setBonusQuestions(ArrayList<Question> bonusQuestions) {
		this.bonusQuestions = bonusQuestions;
	}
	
}
