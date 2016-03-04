package structures;
import java.util.ArrayList;


import system.Antecedent;
import system.Consequent;

public class Goal implements Consequent, Antecedent{
	
	private ArrayList<Test> tests;
	private boolean satisfied;
	private User user;
	
	public Goal(User s)
	{
		setUser(s);
		setTests(new ArrayList<Test>());
		setSatisfied(false);
		
	}
	
	public Goal(User s, ArrayList<Test> t, boolean c)
	{
		setUser(s);
		setTests(t);
		setSatisfied(c);
	}
	


	public void setUser(User s)
	{
		user = s;
	}
	
	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}

	@Override
	public void setSatisfied(boolean arg) {
		satisfied = arg;
		
	}
	
	public ArrayList<Test> getTests()
	{
		return tests;
	}
	
	public User getUser()
	{
		return user;
	}

	@Override
	public boolean isSatisfied() {
		return satisfied;
	}

	@Override
	public boolean testAntecedent() {
		boolean answer = true;
		for (Test test : tests)
		{
			answer &= test.isPassed();
		}
		
		return answer;
	}
	
	public boolean equals(Goal g)
	{
		boolean equal = true;
		ArrayList<Test> otherTests = g.getTests();
		
		if(!(this.tests.size() == otherTests.size())) equal = false;
		
		for(int i = 0; i < this.tests.size() && equal; i++)
		{
			if(!this.tests.get(i).equals(otherTests.get(i))) equal = false;
		}
		
		return equal;
	}
}


