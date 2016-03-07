package system;

import java.util.ArrayList;

/**
 * A place to hold hypotheses and rules for use by the InferenceEngine.
 * 
 * @author Rhys
 * @version 1.0
 */

public class WorkingMemory {
	ArrayList<Consequent> hypotheses;
	ArrayList<Rule> rules;
	String name;

	/**
	 * Creates a new working memory.
	 */
	public WorkingMemory()
	{
		setHypotheses( new ArrayList<Consequent>() );
		setRules( new ArrayList<Rule>() );
	}
	
	/**
	 *Creates a new working memory from a provided ArrayList<T> where T implements the Consequent interface.
	 *
	 * @param	h	An ArrayList of Consequents.
	 */
	public WorkingMemory(ArrayList<Consequent> h)
	{
		setHypotheses(h);
		setRules( new ArrayList<Rule>() );
	}
	
	/**
	 * Sets hypotheses to the provided ArrayList<T> where T implements the Consequent interface.
	 * 
	 * @param	h	An ArrayList of Consequents.
	 */
	public void setHypotheses(ArrayList<Consequent> h)
	{
		hypotheses = h;
	}
	
	/**
	 * Sets rules to the provided ArrayList of Rules.
	 * 
	 * @param	r	An ArrayList of Rules.
	 */
	public void setRules(ArrayList<Rule> r)
	{
		rules = r;
	}
	
	/**
	 * Sets the name of this WorkingMemory to the provided String.
	 * 
	 * @param	n	A String
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * Returns the name of this WorkingMemory
	 * 
	 * @return name		A String
	 */
	public String getName()
	{
		return name;
	}
	
	
	/**
	 * Returns the list of hypotheses maintained by this WorkingMemory
	 * 
	 * @return hypotheses	An ArrayList<T> where T implements the Consequent interface.
	 */
	public ArrayList<Consequent> getHypotheses()
	{
		return hypotheses;
	}
	
	/**
	 * Returns the list of Rules maintained by this WorkingMemory
	 * 
	 * @return rules	An ArrayList of Rules.
	 */
	public ArrayList<Rule> getRules()
	{
		return rules;
	}
	
	/**
	 * Adds a Consequent to the list of hypotheses maintained by this WorkingMemory if it is not already present.
	 * @param  c		A Consequent
	 * @return rules	An ArrayList of Rules
	 */
	public void addHypothesis(Consequent c)
	{
		if(!hypotheses.contains(c)) hypotheses.add(c);
	}
	
	/**
	 * Determines if a Consequent is already a member of this WorkingMemory's hypotheses.
	 * 
	 * @param  c					A Consequent
	 * @return <code>true</code> 	if the Consequent exists in hypotheses
	 *         <code>false</code> 	otherwise
	 */
	public boolean contains(Consequent c)
	{
		return hypotheses.contains(c);
	}
	
	/**
	 * Determines if a Rule is already a member of this WorkingMemory's rules.
	 * 
	 * @param  c					A Rule
	 * @return <code>true</code> 	if the Rule exists in hypotheses
	 *         <code>false</code> 	otherwise
	 */
	public boolean contains(Rule r)
	{
		return rules.contains(r);
	}
	
	/**
	 * Returns the name of this WorkingMemory
	 * Overrides the toString() method inherited from Object.
	 * 
	 * @return 	name	A String
	 */
	public String toString()
	{
		return name;
	}
}
