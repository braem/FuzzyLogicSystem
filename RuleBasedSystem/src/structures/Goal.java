package structures;
import java.io.Serializable;
import java.util.ArrayList;


import system.Antecedent;
import system.Consequent;

/**
 * A set of tests that need to be completed.
 * Intended to be used by LearningPlan.
 * 
 * @author Breamen
 */
public class Goal implements Consequent, Antecedent, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884557923175830060L;
	private ArrayList<Test> tests;
	private boolean satisfied;
	private User user;
	public String name;
	
	/**
	 * Creates an empty goal.
	 */
	public Goal()
	{
		tests = null;
		satisfied = false;
		user = null;
		name = null;
	}
	
	/*
	 * Creates a goal with the specified user and title.
	 * 
	 * @param s      The user the goal is assigned to.
	 * @param g      The title of the goal.
	 */
	public Goal(User s, String g)
	{
		setUser(s);
		setTests(new ArrayList<Test>());
		setSatisfied(false);
		setName(g);
	}
	
	/*
	 * Creates a goal with the specified user, title, and list of tests.
	 * It also allows specification on whether it is satisfied.
	 * 
	 * @param s         The user the goal is assigned to.
	 * @param t         The list of tests.
	 * @param c         The desired satisfied state.
	 * @param g         The title of the goal.
	 */
	public Goal(User s, ArrayList<Test> t, boolean c, String g)
	{
		setUser(s);
		setTests(t);
		setSatisfied(c);
		setName(g);
	}
	
	/*
	 * Sets the user the goal is assigned to.
	 * 
	 * @param s      The users the goal is assigned to.
	 */
	public void setUser(User s)
	{
		user = s;
	}
	
	/*
	 * Sets the list of tests.
	 * 
	 * @param tests     The new list of tests.
	 */
	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}
	
	/*
	 * Sets the title of the goal.
	 * 
	 * @param g      The new title of the goal.
	 */
	public void setName(String g)
	{
		name = g;
	}
	
	/*
	 * Sets whether the goal is satisfied.
	 * 
	 * @param arg       The new satisfied state.
	 */
	@Override
	public void setSatisfied(boolean arg) {
		satisfied = arg;
	}
	
	/*
	 * Returns the list of tests.
	 * 
	 * @return    The list of tests.
	 */
	public ArrayList<Test> getTests()
	{
		return tests;
	}
	
	/*
	 * Returns the users assigned to the goal.
	 * 
	 * @return       The user assigned to the goal.
	 */
	public User getUser()
	{
		return user;
	}
	
	/*
	 * Returns the title of the goal.
	 * 
	 * @return    The title of the goal.
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Returns whether the goal is satisfied.
	 * 
	 * @return       <code>true</code> if the goal is satisfied.
	 *               <code>false</code> otherwise.
	 */
	@Override
	public boolean isSatisfied() {
		return satisfied;
	}
	
	/*
	 * Returns whether the all the tests have been passed.
	 * 
	 * @return       <code>true</code> if all test have been passed.
	 *               <code>false</code> if any test has not been passed.
	 */
	@Override
	public boolean testAntecedent() {
		boolean answer = true;
		for (Test test : tests)
		{
			answer &= test.isPassed();
		}
		
		return answer;
	}
	
	/*
	 * Tests if two goals are equal.
	 * 
	 * @param g      The goal to be compared against this one.
	 * @return       <code>true</code> if the goal is equal to this one.
	 *               <code>false</code> otherwise.
	 */
	public boolean equals(Goal g)
	{
		boolean equal = true;
		ArrayList<Test> otherTests = g.getTests();
		
		if(!(this.tests.size() == otherTests.size())) equal = false;
		
		for(int i = 0; i < this.tests.size() && equal; i++)
		{
			if(!this.tests.get(i).equals(otherTests.get(i))) equal = false;
		}
		
		return equal;
	}
	
	/*
	 * Tests whether an object is equal to this goal.
	 * 
	 * @param obj       The object to be compared to this goal.
	 * @return          <code>true</code> if the object is equal to this goal.
	 *                  <code>false</code> otherwise.
	 */
	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Goal)) return false;
		Goal goal = (Goal)obj;
		if(!name.equals(goal.getName())) return false;
		if(!tests.equals(goal.getTests())) return false;
		return true;
	}
	
	/*
	 * Prints the title of this goal as a String.
	 * 
	 * @return       The title of this goal.
	 */
	@Override
	public String toString()
	{
		return name;
	}
}


