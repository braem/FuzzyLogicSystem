package structures;

import system.DiscreteFuzzySet;

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
	
   /**
    * Calculates the percentage of correct answers to a test.
    * @param test               The test that is being marked.
    * @param studentAttempt     The user's attempted answers.
    * @return                   The mark the user got on the test.
    */
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
	
   /**
    * Returns the DiscreteFuzzySet representing the Success fuzzy set to which this User's mark has greatest membership.
    * @param student A User whose LVProfile is to be used for fuzzy grading.
    * @param mark	The input crisp mark to be fuzzified.
    * @return		A DiscreteFuzzySet representing the fuzzy value corresponding to the Student's test score.
    */
   public static DiscreteFuzzySet<Integer> fuzzyMark(User student, double mark)
   {
	   
	   String grade = getLetterGrade(mark);   

	   
	 return student.getSuccess().greatestMembershipSet(letterGradeToSuccessValue(grade));
   }
   
   
   public static int letterGradeToSuccessValue(String grade)
   {
	   int successValue;
		 switch(grade)
		 {
		 case "A+": successValue = 13; break;
		 case "A": successValue = 12; break;
		 case "A-": successValue = 11; break;
		 case "B+": successValue = 10; break;
		 case "B": successValue = 9; break;
		 case "B-": successValue = 8; break;
		 case "C+": successValue = 7; break;
		 case "C": successValue = 6; break;
		 case "C-": successValue = 5; break;
		 case "D+": successValue = 4; break;
		 case "D": successValue = 3; break;
		 case "D-": successValue = 2; break;
		 case "F": successValue = 1; break;
		 default: successValue = 0; break;
		 }
		 
		 return successValue;
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
