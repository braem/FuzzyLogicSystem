package structures;

import java.awt.geom.Point2D;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;

import system.DiscreteFuzzySet;
import system.DiscreteLinguisticVariable;
import system.FuzzyKnowledgeBase;
import system.FuzzyRule;
import system.NonUniqueLinguisticVariableSetNamesException;
import system.Pair;

/**
 * Contains the information needed by a user.
 * 
 * @author Braemen
 * @version 1.0
 */
public class User implements Serializable {
	private static final long serialVersionUID = -4383872330755026265L;
	private String firstName;
	private String lastName;
	private HashSet<LearningPlan> plan;
	private DiscreteLinguisticVariable<Integer> difficulty;
	private DiscreteLinguisticVariable<Integer> success;
	private DiscreteLinguisticVariable<Integer> learning;
	private FuzzyKnowledgeBase<Double> fuzzyRules;
	
	/**
	 * Creates a new User with the specified first name, last name, and learning plan list.
	 * 
	 * @param firstName    The user's first name.
	 * @param lastName     The user's last name.
	 * @param p            The learning plan list.
	 */
	public User(String firstName, String lastName, HashSet<LearningPlan> p) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setLearningPlan(p);
		
		initLinguisticVariables();
		initFuzzyRules();
	}
	
	/**
	 * Creates a User with the specified first and last name
	 * 
	 * @param firstName    The user's first name.
	 * @param lastName     The user's last name.
	 */
	public User(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		
		initLinguisticVariables();
		initFuzzyRules();
	}
	
	/**
	 * Initializes this User's LinguisticVariable profile to default values upon construction.
	 */
	private void initLinguisticVariables()
	{
		initDifficulty();
		initSuccess();	
		initLearning();		
	}
	

	/**
	 * Initializes the nine fuzzy rules used to describe a student's learning
	 * based on the difficulty of a test and their success on it.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initFuzzyRules()
	{
		DiscreteLinguisticVariable learning = this.getLearning();
		DiscreteLinguisticVariable success = this.getSuccess();
		DiscreteLinguisticVariable difficulty = this.getDifficulty();
		
		ArrayList<DiscreteFuzzySet> lSets = learning.getFuzzySets();
		ArrayList<DiscreteFuzzySet> sSets = success.getFuzzySets();
		ArrayList<DiscreteFuzzySet> dSets = difficulty.getFuzzySets();
		
		int stop = sSets.size() * dSets.size();
		int picker = 0;
		
		DiscreteFuzzySet<Double> lbad = learning.getFuzzySet("Bad");
		DiscreteFuzzySet<Double> lgood = learning.getFuzzySet("Good");
		DiscreteFuzzySet<Double> lexc = learning.getFuzzySet("Excellent");
		
		ArrayList<DiscreteFuzzySet<Double>> consOrdering = new ArrayList<>();
		consOrdering.add(lbad);
		consOrdering.add(lbad);
		consOrdering.add(lgood);
		consOrdering.add(lbad);
		consOrdering.add(lgood);
		consOrdering.add(lexc);
		consOrdering.add(lbad);
		consOrdering.add(lexc);
		consOrdering.add(lexc);
		
		ArrayList<FuzzyRule<Double>> rules = new ArrayList<>();
		
		for(DiscreteFuzzySet diff : dSets)
		{
			for(DiscreteFuzzySet succ : sSets)
			{
				ArrayList<DiscreteFuzzySet> ants = new ArrayList<>();
				ants.add(diff);
				ants.add(succ);
				
				DiscreteFuzzySet cons = consOrdering.get(picker++);
				rules.add((new FuzzyRule<Double>(ants, cons)));
			}
		}	
		
		this.fuzzyRules = new FuzzyKnowledgeBase<Double>(rules);
	}

	/**
	 * Initializes this User's Difficulty LinguisticVariable and adds it to the LVProfile.
	 */

	private void initDifficulty()
	{
		DiscreteFuzzySet<Integer> diffEasy = null;
		DiscreteFuzzySet<Integer> diffMedium = null;
		DiscreteFuzzySet<Integer> diffHard = null;
		
	
		ArrayList<Pair<Integer, Double>> easyPoints = new ArrayList<>();
		ArrayList<Pair<Integer, Double>> mediumPoints = new ArrayList<>();
		ArrayList<Pair<Integer, Double>> hardPoints = new ArrayList<>();
		
		easyPoints.add(new Pair<Integer, Double>( 1, 1.0));
		easyPoints.add(new Pair<Integer, Double>( 2, 1.0));
		easyPoints.add(new Pair<Integer, Double>( 3, 1.0));
		easyPoints.add(new Pair<Integer, Double>( 4, 1.0));
		easyPoints.add(new Pair<Integer, Double>( 5, 0.5));
		easyPoints.add(new Pair<Integer, Double>( 6, 0.0));
		easyPoints.add(new Pair<Integer, Double>( 7, 0.0));
		easyPoints.add(new Pair<Integer, Double>( 8, 0.0));
		easyPoints.add(new Pair<Integer, Double>( 9, 0.0));
		easyPoints.add(new Pair<Integer, Double>( 10, 0.0));
		
		mediumPoints.add(new Pair<Integer, Double>( 1, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 2, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 3, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 4, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 5, 0.5));
		mediumPoints.add(new Pair<Integer, Double>( 6, 1.0));
		mediumPoints.add(new Pair<Integer, Double>( 7, 1.0));
		mediumPoints.add(new Pair<Integer, Double>( 8, 0.5));
		mediumPoints.add(new Pair<Integer, Double>( 9, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 10, 0.0));
		
		hardPoints.add(new Pair<Integer, Double>( 1, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 2, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 3, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 4, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 5, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 6, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 7, 0.0));
		hardPoints.add(new Pair<Integer, Double>( 8, 0.5));
		hardPoints.add(new Pair<Integer, Double>( 9, 1.0));
		hardPoints.add(new Pair<Integer, Double>( 10, 1.0));
		
		Comparator<Integer> c = new Comparator<Integer>(){
			public int compare(Integer first, Integer  second)
			{
				return first.compareTo(second);
			}
		};
		

		
		try {
			difficulty = new DiscreteLinguisticVariable<Integer>("Difficulty", c);
			diffEasy = new DiscreteFuzzySet<Integer>(easyPoints, "Easy", difficulty);
			diffMedium = new DiscreteFuzzySet<Integer>(mediumPoints, "Medium", difficulty);
			diffHard = new DiscreteFuzzySet<Integer>(hardPoints, "Hard", difficulty);
			ArrayList<DiscreteFuzzySet<Integer>> diffList = new ArrayList<>();
			diffList.add(diffEasy);
			diffList.add(diffMedium);
			diffList.add(diffHard);
			
			difficulty.setFuzzySets(diffList);
			
		} catch (NonUniqueLinguisticVariableSetNamesException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Initializes this User's Success LinguisticVariable and adds it to the LVProfile.
	 */
	private void initSuccess()
	{
		DiscreteFuzzySet<Integer> succBad = null;
		DiscreteFuzzySet<Integer> succGood = null;
		DiscreteFuzzySet<Integer> succExcellent = null;

		ArrayList<Pair<Integer, Double>> badPoints = new ArrayList<>();
		ArrayList<Pair<Integer, Double>> goodPoints = new ArrayList<>();
		ArrayList<Pair<Integer, Double>> excellentPoints = new ArrayList<>();
		
		badPoints.add(new Pair<Integer, Double>( 1, 1.0));
		badPoints.add(new Pair<Integer, Double>( 2, 1.0));
		badPoints.add(new Pair<Integer, Double>( 3, 1.0));
		badPoints.add(new Pair<Integer, Double>( 4, 1.0));
		badPoints.add(new Pair<Integer, Double>( 5, 1.0));
		badPoints.add(new Pair<Integer, Double>( 6, 0.5));
		badPoints.add(new Pair<Integer, Double>( 7, 0.0));
		badPoints.add(new Pair<Integer, Double>( 8, 0.0));
		badPoints.add(new Pair<Integer, Double>( 9, 0.0));
		badPoints.add(new Pair<Integer, Double>( 10, 0.0));
		badPoints.add(new Pair<Integer, Double>( 11, 0.0));
		badPoints.add(new Pair<Integer, Double>( 12, 0.0));
		badPoints.add(new Pair<Integer, Double>( 13, 0.0));
		
		goodPoints.add(new Pair<Integer, Double>( 1, 0.0));
		goodPoints.add(new Pair<Integer, Double>( 2, 0.0));
		goodPoints.add(new Pair<Integer, Double>( 3, 0.0));
		goodPoints.add(new Pair<Integer, Double>( 4, 0.0));
		goodPoints.add(new Pair<Integer, Double>( 5, 0.0));
		goodPoints.add(new Pair<Integer, Double>( 6, 0.5));
		goodPoints.add(new Pair<Integer, Double>( 7, 1.0));
		goodPoints.add(new Pair<Integer, Double>( 8, 1.0));
		goodPoints.add(new Pair<Integer, Double>( 9, 1.0));
		goodPoints.add(new Pair<Integer, Double>( 10, 1.0));
		goodPoints.add(new Pair<Integer, Double>( 11,  0.5));
		goodPoints.add(new Pair<Integer, Double>( 12, 0.0));
		goodPoints.add(new Pair<Integer, Double>( 13, 0.0));
		
		excellentPoints.add(new Pair<Integer, Double>( 1, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 2, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 3, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 4, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 5, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 6, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 7, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 8, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 9, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 10, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 11, 0.5));
		excellentPoints.add(new Pair<Integer, Double>( 12, 1.0));
		excellentPoints.add(new Pair<Integer, Double>( 13, 1.0));
		

		
		Comparator<Integer> c = new Comparator<Integer>(){
			public int compare(Integer first, Integer second)
			{
				return first.compareTo(second);
			}
		};
		

		
		try {
			success = new DiscreteLinguisticVariable<Integer>("Success", c);
			succBad = new DiscreteFuzzySet<Integer>(badPoints, "Bad", success);
			succGood = new DiscreteFuzzySet<Integer>(goodPoints, "Good", success);
			succExcellent = new DiscreteFuzzySet<Integer>(excellentPoints, "Excellent", success);
			ArrayList<DiscreteFuzzySet<Integer>> succList = new ArrayList<>();
			succList.add(succBad);
			succList.add(succGood);
			succList.add(succExcellent);
			
			success.setFuzzySets(succList);
		} catch (NonUniqueLinguisticVariableSetNamesException e) {
			
			e.printStackTrace();
		}

	}
	
	/**
	 * Initializes this User's Success LinguisticVariable and adds it to the LVProfile.
	 */
	private void initLearning()
	{
		DiscreteFuzzySet<Integer> learnBad = null;
		DiscreteFuzzySet<Integer> learnGood = null;
		DiscreteFuzzySet<Integer> learnExcellent = null;
		

		ArrayList<Pair<Integer, Double>> badPoints = new ArrayList<>();
		ArrayList<Pair<Integer, Double>> mediumPoints = new ArrayList<>();
		ArrayList<Pair<Integer, Double>> excellentPoints = new ArrayList<>();
		
		badPoints.add(new Pair<Integer, Double>( 1, 1.0));
		badPoints.add(new Pair<Integer, Double>( 2, 1.0));
		badPoints.add(new Pair<Integer, Double>( 3, 1.0));
		badPoints.add(new Pair<Integer, Double>( 4, 1.0));
		badPoints.add(new Pair<Integer, Double>( 5, 0.5));
		badPoints.add(new Pair<Integer, Double>( 6, 0.0));
		badPoints.add(new Pair<Integer, Double>( 7, 0.0));
		badPoints.add(new Pair<Integer, Double>( 8, 0.0));
		badPoints.add(new Pair<Integer, Double>( 9, 0.0));
		badPoints.add(new Pair<Integer, Double>( 10, 0.0));
		
		mediumPoints.add(new Pair<Integer, Double>( 1, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 2, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 3, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 4, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 5, 0.5));
		mediumPoints.add(new Pair<Integer, Double>( 6, 1.0));
		mediumPoints.add(new Pair<Integer, Double>( 7, 1.0));
		mediumPoints.add(new Pair<Integer, Double>( 8, 0.5));
		mediumPoints.add(new Pair<Integer, Double>( 9, 0.0));
		mediumPoints.add(new Pair<Integer, Double>( 10, 0.0));
		
		excellentPoints.add(new Pair<Integer, Double>( 1, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 2, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 3, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 4, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 5, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 6, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 7, 0.0));
		excellentPoints.add(new Pair<Integer, Double>( 8, 0.5));
		excellentPoints.add(new Pair<Integer, Double>( 9, 1.0));
		excellentPoints.add(new Pair<Integer, Double>( 10, 1.0));
		
		Comparator<Integer> c = new Comparator<Integer>(){
			public int compare(Integer first, Integer second)
			{
				return first.compareTo(second);
			}
		};		
		try {
			learning = new DiscreteLinguisticVariable<Integer>("Difficulty", c);
			learnBad = new DiscreteFuzzySet<Integer>(badPoints, "Bad", learning);
			learnGood = new DiscreteFuzzySet<Integer>(mediumPoints, "Good", learning);
			learnExcellent = new DiscreteFuzzySet<Integer>(excellentPoints, "Excellent", learning);
			ArrayList<DiscreteFuzzySet<Integer>> learnList = new ArrayList<>();
			learnList.add(learnBad);
			learnList.add(learnGood);
			learnList.add(learnExcellent);
			learning.setFuzzySets(learnList);
		} catch (NonUniqueLinguisticVariableSetNamesException e) {
			
			e.printStackTrace();
		}
	}
	
	
	
	
//	/**
//	 * Initializes this User's Difficulty LinguisticVariable and adds it to the LVProfile.
//	 */
//	private void initDifficulty()
//	{
//		FuzzyTrapezoid diffEasy = null;
//		FuzzyTrapezoid diffMedium = null;
//		FuzzyTrapezoid diffHard = null;
//		LinguisticVariable difficulty = null;
//		
//		try{
//			diffEasy = new FuzzyTrapezoid(0.0, 0.0, 25.0, 35.0, 1.0, "Easy");
//			diffMedium = new FuzzyTrapezoid(25.0, 35.0, 55.0, 65.0, 1.0, "Medium");
//			diffHard = new FuzzyTrapezoid(55.0, 65.0, 100.0, 100.0, 1.0, "Hard");
//			ArrayList<FuzzyTrapezoid> diffList = new ArrayList<>();
//			diffList.add(diffEasy);
//			diffList.add(diffMedium);
//			diffList.add(diffHard);
//			
//			difficulty = new LinguisticVariable(diffList);
//			difficulty.setName("Difficulty");
//		}catch(FuzzyTrapezoidInvalidPointsException e)
//		{
//			//Print an error to UI somehow.
//		}catch(FuzzyTrapezoidNegativeMaximumException e)
//		{
//			//Print an error to UI somehow.
//		}catch(NonUniqueLinguisticVariableSetNamesException e)
//		{
//			//Print an error to UI somehow.
//		}
//		
//		this.LVProfile.add(difficulty);
//	}
//	
//	/**
//	 * Initializes this User's Success LinguisticVariable and adds it to the LVProfile.
//	 */
//	private void initSuccess()
//	{
//		FuzzyTrapezoid succBad = null;
//		FuzzyTrapezoid succGood = null;
//		FuzzyTrapezoid succExcellent = null;
//		LinguisticVariable success = null;
//		
//		try{
//			succBad = new FuzzyTrapezoid(0.0, 0.0, 50.0, 55.0, 1.0, "Bad");
//			succGood = new FuzzyTrapezoid(55.0, 65.0, 75.0, 85.0, 1.0, "Good");
//			succExcellent = new FuzzyTrapezoid(75.0, 85.0, 100.0, 100.0, 1.0, "Excellent");
//			ArrayList<FuzzyTrapezoid> succList = new ArrayList<>();
//			succList.add(succBad);
//			succList.add(succGood);
//			succList.add(succExcellent);
//			
//			success = new LinguisticVariable(succList);
//			success.setName("Success");
//		}catch(FuzzyTrapezoidInvalidPointsException e)
//		{
//			//Print an error to UI somehow.
//		}catch(FuzzyTrapezoidNegativeMaximumException e)
//		{
//			//Print an error to UI somehow.
//		}catch(NonUniqueLinguisticVariableSetNamesException e)
//		{
//			//Print an error to UI somehow.
//		}
//		
//		this.LVProfile.add(success);
//	}
//	
//	/**
//	 * Initializes this User's Success LinguisticVariable and adds it to the LVProfile.
//	 */
//	private void initLearning()
//	{
//		FuzzyTrapezoid learnBad = null;
//		FuzzyTrapezoid learnGood = null;
//		FuzzyTrapezoid learnExcellent = null;
//		LinguisticVariable learning = null;
//		
//		try{
//			learnBad = new FuzzyTrapezoid(0.0, 0.0, 25.0, 35.0, 1.0, "Bad");
//			learnGood = new FuzzyTrapezoid(25.0, 35.0, 55.0, 65.0, 1.0, "Good");
//			learnExcellent = new FuzzyTrapezoid(55.0, 65.0, 100.0, 100.0, 1.0, "Excellent");
//			ArrayList<FuzzyTrapezoid> learnList = new ArrayList<>();
//			learnList.add(learnBad);
//			learnList.add(learnGood);
//			learnList.add(learnExcellent);
//			
//			learning = new LinguisticVariable(learnList);
//			learning.setName("Learning");
//		}catch(FuzzyTrapezoidInvalidPointsException e)
//		{
//			//Print an error to UI somehow.
//		}catch(FuzzyTrapezoidNegativeMaximumException e)
//		{
//			//Print an error to UI somehow.
//		}catch(NonUniqueLinguisticVariableSetNamesException e)
//		{
//			//Print an error to UI somehow.
//		}
//		
//		this.LVProfile.add(learning);
//	}
//	
	
	/**
	 * Returns the user's full name.
	 * 
	 * @return    The user's full name.
	 */
	public String getUserName() {
		return firstName+"_"+lastName;
	}
	
	/**
	 * Returns the user's first name.
	 * 
	 * @return       The user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the user's learning plan list.
	 * 
	 * @return    The user's learning plan list.
	 */
	public HashSet<LearningPlan> getLearningPlan()
	{
		return plan;
	}
	
	/**
	 * Sets the user's learning plan.
	 * 
	 * @param p      The new learning plan.
	 */
	public void setLearningPlan (HashSet<LearningPlan> p)
	{
		plan = p;
	}
	
	/**
	 * Sets the user's first name.
	 * 
	 * @param firstName    The user's new first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the user's last name.
	 * 
	 * @return          The user's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the user's last name.
	 * 
	 * @param lastName     The user's new last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	/**
	 * Returns the success DiscreteLinguisticVariable belonging to this User
	 * @return The DiscreteLinguisticVariable the success DiscreteLinguisticVariable belonging to this User
	 */
	public DiscreteLinguisticVariable<Integer> getSuccess()
	{
		return success;
	}
	
	/**
	 * Returns the learning DiscreteLinguisticVariable belonging to this User
	 * @return The DiscreteLinguisticVariable the learning DiscreteLinguisticVariable belonging to this User
	 */
	public DiscreteLinguisticVariable<Integer> getLearning()
	{
		return learning;
	}
	
	/**
	 * Returns the difficulty DiscreteLinguisticVariable belonging to this User
	 * @return The DiscreteLinguisticVariable the difficulty DiscreteLinguisticVariable belonging to this User
	 */
	public DiscreteLinguisticVariable<Integer> getDifficulty()
	{
		return difficulty;
	}
	
	public FuzzyKnowledgeBase<Double> getFuzzyKnowledgeBase()
	{
		return this.fuzzyRules;
	}
	
}
