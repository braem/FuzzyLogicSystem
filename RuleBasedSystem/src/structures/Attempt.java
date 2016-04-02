package structures;
import java.io.Serializable;
import java.util.ArrayList;

/**
 * Contains the answers to a test.
 * Intended to be used by Test.
 * 
 * @author Braemen
 * @version 1.0
 */
public class Attempt implements Serializable
{
	private static final long serialVersionUID = 1037934762325930610L;
	private ArrayList<AnswerValue> normalAnswers;
	private ArrayList<AnswerValue> bonusAnswers;
	private FuzzyTrapezoid success;
	
	/**
	 * Creates an Attempt with empty answer lists
	 */
	public Attempt() {
		normalAnswers = new ArrayList<AnswerValue>();
		bonusAnswers = new ArrayList<AnswerValue>();
	}
	
	/**
	 * Creates an Attempt with only normal answers
	 * 
	 * @param normalAnswers   The list of answers.
	 */
	public Attempt(ArrayList<AnswerValue> normalAnswers) {
		this.normalAnswers = normalAnswers;
		bonusAnswers = new ArrayList<AnswerValue>();
		
	}
	
	/**
	 * Creates an Attempt with both normal and bonus answers
	 * 
	 * @param normalAnswers   The list of normal answers.
	 * @param bonusAnswers    The list of bonus answers.
	 */
	public Attempt(ArrayList<AnswerValue> normalAnswers, ArrayList<AnswerValue> bonusAnswers) {
		this.normalAnswers = normalAnswers;
		this.bonusAnswers = bonusAnswers;
	}
	
	/**
	 * Returns the list of normal answers.
	 * 
	 * @return    The list of normal answers.
	 */
	public ArrayList<AnswerValue> getNormalAnswers() { return normalAnswers; }
	
	/**
	 * Returns the list of bonus answers.
	 * 
	 * @return    The list of bonus answers.
	 */
	public ArrayList<AnswerValue> getBonusAnswers() { return bonusAnswers; }
	
	/**
	 * Returns the lists of answers as String.
	 * 
	 * @return    String version of the lists of answers.
	 */
	@Override
	public String toString()
	{
		return normalAnswers+"\n"+bonusAnswers;
	}
}
