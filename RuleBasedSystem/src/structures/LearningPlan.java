package structures;
import java.io.Serializable;
import java.util.ArrayList;

import system.Consequent;

/**
 * A learning plan made up of goals that need to be met.
 * 
 * @author Rhys
 * @version 1.0
 */
public class LearningPlan implements Consequent, Serializable {

	private static final long serialVersionUID = -207368307190505713L;
	private ArrayList<Goal> goals;
	private ArrayList<PreReq> prereqs;
	private boolean satisfied = false;
	private String name;
	
	/**
	 * Creates a learning plan with the specified goal list, prereq list, and name.
	 * @param g      The goal list.
	 * @param pr     The prereq list.
	 * @param n      The name of the learning plan.
	 */
	public LearningPlan(ArrayList<Goal> g, ArrayList<PreReq> pr, String n)
	{
		setGoals(g);
		setPreReqs(pr);
		setName(n);
	}
	
	/**
	 * Adds a prereq to the learning plan.
	 * @param pr     The prereq to add.
	 */
	public void addPreReq(PreReq pr)
	{
		if(!prereqs.contains(pr)) prereqs.add(pr);
	}
	
	/**
	 * Removes a prereq from the learning plan.
	 * @param pr     The prereq to remove.
	 */
	public void removePreReq(PreReq pr)
	{
		prereqs.remove(pr);
	}
	
	/**
	 * Returns the list of goals.
	 * @return    The list of goals.
	 */
	public ArrayList<Goal> getGoals() {
		return goals;
	}
	
	/**
	 * Sets the list of goals.
	 * @param goals     The new list of goals.
	 */
	public void setGoals(ArrayList<Goal> goals) {
		this.goals = goals;
	}
	
	/**
	 * Returns the list of prereqs.
	 * @return       The list of prereq.
	 */
	public ArrayList<PreReq> getPreReqs() {
		return prereqs;
	}
	
	/**
	 * Sets the list of prereqs.
	 * @param prereqs      The new prereq list.
	 */
	public void setPreReqs(ArrayList<PreReq> prereqs) {
		this.prereqs = prereqs;
	}
	
	/**
	 * Sets the name of the learning plan.
	 * @param s      The new name of the learning plan.
	 */
	public void setName(String s)
	{
		this.name = s;
	}
	
	/**
	 * Returns the name of the learning plan.
	 * @return    Name of the learning plan.
	 */
	public String getName()
	{
		return name;
	}
	
	/**
	 * Returns the name of the learning plan.
	 * @return    Name of the learning plan.
	 */
	public String toString()
	{
		return name;
	}
	
	/**
    * Overridden from the Consequent interface.
    * Sets the satisfied variable to the boolean value provided.
    * @param arg      A boolean argument.
    */
	@Override
	public void setSatisfied(boolean arg) {
		// TODO Auto-generated method stub	
	}
	
	/**
    * Overridden from the Consequent interface.
    * Returns the value of the satisfied variable
    * @return      A boolean variable representing the truth value of this consequent.
    */
	@Override
	public boolean isSatisfied() {
		// TODO Auto-generated method stub
		return false;
	}
}
