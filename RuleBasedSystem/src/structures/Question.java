package structures;

import java.io.Serializable;

public class Question implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5309465185881803883L;
	private String question;
	private AnswerValue answer;
	
	public Question(String question, AnswerValue answer, boolean isBonus) {
		this.question = "";
	   if(isBonus)
			this.question = "-Bonus-\n";
		this.question += question;
		this.answer = answer;
	}
	
	public String getQuestion() {
		return question;
	}

	public AnswerValue getAnswer() {
		return answer;
	}
	
	public boolean isCorrectAnswer(AnswerValue answer) {
		if(this.answer.equals(answer)) return true;
		else return false;
	}
	
	@Override
	public String toString() {
		return question;
	}
}
