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
	private JFrame thisFrame = null;
	private JPanel contentPane;
	private JTextField questionNameTF;
	private JTextField testNameTF;
	private JTextField goalNameTF;
	private JTextArea createQuestionTA;
	private JTextArea selectedQuestionTA;
	private DefaultListModel<Goal> goalModel;
	private JList<Goal> goalList;
	private DefaultListModel<Test> testModel;
	private JList<Test> testList;
	private DefaultListModel<Question> questionModel;
	private JList<Question> questionList;
	private JButton btnAddPlan;
	private JButton btnAddGoal;
	private JButton btnAddTest;
	private JButton btnAddQuestion;
	private JComboBox<AnswerValue> answerCB;
	private JCheckBox chckbxIsBonus;
	private DefaultListModel<PreReq> prereqModel;
	private JList<PreReq> prereqList;
	private JButton btnAddAsPrereq;
	private JTextField planNameTF;
	private JLabel lblPlanName;

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
	 * Create the frame.
	 */
	public LearningPlanCreationWindow() {
		setTitle("Create a Learning Plan");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 915, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		createQuestionTA = new JTextArea();
		createQuestionTA.setLineWrap(true);
		createQuestionTA.setFont(new Font("Monospaced", Font.PLAIN, 14));
		createQuestionTA.setBounds(10, 47, 295, 160);
		contentPane.add(createQuestionTA);
		
		selectedQuestionTA = new JTextArea();
		selectedQuestionTA.setLineWrap(true);
		selectedQuestionTA.setFont(new Font("Monospaced", Font.PLAIN, 14));
		selectedQuestionTA.setBounds(574, 47, 295, 160);
		contentPane.add(selectedQuestionTA);
		
		questionNameTF = new JTextField();
		questionNameTF.setFont(new Font("Tahoma", Font.PLAIN, 15));
		questionNameTF.setBounds(119, 218, 125, 25);
		contentPane.add(questionNameTF);
		questionNameTF.setColumns(10);
		
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
		goalList.setBounds(646, 290, 223, 86);
		contentPane.add(goalList);
		
		testModel = new DefaultListModel<Test>();
		testList = new JList<Test>(testModel);
		testList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		testList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		testList.setBounds(12, 291, 137, 160);
		contentPane.add(testList);
		
		questionModel = new DefaultListModel<Question>();
		questionList = new JList<Question>(questionModel);
		questionList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent arg0) {
				Question q = questionList.getSelectedValue();
				selectedQuestionTA.setText(q+"");
			}
		});
		questionList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		questionList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questionList.setBounds(427, 47, 137, 160);
		contentPane.add(questionList);
		
		prereqModel = new DefaultListModel<PreReq>();
		prereqList = new JList<PreReq>(prereqModel);
		prereqList.setFont(new Font("Tahoma", Font.PLAIN, 14));
		prereqList.setBounds(370, 291, 266, 160);
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
				Question q = new Question(createQuestionTA.getText(), (AnswerValue)answerCB.getSelectedItem(), chckbxIsBonus.isSelected());
				questionModel.addElement(q);
			}
		});
		btnAddQuestion.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddQuestion.setBounds(254, 217, 161, 27);
		contentPane.add(btnAddQuestion);
		
		btnAddTest = new JButton("Add Test to Goal");
		btnAddTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Question> qs = new ArrayList<Question>();
				ArrayList<AnswerValue> as = new ArrayList<AnswerValue>();
				for(int i=0; i<questionModel.getSize(); i++) {
					qs.add((Question)questionModel.getElementAt(i));
				}
				for(int i=0; i<qs.size(); i++) {
					as.add(qs.get(i).getAnswer());
				}
				Test t = new Test(testNameTF.getText(), qs, new Attempt(as));
				testModel.addElement(t);
			}
		});
		btnAddTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddTest.setBounds(732, 218, 137, 27);
		contentPane.add(btnAddTest);
		
		btnAddGoal = new JButton("Add Goal to Plan");
		btnAddGoal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Test> tests = new ArrayList<Test>();
				for(int i=0; i<testModel.getSize(); i++) {
					tests.add((Test)testModel.getElementAt(i));
				}
				Goal g = new Goal(null, tests, false, goalNameTF.getText());
				goalModel.addElement(g);
			}
		});
		btnAddGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddGoal.setBounds(159, 327, 201, 27);
		contentPane.add(btnAddGoal);
		
		btnAddAsPrereq = new JButton("Add as Prereq");
		btnAddAsPrereq.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreatePrereqPopupWindow window = new CreatePrereqPopupWindow(prereqModel, goalModel, goalList.getSelectedValue());
				window.enable();
			}
		});
		btnAddAsPrereq.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnAddAsPrereq.setBounds(159, 386, 201, 27);
		contentPane.add(btnAddAsPrereq);
		
		btnAddPlan = new JButton("Add Plan");
		btnAddPlan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		btnAddPlan.setBounds(646, 424, 223, 27);
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
		JLabel lblQuestionName = new JLabel("Question Name:");
		lblQuestionName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblQuestionName.setBounds(10, 218, 113, 25);
		contentPane.add(lblQuestionName);
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
		planNameTF.setBounds(732, 387, 137, 25);
		contentPane.add(planNameTF);
		
		lblPlanName = new JLabel("Plan Name:");
		lblPlanName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPlanName.setBounds(646, 387, 84, 25);
		contentPane.add(lblPlanName);
	}
}
