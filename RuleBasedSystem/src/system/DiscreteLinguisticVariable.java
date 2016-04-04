package system;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Comparator;

import structures.SerializableComparator;

/**
 * 
 * @author Rhys Beck
 * @version 2.0
 */

public class DiscreteLinguisticVariable<Input> implements Serializable {

	private static final long serialVersionUID = -5394991812000135696L;

	private String name;
	private ArrayList<DiscreteFuzzySet<Input>> fuzzySets;
	SerializableComparator<Input> comparator;
	
	/**
	 * Constructs an empty DiscreteLinguisticVariable.
	 * @param name String giving the name of this DiscreteLinguisticVariable
	 * @param Comparator<Input> to be used to compare Input values of this variable's DiscreteFuzzySets.
	 */
	public DiscreteLinguisticVariable(String name, SerializableComparator<Input> c)
	{
		setName(name);
		fuzzySets = new ArrayList<DiscreteFuzzySet<Input>> ();
		comparator = c;
	}
	
	/**
	 * Creates a new DiscreteLingusiticVariable with the given named fuzzy sets.
	 * @param sets An ArrayList of DiscreteFuzzySet<Input>s.
	 * @param name String giving the name of this DiscreteLinguisticVariable
	 * @param Comparator<Input> to be used to compare Input values of this variable's DiscreteFuzzySets.
	 * The Strings give the names of the DiscreteFuzzySet<Input>s, and must be unique.
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 */
	public DiscreteLinguisticVariable(ArrayList<DiscreteFuzzySet<Input>> sets, String name, SerializableComparator<Input> c) throws NonUniqueLinguisticVariableSetNamesException
	{
		setFuzzySets(sets);
		setName(name);
		comparator = c;
	}

	/**
	 * Returns the name, fuzzy set pairs contained within this DiscreteLinguisticVariable.
	 * @return An ArrayList of DiscreteFuzzySet<Input>s.
	 * The Strings give the names of the DiscreteFuzzySet<Input>s, and must be unique.
	 */
	public ArrayList<DiscreteFuzzySet<Input>> getFuzzySets() {
		return fuzzySets;
	}

