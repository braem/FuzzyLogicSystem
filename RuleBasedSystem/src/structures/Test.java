package structures;
import java.io.Serializable;
import java.util.ArrayList;

import system.Antecedent;
import system.Consequent;
import system.DiscreteFuzzySet;
import system.DiscreteLinguisticVariable;
import system.FuzzyKnowledgeBase;
import system.FuzzyRule;
import system.FuzzyRuleBadInputTypeException;
import system.Pair;
import structures.User;


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
	private int minLearning = 7;
	private int difficulty;
	
	/**
	 * Creates an empty Test.
	 * Not recommended to be used.
	 */
	public Test()
	{
		testName = null;
		normalQuestions = null;
		bonusQuestions = null;
		difficulty = 1.0;
		minLearning = 0.7;
	}
	//TODO Fix constructors so that minLearning and difficulty are taken as arguments.
	//Left alone so that I can continue testing without breaking the builder.
	
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
		difficulty = 1.0;
		minLearning = 0.7;
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
	{
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
	 * @param A User whose fuzzy set profile will be used to test Antecedent
	 * @return       <code>true</code> if test has a passing grade.
	 *               <code>false</code> if the test does not have a passing grade.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public boolean testAntecedent(User u)
	{
		//A test is passed if it's learning is above some number.
		//To determine this, must take this test's crisp difficulty
		//and success values and apply the User's fuzzy sets 
		//then use fuzzy rules and inference to produce
		//a fuzzy learning value.  This is then defuzzified
		//to give a crisp value which is used to determine
		//if this test has been passed or not.
		
		DiscreteLinguisticVariable<String> success = u.getSuccess();
		DiscreteLinguisticVariable<Double> difficulty = u.getDifficulty();
		DiscreteLinguisticVariable<Double> learning = u.getLearning();
		FuzzyKnowledgeBase<Double> ruleBase = u.getFuzzyKnowledgeBase();
		
		String letterGrade = Marker.getLetterGrade(this.studentGrade);
		
		DiscreteFuzzySet<String> sSet = success.greatestMembershipSet(letterGrade);
		DiscreteFuzzySet<Double> dSet = difficulty.greatestMembershipSet(this.difficulty);
		ArrayList<DiscreteFuzzySet> ants = new ArrayList<>();
		ants.add(sSet);
		ants.add(dSet);
		
		ArrayList<FuzzyRule<Double>> matchedRules = ruleBase.matchRule(ants);
		
		ArrayList<DiscreteFuzzySet<Double>> lSets = new ArrayList<>();
		
		Pair[] inputs = {new Pair("Difficulty", this.difficulty), new Pair("Success", letterGrade)};
		
		for(FuzzyRule rule : matchedRules)
		{
			try {
				lSets.add(rule.fire(inputs));
			} catch (FuzzyRuleBadInputTypeException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		DiscreteFuzzySet finalSet = lSets.get(0);
		
		for(DiscreteFuzzySet<Double> set : lSets)
		{
			finalSet = finalSet.OR(set);
		}
		
		double learningValue = finalSet.numericDefuzzify();
		
		return learningValue >= minLearning;	
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
	 * Returns the crisp difficulty value for this Test.
	 * @return a double giving the crisp difficulty value for this test.
	 */
	public double getDifficulty()
	{
		return this.difficulty;
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
