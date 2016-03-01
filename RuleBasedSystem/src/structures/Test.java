package structures;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author braemen
 *
 *
 *	TODO give each test its own folder of which holds the attempts
 */
public class Test
{
	private String testName;
	private List<Question> normalQuestions;
	private List<Question> bonusQuestions;
	private List<PreReq> prereqs;

	public Test(String testName, List<Question> normalQuestions, List<Question> bonusQuestions, List<PreReq> prereqs) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = bonusQuestions;
		this.prereqs = prereqs;
	}
	public Test(String testName, List<Question> normalQuestions, List<PreReq> prereqs) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = new ArrayList<Question>();
		this.prereqs = prereqs;
	}
	public Test(String testName, List<Question> normalQuestions) {
		this.testName = testName;
		this.normalQuestions = normalQuestions;
		this.bonusQuestions = new ArrayList<Question>();
		this.prereqs = null;
	}
	
	@Override
	public String toString() {
		return testName;
	}
	
	public String getTestName() {
		return testName;
	}

	public List<Question> getNormalQuestions() {
		return normalQuestions;
	}

	public void setNormalQuestions(List<Question> normalQuestions) {
		this.normalQuestions = normalQuestions;
	}

	public List<Question> getBonusQuestions() {
		return bonusQuestions;
	}

	public void setBonusQuestions(List<Question> bonusQuestions) {
		this.bonusQuestions = bonusQuestions;
	}
	public List<PreReq> getPrereq() {
		return prereqs;
	}
	public void setPrereq(List<PreReq> prereqs) {
		this.prereqs = prereqs;
	}
	
}
