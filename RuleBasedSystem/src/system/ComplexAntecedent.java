package system;

import java.util.ArrayList;

import structures.Goal;

/**
 *@author Rhys 
 **/

/*
 * An antecedent comprised of multiple conjunctively joined antecedents.
 * */
public class ComplexAntecedent implements Antecedent{
	
	private ArrayList<? extends Antecedent> antecedents;
	
	public ComplexAntecedent()
	{
		antecedents = null;
	}
	
	public ComplexAntecedent(ArrayList<? extends Antecedent> a)
	{
		setAntecedents(a);
	}
	
	public void setAntecedents(ArrayList<? extends Antecedent> a)
	{
		antecedents = a;
	}
	
	public ArrayList<? extends Antecedent> getAntecedents()
	{
		return antecedents;
	}
	
	/*
	 * From Antecedent interface.  Tests the Antecedents that make up this ComplexAntecedent.
	 */
	public boolean testAntecedent()
	{
		return testAntecedents();
	}
	
	/*
	 * Tests the Antecedents that make up this ComplexAntecedent.
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
