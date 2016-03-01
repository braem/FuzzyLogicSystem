package structures;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class MainIOTest {

	@Test
	public void test() {
		List<Question> questions = new ArrayList<Question>();
		structures.Test test = new structures.Test("Basic_Algebra", questions);
		MainIO.createNewTest(test);
	}
	
}
