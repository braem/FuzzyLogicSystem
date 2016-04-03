package system;

import java.util.ArrayList;

public class FuzzyKnowledgeBase<Output> {

	private ArrayList<FuzzyRule<Output>> fuzzyRules; 
	
	public FuzzyKnowledgeBase(ArrayList<FuzzyRule<Output>> rules) {
		this.fuzzyRules = rules;
	}
	
	/**
	 * Given an set of antecedent DescreteFuzzySets, attempts to locate the matching rules.
	 * @param ants A set of DiscreteFuzzySets to be matched against antecedents of fuzzy rules.
	 * @return An ArrayList of FuzzyRules that match the antecedents provided.
	 */

	public ArrayList<FuzzyRule<Output>> matchRule(ArrayList<DiscreteFuzzySet> ants)
	{
		ArrayList<FuzzyRule<Output>> rules = null;
		FuzzyRule<Output> rule = null;
		
		boolean equal;		
		
		for(int i = 0; i < fuzzyRules.size(); i++ )
		{
			equal = true;
			
			rule = fuzzyRules.get(i);
			ArrayList<DiscreteFuzzySet> ruleAnts = rule.getAntecedents();
			
			if(ants.size() == ruleAnts.size())
			{
				for(int j = 0 ; j < ants.size() ; j++ )
				{
					if(ants.get(j) != ruleAnts.get(j))
					{
						equal = false;
						break;
					}
				}
				
				if(equal) rules.add(rule);
			}
			else equal = false;
			
			if(!equal) break;			
		}
		
		return rules;
		
	}
	
	
	
	
}
