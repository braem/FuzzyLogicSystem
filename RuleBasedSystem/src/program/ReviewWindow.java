package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.AnswerValue;
import structures.Attempt;
import structures.LearningPlan;
import structures.Marker;
import structures.Question;
import structures.Test;
import structures.User;
import system.InferenceEngine;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import file_io.FileIO;

import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author braem
 *
 */
public class ReviewWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1202080739655736067L;
	private JPanel contentPane;
	private JFrame thisFrame = this;
	private JTextField percentTF;
	private JTextField gradeTF;
	private JTable table;
	private JButton btnTakeAnotherTest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ReviewWindow frame = new ReviewWindow(null, null, null, null);
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

	/**
	 * Create the frame.
	 */
	public ReviewWindow(Test test, Attempt userAttempt, User user, LearningPlan currentPlan) {
		setTitle(test.getTestName()+" Review");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 348, 479);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		setup(contentPane, test, userAttempt, user, currentPlan);
	}
	
	private void setup(JPanel contentPane, Test test, Attempt userAttempt, User user, LearningPlan currentPlan) {
		boolean bestGradeOnThisTest = false;
		
		//grade this test
		double percentGrade = Marker.mark(test.getAnswerKey(), userAttempt);
		String letterGrade = Marker.getLetterGrade(percentGrade);
		if(test.getStudentGrade() < percentGrade) {
			test.setStudentAttempt(userAttempt);
			test.setStudentGrade(percentGrade);
			bestGradeOnThisTest = true;
			InferenceEngine iE = new InferenceEngine();
			iE.init(currentPlan);
			iE.inferenceCycle();
		}
		FileIO.writeUser(user); //write user to .ser
		
		/* set the table that shows the grades */
		ArrayList<Question> normalQuestions = test.getNormalQuestions();
		ArrayList<Question> bonusQuestions = test.getBonusQuestions();
		ArrayList<AnswerValue> normalKey = test.getAnswerKey().getNormalAnswers();
		ArrayList<AnswerValue> bonusKey = test.getAnswerKey().getBonusAnswers();
		ArrayList<AnswerValue> studentNAnswers = userAttempt.getNormalAnswers();
		ArrayList<AnswerValue> studentBAnswers = userAttempt.getBonusAnswers();
		String[] titles = {"Question", "Answer", "Attempted Answer", "Correct?", "isBonus"};
		Object[][] tableContentsOops = new Object[5][normalQuestions.size()+bonusQuestions.size()];
		for(int i=0; i<tableContentsOops.length; i++)//row
			for(int m=0; m<tableContentsOops[i].length; m++)//col
				if(i==0)
					tableContentsOops[i][m] = m+1;
				else if(i==1)
					if(m >= normalKey.size())
						tableContentsOops[i][m] = bonusKey.get(m-normalKey.size());
					else
						tableContentsOops[i][m] = normalKey.get(m);
				else if(i==2)
					if(m >= normalKey.size())
						tableContentsOops[i][m] = studentBAnswers.get(m-normalKey.size());
					else
						tableContentsOops[i][m] = studentNAnswers.get(m);
				else if(i==3)
					if(normalKey.get(m).equals(studentNAnswers.get(m)))
						tableContentsOops[i][m] = 'o';
					else
						tableContentsOops[i][m] = 'x';
				else
					if(m >= normalKey.size())
						tableContentsOops[i][m] = "Bonus";
					else
						tableContentsOops[i][m] = "";
		Object[][] tableContents = new Object[normalQuestions.size()+bonusQuestions.size()][5];
		//just switching rows/columns
		for(int i=0; i<tableContentsOops.length; i++)//row
			for(int j=0; j<tableContentsOops[i].length; j++)//col
				tableContents[j][i] = tableContentsOops[i][j];
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 14));
		table.setBackground(Color.WHITE);
		table.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		table.setModel(new DefaultTableModel(tableContents, titles) {
			private static final long serialVersionUID = -1842128243407165869L;
			Class[] columnTypes = new Class[] {
				Integer.class, AnswerValue.class, AnswerValue.class, Character.class, String.class
			};
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.getColumnModel().getColumn(0).setPreferredWidth(35);
		table.getColumnModel().getColumn(1).setPreferredWidth(35);
		table.getColumnModel().getColumn(2).setPreferredWidth(35);
		table.getColumnModel().getColumn(3).setPreferredWidth(35);
		table.getColumnModel().getColumn(4).setPreferredWidth(60);
		table.setBounds(10, 45, 280, 329);
		contentPane.add(table);
		
		btnTakeAnotherTest = new JButton("Take Another Test");
		btnTakeAnotherTest.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//go back to the selection window
				SelectWindow window = new SelectWindow(user);
				thisFrame.dispose();
				window.enable();
			}
		});
		btnTakeAnotherTest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnTakeAnotherTest.setBounds(10, 385, 275, 23);
		contentPane.add(btnTakeAnotherTest);
		
		//grade related text fields
		percentTF = new JTextField();
		percentTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		percentTF.setEditable(false);
		percentTF.setColumns(10);
		percentTF.setBounds(80, 11, 67, 23);
		percentTF.setText(""+percentGrade);
		contentPane.add(percentTF);
		gradeTF = new JTextField();
		gradeTF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		gradeTF.setEditable(false);
		gradeTF.setColumns(10);
		gradeTF.setBounds(218, 11, 67, 23);
		gradeTF.setText(letterGrade);
		contentPane.add(gradeTF);
		
		//labels
		JLabel lblPercent = new JLabel("Percent:");
		lblPercent.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblPercent.setBounds(10, 11, 60, 23);
		contentPane.add(lblPercent);
		JLabel lblGrade = new JLabel("Grade:");
		lblGrade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGrade.setBounds(157, 11, 51, 23);
		contentPane.add(lblGrade);
	}
}
