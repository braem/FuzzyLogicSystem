package system;

/**
 * @author Rhys
 * */
/*
 * Representation for rules of the form Antecedent -> Consequent 
 * */
public class Rule implements Antecedent, Consequent{

	private Antecedent theLeft;
	private Consequent theRight;
	
	public Rule()
	{
		theLeft = null;
		theRight=null;
	}
	
	public Rule(Antecedent a, Consequent c)
	{
		setAntecedent(a);
		setConsequent(c);
	}
	
	public Antecedent getAntecedent() {
		return theLeft;
	}
	public void setAntecedent(Antecedent theLeft) {
		this.theLeft = theLeft;
	}
	public Consequent getConsequent() {
		return theRight;
	}
	public void setConsequent(Consequent theRight) {
		this.theRight = theRight;
	}
	
	/*
	 * Sets the Consequent's satisfied variable to the value returned by testing the Antecedent.
	 * */
	public void evaluate()
	{
		theRight.setSatisfied(theLeft.testAntecedent());
	}
	
	/*
	 * Sets the Consequent's satisfied variable to the value returned by testing the Antecedent.
	 * Returns the value of the consequent (and antecedent).
	 * */
	public boolean test()
	{
		theRight.setSatisfied(theLeft.testAntecedent());
		return theLeft.testAntecedent();
	}

	@Override
	public void setSatisfied(boolean arg) {
		theRight.setSatisfied(arg);
	}

	@Override
	public boolean isSatisfied() {
		return theRight.isSatisfied();
	}

	@Override
	public boolean testAntecedent() {
		return theLeft.testAntecedent();
	}
	

}
