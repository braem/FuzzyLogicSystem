package structures;
import java.io.Serializable;
import java.util.ArrayList;

import system.Antecedent;
import system.Consequent;


/**
 * 
 * @author braemen
 *
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
	private Attempt answerKey;
	private boolean satisfied = false;
	private Attempt studentAttempt;
	private double studentGrade = 0.0;

	public Test()
	{
		testName = null;
		normalQuestions = null;
		bonusQuestions = null;
	}
	
	public Test(String testName, ArrayList<Question> normalQuestions, ArrayList<Question> bonusQuestions, Attempt answerKey) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = bonusQuestions;
		this.answerKey = answerKey;
	}

	
	public Test(String testName, ArrayList<Question> normalQuestions, Attempt answerKey) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = new ArrayList<Question>();
		this.answerKey = answerKey;
	}
	
	public boolean isPassed()
	{//TODO
		return studentGrade >= passingGrade;
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

	public Attempt getAnswerKey() {
		return answerKey;
	}

	public void setAnswerKey(Attempt answerKey) {
		this.answerKey = answerKey;
	}

	public Attempt getStudentAttempt() {
		return studentAttempt;
	}

	public void setStudentAttempt(Attempt studentAttempt) {
		this.studentAttempt = studentAttempt;
	}

	public double getStudentGrade() {
		return studentGrade;
	}

	public void setStudentGrade(double studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Test)) return false;
		Test test = (Test)obj;
		if(!testName.equals(test.getTestName())) return false;
		return true;
	}

}
