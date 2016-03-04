package structures;
import java.util.ArrayList;
import java.util.List;

import system.Antecedent;


/**
 * 
 * @author braemen
 *
 *
 *	TODO give each test its own folder of which holds the attempts
 */
public class Test implements Antecedent
{
	
	private static final double passingGrade = 50.0;
	private String testName;
	private List<Question> normalQuestions;
	private List<Question> bonusQuestions;

	public Test(String testName, List<Question> normalQuestions, List<Question> bonusQuestions) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = bonusQuestions;
	}

	
	public Test(String testName, List<Question> normalQuestions) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = new ArrayList<Question>();
	}
	
	public boolean isPassed()
	{
		double mark = MainIO.getAttemptMark(this.testName);
		return mark > passingGrade;
	}
	
	@Override
	public String toString() {
		return testName;
	}
	
	public String getTestName() {
		return testName;
	}

	public List<Question> getNormalQuestions() {
		return normalQuestions;
	}

	public void setNormalQuestions(List<Question> normalQuestions) {
		this.normalQuestions = normalQuestions;
	}

	public List<Question> getBonusQuestions() {
		return bonusQuestions;
	}

	public void setBonusQuestions(List<Question> bonusQuestions) {
		this.bonusQuestions = bonusQuestions;
	}
	
	public boolean testAntecedent()
	{
		return this.isPassed();
	}

}
