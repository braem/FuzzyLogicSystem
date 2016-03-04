package system;

import java.util.ArrayList;

import structures.Goal;
import structures.LearningPlan;

public class KnowledgeBase {
	private ArrayList<Rule> rules;
	
	
	public KnowledgeBase(ArrayList<Rule> r)
	{
		setRules(r);
	}
	
	public void setRules(ArrayList<Rule> r)
	{
		rules = r;
	}
	
	public ArrayList<Rule> getRules()
	{
		return rules;
	}
	
	public void rulesFromPlan(LearningPlan plan)
	{
		
		//First, create the plan completion rule: Goal1 AND Goal2 AND ... AND Goaln --> Plan complete
		
		ComplexAntecedent planAnt = new ComplexAntecedent(plan.getGoals());
		Rule planRule = new Rule(planAnt, plan);
		rules.add(planRule);
		
		//Next, create all the individual goal rules: Test1 AND Test2 AND ... AND Testn --> Goal<whichever goal it is>
		
		ComplexAntecedent goalAnt = new ComplexAntecedent();
		Rule goalRule = new Rule();
		
		for(Goal goal : plan.getGoals())
		{
			goalAnt.setAntecedents(goal.getTests());
			goalRule.setAntecedent(goalAnt);
			goalRule.setConsequent(goal);
			rules.add(goalRule);
		}
		
	}

}
