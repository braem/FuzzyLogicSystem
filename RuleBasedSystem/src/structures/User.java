package structures;

import java.io.Serializable;

public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -4383872330755026265L;
	private String firstName;
	private String lastName;
	private LearningPlan plan;
	
	public User(String firstName, String lastName, LearningPlan p) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
		this.setLearningPlan(p);
	}
	
	public User(String firstName, String lastName) {
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}

	public String getUserName() {
		return firstName+"_"+lastName;
	}
	
	public String getFirstName() {
		return firstName;
	}
	
	public LearningPlan getLearningPlan()
	{
		return plan;
	}
	
	public void setLearningPlan (LearningPlan p)
	{
		plan = p;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
}
