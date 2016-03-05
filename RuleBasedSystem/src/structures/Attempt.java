package structures;
import java.io.Serializable;
import java.util.ArrayList;

public class Attempt implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1037934762325930610L;
	private ArrayList<AnswerValue> normalAnswers;
	private ArrayList<AnswerValue> bonusAnswers;
	private String name;

	public Attempt() {
		normalAnswers = new ArrayList<AnswerValue>();
		bonusAnswers = new ArrayList<AnswerValue>();
		this.name = "Unnamed";
	}
	public Attempt(ArrayList<AnswerValue> normalAnswers) {
		this.normalAnswers = normalAnswers;
		bonusAnswers = new ArrayList<AnswerValue>();
		this.name = "Unnamed";
	}
	public Attempt(ArrayList<AnswerValue> normalAnswers, String n) {
		this.normalAnswers = normalAnswers;
		bonusAnswers = new ArrayList<AnswerValue>();
		this.name = n;
		
	}
	public Attempt(ArrayList<AnswerValue> normalAnswers, ArrayList<AnswerValue> bonusAnswers, String n) {
		this.normalAnswers = normalAnswers;
		this.bonusAnswers = bonusAnswers;
		this.name = n;
	}
	
	public ArrayList<AnswerValue> getNormalAnswers() { return normalAnswers; }
	public ArrayList<AnswerValue> getBonusAnswers() { return bonusAnswers; }
	
	public String toString()
	{
		return name;
	}
}
