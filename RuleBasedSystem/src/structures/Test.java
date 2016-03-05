package structures;
import java.io.Serializable;
import java.util.ArrayList;

import system.Antecedent;


/**
 * 
 * @author braemen
 *
 *
 *	TODO give each test its own folder of which holds the attempts
 */
public class Test implements Antecedent, Serializable
{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 486056762589500608L;
	private static final double passingGrade = 50.0;
	private String testName;
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;

	public Test()
	{
		testName = null;
		normalQuestions = null;
		bonusQuestions = null;
	}
	
	public Test(String testName, ArrayList<Question> normalQuestions, ArrayList<Question> bonusQuestions) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = bonusQuestions;
	}

	
	public Test(String testName, ArrayList<Question> normalQuestions) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = new ArrayList<Question>();
	}
	
	public boolean isPassed()
	{//TODO
		double mark = 0.0;
		return mark > passingGrade;
	}
	
	@Override
	public String toString() {
		return testName;
	}
	
	public String getTestName() {
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
	
	public boolean testAntecedent()
	{
		return this.isPassed();
	}

}
