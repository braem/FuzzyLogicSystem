package system;

import java.util.ArrayList;

public class WorkingMemory {
	ArrayList<? extends Consequent> hypotheses;
	
	public WorkingMemory(ArrayList<? extends Consequent> h)
	{
		setHypotheses(h);
	}
	
	public void setHypotheses(ArrayList<? extends Consequent> h)
	{
		hypotheses = h;
	}
	
	public void addHypothesis(Consequent c)
	{
		if(!hypotheses.contains(c)) hypotheses.add(c);
	}
}
