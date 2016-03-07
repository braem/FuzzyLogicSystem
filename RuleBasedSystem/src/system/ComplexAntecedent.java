package system;

import java.util.ArrayList;

import structures.Goal;

/**
 *@author Rhys 
 * An antecedent comprised of multiple conjunctively (logical AND) joined antecedents.
 **/

/*
 * 
 * */
public class ComplexAntecedent implements Antecedent{
	
	private ArrayList<? extends Antecedent> antecedents;
	
	/*
	 * Creates an empty ComplexAntecedent.  Not recommended.
	 */
	public ComplexAntecedent()
	{
		antecedents = null;
	}
	
	/*
	 *	Creates a ComplexAntecedent from an ArrayList<T> where T implements the Antecedent interface
	 *	@param a	A list of Antecedents. 
	 */
	public ComplexAntecedent(ArrayList<? extends Antecedent> a)
	{
		setAntecedents(a);
	}
	
	/*
	 *	Sets antecedents to a given ArrayList<T> where T implments the Antecedent interface.
	 *	@param a	A list of Antecedents. 
	 */
	public void setAntecedents(ArrayList<? extends Antecedent> a)
	{
		antecedents = a;
	}
	
	/*
	 *	Returns the list of antecedents.
	 *	@return antecedents 	The list of Antecedents in this ComplexAntecedent. 
	 */
	public ArrayList<? extends Antecedent> getAntecedents()
	{
		return antecedents;
	}
	
	/*
	 * From Antecedent interface.  Tests the Antecedents that make up this ComplexAntecedent.
	 * @return <code>true</code> if all Antecedents are true.
	 *         <code>false</code> if not all Antecedents are true.
	 */
	public boolean testAntecedent()
	{
		return testAntecedents();
	}
	
	/*
	 * Tests the Antecedents that make up this ComplexAntecedent.
	 *@return <code>true</code> if all Antecedents are true.
	 *        <code>false</code> if not all Antecedents are true.
	 */
	public boolean testAntecedents()
	{
		boolean answer = true;
		
		for(Antecedent ant : antecedents)
		{
			answer &= ant.testAntecedent();
		}
		
		return answer;
	}

	
}
