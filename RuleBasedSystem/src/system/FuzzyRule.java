package system;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * This class represents a fuzzy rule with multiple antecedent fuzzy sets and a single output fuzzy set.
 * @author Rhys Beck
 * @verion 2.0
 */

public class FuzzyRule<OutputX> implements Serializable{

	private static final long serialVersionUID = -1012205804486859967L;
	ArrayList<DiscreteFuzzySet> antecedents;
	DiscreteFuzzySet<OutputX> consequent;
	String name;
	
	/**
	 * Constructs a FuzzyRule from the antecedents and consequent provided.
	 * @param ants an ArrayList of DiscreteFuzzySets representing the fuzzy consequents of this rule.
	 * @param cons	a DiscreteFuzzySet representing the consequent of this rule.
	 */
	public FuzzyRule(ArrayList<DiscreteFuzzySet> ants, DiscreteFuzzySet<OutputX> cons) {
		setAntecedents(ants); 
		setConsequent(cons);
	}

	/**
	 * Returns the antecedents of this FuzzyRule
	 * @return an ArrayList of DiscreteFuzzySet representing the antecedents of this FuzzyRule.
	 */
	public ArrayList<DiscreteFuzzySet> getAntecedents() {
		return antecedents;
	}

	/**
	 * Sets the antecedents of this FuzzyRule
	 * @param antecedents An ArrayList of DiscreteFuzzySet representing the antecedents of this FuzzyRule.
	 */
	public void setAntecedents(ArrayList<DiscreteFuzzySet> antecedents) {
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
	 * @param inputs An array of Pair<String, Input> where String is the name of the fuzzy set to which the Input belongs.
	 * @return the output DiscreteFuzzySet resulting from firing this rule with the inputs provided.
	 * @throws FuzzyRuleBadInputTypeException 
	 * @throws DiscreteFuzzySetNegativeMaximumException 
	 */
	@SuppressWarnings("rawtypes")
	public DiscreteFuzzySet<OutputX> fire(Pair[] inputs) throws FuzzyRuleBadInputTypeException
	{
		DiscreteFuzzySet<OutputX> output = new DiscreteFuzzySet<OutputX>(consequent);
		
		if(inputs.length == antecedents.size())
		{
			double minMembership = 1.0;
			
			for(DiscreteFuzzySet fs : antecedents)
			{
				for(Pair pair : inputs)
				{
					Class setInputType = ((Pair) fs.getPoints().get(0)).getFirst().getClass();
					Class inputType = pair.getSecond().getClass();
					Class shouldBeString = pair.getFirst().getClass();
					
					if(inputType.equals( setInputType ) && shouldBeString.equals("".getClass()))
					{					
						double testMem = fs.getMembership(pair.getSecond());
						if(pair.getFirst().equals(fs.getName()) && testMem < minMembership)
						{
							minMembership = testMem;
						}
					}
					else throw new FuzzyRuleBadInputTypeException();				
				}
			}
			
			output.truncate(minMembership);
		}
		
		return output;
	}
	
	/**
	 * Sets the name of this FuzzyRule.
	 * @param name a String giving the name of this FuzzyRule.
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	
	/**
	 * Overrides the default toString method. Returns the name of this FuzzyRule.
	 */
	public String toString()
	{
		return name;
	}

}
