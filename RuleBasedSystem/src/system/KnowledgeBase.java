package system;

import java.util.ArrayList;

import structures.Goal;
import structures.LearningPlan;

/**
 * The KnowledgeBase stores Rules for use by an InferenceEngine.
 * 
 * @author Rhys
 * @version 1.0
 */
public class KnowledgeBase {
	private ArrayList<Rule> rules;
	private String name;
	
	/**
	 * Creates a KnowledgeBase with an empty rule list.
	 */
	public KnowledgeBase()
	{
		rules = new ArrayList<Rule>();
	}
	
	/**
	 * Creates a KnowledgeBase with the specified rule list.
	 * 
	 * @param r      The rule list.
	 */
	public KnowledgeBase(ArrayList<Rule> r)
	{
		setRules(r);
	}
	
	/**
	 * Sets a new rule list.
	 * 
	 * @param r      The new rule list.
	 */
	public void setRules(ArrayList<Rule> r)
	{
		rules = r;
	}
	
	/**
	 * Sets the name of the knowledge base.
	 * 
	 * @param n      The new name.
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/**
	 * Returns the name of the knowledge base
	 * 
	 * @return       The name of the knowledge base.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the name of the knowledge base.
	 * 
	 * @return       The name of the knowledge base.
	 */
	public String toString()
	{
		return name;
	}
	
	/**
	 * Returns the list of rules.
	 * 
	 * @return       The list of rules.
	 */
	public ArrayList<Rule> getRules()
	{
		return rules;
	}
	
	/**
	 * This method allows the KnowledgeBase to create a rule based representation of the state
	 * of a user's current learning plan on demand.  It is assumed that if you want a new knowledge
	 * base with only one plan in it, then you will use a new InferenceEngine.  Otherwise, plans
	 * stack in the knowledge base.
	 * 
	 * @param plan      The learning plan to get the rules from.
	 */
	public void rulesFromPlan(LearningPlan plan)
	{
		
		//First, create the plan completion rule: Goal1 AND Goal2 AND ... AND Goaln --> Plan complete
		
		ComplexAntecedent planAnt = new ComplexAntecedent(plan.getGoals());
		Rule planRule = new Rule(planAnt, plan);
		rules.add(planRule);
		
		//Next, create all the individual goal rules: Test1 AND Test2 AND ... AND Testn --> Goal<whichever goal it is>
		
		ComplexAntecedent goalAnt;
		Rule goalRule;
		
		for(Goal goal : plan.getGoals())
		{
			goalRule = new Rule();
			goalAnt = new ComplexAntecedent();
			goalAnt.setAntecedents(goal.getTests());
			goalRule.setAntecedent(goalAnt);
			goalRule.setConsequent(goal);
			rules.add(goalRule);
		}
		
	}

}
