package structures;

import java.io.Serializable;

public class PreReq implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4882200394636263490L;
	private Goal prereq;
	private Goal goal;
	private String name;
	
	public PreReq(Goal prereq, Goal test, String n) {
		this.setPreReq(prereq);
		this.setGoal(test);
		this.setName(n);
	}

	public Goal getPreReq() {
		return prereq;
	}

	private void setPreReq(Goal prereq) {
		this.prereq = prereq;
	}

	public Goal getGoal() {
		return goal;
	}

	private void setGoal(Goal test) {
		this.goal = test;
	}
	
	public void setName(String n)
	{
		name = n;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean equals(PreReq pr)
	{
		return this.getGoal().equals(pr.getGoal()) && this.getPreReq().equals(pr.getPreReq());
	}
	
	public String toString()
	{
		return name;
	}
}