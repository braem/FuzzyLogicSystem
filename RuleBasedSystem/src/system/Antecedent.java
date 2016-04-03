package system;
import structures.User;
/**
 * This interface provides a single boolean method to allow testing of an antecedent condition in a rule.
 * A User must be specified to evaluate an Antecedent using that User's specific fuzzy set profile.
 * @author Rhys
 * @version 1.0
 * */
public interface Antecedent {
	public boolean testAntecedent(User u);

}
