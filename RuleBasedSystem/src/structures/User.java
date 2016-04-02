package structures;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;

import system.FuzzyTrapezoid;
import system.FuzzyTrapezoidInvalidPointsException;
import system.FuzzyTrapezoidNegativeMaximumException;
import system.LinguisticVariable;
import system.NonUniqueLinguisticVariableSetNamesException;

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
	private ArrayList<LinguisticVariable> LVProfile;
	
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
	 * Initializes this User's Difficulty LinguisticVariable and adds it to the LVProfile.
	 */
	private void initDifficulty()
	{
		FuzzyTrapezoid diffEasy = null;
		FuzzyTrapezoid diffMedium = null;
		FuzzyTrapezoid diffHard = null;
		LinguisticVariable difficulty = null;
		
		try{
			diffEasy = new FuzzyTrapezoid(0.0, 0.0, 25.0, 35.0, 1.0, "Easy");
			diffMedium = new FuzzyTrapezoid(25.0, 35.0, 55.0, 65.0, 1.0, "Medium");
			diffHard = new FuzzyTrapezoid(55.0, 65.0, 100.0, 100.0, 1.0, "Hard");
			ArrayList<FuzzyTrapezoid> diffList = new ArrayList<>();
			diffList.add(diffEasy);
			diffList.add(diffMedium);
			diffList.add(diffHard);
			
			difficulty = new LinguisticVariable(diffList);
			difficulty.setName("Difficulty");
		}catch(FuzzyTrapezoidInvalidPointsException e)
		{
			//Print an error to UI somehow.
		}catch(FuzzyTrapezoidNegativeMaximumException e)
		{
			//Print an error to UI somehow.
		}catch(NonUniqueLinguisticVariableSetNamesException e)
		{
			//Print an error to UI somehow.
		}
		
		this.LVProfile.add(difficulty);
	}
	
	/**
	 * Initializes this User's Success LinguisticVariable and adds it to the LVProfile.
	 */
	private void initSuccess()
	{
		FuzzyTrapezoid succBad = null;
		FuzzyTrapezoid succGood = null;
		FuzzyTrapezoid succExcellent = null;
		LinguisticVariable success = null;
		
		try{
			succBad = new FuzzyTrapezoid(0.0, 0.0, 50.0, 55.0, 1.0, "Bad");
			succGood = new FuzzyTrapezoid(55.0, 65.0, 75.0, 85.0, 1.0, "Good");
			succExcellent = new FuzzyTrapezoid(75.0, 85.0, 100.0, 100.0, 1.0, "Excellent");
			ArrayList<FuzzyTrapezoid> succList = new ArrayList<>();
			succList.add(succBad);
			succList.add(succGood);
			succList.add(succExcellent);
			
			success = new LinguisticVariable(succList);
			success.setName("Difficulty");
		}catch(FuzzyTrapezoidInvalidPointsException e)
		{
			//Print an error to UI somehow.
		}catch(FuzzyTrapezoidNegativeMaximumException e)
		{
			//Print an error to UI somehow.
		}catch(NonUniqueLinguisticVariableSetNamesException e)
		{
			//Print an error to UI somehow.
		}
		
		this.LVProfile.add(success);
	}
	
	/**
	 * Initializes this User's Success LinguisticVariable and adds it to the LVProfile.
	 */
	private void initLearning()
	{
		FuzzyTrapezoid learnBad = null;
		FuzzyTrapezoid learnGood = null;
		FuzzyTrapezoid learnExcellent = null;
		LinguisticVariable learning = null;
		
		try{
			learnBad = new FuzzyTrapezoid(0.0, 0.0, 25.0, 35.0, 1.0, "Bad");
			learnGood = new FuzzyTrapezoid(25.0, 35.0, 55.0, 65.0, 1.0, "Good");
			learnExcellent = new FuzzyTrapezoid(55.0, 65.0, 100.0, 100.0, 1.0, "Excellent");
			ArrayList<FuzzyTrapezoid> learnList = new ArrayList<>();
			learnList.add(learnBad);
			learnList.add(learnGood);
			learnList.add(learnExcellent);
			
			learning = new LinguisticVariable(learnList);
			learning.setName("Difficulty");
		}catch(FuzzyTrapezoidInvalidPointsException e)
		{
			//Print an error to UI somehow.
		}catch(FuzzyTrapezoidNegativeMaximumException e)
		{
			//Print an error to UI somehow.
		}catch(NonUniqueLinguisticVariableSetNamesException e)
		{
			//Print an error to UI somehow.
		}
		
		this.LVProfile.add(learning);
	}
	
	
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
	 * Returns the LinguisticVariable profile of this user.
	 * @return An ArrayList<LinguisticVariable> which gives the LinguisticVariable profile of this user.
	 */
	public ArrayList<LinguisticVariable> getLVProfile()
	{
		return LVProfile;
	}
	
	/**
	 * Returns the LinguisticVariable from this User's LVProfile with the name specified.
	 * @param name A String specifying the name of the desired LinguisticVariable.
	 * @return	The LinguisticVariable with the name specified.
	 */
	public LinguisticVariable getLinguisticVariable(String name)
	{
		LinguisticVariable retVar = null;
		
		for(LinguisticVariable var : LVProfile)
		{
			if(var.getName().equals(name)) 
			{
				retVar = var;
				break;
			}
		}
		
		return retVar;
	}
}
