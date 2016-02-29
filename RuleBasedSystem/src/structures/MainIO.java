package structures;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MainIO
{
	private final static Charset ENCODING = StandardCharsets.UTF_8;
	private final static String FILE_EXTENSION = ".txt";
	private final static String DIRECTORY = System.getProperty("user.dir");
	private final static int SCORE_INDEX = 0;
	
	//TODO
	public static void writeTestResults(String testName, String userName, Attempt attempt, double mark) {
		String fileName = DIRECTORY+"\\"+testName+"\\"+userName+FILE_EXTENSION;
		
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
			content = new ArrayList<String>();
			content.add(mark+"");
			content.add("Normal Answers:");
			for(AnswerValue ans : attempt.getNormalAnswers())
				content.add(ans+"");
			content.add("Bonus Answers:");
			for(AnswerValue ans : attempt.getBonusAnswers())
				content.add(ans+"");
			try {
				writeToFile(content, fileName);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
	
	private static List<String> readFile(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		return Files.readAllLines(path, ENCODING);
	}
	
	private static void writeToFile(List<String> lines, String fileName) throws IOException {
		Path path = Paths.get(fileName);
		Files.write(path, lines, ENCODING);
	}
}