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

	public Attempt() {
		normalAnswers = new ArrayList<AnswerValue>();
		bonusAnswers = new ArrayList<AnswerValue>();
	}

	public Attempt(ArrayList<AnswerValue> normalAnswers) {
		this.normalAnswers = normalAnswers;
		bonusAnswers = new ArrayList<AnswerValue>();
		
	}
	public Attempt(ArrayList<AnswerValue> normalAnswers, ArrayList<AnswerValue> bonusAnswers) {
		this.normalAnswers = normalAnswers;
		this.bonusAnswers = bonusAnswers;
	}
	
	public ArrayList<AnswerValue> getNormalAnswers() { return normalAnswers; }
	public ArrayList<AnswerValue> getBonusAnswers() { return bonusAnswers; }
	
	@Override
	public String toString()
	{
		return normalAnswers+"\n"+bonusAnswers;
	}
}
