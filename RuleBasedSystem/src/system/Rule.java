package system;

import structures.User;

/**
 * Representation for rules of the form Antecedent -&#62; Consequent
 * @author Rhys
 * @version 1.0 
 * */
public class Rule implements Antecedent, Consequent{

	private Antecedent theLeft;
	private Consequent theRight;
	
	/**
	 * Creates an empty Rule.  Not recommended.
	 */
	public Rule()
	{
		theLeft = null;
		theRight=null;
	}
	
	/**
	 * Creates a rule from a given Antecedent and Consequent
	 * 
	 * @param	a	An object implementing the Antecedent interface
	 * @param	c	An object implementing the Consequent interface
	 */
	public Rule(Antecedent a, Consequent c)
	{
		setAntecedent(a);
		setConsequent(c);
	}
	
	/**
	 * Returns this Rule's Antecedent
	 * 
	 * @return       The Antecedent of this Rule.
	 */
	public Antecedent getAntecedent() {
		return theLeft;
	}
	
	/**
	 * Sets this Rule's Antecedent to the one provided.
	 * 
	 * @param theLeft	The provided Antecedent of this Rule.
	 */
	public void setAntecedent(Antecedent theLeft) {
		this.theLeft = theLeft;
	}
	
	/**
	 * Returns this Rule's Consequent
	 * 
	 * @return       The Consequent of this Rule.
	 */
	public Consequent getConsequent() {
		return theRight;
	}
	
	/**
	 * Sets this Rule's Consequent to the one provided.
	 * 
	 * @param theRight	The provided Consequent of this Rule.
	 */
	public void setConsequent(Consequent theRight) {
		this.theRight = theRight;
	}
	
	/**
	 * Sets the Consequent's satisfied variable to the value returned by testing the Antecedent.
	 * @param u the current active User
	 * */
	public void evaluate(User u)
	{
		theRight.setSatisfied(theLeft.testAntecedent(u));
	}
	
	/**
	 * Overridden from the Consequent interface.
	 * Sets the satisfied variable to the boolean value provided.
	 * @param	arg		A boolean argument.
	 */
	@Override
	public void setSatisfied(boolean arg) {
		theRight.setSatisfied(arg);
	}

	/**
	 * Overridden from the Consequent interface.
	 * Returns the value of the satisfied variable
	 * @return		A boolean variable representing the truth value of this consequent.
	 */
	@Override
	public boolean isSatisfied() {
		return theRight.isSatisfied();
	}

	/**
	 * Overridden from the Antecedent interface.
	 * Returns the value obtained by testing this Rule's Antecedent.
	 * @return	<code>true</code> if the Antecedent is true
	 *          <code>false</code> if the Antecedent is false.
	 */
	@Override
	public boolean testAntecedent(User u) {
		return theLeft.testAntecedent(u);
	}
	

}
