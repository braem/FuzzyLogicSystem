package system;

import java.util.ArrayList;

import structures.User;

/**
 * An antecedent comprised of multiple conjunctively (logical AND) joined antecedents.
 * 
 * @author Rhys
 * @version 1.0 
 **/

public class ComplexAntecedent implements Antecedent{
	
	private ArrayList<? extends Antecedent> antecedents;
	
	/**
	 * Creates an empty ComplexAntecedent.  Not recommended.
	 */
	public ComplexAntecedent()
	{
		antecedents = null;
	}
	
	/**
	 *	Creates a ComplexAntecedent from an ArrayList&#60;T&#62; where T implements the Antecedent interface
	 *	@param a	A list of Antecedents. 
	 */
	public ComplexAntecedent(ArrayList<? extends Antecedent> a)
	{
		setAntecedents(a);
	}
	
	/**
	 *	Sets antecedents to a given ArrayList&#60;T&#62; where T implments the Antecedent interface.
	 *	@param a	A list of Antecedents. 
	 */
	public void setAntecedents(ArrayList<? extends Antecedent> a)
	{
		antecedents = a;
	}
	
	/**
	 *	Returns the list of antecedents.
	 *	@return       The list of Antecedents in this ComplexAntecedent. 
	 */
	public ArrayList<? extends Antecedent> getAntecedents()
	{
		return antecedents;
	}
	
	/**
	 * From Antecedent interface.  Tests the Antecedents that make up this ComplexAntecedent.
	 * @return <code>true</code> if all Antecedents are true.
	 *         <code>false</code> if not all Antecedents are true.
	 */
	public boolean testAntecedent(User u)
	{
		return testAntecedents(u);
	}
	
	/**
	 * Tests the Antecedents that make up this ComplexAntecedent.
	 * @return <code>true</code> if all Antecedents are true.
	 *        <code>false</code> if not all Antecedents are true.
	 */
	public boolean testAntecedents(User u)
	{
		boolean answer = true;
		
		for(Antecedent ant : antecedents)
		{
			answer &= ant.testAntecedent(u);
		}
		
		return answer;
	}
}
