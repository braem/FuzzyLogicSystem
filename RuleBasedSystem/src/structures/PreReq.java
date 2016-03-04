package structures;
public class PreReq
{
	private Goal prereq;
	private Goal goal;
	
	public PreReq(Goal prereq, Goal test) {
		this.setPreReq(prereq);
		this.setGoal(test);
	}

	public Goal getPreReq() {
		return prereq;
	}

	private void setPreReq(Goal prereq) {
		this.prereq = prereq;
	}

	public Goal getGoal() {
		return goal;
	}

	private void setGoal(Goal test) {
		this.goal = test;
	}
	
	public boolean equals(PreReq pr)
	{
		return this.getGoal().equals(pr.getGoal()) && this.getPreReq().equals(pr.getPreReq());
	}
}