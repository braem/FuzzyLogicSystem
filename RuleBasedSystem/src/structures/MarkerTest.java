package structures;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MarkerTest {

	@Test
	public void perfectScoreTest1() {
		List<AnswerValue> exampleKey = new ArrayList<AnswerValue>();
		exampleKey.add(AnswerValue.A); exampleKey.add(AnswerValue.E);
		exampleKey.add(AnswerValue.B); exampleKey.add(AnswerValue.B);
		assertTrue(Marker.mark(new Attempt(exampleKey), new Attempt(exampleKey)) == 100.0);
	}

	@Test
	public void perfectScoreTest2() {
		Question q1 = new Question("Q1", AnswerValue.G);
		Question q2 = new Question("Q2", AnswerValue.C);
		Question q3 = new Question("Q3", AnswerValue.C);
		List<Question> questions = new ArrayList<Question>();
		questions.add(q1); questions.add(q2); questions.add(q3);
		List<AnswerValue> exampleKey = new ArrayList<AnswerValue>();
		exampleKey.add(AnswerValue.G); exampleKey.add(AnswerValue.C); exampleKey.add(AnswerValue.C);
		structures.Test test = new structures.Test("example_test", questions);
		assertTrue(Marker.mark(test, new Attempt(exampleKey)) == 100.0);
	}
	
}
