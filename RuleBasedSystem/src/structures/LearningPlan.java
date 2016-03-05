package structures;
import java.io.Serializable;
import java.util.ArrayList;

import system.Consequent;

public class LearningPlan implements Consequent, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -207368307190505713L;
	private ArrayList<Goal> goals;
	private ArrayList<PreReq> prereqs;
	private boolean satisfied = false;
	private String name;
	
	public LearningPlan(ArrayList<Goal> g, ArrayList<PreReq> pr, String n)
	{
		setGoals(g);
		setPreReqs(pr);
		setName(n);
	}

	public void addPreReq(PreReq pr)
	{
		if(!prereqs.contains(pr)) prereqs.add(pr);
	}
	
	public void removePreReq(PreReq pr)
	{
		prereqs.remove(pr);
	}

	public ArrayList<Goal> getGoals() {
		return goals;
	}

	public void setGoals(ArrayList<Goal> goals) {
		this.goals = goals;
	}

	public ArrayList<PreReq> getPreReqs() {
		return prereqs;
	}

	public void setPreReqs(ArrayList<PreReq> prereqs) {
		this.prereqs = prereqs;
	}
	
	public void setName(String s)
	{
		this.name = s;
	}
	
	public String getName()
	{
		return name;
	}
	
	public String toString()
	{
		return name;
	}
	

	@Override
	public void setSatisfied(boolean arg) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public boolean isSatisfied() {
		// TODO Auto-generated method stub
		return false;
	}
}
