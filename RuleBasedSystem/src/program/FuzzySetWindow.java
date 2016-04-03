package program;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.User;
import system.DiscreteFuzzySet;
import system.DiscreteLinguisticVariable;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class FuzzySetWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 3599584867107349804L;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FuzzySetWindow frame = new FuzzySetWindow(null);
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
	 * Create the frame.
	 */
	public FuzzySetWindow(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 793, 478);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox<DiscreteFuzzySet<Double>> difficultyCB = new JComboBox<DiscreteFuzzySet<Double>>();
		difficultyCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		difficultyCB.setBounds(10, 47, 127, 25);
		contentPane.add(difficultyCB);
		
		JComboBox<DiscreteFuzzySet<Double>> learningCB = new JComboBox<DiscreteFuzzySet<Double>>();
		learningCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		learningCB.setBounds(147, 47, 127, 25);
		contentPane.add(learningCB);
		
		JComboBox<DiscreteFuzzySet<String>> successCB = new JComboBox<DiscreteFuzzySet<String>>();
		successCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		successCB.setBounds(284, 47, 127, 25);
		contentPane.add(successCB);
		
		//discrete variables
		DiscreteLinguisticVariable<Double> difficulty = user.getDifficulty();
		DiscreteLinguisticVariable<Double> learning = user.getLearning();
		DiscreteLinguisticVariable<String> success = user.getSuccess();
		
		//easy, medium, hard
		ArrayList<DiscreteFuzzySet<Double>> difficultySets = difficulty.getFuzzySets();
		ArrayList<DiscreteFuzzySet<Double>> learningSets = learning.getFuzzySets();
		ArrayList<DiscreteFuzzySet<String>> successSets = success.getFuzzySets();
		
		/* labels */
		JLabel lblSuccess = new JLabel("Success:");
		lblSuccess.setHorizontalAlignment(SwingConstants.CENTER);
		lblSuccess.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSuccess.setBounds(284, 11, 127, 25);
		contentPane.add(lblSuccess);
		JLabel lblLearning = new JLabel("Learning:");
		lblLearning.setHorizontalAlignment(SwingConstants.CENTER);
		lblLearning.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLearning.setBounds(147, 11, 127, 25);
		contentPane.add(lblLearning);
		JLabel lblDifficulty = new JLabel("Difficulty:");
		lblDifficulty.setHorizontalAlignment(SwingConstants.CENTER);
		lblDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDifficulty.setBounds(10, 11, 127, 25);
		contentPane.add(lblDifficulty);
	}
}
