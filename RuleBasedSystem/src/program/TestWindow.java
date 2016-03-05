package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.AnswerValue;
import structures.Question;
import structures.Test;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.JProgressBar;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TestWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3174576884030367218L;
	private JPanel contentPane;
	private JFrame thisFrame = this;
	private JComboBox<Question> questionSelectCB;
	private JComboBox<AnswerValue> answerCB;
	private JTextArea questionTA;
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;
	private ArrayList<AnswerValue> answers;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TestWindow frame = new TestWindow(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TestWindow(Test test) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 366, 349);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		normalQuestions = test.getNormalQuestions();
		bonusQuestions = test.getBonusQuestions();
		
		questionTA = new JTextArea();
		questionTA.setLineWrap(true);
		questionTA.setFont(new Font("Monospaced", Font.PLAIN, 14));
		questionTA.setBounds(15, 16, 295, 160);
		contentPane.add(questionTA);
		
		answerCB = new JComboBox<AnswerValue>();
		answerCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		answerCB.setBounds(15, 192, 56, 26);
		contentPane.add(answerCB);
		for(AnswerValue ansVal : AnswerValue.values())
			answerCB.addItem(ansVal);
		
		questionSelectCB = new JComboBox<Question>();
		questionSelectCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questionSelectCB.setBounds(254, 192, 56, 26);
		contentPane.add(questionSelectCB);
		for(Question question : normalQuestions)
			questionSelectCB.addItem(question);
		
		JButton btnLockAnswer = new JButton("Lock Answer");
		btnLockAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		btnLockAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLockAnswer.setBounds(86, 191, 153, 29);
		contentPane.add(btnLockAnswer);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setBounds(15, 234, 295, 26);
		contentPane.add(progressBar);
	}
}
