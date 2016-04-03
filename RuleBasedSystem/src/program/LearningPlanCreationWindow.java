package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import file_io.FileIO;
import structures.AnswerValue;
import structures.Attempt;
import structures.Goal;
import structures.LearningPlan;
import structures.PreReq;
import structures.Question;
import structures.Test;

import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JCheckBox;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;

public class LearningPlanCreationWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 4003589580490610269L;
	private JFrame thisFrame = this;
	private JPanel contentPane;
	private JTextField testNameTF;
	private JTextField goalNameTF;
	private JTextArea createQuestionTA;
	private JTextArea selectedQuestionTA;
	private DefaultListModel<Goal> goalModel;
	private JList<Goal> goalList;
	private DefaultListModel<Test> testModel;
	private JList<Test> testList;
	private DefaultListModel<Integer> questionModel;
	private JList<Integer> questionList;
	private JButton btnAddPlan;
	private JButton btnAddGoal;
	private JButton btnAddTest;
	private JButton btnAddQuestion;
	private JComboBox<AnswerValue> answerCB;
	private JCheckBox chckbxIsBonus;
	private DefaultListModel<PreReq> prereqModel;
	private JList<PreReq> prereqList;
	private JTextField planNameTF;
	private JLabel lblPlanName;
	
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;
	private int questionCtr = 1;
	private JComboBox<Goal> prereqCB;
	private JComboBox<Goal> goalCB;
	private JLabel lblPrereq;
	private JLabel lblGoal;
	private JButton btnAddPrereq;
	private JButton btnRemoveQuestion;
	private JButton btnRemoveTest;
	private JButton btnRemovePrereq;
	private JButton btnRemoveGoal;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LearningPlanCreationWindow frame = new LearningPlanCreationWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Enable this window
	 */
	public void enable() {
		this.setVisible(true);
	}
	
	/**
	 * Get the corresponding question from the integer
	 * 
	 * @param q      Integer that specifies the question.
	 * @return       The Question be being specified.
	 */
	private Question intToQuestion(int q) {
		Question question;
		try {
			question = normalQuestions.get(q-1);
		} catch(IndexOutOfBoundsException e) {
			question = bonusQuestions.get(q-normalQuestions.size()-1);
		}
		return question;
	}

	/**
	 * Create the frame.
	 */
	public LearningPlanCreationWindow() {
		setTitle("Create a Learning Plan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1049, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		normalQuestions = new ArrayList<Question>();
		bonusQuestions = new ArrayList<Question>();
		
		createQuestionTA = new JTextArea();
		createQuestionTA.setLineWrap(true);
		createQuestionTA.setFont(new Font("Monospaced", Font.PLAIN, 14));
		createQuestionTA.setBounds(10, 47, 295, 160);
		contentPane.add(createQuestionTA);
		
		selectedQuestionTA = new JTextArea();
		selectedQuestionTA.setEditable(false);
		selectedQuestionTA.setLineWrap(true);
		selectedQuestionTA.setFont(new Font("Monospaced", Font.PLAIN, 14));
		selectedQuestionTA.setBounds(574, 47, 295, 160);
		contentPane.add(selectedQuestionTA);
		
		testNameTF = new JTextField();
		testNameTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		testNameTF.setColumns(10);
		testNameTF.setBounds(506, 218, 216, 25);
		contentPane.add(testNameTF);
		
		goalNameTF = new JTextField();
		goalNameTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		goalNameTF.setColumns(10);
		goalNameTF.setBounds(240, 291, 120, 25);
		contentPane.add(goalNameTF);
		
		goalModel = new DefaultListModel<Goal>();
		goalList = new JList<Goal>(goalModel);
		goalList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		goalList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		goalList.setBounds(517, 291, 223, 82);
		contentPane.add(goalList);
		
		testModel = new DefaultListModel<Test>();
		testList = new JList<Test>(testModel);
		testList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		testList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		testList.setBounds(12, 291, 137, 160);
		contentPane.add(testList);
		
		questionModel = new DefaultListModel<Integer>();
		questionList = new JList<Integer>(questionModel);
		questionList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				try {
				Question q = intToQuestion(questionList.getSelectedValue());
				selectedQuestionTA.setText(q+""); }
				catch(Exception e) {}
			}
		});
		questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		questionList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questionList.setBounds(427, 47, 137, 160);
		contentPane.add(questionList);
		
		prereqModel = new DefaultListModel<PreReq>();
		prereqList = new JList<PreReq>(prereqModel);
		prereqList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prereqList.setBounds(370, 291, 137, 160);
		contentPane.add(prereqList);
		
		answerCB = new JComboBox<AnswerValue>();
		answerCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		answerCB.setBounds(315, 95, 84, 25);
		contentPane.add(answerCB);
		for(AnswerValue v : AnswerValue.values())
			answerCB.addItem(v);
		
		chckbxIsBonus = new JCheckBox("Is Bonus");
		chckbxIsBonus.setBounds(311, 139, 97, 23);
		contentPane.add(chckbxIsBonus);
		
		btnAddQuestion = new JButton("Add Question to Test");
		btnAddQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!createQuestionTA.getText().equals("")) {
					//add it
					Question q = new Question(createQuestionTA.getText(), (AnswerValue)answerCB.getSelectedItem(), chckbxIsBonus.isSelected());
					if(chckbxIsBonus.isSelected())
						bonusQuestions.add(q);
					else
						normalQuestions.add(q);
					questionModel.addElement(questionCtr);
					questionCtr++;
					
					//clear previous
					createQuestionTA.setText("");
				}
			}
		});
		btnAddQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddQuestion.setBounds(60, 218, 183, 27);
		contentPane.add(btnAddQuestion);
		
		btnAddTest = new JButton("Add Test to Goal");
		btnAddTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(testNameTF.getText().equals("") || (normalQuestions.size() == 0 && bonusQuestions.size() == 0))
					return;
				//add it
				ArrayList<Question> qs = new ArrayList<Question>();
				ArrayList<Question> bqs = new ArrayList<Question>();
				ArrayList<AnswerValue> as = new ArrayList<AnswerValue>();
				for(int i=0; i<normalQuestions.size(); i++) {
					qs.add(normalQuestions.get(i));
				}
				for(int i=0; i<bonusQuestions.size(); i++) {
					bqs.add(bonusQuestions.get(i));
				}
				for(int i=0; i<qs.size(); i++) {
					as.add(qs.get(i).getAnswer());
				}
				Test t;
				if(bqs.size() == 0)
					t = new Test(testNameTF.getText(), qs, new Attempt(as));
				else
					t = new Test(testNameTF.getText(), qs, bqs, new Attempt(as));
				testModel.addElement(t); 
				
				//clear previous
				questionList.clearSelection();
				questionModel.clear();
				createQuestionTA.setText("");
				normalQuestions.clear();
				bonusQuestions.clear();
				selectedQuestionTA.setText("");
				testNameTF.setText("");
				questionCtr = 1;
			}
		});
		btnAddTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddTest.setBounds(732, 218, 137, 27);
		contentPane.add(btnAddTest);
		
		btnAddGoal = new JButton("Add Goal to Plan");
		btnAddGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(!goalNameTF.getText().equals("") && testModel.size() > 0) {
					ArrayList<Test> tests = new ArrayList<Test>();
					for(int i=0; i<testModel.getSize(); i++) {
						tests.add((Test)testModel.getElementAt(i));
					}
					Goal g = new Goal(null, tests, false, goalNameTF.getText());
					goalModel.addElement(g);
					
					prereqCB.addItem(g);
					goalCB.addItem(g);
					
					//clear
					testModel.clear();
					testNameTF.setText("");
					goalNameTF.setText("");
				}
			}
		});
		btnAddGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddGoal.setBounds(159, 327, 201, 27);
		contentPane.add(btnAddGoal);
		
		btnAddPlan = new JButton("Add Plan");
		btnAddPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(planNameTF.getText().equals("") || goalModel.size() == 0)
					return;
				ArrayList<Goal> goals = new ArrayList<Goal>();
				for(int i=0; i<goalModel.getSize(); i++) {
					goals.add((Goal)goalModel.getElementAt(i));
				}
				ArrayList<PreReq> prereqs = new ArrayList<PreReq>();
				for(int i=0; i<prereqModel.getSize(); i++) {
					prereqs.add((PreReq)prereqModel.getElementAt(i));
				}
				LearningPlan plan = new LearningPlan(goals, prereqs, planNameTF.getText());
				FileIO.writeLearningPlan(plan);
				LearningPlanCreationWindow window = new LearningPlanCreationWindow();
				thisFrame.dispose();
				window.enable();
			}
		});
		btnAddPlan.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddPlan.setBounds(750, 346, 147, 27);
		contentPane.add(btnAddPlan);
		
		/* back button */
		JButton btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoiceWindow window = new ChoiceWindow();
				window.enable();
				thisFrame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(780, 13, 89, 25);
		contentPane.add(btnBack);
		
		/* labels */
		JLabel lblCreateQuestion = new JLabel("Create Question:");
		lblCreateQuestion.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblCreateQuestion.setBounds(10, 11, 176, 25);
		contentPane.add(lblCreateQuestion);
		JLabel lblWorkingTest = new JLabel("Working Test:");
		lblWorkingTest.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkingTest.setBounds(425, 11, 176, 25);
		contentPane.add(lblWorkingTest);
		JLabel lblWorkingPlan = new JLabel("Working Plan:");
		lblWorkingPlan.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkingPlan.setBounds(646, 254, 137, 25);
		contentPane.add(lblWorkingPlan);
		JLabel goalLbl = new JLabel("Goal Name:");
		goalLbl.setFont(new Font("Tahoma", Font.PLAIN, 15));
		goalLbl.setBounds(159, 291, 84, 25);
		contentPane.add(goalLbl);
		JLabel lblTestName = new JLabel("Test Name:");
		lblTestName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblTestName.setBounds(425, 218, 84, 25);
		contentPane.add(lblTestName);
		JLabel lblWorkingGoal = new JLabel("Working Goal:");
		lblWorkingGoal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWorkingGoal.setBounds(10, 254, 176, 25);
		contentPane.add(lblWorkingGoal);
		JLabel lblQuestion = new JLabel("Question");
		lblQuestion.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuestion.setBounds(315, 47, 102, 25);
		contentPane.add(lblQuestion);
		JLabel lblAnswer = new JLabel("Answer:");
		lblAnswer.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblAnswer.setBounds(315, 65, 102, 25);
		contentPane.add(lblAnswer);
		JLabel lblPrereqs = new JLabel("Prereqs:");
		lblPrereqs.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPrereqs.setBounds(372, 254, 137, 25);
		contentPane.add(lblPrereqs);
		
		planNameTF = new JTextField();
		planNameTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		planNameTF.setColumns(10);
		planNameTF.setBounds(750, 310, 147, 25);
		contentPane.add(planNameTF);
		
		lblPlanName = new JLabel("Plan Name:");
		lblPlanName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlanName.setBounds(750, 288, 84, 25);
		contentPane.add(lblPlanName);
		
		prereqCB = new JComboBox<Goal>();
		prereqCB.setBounds(516, 398, 120, 25);
		contentPane.add(prereqCB);
		
		goalCB = new JComboBox<Goal>();
		goalCB.setBounds(646, 398, 120, 25);
		contentPane.add(goalCB);
		
		lblPrereq = new JLabel("Prereq:");
		lblPrereq.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPrereq.setBounds(517, 373, 84, 25);
		contentPane.add(lblPrereq);
		
		lblGoal = new JLabel("Goal:");
		lblGoal.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblGoal.setBounds(656, 373, 84, 25);
		contentPane.add(lblGoal);
		
		btnAddPrereq = new JButton("Add Prereq");
		btnAddPrereq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Goal p = (Goal)prereqCB.getSelectedItem();
				Goal g = (Goal)goalCB.getSelectedItem();
				if (!p.equals(g))
				{
				   PreReq pq = new PreReq(p, g, p+" | "+g);
				   prereqModel.addElement(pq);
				}
			}
		});
		btnAddPrereq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddPrereq.setBounds(517, 424, 249, 27);
		contentPane.add(btnAddPrereq);
		
		
		btnRemoveQuestion = new JButton("Remove \r\nQuestion");
		btnRemoveQuestion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Question> allQs = new ArrayList<Question>();
				for(int i=0; i<questionModel.size(); i++) {
					Question q = intToQuestion(questionModel.getElementAt(i));
					allQs.add(q);
				}
				if (!questionList.isSelectionEmpty())
				{
					Question selectedQuestion = intToQuestion(questionList.getSelectedValue());
		            if(!normalQuestions.remove(selectedQuestion))
		               bonusQuestions.remove(selectedQuestion);
		            questionCtr = 1;
		            questionModel.clear();
		            for(Question q : normalQuestions) {
		               questionModel.addElement(questionCtr);
		               questionCtr++;
		            }
		            for(Question q : bonusQuestions) {
		               questionModel.addElement(questionCtr);
		               questionCtr++;
		            }
				}
				
				//clear
				selectedQuestionTA.setText("");
			}
		});
		btnRemoveQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveQuestion.setBounds(570, 12, 152, 27);
		contentPane.add(btnRemoveQuestion);
		
		btnRemoveTest = new JButton("Remove \rTest");
		btnRemoveTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!testList.isSelectionEmpty())
				{
				   testModel.removeElementAt(testList.getSelectedIndex());
				}
			}
		});
		btnRemoveTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveTest.setBounds(159, 372, 152, 27);
		contentPane.add(btnRemoveTest);
		
		btnRemovePrereq = new JButton("Remove \r\nPrereq");
		btnRemovePrereq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!prereqList.isSelectionEmpty())
				{
				   prereqModel.removeElementAt(prereqList.getSelectedIndex());
				}
			}
		});
		btnRemovePrereq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemovePrereq.setBounds(208, 424, 152, 27);
		contentPane.add(btnRemovePrereq);
		
		btnRemoveGoal = new JButton("Remove Goal");
		btnRemoveGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (!goalList.isSelectionEmpty())
				{
				   goalModel.removeElementAt(goalList.getSelectedIndex());
				}
			}
		});
		btnRemoveGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnRemoveGoal.setBounds(516, 253, 120, 27);
		contentPane.add(btnRemoveGoal);
	}
}