	/**
	 * Sets the name, fuzzy sets pairs for this DiscreteLinguisticVariable to those provided.
	 * @param fuzzySets An ArrayList of DiscreteFuzzySet<Input>s.
	 * The Strings give the names of the DiscreteFuzzySet<Input>s, and must be unique.
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 */
	public void setFuzzySets(ArrayList<DiscreteFuzzySet<Input>> fuzzySets) throws NonUniqueLinguisticVariableSetNamesException
	{
		
		boolean nonUniqueNames = false;
		
		for(DiscreteFuzzySet<Input> p : fuzzySets)
		{
			if(nonUniqueNames) break;
			for(DiscreteFuzzySet<Input> q : fuzzySets)
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
	 * Returns the name of this DiscreteLinguisticVariable
	 * @return name a String giving the name of this DiscreteLinguisticVaraible
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of this DiscreteLinguisticVariable
	 * @param name a String giving the name of this DiscreteLinguisticVaraible
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * @throws NonUniqueLinguisticVariableSetNamesException 
	 * Adds a fuzzy set to this linguistic variable if it's name is not the same as another fuzzy set.
	 * Returns true if successful, false if unsuccessful.
	 * @param ft A DiscreteFuzzySet<Input> representing a fuzzy membership function.
	 * @throws NonUniqueLinguisticVariableSetNamesException
	 * 
	 */
	public void addFuzzySet(DiscreteFuzzySet<Input> ft) throws NonUniqueLinguisticVariableSetNamesException
	{
		boolean nonUniqueSetName = false;
		for(DiscreteFuzzySet<Input> set : fuzzySets)
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
		else throw new NonUniqueLinguisticVariableSetNamesException();
		
	}
	
	/**
	 * Removes from fuzzySets that set with name equal to the name argument.
	 * If no matching set is found, nothing happens.
	 * As names are required to be unique, only one set will be removed.
	 * @param name a String giving the name of the fuzzy set to be removed.
	 */
	public void removeFuzzySet(String name)
	{
		for(DiscreteFuzzySet<Input> ft : fuzzySets)
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
	 * @param name the DiscreteFuzzySet<Input> to be removed.
	 */
	public void removeFuzzySet(DiscreteFuzzySet<Input> remove)
	{
		for(DiscreteFuzzySet<Input> ft : fuzzySets)
		{
			if(ft.equals(remove)) 
			{
				fuzzySets.remove(remove);
				break;
			}
		}
	}
	
	/**
	 * Returns the DiscreteFuzzySet<Input> with the name provided.  Returns null if no fuzzy set with that name exists.
	 * @param name A String giving the name of the desired DiscreteFuzzySet<Input>
	 * @return	retSet A DiscreteFuzzySet<Input> with the name provided, if it exists.  Otherwise, null.
	 */
	public DiscreteFuzzySet<Input> getFuzzySet(String name)
	{
		DiscreteFuzzySet<Input> retSet = null;
		
		for(DiscreteFuzzySet<Input> ft : fuzzySets)
		{
			if(ft.getName().equals(name)) 
			{
				retSet=ft;
			}
		}
		
		return retSet;
	}
	
	/**
	 * Returns the DiscreteFuzzySet<Input> among this DiscreteLinguisticVariable's fuzzy sets which gives the greatest
	 * membership value to the input, or null if the input is outside the defined bounds of this DiscreteLinguisticVariable's fuzzy sets.
	 * @param input	 A double value.
	 * @return	A DiscreteFuzzySet<Input> representing the fuzzy set to which the input has the greatest membership.
	 */
	public DiscreteFuzzySet<Input> greatestMembershipSet(Input input)
	{
		//Check that input is within the domain of the LinguisticVariable.
		Input lowerBound = getLowerBound();
		Input upperBound = getUpperBound();
		DiscreteFuzzySet<Input> retSet = null;
		
		if(comparator.compare(lowerBound, input) <= 0 && comparator.compare( input, upperBound) <= 0)
		{
			double greatestMembership = -1.0; //If the greatest membership is 0, still want to return that set.
			
			for(DiscreteFuzzySet<Input> ft : fuzzySets)
			{
				double testMem = ft.getMembership(input);
				if(testMem > greatestMembership) 
				{
					greatestMembership = testMem;
					retSet = ft;
				}
			}
		}
		
		return retSet;
	}
	
	/**
	 * Returns the minimum value for which this DiscreteLinguisticVariable is defined.
	 * @return An Input giving the minimum value for which this DiscreteLinguisticVariable is defined.
	 */
	public Input getLowerBound()
	{
		Input minimum = fuzzySets.get(0).getPoints().get(0).getFirst(); //Need some starting point within the domain.
		
		for(DiscreteFuzzySet<Input> fs : fuzzySets)
		{
			for(Pair <Input, Double> pair : fs.getPoints())
			{
				if(comparator.compare(pair.getFirst(), minimum) < 0 ) minimum = pair.getFirst();
			}
		}
		
		return minimum;		
	}
	
	/**
	 * Returns the maximum value for which this DiscreteLinguisticVariable is defined.
	 * @return An Input giving the maximum value for which this DiscreteLinguisticVariable is defined.
	 */
	public Input getUpperBound()
	{
		Input maximum = fuzzySets.get(0).getPoints().get(0).getFirst(); //Need some starting point within the domain.
		
		for(DiscreteFuzzySet<Input> fs : fuzzySets)
		{
			for(Pair <Input, Double> pair : fs.getPoints())
			{
				if(comparator.compare(pair.getFirst(), maximum) > 0 ) maximum = pair.getFirst();
			}
		}
		
		return maximum;		
	}
	
	/**
	 * Returns the comparator used by this DiscreteLinguisticVariable.
	 * @return Comparator used by this DiscreteLinguisticVariable.
	 */
	public Comparator<Input> getComparator()
	{
		return comparator;
	}
	
	/**
	 * Returns the DiscreteFuzzySet<Input> resulting from the AND (minimum) operation on the two named
	 * which are part of this DicreteLinguisticVariable.
	 * @param fname String name of one of the DiscreteFuzzySets to be used.
	 * @param sname	String name of the other DiscreteFuzzySet to be used.
	 * @return	DiscreteFuzzySet resulting from the AND (minimum) operation on the two named sets.
	 */
	public DiscreteFuzzySet<Input> AND(String fname, String sname)
	{
		DiscreteFuzzySet<Input> first = this.getFuzzySet(fname);
		DiscreteFuzzySet<Input> second = this.getFuzzySet(sname);
		
		ArrayList<Pair<Input, Double>> firstPts = first.getPoints();
		ArrayList<Pair<Input, Double>> secondPts = second.getPoints();
		ArrayList<Pair<Input, Double>> newValues = new ArrayList<>();
		
		
		for(int i = 0 ; i < firstPts.size(); i++)
		{
			Pair<Input, Double> min;
			min = ( firstPts.get(i).getSecond() <= secondPts.get(i).getSecond() ) ? firstPts.get(i) : secondPts.get(i);
			newValues.add(min);
		}
		
		DiscreteFuzzySet<Input> result = new DiscreteFuzzySet<Input>(newValues, "fname AND sname", this);
		
		return result;
	}
	
	/**
	 * Returns the DiscreteFuzzySet<Input> resulting from the OR (maximum) operation on the two named
	 * which are part of this DicreteLinguisticVariable.
	 * @param fname String name of one of the DiscreteFuzzySets to be used.
	 * @param sname	String name of the other DiscreteFuzzySet to be used.
	 * @return	DiscreteFuzzySet resulting from the OR (maximum) operation on the two named sets.
	 */
	public DiscreteFuzzySet<Input> OR(String fname, String sname)
	{
		DiscreteFuzzySet<Input> first = this.getFuzzySet(fname);
		DiscreteFuzzySet<Input> second = this.getFuzzySet(sname);
		
		ArrayList<Pair<Input, Double>> firstPts = first.getPoints();
		ArrayList<Pair<Input, Double>> secondPts = second.getPoints();
		ArrayList<Pair<Input, Double>> newValues = new ArrayList<>();
		
		
		for(int i = 0 ; i < firstPts.size(); i++)
		{
			Pair<Input, Double> max;
			max = ( firstPts.get(i).getSecond() >= secondPts.get(i).getSecond() ) ? firstPts.get(i) : secondPts.get(i);
			newValues.add(max);
		}
		
		DiscreteFuzzySet<Input> result = new DiscreteFuzzySet<Input>(newValues, "fname OR sname", this);
		
		return result;
	}
	
	/**
	 * Overrides the default toString() method.
	 * Returns the name of this DiscreteLinguisticVariable.
	 * @return String, the name of this DiscreteLinguisticVariable.
	 */
	public String toString()
	{
		return name;
	}
	
}
