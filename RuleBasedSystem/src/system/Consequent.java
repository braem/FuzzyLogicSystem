package system;

/**
 * This interface provides a method setSatisfied(boolean) intended to set the state of a 
 * boolean variable within the implementing class.  Java doesn't allow for non-static
 * non-final fields in an interface, so I can't enforce this via the interface.
 * 
 * isSatisfied is meant to return the value of the aforementioned boolean variable.
 * 
 * @author Rhys
 * @version 1.0
 * */
public interface Consequent {
	
	public void setSatisfied(boolean arg);
	public boolean isSatisfied();
}
