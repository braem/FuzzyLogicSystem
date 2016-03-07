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
						
						if(r.isSatisfied())//If R is satisfied, then the antecedents must be true, and so can be added as facts to working memory.
						{
							
							if(r.getAntecedent() instanceof ComplexAntecedent)//If the antecedent is complex, add individual antecedents separately.
							{
								ComplexAntecedent compAnt = (ComplexAntecedent) r.getAntecedent();
								for(Antecedent ant : compAnt.getAntecedents())
								{
									if(!hyps.contains((Consequent) ant)) hyps.add((Consequent) ant);
									if(ant instanceof Goal)
									{ //ToDo List holds unsatisfied goals, so remove satisfied goal from list.
									 try{ ToDoWindow.removeGoal((Goal) ant);}
									catch(Exception e){}
									}
								}
							}
							else
							{
								Antecedent ant = r.getAntecedent();
								if(!hyps.contains((Consequent) ant)) hyps.add((Consequent) ant);
								hyps.add((Consequent) ant);
								if(ant instanceof Goal)
								{ //ToDo List holds unsatisfied goals, so remove satisfied goal from list.
								 try{ ToDoWindow.removeGoal((Goal) ant);}
								catch(Exception e){}
								}
							}
							
							//Since the antecedents are satisfied, the consequent is also satisfied, so it can be added as a fact.
							Consequent cons = r.getConsequent();
							if(!hyps.contains(cons))hyps.add(r.getConsequent());
						}
						else//Since this rule has not been satisfied ...
						{
							if(r.getAntecedent() instanceof ComplexAntecedent)//If the antecedent is complex, add individual antecedents separately.
							{
								ComplexAntecedent compAnt = (ComplexAntecedent) r.getAntecedent();
								for(Antecedent ant : compAnt.getAntecedents())
								{
//									if(!ant.testAntecedent())
//									{
										//Add antecedent to hypotheses
										
									if(!hyps.contains((Consequent) ant)) hyps.add((Consequent) ant);
										
										//Add antecedent to to-do list
										
										//ToDo List holds unsatisfied goals, so add unsatisfied goal to list, but don't duplicate goals.
										if(ant instanceof Goal && !ToDoWindow.hasGoal((Goal)ant))
										{ //ToDo List holds unsatisfied goals, so add unsatisfied goal to list.
										 try{ ToDoWindow.addGoal((Goal) ant);}
										catch(Exception e){}
										}
									//}
									  
								}
							}
							else
							{
								Antecedent ant = r.getAntecedent();
//								if(!ant.testAntecedent())
//								{
									//Add antecedent to hypotheses
										
									if(!hyps.contains((Consequent) ant)) hyps.add((Consequent) ant);
									
									//Add antecedent to to-do list
									
									//ToDo List holds unsatisfied goals, so add unsatisfied goal to list, but don't duplicate goals.
									
									if(ant instanceof Goal && !ToDoWindow.hasGoal((Goal) ant))
									{ //ToDo List holds unsatisfied goals, so add unsatisfied goal to list.
									 try{ ToDoWindow.addGoal((Goal) ant);}
									catch(Exception e){}
									}
								//}
							}
							
							//Also need to add the consequent to the toDoList if it's a Goal.
							Consequent cons = r.getConsequent();
							if(cons instanceof Goal && !ToDoWindow.hasGoal((Goal) cons)) ToDoWindow.addGoal((Goal)cons);
						}

					}
				}
			}
		}
	}
	


}
