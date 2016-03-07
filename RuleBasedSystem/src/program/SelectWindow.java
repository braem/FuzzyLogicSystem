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
 * 
 * @author braem
 *
 * Window for selecting a learning plan, goal and test to do
 */
public class SelectWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8807127458602336380L;
	private JPanel contentPane;
	private JFrame thisFrame = this;
	private JComboBox<LearningPlan> learningPlanCB;
	private JButton btnBack;
	private JButton btnStart;
	private JComboBox<Goal> goalCB;
	private JComboBox<Test> testCB;
	private JLabel lblSelectAGoal;
	private JLabel lblSelectATest;
	private List prereqList;
	private HashSet<LearningPlan> learningPlans;

	/**
	 * Launch the application.
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
	
	public void enable() {
		this.setVisible(true);
	}
	
	public ArrayList<Goal> goalsNotMet(Goal goal) {
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
	
	public ArrayList<Goal> getGoalsToDo() {
		ArrayList<Goal> goalsToDo = new ArrayList<Goal>();
		
		return goalsToDo;
	}

	/**
	 * Create the frame.
	 */
	public SelectWindow(User user) {
		setTitle(user.getUserName());
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 792, 217);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		InferenceEngine iE = new InferenceEngine();
		
		//create todo list
		ToDoWindow w = new ToDoWindow();
		w.enable();
		
		//load learning plans
		learningPlans = FileIO.loadLearningPlans();
		
		JLabel lblSelectALearning = new JLabel("Select a Learning Plan");
		lblSelectALearning.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectALearning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectALearning.setBounds(10, 11, 235, 22);
		contentPane.add(lblSelectALearning);
		
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow window = new LoginWindow();
				thisFrame.dispose();
				window.enable();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnBack.setBounds(393, 107, 97, 26);
		contentPane.add(btnBack);
		
		btnStart = new JButton("Start Test");
		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if((Test)testCB.getSelectedItem() != null) {
					user.setLearningPlan(learningPlans);
					TestWindow window = new TestWindow((Test)testCB.getSelectedItem(), user, (LearningPlan)learningPlanCB.getSelectedItem());
					thisFrame.dispose();
					window.enable();
				}
			}
		});
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStart.setBounds(255, 92, 128, 41);
		contentPane.add(btnStart);
		
		goalCB = new JComboBox<Goal>();
		goalCB.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	testCB.removeAllItems();
		    	prereqList.removeAll();
		    	btnStart.setEnabled(false);
		        Goal goal = (Goal)goalCB.getSelectedItem();
		        if(goal == null) return;
		        //get the prereqs not met
		        ArrayList<Goal> goalsNotMet = goalsNotMet(goal);
		        if(goalsNotMet.isEmpty()) { //all prereqs met
		        	btnStart.setEnabled(true);
			        for(Test test : goal.getTests())
			        	testCB.addItem(test);
		        }
		        else { //write the prereqs to the list
		        	for(Goal g : goalsNotMet)
		        		prereqList.add(""+g);
		        }
		    }
		});
		goalCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		goalCB.setBounds(255, 44, 235, 22);
		contentPane.add(goalCB);
		
		testCB = new JComboBox<Test>();
		testCB.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		        
		    }
		});
		testCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testCB.setBounds(10, 109, 235, 22);
		contentPane.add(testCB);
		
		lblSelectAGoal = new JLabel("Select a Goal");
		lblSelectAGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAGoal.setBounds(255, 11, 235, 22);
		contentPane.add(lblSelectAGoal);
		
		lblSelectATest = new JLabel("Select a Test");
		lblSelectATest.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectATest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectATest.setBounds(10, 77, 235, 22);
		contentPane.add(lblSelectATest);
		
		prereqList = new List();
		prereqList.setEnabled(false);
		prereqList.setBounds(496, 44, 235, 89);
		contentPane.add(prereqList);
		
		JLabel lblPrereqs = new JLabel("Prequisites");
		lblPrereqs.setHorizontalAlignment(SwingConstants.CENTER);
		lblPrereqs.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPrereqs.setBounds(496, 11, 235, 22);
		contentPane.add(lblPrereqs);
		
		learningPlanCB = new JComboBox<LearningPlan>();
		learningPlanCB.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	goalCB.removeAllItems();
	            testCB.removeAllItems();
	            prereqList.removeAll();
	            ToDoWindow.removeAllGoals();
	            btnStart.setEnabled(false);
	            LearningPlan plan = (LearningPlan)learningPlanCB.getSelectedItem();
	            iE.init(plan);
	    		iE.inferenceCycle();
	            if(plan == null) return;
	            for(Goal goal : plan.getGoals())
	            	goalCB.addItem(goal);
		    }
		});
		learningPlanCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		learningPlanCB.setBounds(10, 44, 235, 22);
		contentPane.add(learningPlanCB);
		
		for(LearningPlan plan : learningPlans)
			learningPlanCB.addItem(plan);
		
		btnStart.setEnabled(false);
	}
}
