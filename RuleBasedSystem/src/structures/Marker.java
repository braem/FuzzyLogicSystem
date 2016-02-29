package structures;

public class Marker
{
	/* returns percent value */
	public static double mark(Attempt answerKey, Attempt studentAttempt) {
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
	
	public static double mark(Test test, Attempt studentAttempt) {
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
}
