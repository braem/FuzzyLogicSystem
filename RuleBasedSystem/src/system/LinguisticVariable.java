package system;

import java.util.ArrayList;
import java.util.EnumMap;

/**
 * 
 * @author Rhys Beck
 * @version 2.0
 */

public class LinguisticVariable {
	
	
	private String name;

	private ArrayList<FuzzyTrapezoid> fuzzySets;
	
	/**
	 * Constructs an empty LinguisticVariable.
	 */
	public LinguisticVariable ()
	{
		fuzzySets = new ArrayList<FuzzyTrapezoid> ();
	}
	
	/**
	 * Creates a new LingusiticVariable with the given named fuzzy sets.
	 * @param sets An ArrayList of FuzzyTrapezoids.
	 * The Strings give the names of the FuzzyTrapezoids, and must be unique.
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 */
	public LinguisticVariable(ArrayList<FuzzyTrapezoid> sets) throws NonUniqueLinguisticVariableSetNamesException
	{
		setFuzzySets(sets);
	}

	/**
	 * Returns the name, fuzzy set pairs contained within this LinguisticVariable.
	 * @return An ArrayList of FuzzyTrapezoids.
	 * The Strings give the names of the FuzzyTrapezoids, and must be unique.
	 */
	public ArrayList<FuzzyTrapezoid> getFuzzySets() {
		return fuzzySets;
	}

	/**
	 * Sets the name, fuzzy sets pairs for this LinguisticVariable to those provided.
	 * @param fuzzySets An ArrayList of FuzzyTrapezoids.
	 * The Strings give the names of the FuzzyTrapezoids, and must be unique.
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 */
	public void setFuzzySets(ArrayList<FuzzyTrapezoid> fuzzySets) throws NonUniqueLinguisticVariableSetNamesException
	{
		
		boolean nonUniqueNames = false;
		
		for(FuzzyTrapezoid p : fuzzySets)
		{
			if(nonUniqueNames) break;
			for(FuzzyTrapezoid q : fuzzySets)
			{
				if(p != q & p.getName().equals(q.getName()))
				{
					nonUniqueNames = true;
					break;
				}
			}
		}
		
		if(nonUniqueNames) throw new NonUniqueLinguisticVariableSetNamesException();
		
		this.fuzzySets = fuzzySets;
	}
	
	/**
	 * Returns the name of this LinguisticVariable
	 * @return name a String giving the name of this LinguisticVaraible
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this LinguisticVariable
	 * @param name a String giving the name of this LinguisticVaraible
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * Adds a fuzzy set to this linguistic variable if it's name is not the same as another fuzzy set.
	 * Returns true if successful, false if unsuccessful.
	 * @param ft A FuzzyTrapezoid representing a fuzzy membership function.
	 * @return	<code>true</code>  if ft added successfully
	 *          <code>false</code> if ft not added successfully
	 */
	public boolean addFuzzySet(FuzzyTrapezoid ft)
	{
		boolean nonUniqueSetName = false;
		for(FuzzyTrapezoid set : fuzzySets)
		{
			if(set.getName().equals(ft.getName()))
			{
				nonUniqueSetName = true;
				break;
			}
		}
		
		if(!nonUniqueSetName)
		{
			fuzzySets.add(ft);
		}
		
		return nonUniqueSetName;
	}
	
	/**
	 * Removes from fuzzySets that set with name equal to the name argument.
	 * If no matching set is found, nothing happens.
	 * As names are required to be unique, only one set will be removed.
	 * @param name a String giving the name of the fuzzy set to be removed.
	 */
	public void removeFuzzySet(String name)
	{
		for(FuzzyTrapezoid ft : fuzzySets)
		{
			if(ft.getName().equals(name)) 
			{
				fuzzySets.remove(ft);
				break;
			}
		}
	}
	
	/**
	 * Removes from fuzzySets that set equal to the argument.
	 * If no matching set is found, nothing happens.
	 * As names are required to be unique, only one set will be removed.
	 * @param name the FuzzyTrapezoid to be removed.
	 */
	public void removeFuzzySet(FuzzyTrapezoid remove)
	{
		for(FuzzyTrapezoid ft : fuzzySets)
		{
			if(ft.equals(remove)) 
			{
				fuzzySets.remove(remove);
				break;
			}
		}
	}
	
	/**
	 * Overrides the Object toString method.  Returns the name of this LinguisticVariable.
	 */
	public String toString()
	{
		return name;
	}
	
}
