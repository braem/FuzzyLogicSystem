package system;

import java.util.ArrayList;

import program.ToDoWindow;
import structures.Goal;
import structures.LearningPlan;
import structures.User;

/**
 * The inference engine performs basic inferences based on rules of the form
 * Antecedent -&#62; Consequent 
 * OR
 * ComplexAntecedent -&#62; Consequent
 * where, in logical terms, ComplexAntecedent is effectively
 * Antecedent1 AND Antecedent2 AND...
 * This limits the complexity of the rules, but for the intended application their expressive
 * power is more than sufficient.
 * 
 * 
 *The engine is designed to be initialized using a User's LearningPlan instance,
 *creating the necessary rules and hypotheses from the state of the plan,
 *performing the indicated inferences, and updating the state of the plan and of
 *the ToDoWindow.  Since the state of the plans is not maintained internally,
 *once a cycle is complete the engine can be disposed of, simplifying application logic.
 *
 * @author Rhys
 * @version 1.0
 * */
public class InferenceEngine
{
	private WorkingMemory memory;
	private KnowledgeBase know;
	private Rule selectedRule;
	private ArrayList<FuzzyRule> fuzzyRules;
	private User student;
	
	
	/**
	 * Creates a new InferenceEngine.
	 * */
	public InferenceEngine()
	{
		memory = new WorkingMemory();
		know = new KnowledgeBase();
	}
	
	/**
	 * initializes the InferenceEngine using the provided LearningPlan instance.
	 * 
	 * @param lp	A learning plan used to initialize the InferenceEngine
	 * */
	public void init(User u, LearningPlan lp)
	{
		student = u;
		memory = new WorkingMemory();
		know = new KnowledgeBase();
		
		memory.addHypothesis((Consequent) lp);
		know.rulesFromPlan(lp);
		
		initFuzzyRules();
	}
	
	/**
	 * Initializes the nine fuzzy rules used to describe a student's learning
	 * based on the difficulty of a test and their success on it.
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void initFuzzyRules()
	{
		DiscreteLinguisticVariable learning = student.getLearning();
		DiscreteLinguisticVariable success = student.getSuccess();
		DiscreteLinguisticVariable difficulty = student.getDifficulty();
		
		ArrayList<DiscreteFuzzySet> lSets = learning.getFuzzySets();
		ArrayList<DiscreteFuzzySet> sSets = success.getFuzzySets();
		ArrayList<DiscreteFuzzySet> dSets = difficulty.getFuzzySets();
		
		int stop = sSets.size() * dSets.size();
		int picker = 0;
		
		DiscreteFuzzySet lbad = learning.getFuzzySet("Bad");
		DiscreteFuzzySet lgood = learning.getFuzzySet("Good");
		DiscreteFuzzySet lexc = learning.getFuzzySet("Excellent");
		
		ArrayList<DiscreteFuzzySet> consOrdering = new ArrayList<>();
		consOrdering.add(lbad);
		consOrdering.add(lbad);
		consOrdering.add(lgood);
		consOrdering.add(lbad);
		consOrdering.add(lgood);
		consOrdering.add(lexc);
		consOrdering.add(lbad);
		consOrdering.add(lexc);
		consOrdering.add(lexc);
		
		for(DiscreteFuzzySet diff : dSets)
		{
			for(DiscreteFuzzySet succ : sSets)
			{
				ArrayList<DiscreteFuzzySet> ants = new ArrayList<>();
				ants.add(diff);
				ants.add(succ);
				
				DiscreteFuzzySet cons = consOrdering.get(picker++);
				fuzzyRules.add((new FuzzyRule(ants, cons)));
			}
		}		
	}
	
	/**
	 * Performs a single inference cycle through all hypotheses and rules.
	 * Inference proceeds using the backward chaining approach.
	 * This was deemed best because the goal state is known ahead of time.
	 * Specifically, the user must complete all Goals in the LearningPlan provided on initialization.
	 */
	public void inferenceCycle()
	{
		ArrayList<Rule> wmRules = memory.getRules();
		ArrayList<Consequent> hyps = memory.getHypotheses();
		ArrayList<Rule> knowRules = know.getRules();
		Rule ruleptr;
			
		
		//Search through the knowledge base for rules whose consequents match the unsatisfied hypotheses in working memory
		for(int i = 0 ; i < hyps.size() ; i++)
		{
			Consequent hyp = hyps.get(i);
			
			if(!hyp.isSatisfied()) //If that hypothesis is not currently satisfied, i.e. it isn't a fact...
			{
				for(Rule r : knowRules)
				{
					if(r.getConsequent().equals(hyp) && !wmRules.contains(r))//Find a rule with a matching consequent that isn't in working memory...
					{
						wmRules.add(r);//and add it to working memory
						
						r.evaluate();// check conditions of R
						
						if(r.getAntecedent() instanceof ComplexAntecedent)//If the antecedent is complex, deal with individual antecedents separately.
						{
							ComplexAntecedent compAnt = (ComplexAntecedent) r.getAntecedent();
							for(Antecedent ant : compAnt.getAntecedents())
							{
								if(!hyps.contains((Consequent) ant)) hyps.add((Consequent) ant);
								if(ant instanceof Goal)
								{ 
									Goal goal = (Goal) ant;

									if(goal.isSatisfied() && ToDoWindow.hasGoal(goal))//If goal is satisfied try to remove it from the todoList.
									{
										 try{ ToDoWindow.removeGoal(goal);}
											catch(Exception e){System.out.println(e);}
											
									}
									else if(!goal.isSatisfied() && !ToDoWindow.hasGoal(goal))//If the goal is unsatisfied, add it to todoList.
									{
										 try{ ToDoWindow.addGoal(goal);}
										 catch(Exception e){System.out.println(e);}
									}
								}
							}
						}
						else
						{
							Antecedent ant = r.getAntecedent();
							if(!hyps.contains((Consequent) ant)) hyps.add((Consequent) ant);
							hyps.add((Consequent) ant);
							
							if(ant instanceof Goal)
							{ 
								Goal goal = (Goal) ant;

									if(goal.isSatisfied() && ToDoWindow.hasGoal(goal))//If goal is satisfied try to remove it from the todoList.
									{
										 try{ ToDoWindow.removeGoal(goal);}
											catch(Exception e){System.out.println(e);}
											
									}
									else if(!goal.isSatisfied() && !ToDoWindow.hasGoal(goal))//If the goal is unsatisfied, add it to todoList.
									{
										 try{ ToDoWindow.addGoal(goal);}
										 catch(Exception e){System.out.println(e);}
									}
							
							}
						}
						
						
						if(r.getConsequent() instanceof Goal)
						{
							Goal goal = (Goal) r.getConsequent();

							//Satisfied goals on the consequent side should be removed from the to do list.
							//Unsatisfied goals on the consequent side should be added to to do list if they aren't already there.
							if(r.isSatisfied() && ToDoWindow.hasGoal(goal)) ToDoWindow.removeGoal((Goal) goal);
							else if(!r.isSatisfied() && !ToDoWindow.hasGoal(goal)) ToDoWindow.addGoal(goal);
						
						}


					}
				}
			}
		}
	}
	


}
