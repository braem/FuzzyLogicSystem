package structures;

import java.io.Serializable;
import java.util.HashSet;

/**
 * Contains the information needed by a user.
 * 
 * @author Breamen
 * @version 1.0
 */
public class User implements Serializable {
	private static final long serialVersionUID = -4383872330755026265L;
	private String firstName;
	private String lastName;
	private HashSet<LearningPlan> plan;
	
	/**
	 * Creates a new User with the specified first name, last name, and learning plan list.
	 * 
	 * @param firstName    The user's first name.
	 * @param lastName     The user's last name.
	 * @param p            The learning plan list.
	 */
	public User(String firstName, String lastName, HashSet<LearningPlan> p) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setLearningPlan(p);
	}
	
	/**
	 * Creates a User with the specified first and last name
	 * 
	 * @param firstName    The user's first name.
	 * @param lastName     The user's last name.
	 */
	public User(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	/**
	 * Returns the user's full name.
	 * 
	 * @return    The user's full name.
	 */
	public String getUserName() {
		return firstName+"_"+lastName;
	}
	
	/**
	 * Returns the user's first name.
	 * 
	 * @return       The user's first name.
	 */
	public String getFirstName() {
		return firstName;
	}
	
	/**
	 * Returns the user's learning plan list.
	 * 
	 * @return    The user's learning plan list.
	 */
	public HashSet<LearningPlan> getLearningPlan()
	{
		return plan;
	}
	
	/**
	 * Sets the user's learning plan.
	 * 
	 * @param p      The new learning plan.
	 */
	public void setLearningPlan (HashSet<LearningPlan> p)
	{
		plan = p;
	}
	
	/**
	 * Sets the user's first name.
	 * 
	 * @param firstName    The user's new first name.
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	/**
	 * Returns the user's last name.
	 * 
	 * @return          The user's last name.
	 */
	public String getLastName() {
		return lastName;
	}
	
	/**
	 * Sets the user's last name.
	 * 
	 * @param lastName     The user's new last name.
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
