package structures;

import java.io.Serializable;

/**
 * A pair of goals, one being the prerequisite of the other.
 * Intended to be used by LearningPlan.
 * 
 * @author Breamen
 */
public class PreReq implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = -4882200394636263490L;
	private Goal prereq;
	private Goal goal;
	private String name;
	
	/*
	 * Creates a PreReq with the specified goals and name.
	 * 
	 * @param prereq       Goal that is to be the prereq.
	 * @param test         Goal that is to be requiring a prereq.
	 * @param n            Name of the prereq pair.
	 */
	public PreReq(Goal prereq, Goal test, String n) {
		this.setPreReq(prereq);
		this.setGoal(test);
		this.setName(n);
	}
	
	/*
	 * Returns the prereq goal.
	 * 
	 * @return    The goal that represent the prereq.
	 */
	public Goal getPreReq() {
		return prereq;
	}
	
	/*
	 * Sets the prereq goal.
	 * 
	 * @param prereq       The new goal to be used as the prereq.
	 */
	private void setPreReq(Goal prereq) {
		this.prereq = prereq;
	}
	
	/*
	 * Returns the goal that has a prereq.
	 * 
	 * @return          The goal that has a prereq.
	 */
	public Goal getGoal() {
		return goal;
	}
	
	/*
	 * Sets the goal that has a prereq.
	 * 
	 * @param test      The new goal that has a prereq.
	 */
	private void setGoal(Goal test) {
		this.goal = test;
	}
	
	/*
	 * Sets the name of the prereq pair.
	 * 
	 * @param n         The new name of the prereq pair.
	 */
	public void setName(String n)
	{
		name = n;
	}
	
	/*
	 * Returns the name of the prereq pair.
	 * 
	 * @return          The name of the prereq pair.
	 */
	public String getName()
	{
		return name;
	}
	
	/*
	 * Checks if a PreReq is equal to this one.
	 * 
	 * @param pr        The PreReq to be compared to this one.
	 * @return          <code>true</code> if the PreReq is equal to this one.
	 *                  <code>false</code> otherwise.
	 */
	public boolean equals(PreReq pr)
	{
		return this.getGoal().equals(pr.getGoal()) && this.getPreReq().equals(pr.getPreReq());
	}
	
	/*
	 * Returns the name of the prereq pair.
	 * 
	 * @return       The name of the prereq pair.
	 */
	public String toString()
	{
		return name;
	}
}