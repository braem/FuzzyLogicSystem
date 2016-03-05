package structures;
import java.io.Serializable;
import java.util.ArrayList;


import system.Antecedent;
import system.Consequent;

public class Goal implements Consequent, Antecedent, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 7884557923175830060L;
	private ArrayList<Test> tests;
	private boolean satisfied;
	private User user;
	public String name;
	
	public Goal()
	{
		tests = null;
		satisfied = false;
		user = null;
		name = null;
	}
	
	public Goal(User s, String g)
	{
		setUser(s);
		setTests(new ArrayList<Test>());
		setSatisfied(false);
		setName(g);
		
	}
	
	public Goal(User s, ArrayList<Test> t, boolean c, String g)
	{
		setUser(s);
		setTests(t);
		setSatisfied(c);
		setName(g);
	}


	public void setUser(User s)
	{
		user = s;
	}
	
	public void setTests(ArrayList<Test> tests) {
		this.tests = tests;
	}
	
	public void setName(String g)
	{
		name = g;
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
	
	public String getName()
	{
		return name;
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
	
	public String toString()
	{
		return name;
	}
}


