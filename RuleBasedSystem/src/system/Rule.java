package system;

public class Rule{

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
	
	
	public boolean test()
	{
		theRight.setSatisfied(theLeft.testAntecedent());
		return theLeft.testAntecedent();
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
	
	public void evaluate()
	{
		theRight.setSatisfied(theLeft.testAntecedent());
	}


}
