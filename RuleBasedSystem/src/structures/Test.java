package structures;
import java.io.Serializable;
import java.util.ArrayList;

import system.Antecedent;
import system.Consequent;
import system.FuzzyTrapezoid;


/**
 * A Test is a set of questions and answers and is intended to be used by Goals.
 * It contains a list of questions, a list of bonus questions, and an answer key
 * It can also store a users answers and grade, as well as the fuzzy value for
 * success.
 * 
 * @author Braemen
 * @version 1.0
 */
public class Test implements Antecedent, Consequent, Serializable
{
	private static final long serialVersionUID = 4250849022572701526L;
	private static final double passingGrade = 50.0;
	private String testName;
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;
	private Attempt answerKey;
	private boolean satisfied = false;
	private Attempt studentAttempt;
	private double studentGrade = 0.0;
	private FuzzyTrapezoid success = null;
	
	/**
	 * Creates an empty Test.
	 * Not recommended to be used.
	 */
	public Test()
	{
		testName = null;
		normalQuestions = null;
		bonusQuestions = null;
	}
	
	/**
	 * Creates a Test with normal and bonus questions.
	 * 
	 * @param testName           The title of the test.
	 * @param normalQuestions    The list of normal questions.
	 * @param bonusQuestions     The list of bonus questions.
	 * @param answerKey          The list of answers to both sets of questions.
	 */
	public Test(String testName, ArrayList<Question> normalQuestions, ArrayList<Question> bonusQuestions, Attempt answerKey) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = bonusQuestions;
		this.answerKey = answerKey;
	}

	/**
	 * Creates a Test with only normal questions.
	 * 
	 * @param testName           The title of the test.
	 * @param normalQuestions    The list of questions.
	 * @param answerKey          The list of answers.
	 */
	public Test(String testName, ArrayList<Question> normalQuestions, Attempt answerKey) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = new ArrayList<Question>();
		this.answerKey = answerKey;
	}
	
	/**
	 * Checks if the test has been passed.
	 * 
	 * @return <code>true</code> if the test has a passing grade.
	 *         <code>false</code> if the test does not have a passing grade.
	 */
	public boolean isPassed()
	{//TODO
		return studentGrade >= passingGrade;
	}
	
	/**
	 * Returns the title of the test.
	 * Overwrites the standard toString method.
	 * 
	 * @return    String of the tests name.
	 */
	@Override
	public String toString() {
		return testName;
	}
	
	/**
	 * Returns the title of the test.
	 * 
	 * @return    String of the tests name.
	 */
	public String getTestName() {
		return testName;
	}
	
	/**
	 * Returns the list of the normal questions.
	 * 
	 * @return    The list of normal questions.
	 */
	public ArrayList<Question> getNormalQuestions() {
		return normalQuestions;
	}
	
	/**
	 * Sets a new list of normal questions.
	 * 
	 * @param normalQuestions     The new list of normal questions.
	 */
	public void setNormalQuestions(ArrayList<Question> normalQuestions) {
		this.normalQuestions = normalQuestions;
	}
	
	/**
	 * Returns the list of bonus questions.
	 * 
	 * @return       The list of bonus questions.
	 */
	public ArrayList<Question> getBonusQuestions() {
		return bonusQuestions;
	}
	
	/**
	 * Sets a new list of bonus questions
	 * 
	 * @param bonusQuestions     The new list of bonus questions.
	 */
	public void setBonusQuestions(ArrayList<Question> bonusQuestions) {
		this.bonusQuestions = bonusQuestions;
	}
	
	/**
	 * Returns whether or not the test has a passing grade.
	 * 
	 * @return       <code>true</code> if test has a passing grade.
	 *               <code>false</code> if the test does not have a passing grade.
	 */
	@Override
	public boolean testAntecedent()
	{
		return this.isPassed();
	}
	
	/**
	 * Returns whether or not the test has been satisfied.
	 * 
	 * @return       <code>true</code> if the test is satisfied.
	 *               <code>false</code> if the test is not satisfied.
	 */
	@Override
   public boolean isSatisfied()
	{
		return satisfied;
	}
	
	/**
	 * Sets whether or not the test it satisfied.
	 * 
	 * @param arg       The new satisfied state
	 */
	@Override
	public void setSatisfied(boolean arg) {
		// TODO Auto-generated method stub
		satisfied = arg;
	}
	
	/**
	 * Returns the answer key.
	 * 
	 * @return    The Attempt that contains the answer key.
	 */
	public Attempt getAnswerKey() {
		return answerKey;
	}
	
	/**
	 * Sets the new answer key.
	 * 
	 * @param answerKey       The new answer key.
	 */
	public void setAnswerKey(Attempt answerKey) {
		this.answerKey = answerKey;
	}
	
	/**
	 * Returns the set of answers from the users attempt.
	 * 
	 * @return    The users last attempt.
	 */
	public Attempt getStudentAttempt() {
		return studentAttempt;
	}
	
	/**
	 * Sets the user's attempt
	 * 
	 * @param studentAttempt     The new user attempt.
	 */
	public void setStudentAttempt(Attempt studentAttempt) {
		this.studentAttempt = studentAttempt;
	}
	
	/**
	 * Returns the user's grade.
	 * 
	 * @return    The user's grade.
	 */
	public double getStudentGrade() {
		return studentGrade;
	}
	
	/**
	 * Sets the user's grade.
	 * 
	 * @param studentGrade    The new grade.
	 */
	public void setStudentGrade(double studentGrade) {
		this.studentGrade = studentGrade;
	}
	
	/**
	 * Checks if an object is the same as this test.
	 * 
	 * @param obj    The object being compared.
	 * @return       <code>true</code> if the object is equal to this test.
	 *               <code>false</code> otherwise.
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Test)) return false;
		Test test = (Test)obj;
		if(!testName.equals(test.getTestName())) return false;
		return true;
	}
}
