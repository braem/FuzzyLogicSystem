package system;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * 
 * @author Rhys Beck
 * @version 2.0
 */

public class LinguisticVariable {
	
	private ArrayList < Pair <String, FuzzyTrapezoid> > fuzzySets;
	
	/**
	 * Constructs an empty LinguisticVariable.
	 */
	public LinguisticVariable ()
	{
		fuzzySets = new ArrayList < Pair <String, FuzzyTrapezoid> >();
	}
	
	/**
	 * Creates a new LingusiticVariable with the given named fuzzy sets.
	 * @param sets An ArrayList of Pairs of Strings and FuzzyTrapezoids.
	 * The Strings give the names of the FuzzyTrapezoids, and must be unique.
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 */
	public LinguisticVariable(ArrayList < Pair <String, FuzzyTrapezoid> > sets) throws NonUniqueLinguisticVariableSetNamesException
	{
		setFuzzySets(sets);
	}

	/**
	 * Returns the name, fuzzy set pairs contained within this LinguisticVariable.
	 * @return An ArrayList of Pairs of Strings and FuzzyTrapezoids.
	 * The Strings give the names of the FuzzyTrapezoids, and must be unique.
	 */
	public ArrayList<Pair<String, FuzzyTrapezoid>> getFuzzySets() {
		return fuzzySets;
	}

	/**
	 * Sets the name, fuzzy sets pairs for this LinguisticVariable to those provided.
	 * @param fuzzySets An ArrayList of Pairs of Strings and FuzzyTrapezoids.
	 * The Strings give the names of the FuzzyTrapezoids, and must be unique.
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 */
	public void setFuzzySets(ArrayList<Pair<String, FuzzyTrapezoid>> fuzzySets) throws NonUniqueLinguisticVariableSetNamesException
	{
		
		boolean nonUniqueNames = false;
		
		for(Pair p : fuzzySets)
		{
			if(nonUniqueNames) break;
			for(Pair q : fuzzySets)
			{
				if(p != q & p.getFirst().equals(q.getFirst()))
				{
					nonUniqueNames = true;
					break;
				}
			}
		}
		
		if(nonUniqueNames) throw new NonUniqueLinguisticVariableSetNamesException();
		
		this.fuzzySets = fuzzySets;
	}
	
	
}
