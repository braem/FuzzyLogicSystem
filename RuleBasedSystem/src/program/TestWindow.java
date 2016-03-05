package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import structures.AnswerValue;
import structures.Attempt;
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
	private JComboBox<Integer> questionSelectCB;
	private JComboBox<AnswerValue> answerCB;
	private JTextArea questionTA;
	private ArrayList<Question> normalQuestions;
	private ArrayList<Question> bonusQuestions;
	private ArrayList<AnswerValue> normalAnswers;
	private ArrayList<AnswerValue> bonusAnswers;
	private JProgressBar progressBar;
	private JButton btnSubmit;
	
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
	
	public void enable() {
		this.setVisible(true);
	}
	
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
	public TestWindow(Test test) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 373, 335);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		normalQuestions = test.getNormalQuestions();
		bonusQuestions = test.getBonusQuestions();
		bonusAnswers = new ArrayList<AnswerValue>();
		normalAnswers = new ArrayList<AnswerValue>();
		for(int i=0; i<normalQuestions.size(); i++)
			normalAnswers.add(null);
		for(int i=0; i<bonusAnswers.size(); i++)
			bonusAnswers.add(null);
		
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
		
		questionSelectCB = new JComboBox<Integer>();
		questionSelectCB.addActionListener (new ActionListener () {
		    public void actionPerformed(ActionEvent e) {
		    	Question question = intToQuestion((Integer)questionSelectCB.getSelectedItem());
		        questionTA.setText(""+question);
		    }
		});
		questionSelectCB.setFont(new Font("Tahoma", Font.PLAIN, 14));
		questionSelectCB.setBounds(254, 192, 56, 26);
		contentPane.add(questionSelectCB);
		for(int i=1; i<=normalQuestions.size()+bonusQuestions.size(); i++) 
			questionSelectCB.addItem(i);
		
		JButton btnLockAnswer = new JButton("Lock Answer");
		btnLockAnswer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int q = (Integer)questionSelectCB.getSelectedItem();
				AnswerValue ans = (AnswerValue)answerCB.getSelectedItem();
				if(q > normalQuestions.size()) {
					bonusAnswers.set(normalQuestions.size()-q-1, ans);
				}
				else {
					if(normalAnswers.get(q-1) == null)
						progressBar.setValue(progressBar.getValue()+1);
					normalAnswers.set(q-1, ans);
				}
			}
		});
		btnLockAnswer.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLockAnswer.setBounds(86, 191, 153, 29);
		contentPane.add(btnLockAnswer);
		
		progressBar = new JProgressBar();
		
		progressBar.setBounds(15, 229, 295, 14);
		progressBar.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent evt) {
		        if(progressBar.getValue() == progressBar.getMaximum())
		        	btnSubmit.setEnabled(true);
			}
		});
		contentPane.add(progressBar);
		progressBar.setMinimum(0);
		progressBar.setMaximum(normalQuestions.size());
		
		btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Attempt attempt = new Attempt(normalAnswers, bonusAnswers);
				ReviewWindow window = new ReviewWindow(test, attempt);
				thisFrame.dispose();
				window.enable();
			}
		});
		btnSubmit.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnSubmit.setBounds(86, 251, 153, 29);
		btnSubmit.setEnabled(false);
		contentPane.add(btnSubmit);
	}
}
