package structures;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import system.Antecedent;
import system.Consequent;


/**
 * 
 * @author braemen
 *
 *
 *	TODO give each test its own folder of which holds the attempts
 */
public class Test implements Antecedent, Consequent, Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4250849022572701526L;
	private static final double passingGrade = 50.0;
	private String testName;
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;
	private boolean satisfied = false;

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
	
	public boolean isSatisfied()
	{
		return satisfied;
	}

	@Override
	public void setSatisfied(boolean arg) {
		// TODO Auto-generated method stub
		satisfied = arg;
	}

}
