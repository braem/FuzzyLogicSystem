package system;

import java.util.ArrayList;

import program.ToDoWindow;
import structures.Goal;
import structures.LearningPlan;

public class InferenceEngine
{
	private WorkingMemory memory;
	private KnowledgeBase know;
	private Rule selectedRule;
	
	public InferenceEngine()
	{
		memory = new WorkingMemory();
		know = new KnowledgeBase();
	}
	
	public void init(LearningPlan lp)
	{
		memory = new WorkingMemory();
		know = new KnowledgeBase();
		
		memory.addHypothesis((Consequent) lp);
		know.rulesFromPlan(lp);
	}
	
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
							if(r.isSatisfied()) ToDoWindow.removeGoal((Goal) goal);
							else if(!ToDoWindow.hasGoal(goal)) ToDoWindow.addGoal(goal);
						
						}


					}
				}
			}
		}
	}
	


}
