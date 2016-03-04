package system;

import java.util.ArrayList;

import structures.Goal;

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

	public boolean testAntecedent()
	{
		return testAntecedents();
	}
	
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
