package structures;

import java.io.Serializable;

/**
 * A question to be used by Test.
 * 
 * @author Braemen
 * @version 1.0
 */
public class Question implements Serializable
{
	private static final long serialVersionUID = 5309465185881803883L;
	private String question;
	private AnswerValue answer;
	
	/**
	 * Creates a question with the specified text and answer.
	 * 
	 * @param question     The text of the question.
	 * @param answer       The Answer to the question.
	 * @param isBonus      Whether the question is a bonus question.
	 */
	public Question(String question, AnswerValue answer, boolean isBonus) {
		this.question = "";
	   if(isBonus)
			this.question = "-Bonus-\n";
		this.question += question;
		this.answer = answer;
	}
	
	/**
	 * Returns the text of the question.
	 * @return       The text of the question.
	 */
	public String getQuestion() {
		return question;
	}
	
	/**
	 * Returns the answer to the question
	 * @return       The question's answer.
	 */
	public AnswerValue getAnswer() {
		return answer;
	}
	
	/**
	 * Checks if an answer is the correct answer.
	 * @param answer    The answer to check.
	 * @return          <code>true</code> if the answer is correct.
	 *                  <code>false</code> otherwise.
	 */
	public boolean isCorrectAnswer(AnswerValue answer) {
		if(this.answer.equals(answer)) return true;
		else return false;
	}
	
	/**
	 * Returns the text of the question.
	 * @return       The text of the question.
	 */
	@Override
	public String toString() {
		return question;
	}
}
