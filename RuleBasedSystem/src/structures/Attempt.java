package structures;
import java.util.ArrayList;
import java.util.List;

public class Attempt
{
	private List<AnswerValue> normalAnswers;
	private List<AnswerValue> bonusAnswers;

	public Attempt() {
		normalAnswers = new ArrayList<AnswerValue>();
		bonusAnswers = new ArrayList<AnswerValue>();
	}
	public Attempt(List<AnswerValue> normalAnswers) {
		this.normalAnswers = normalAnswers;
		bonusAnswers = new ArrayList<AnswerValue>();
	}
	public Attempt(List<AnswerValue> normalAnswers, List<AnswerValue> bonusAnswers) {
		this.normalAnswers = normalAnswers;
		this.bonusAnswers = bonusAnswers;
	}
	
	public List<AnswerValue> getNormalAnswers() { return normalAnswers; }
	public List<AnswerValue> getBonusAnswers() { return bonusAnswers; }
}
