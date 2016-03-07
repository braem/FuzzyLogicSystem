package structures;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

/**
 * A class to test the Marker class
 * @author Braemen
 * @version 1.0
 */
public class MarkerTest {

	/**
	 * A test.
	 */
   @Test
	public void perfectScoreTest1() {
		ArrayList<AnswerValue> exampleKey = new ArrayList<AnswerValue>();
		exampleKey.add(AnswerValue.A); exampleKey.add(AnswerValue.E);
		exampleKey.add(AnswerValue.B); exampleKey.add(AnswerValue.B);
		assertTrue(Marker.mark(new Attempt(exampleKey), new Attempt(exampleKey)) == 100.0);
	}
   
   /**
    * A test.
    */
	@Test
	public void perfectScoreTest2() {
		Question q1 = new Question("Q1", AnswerValue.G, false);
		Question q2 = new Question("Q2", AnswerValue.C, false);
		Question q3 = new Question("Q3", AnswerValue.C, false);
		ArrayList<Question> questions = new ArrayList<Question>();
		questions.add(q1); questions.add(q2); questions.add(q3);
		ArrayList<AnswerValue> exampleKey = new ArrayList<AnswerValue>();
		exampleKey.add(AnswerValue.G); exampleKey.add(AnswerValue.C); exampleKey.add(AnswerValue.C);
		structures.Test test = new structures.Test("example_test", questions, new Attempt(exampleKey));
		assertTrue(Marker.mark(test, new Attempt(exampleKey)) == 100.0);
	}
	
}
