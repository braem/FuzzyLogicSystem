package system;

import java.util.ArrayList;

import structures.Goal;
import structures.LearningPlan;

/**
 * @author Rhys
 * */

/*
 * The KnowledgeBase stores Rules for use by an InferenceEngine.
 * */

public class KnowledgeBase {
	private ArrayList<Rule> rules;
	private String name;
	
	
	public KnowledgeBase()
	{
		rules = new ArrayList<Rule>();
	}
	
	public KnowledgeBase(ArrayList<Rule> r)
	{
		setRules(r);
	}
	
	public void setRules(ArrayList<Rule> r)
	{
		rules = r;
	}

	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
	
	public ArrayList<Rule> getRules()
	{
		return rules;
	}
	
	/*
	 * This method allows the KnowledgeBase to create a rule based representation of the state
	 * of a user's current learning plan on demand.  It is assumed that if you want a new knowledge
	 * base with only one plan in it, then you will use a new InferenceEngine.  Otherwise, plans
	 * stack in the knowledge base.
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
