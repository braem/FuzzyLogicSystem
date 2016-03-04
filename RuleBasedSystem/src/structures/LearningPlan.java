package structures;
import java.util.ArrayList;

import system.Consequent;

public class LearningPlan implements Consequent {

	private ArrayList<Goal> goals;
	private ArrayList<PreReq> prereqs;
	private boolean satisfied = false;
	
	public LearningPlan(ArrayList<Goal> g, ArrayList<PreReq> pr)
	{
		setGoals(g);
		setPreReqs(pr);
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
