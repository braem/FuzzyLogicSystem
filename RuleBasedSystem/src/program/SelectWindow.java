package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import file_io.FileIO;
import structures.*;
import system.InferenceEngine;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.awt.event.ActionEvent;
import java.awt.List;


/**
 * Window for selecting a learning plan, goal and test to do
 * Opens a todo list window of goals to be completed
 * Shows prereqs for goals not met
 * Allows a test to be started only when all prereqs are met
 * 
 * @author Braemen
 * @version 1.0
 */
public class SelectWindow extends JFrame
{
	private static final long serialVersionUID = -8807127458602336380L;
	private JPanel contentPane;
	private JFrame thisFrame = this;
	private JComboBox<LearningPlan> learningPlanCB;
	private JButton btnStart;
	private JComboBox<Goal> goalCB;
	private JComboBox<Test> testCB;
	private List prereqList;
	private HashSet<LearningPlan> learningPlans;
	private ToDoWindow todoWindow;

	/**
	 * Test launch the window
	 * 
	 * @param args      List of arguments. Not used.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectWindow frame = new SelectWindow(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * enable this frame
	 */
	public void enable() {
		this.setVisible(true);
	}
	
	/**
	 * Gets all the goals that are not met.
	 * 
	 * @param goal      The goal being checked.
	 * @return          The list of goals not met.
	 */
	private ArrayList<Goal> goalsNotMet(Goal goal) {
		LearningPlan plan = (LearningPlan)learningPlanCB.getSelectedItem();
		ArrayList<PreReq> prereqs = plan.getPreReqs();
		ArrayList<Goal> goalsNeeded = new ArrayList<Goal>();
		ArrayList<Goal> goalsNotMet = new ArrayList<Goal>();
		for(PreReq prereq : prereqs)
			if(prereq.getGoal().equals(goal))
				goalsNeeded.add(prereq.getPreReq());
		for(Goal g : goalsNeeded)
			if(!g.isSatisfied())
				goalsNotMet.add(g);
		return goalsNotMet;
	}

	/**
	 * Create the frame.
	 * 
	 * @param user      The current user.
	 */
	public SelectWindow(User user) {
	   setResizable(false);
		setTitle(user.getUserName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 751, 175);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		//set up this JFrame window
		setup(contentPane, user);
	}
	
	/**
	 * Setup for the current window
	 * 
	 * @param contentPane     The JPanel to use.
	 * @param user            The current user.
	 */
	private void setup(JPanel contentPane, User user) {
		//create the inference engine
		InferenceEngine iE = new InferenceEngine();
		
		//load learning plans
		if(user.getLearningPlan() == null) {
			learningPlans = FileIO.loadLearningPlans();
			user.setLearningPlan(learningPlans);
		}
		else
			learningPlans = user.getLearningPlan();
		
		//create & show todo list in another window
		todoWindow = new ToDoWindow();
		todoWindow.enable();
		
		//button to start taking a test selected
		btnStart = new JButton("Start Test");
		btnStart.addActionListener(new ActionListener() {//button is enabled & clicked
			public void actionPerformed(ActionEvent e) {
				//start the test selected
				if((Test)testCB.getSelectedItem() != null) {
					TestWindow window = new TestWindow((Test)testCB.getSelectedItem(), user, (LearningPlan)learningPlanCB.getSelectedItem());
					thisFrame.dispose();
					window.enable();
				}
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStart.setBounds(255, 92, 128, 41);
		contentPane.add(btnStart);
		
		//combox for goals
		goalCB = new JComboBox<Goal>();
		goalCB.addActionListener (new ActionListener () { //a new selection is made
		    public void actionPerformed(ActionEvent e) {
		    	//new goal selection is made -> reset the tests prereqs and disable start button
		    	testCB.removeAllItems();
		    	prereqList.removeAll();
		    	btnStart.setEnabled(false);
		    	//get the newly selected goal
		        Goal goal = (Goal)goalCB.getSelectedItem();
		        if(goal == null) return;
		        //get the prereqs not met
		        ArrayList<Goal> goalsNotMet = goalsNotMet(goal);
		        if(goalsNotMet.isEmpty()) { //all prereqs met
		        	btnStart.setEnabled(true); //can start a test
			        for(Test test : goal.getTests())
			        	testCB.addItem(test);
		        }
		        else //write the prereqs needed to the list
		        	for(Goal g : goalsNotMet)
		        		prereqList.add(""+g);
		    }
		});
		goalCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		goalCB.setBounds(255, 44, 235, 22);
		contentPane.add(goalCB);
		
		//combox for tests
		testCB = new JComboBox<Test>();
		testCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testCB.setBounds(10, 109, 235, 22);
		contentPane.add(testCB);
		
		//list of prereqs needed to be satisfied before starting a certain goal's tests
		prereqList = new List();
		prereqList.setEnabled(false);
		prereqList.setBounds(496, 44, 235, 89);
		contentPane.add(prereqList);
		
		//combox for learning plans
		learningPlanCB = new JComboBox<LearningPlan>();
		learningPlanCB.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) { //a new selection is made
		    	//new plan is selected, so remove everything
		    	goalCB.removeAllItems();
	            testCB.removeAllItems();
	            prereqList.removeAll();
	            ToDoWindow.removeAllGoals();
	            btnStart.setEnabled(false);
	            //get the newly selected plan, init the inference engine on it & run a cycle
	            LearningPlan plan = (LearningPlan)learningPlanCB.getSelectedItem();
	            if(plan == null) return;
	            iE.init(user, plan);
	    		iE.inferenceCycle();
	            for(Goal goal : plan.getGoals()) //add this plan's goals
	            	goalCB.addItem(goal);
		    }
		});
		learningPlanCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		learningPlanCB.setBounds(10, 44, 235, 22);
		contentPane.add(learningPlanCB);
		
		//add learning plans to the combobox
		for(LearningPlan plan : learningPlans) 
			learningPlanCB.addItem(plan);
		btnStart.setEnabled(false);
		
		
		//labels
		JLabel lblPrereqs = new JLabel("Prequisites");
		lblPrereqs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrereqs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrereqs.setBounds(496, 11, 235, 22);
		contentPane.add(lblPrereqs);
		JLabel lblSelectALearning = new JLabel("Select a Learning Plan");
		lblSelectALearning.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectALearning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectALearning.setBounds(10, 11, 235, 22);
		contentPane.add(lblSelectALearning);
		JLabel lblSelectAGoal = new JLabel("Select a Goal");
		lblSelectAGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAGoal.setBounds(255, 11, 235, 22);
		contentPane.add(lblSelectAGoal);
		JLabel lblSelectATest = new JLabel("Select a Test");
		lblSelectATest.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectATest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectATest.setBounds(10, 77, 235, 22);
		contentPane.add(lblSelectATest);
		
		//simple back button to go back to login screen
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginChoiceWindow window = new LoginChoiceWindow(user);
				thisFrame.dispose();
				todoWindow.dispose();
				window.enable();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(393, 107, 97, 26);
		contentPane.add(btnBack);
	}
}
