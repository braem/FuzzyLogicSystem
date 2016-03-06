package system;

import java.util.ArrayList;

import structures.LearningPlan;

public class InferenceEngine
{
	private WorkingMemory memory;
	private KnowledgeBase know;
	private Rule selectedRule;
	
	public InferenceEngine()
	{
		memory = new WorkingMemory();
		know = new KnowledgeBase();
	}
	
	public void init(LearningPlan lp)
	{
		memory.addHypothesis((Consequent) lp);
		know.rulesFromPlan(lp);
	}
	
	public void inferenceCycle()
	{
		ArrayList<Rule> wmRules = memory.getRules();
		ArrayList<Consequent> hyps = memory.getHypotheses();
		ArrayList<Rule> knowRules = know.getRules();
		Rule ruleptr;
			
		
		//Search through the knowledge base for rules whose consequents match the unsatisfied hypotheses in working memory
		for(Consequent hyp : hyps)
		{
			if(!hyp.isSatisfied()) //If that hypothesis is not currently satisfied, i.e. it isn't a fact...
			{
				for(Rule r : knowRules)
				{
					if(r.getConsequent().equals(hyp) && !wmRules.contains(r))//Find a rule with a matching consequent that isn't in working memory...
					{
						wmRules.add(r);//and add it to working memory
						
						r.evaluate();// check conditions of R
						
						if(r.isSatisfied())//If R is satisfied, then the antecedents must be true, and so can be added as facts to working memory.
						{
							
							if(r.getAntecedent() instanceof ComplexAntecedent)
							{
								ComplexAntecedent compAnt = (ComplexAntecedent) r.getAntecedent();
								for(Antecedent ant : compAnt.getAntecedents())
								{
									hyps.add((Consequent) ant);
								}
							}
							else
							{
								hyps.add((Consequent) r.getAntecedent());
							}
							
							hyps.add(r.getConsequent());
						}
						else//Since this rule has not been satisfied...
						{
							continue;//Try to find another applicable rule which is satisfied.
						}

					}
				}
			}
		}
	}
	


}
