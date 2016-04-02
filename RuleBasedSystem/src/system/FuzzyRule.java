package system;

import java.util.ArrayList;

/**
 * This class represents a fuzzy rule with multiple antecedent fuzzy sets and a single output fuzzy set.
 * @author Rhys Beck
 * @verion 2.0
 */

public class FuzzyRule {

	ArrayList<FuzzyTrapezoid> antecedents;
	FuzzyTrapezoid consequent;
	
	/**
	 * Constructs a FuzzyRule from the antecedents and consequent provided.
	 * @param ants an ArrayList of FuzzyTrapezoids representing the fuzzy consequents of this rule.
	 * @param cons	a FuzzyTrapezoid representing the consequent of this rule.
	 */
	public FuzzyRule(ArrayList<FuzzyTrapezoid> ants, FuzzyTrapezoid cons) {
		setAntecedents(ants); 
		setConsequent(cons);
	}

	/**
	 * Returns the antecedents of this FuzzyRule
	 * @return an ArrayList of FuzzyTrapezoid representing the antecedents of this FuzzyRule.
	 */
	public ArrayList<FuzzyTrapezoid> getAntecedents() {
		return antecedents;
	}

	/**
	 * Sets the antecedents of this FuzzyRule
	 * @param antecedents An ArrayList of FuzzyTrapezoid representing the antecedents of this FuzzyRule.
	 */
	public void setAntecedents(ArrayList<FuzzyTrapezoid> antecedents) {
		this.antecedents = antecedents;
	}

	/**
	 * Returns the consequent of this FuzzyRule
	 * @return  A FuzzyTrapezoid representing the consequent of this FuzzyRule.
	 */
	public FuzzyTrapezoid getConsequent() {
		return consequent;
	}

	/**
	 * Sets the consequent of this FuzzyRule
	 * @param  consequent A FuzzyTrapezoid representing the consequent of this FuzzyRule.
	 */
	public void setConsequent(FuzzyTrapezoid consequent) {
		this.consequent = consequent;
	}
	
	/**
	 * Returns the FuzzyTrapezoid determined by the provided inputs.
	 * @param inputs An array of Pair<String, Double> where String is the name of the fuzzy set to which the Double belongs.
	 * @return
	 * @throws FuzzyTrapezoidNegativeMaximumException 
	 */
	public FuzzyTrapezoid fire(Pair<String, Double>[] inputs) throws FuzzyTrapezoidNegativeMaximumException
	{
		FuzzyTrapezoid output = null;
		
		if(inputs.length == antecedents.size())
		{
			double minMembership = 1.0;
			
			for(FuzzyTrapezoid ft : antecedents)
			{
				for(Pair<String, Double> pair : inputs)
				{
					double testMem = ft.getMembership(pair.getSecond());
					if(pair.getFirst().equals(ft.getName()) && testMem < minMembership)
					{
						minMembership = testMem;
					}
					
				}
			}
			
			output.setMaximum(minMembership);
		}
		
		return output;
	}

}
