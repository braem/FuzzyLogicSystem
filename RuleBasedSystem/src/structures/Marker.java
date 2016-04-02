package structures;

/**
 * Marks tests based on an attempt.
 * @author Braemen
 * @version 1.0
 */
public class Marker
{
	/**
	 * Calculates the percentage of correct answers to a test.
	 * @param answerKey          The answer key for the test.
	 * @param studentAttempt     The user's attempted answers.
	 * @return                   The mark the user got on the test.
	 */
   public static double mark(User student, Attempt answerKey, Attempt studentAttempt) {
		int maxScore = answerKey.getNormalAnswers().size();
		int numOfBonus = answerKey.getBonusAnswers().size();
		int mark = 0;
		for(int i=0; i<maxScore; i++) {
			AnswerValue expectedAnswer = answerKey.getNormalAnswers().get(i);
			AnswerValue actualAnswer = studentAttempt.getNormalAnswers().get(i);
			if(expectedAnswer.equals(actualAnswer))
				mark++;
		}
		for(int i=0; i<numOfBonus; i++) {
			AnswerValue expectedAnswer = answerKey.getBonusAnswers().get(i);
			AnswerValue actualAnswer = studentAttempt.getBonusAnswers().get(i);
			if(expectedAnswer.equals(actualAnswer))
				mark++;
		}
		return ((double)mark/(double)maxScore)*100.0;
	}
	
   /**
    * Calculates the percentage of correct answers to a test.
    * @param test               The test that is being marked.
    * @param studentAttempt     The user's attempted answers.
    * @return                   The mark the user got on the test.
    */
   public static double mark(User student, Test test, Attempt studentAttempt) {
		int maxScore = test.getNormalQuestions().size();
		int numOfBonus = test.getBonusQuestions().size();
		int mark = 0;
		for(int i=0; i<maxScore; i++) {
			Question currentQuestion = test.getNormalQuestions().get(i);
			if(currentQuestion.isCorrectAnswer(studentAttempt.getNormalAnswers().get(i)))
				mark++;
		}
		for(int i=0; i<numOfBonus; i++) {
			Question currentQuestion = test.getBonusQuestions().get(i);
			if(currentQuestion.isCorrectAnswer(studentAttempt.getBonusAnswers().get(i)))
				mark++;
		}
		return ((double)mark/(double)maxScore)*100.0;
	}
	
   /**
    * The letter grade based on the percentage grade.
    * @param percent    The percentage grade to be converted.
    * @return           The letter grade.
    */
	public static String getLetterGrade(double percent) {
		if(percent >= 90.0)
			return "A+";
		else if(percent >= 85.0)
			return "A";
		else if(percent >= 80.0)
			return "A-";
		else if(percent >= 76.0)
			return "B+";
		else if(percent >= 72.0)
			return "B";
		else if(percent >= 68.0)
			return "B-";
		else if(percent >= 64.0)
			return "C+";
		else if(percent >= 60.0)
			return "C";
		else if(percent >= 55.0)
			return "C-";
		else if(percent >= 50.0)
			return "D";
		else return "F";
	}
}
