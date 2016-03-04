package structures;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainIO
{
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private final static String FILE_EXTENSION = ".txt";
	private final static String DIRECTORY = System.getProperty("user.dir");
	private final static String TEST_DIRECTORY = DIRECTORY+"\\TestBucket";
	private final static int SCORE_INDEX = 0;
	
	/* Writing a New Test */
	public static void createNewTest(Test test) {
		List<String> keyContents = makeAttemptContent(test, 100.0);
//		List<String> prereqContents = makePrereqContent(test);
		try {
			writeToFile(keyContents, TEST_DIRECTORY+"\\"+test.getTestName()+"\\Answer_Key"+FILE_EXTENSION);
//			writeToFile(prereqContents, TEST_DIRECTORY+"\\"+test.getTestName()+"\\PreReqs"+FILE_EXTENSION);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* Writing a Test Attempt */
	public static void writeTestAttempt(Test test, User user, Attempt attempt, double mark) {
		String fileName = TEST_DIRECTORY+"\\"+test.getTestName()+"\\"+user.getUserName()+FILE_EXTENSION;
		
		//get last attempts mark
		boolean shouldWrite = true;
		double previousMark = 0.0;
		List<String> content;
		try {
			content = readFile(fileName);
		} catch (IOException e) {
			return;
		}
		if(content.get(SCORE_INDEX) != null) {
			try {
				previousMark = Double.parseDouble(content.get(SCORE_INDEX));
			} catch(NumberFormatException e) {
				shouldWrite = false;
			}
		}
		else shouldWrite = false;
		
		//if this attempt is better, rewrite the file
		if(shouldWrite && mark>previousMark) {
			content = makeAttemptContent(attempt, mark);
			try {
				writeToFile(content, fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
//	private static List<String> makePrereqContent(Test test) {
//		List<String> content = new ArrayList<String>();
//		for(PreReq prereq : test.getPreReq()) {
//			content.add(prereq.getPreReq().getTestName());
//		}
//		return content;
//	}
	private static List<String> makeAttemptContent(Test test, double mark) {
		List<String> content = new ArrayList<String>();
		content.add(mark+"");
		content.add("Normal Answers:");
		for(Question q : test.getNormalQuestions())
			content.add(q.getAnswer()+"");
		for(Question q : test.getBonusQuestions())
			content.add(q.getAnswer()+"");
		return content;
	}
	private static List<String> makeAttemptContent(Attempt attempt, double mark) {
		List<String> content = new ArrayList<String>();
		content.add(mark+"");
		content.add("Normal Answers:");
		for(AnswerValue ans : attempt.getNormalAnswers())
			content.add(ans+"");
		content.add("Bonus Answers:");
		for(AnswerValue ans : attempt.getBonusAnswers())
			content.add(ans+"");
		return content;
	}
	
	private static List<String> readFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}
	private static void writeToFile(List<String> lines, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Files.write(path, lines, ENCODING);
	}
	
	public static double getAttemptMark(String testName)
	{
		Scanner in = null;
		double mark = -1;
		try{
			in = new Scanner(TEST_DIRECTORY+"\\"+testName+"\\Answer_Key"+FILE_EXTENSION);
		}finally
		{
			mark = -1;
		}
		
		try{
			mark = Double.parseDouble(in.nextLine());
		}finally
		{
			mark = -1;
		}
		
		in.close();
		
		return mark;
	}
}