package structures;

public class PreReq
{
	private Test prereq;
	private Test test;
	
	public PreReq(Test prereq, Test test) {
		this.setPrereq(prereq);
		this.setTest(test);
	}

	public Test getPrereq() {
		return prereq;
	}

	private void setPrereq(Test prereq) {
		this.prereq = prereq;
	}

	public Test getTest() {
		return test;
	}

	private void setTest(Test test) {
		this.test = test;
	}
}
