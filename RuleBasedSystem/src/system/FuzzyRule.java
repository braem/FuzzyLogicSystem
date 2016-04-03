package system;

import java.util.ArrayList;

/**
 * This class represents a fuzzy rule with multiple antecedent fuzzy sets and a single output fuzzy set.
 * @author Rhys Beck
 * @verion 2.0
 */

public class FuzzyRule<InputX, OutputX> {

	ArrayList<DiscreteFuzzySet<InputX>> antecedents;
	DiscreteFuzzySet<OutputX> consequent;
	
	/**
	 * Constructs a FuzzyRule from the antecedents and consequent provided.
	 * @param ants an ArrayList of DiscreteFuzzySets representing the fuzzy consequents of this rule.
	 * @param cons	a DiscreteFuzzySet representing the consequent of this rule.
	 */
	public FuzzyRule(ArrayList<DiscreteFuzzySet<InputX>> ants, DiscreteFuzzySet<OutputX> cons) {
		setAntecedents(ants); 
		setConsequent(cons);
	}

	/**
	 * Returns the antecedents of this FuzzyRule
	 * @return an ArrayList of DiscreteFuzzySet representing the antecedents of this FuzzyRule.
	 */
	public ArrayList<DiscreteFuzzySet<InputX>> getAntecedents() {
		return antecedents;
	}

	/**
	 * Sets the antecedents of this FuzzyRule
	 * @param antecedents An ArrayList of DiscreteFuzzySet representing the antecedents of this FuzzyRule.
	 */
	public void setAntecedents(ArrayList<DiscreteFuzzySet<InputX>> antecedents) {
		this.antecedents = antecedents;
	}

	/**
	 * Returns the consequent of this FuzzyRule
	 * @return  A DiscreteFuzzySet representing the consequent of this FuzzyRule.
	 */
	public DiscreteFuzzySet<OutputX> getConsequent() {
		return consequent;
	}

	/**
	 * Sets the consequent of this FuzzyRule
	 * @param  consequent A DiscreteFuzzySet representing the consequent of this FuzzyRule.
	 */
	public void setConsequent(DiscreteFuzzySet<OutputX> consequent) {
		this.consequent = consequent;
	}
	
	/**
	 * Returns the DiscreteFuzzySet determined by the provided inputs.
	 * @param inputs An array of Pair<String, Double> where String is the name of the fuzzy set to which the Double belongs.
	 * @return
	 * @throws DiscreteFuzzySetNegativeMaximumException 
	 */
	public DiscreteFuzzySet<OutputX> fire(Pair<String, InputX>[] inputs)
	{
		DiscreteFuzzySet<OutputX> output = new DiscreteFuzzySet<OutputX>(consequent);
		
		if(inputs.length == antecedents.size())
		{
			double minMembership = 1.0;
			
			for(DiscreteFuzzySet<InputX> ft : antecedents)
			{
				for(Pair<String, InputX> pair : inputs)
				{
					double testMem = ft.getMembership(pair.getSecond());
					if(pair.getFirst().equals(ft.getName()) && testMem < minMembership)
					{
						minMembership = testMem;
					}
					
				}
			}
			
			output.truncate(minMembership);
		}
		
		return output;
	}

}
