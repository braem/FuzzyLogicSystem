
public class Question
{
	private String question;
	private AnswerValue answer;
	
	public Question(String question, AnswerValue answer) {
		this.question = question;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}

	public AnswerValue getAnswer() {
		return answer;
	}
	
	public boolean correctAnswer(AnswerValue answer) {
		if(this.answer.equals(answer)) return true;
		else return false;
	}
}
