package system;

import java.io.Serializable;
import java.util.ArrayList;

public class FuzzyKnowledgeBase<Output> implements Serializable {

	private static final long serialVersionUID = -6841997985405265742L;
	private ArrayList<FuzzyRule<Output>> fuzzyRules; 
	private String name;
	
	
	/**
	 * Constructs a new FuzzyKnowledgeBase from a list of provided rules.
	 * @param rules An ArrayList of FuzzyRules to put in this FuzzyKnowledgeBase
	 */
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
		ArrayList<FuzzyRule<Output>> rules = new ArrayList<>();
		FuzzyRule<Output> rule = null;
		
		boolean equal;		
		
		for(int i = 0; i < fuzzyRules.size(); i++ )
		{
			equal = true;
			
			rule = fuzzyRules.get(i);
			ArrayList<DiscreteFuzzySet> ruleAnts = rule.getAntecedents();
			
			if(ants.size() == ruleAnts.size())
			{	
				equal = true;
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
		}
		
		return rules;
		
	}
	
	public void setName(String name)
	{
		this.name = name;
	}
	
	public String toString()
	{
		return name;
	}
	
}
