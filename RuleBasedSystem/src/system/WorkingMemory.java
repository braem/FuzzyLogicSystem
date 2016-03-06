package system;

import java.util.ArrayList;

public class WorkingMemory {
	ArrayList<Consequent> hypotheses;
	ArrayList<Rule> rules;
	String name;

	public WorkingMemory()
	{
		setHypotheses( new ArrayList<Consequent>() );
		setRules( new ArrayList<Rule>() );
	}
	
	public WorkingMemory(ArrayList<Consequent> h)
	{
		setHypotheses(h);
		setRules( new ArrayList<Rule>() );
	}
	
	public void setHypotheses(ArrayList<Consequent> h)
	{
		hypotheses = h;
	}
	
	public void setRules(ArrayList<Rule> r)
	{
		rules = r;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public ArrayList<Consequent> getHypotheses()
	{
		return hypotheses;
	}
	
	public ArrayList<Rule> getRules()
	{
		return rules;
	}
	
	public void addHypothesis(Consequent c)
	{
		if(!hypotheses.contains(c)) hypotheses.add(c);
	}
	
	public boolean contains(Consequent c)
	{
		return hypotheses.contains(c);
	}
	
	public boolean contains(Rule r)
	{
		return rules.contains(r);
	}
	
	public String toString()
	{
		return name;
	}
}
