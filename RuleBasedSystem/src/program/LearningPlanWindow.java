package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.*;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LearningPlanWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8807127458602336380L;
	private JPanel contentPane;
	private JFrame thisFrame = this;
	private static JComboBox<LearningPlan> learningPlanCB = new JComboBox<LearningPlan>();
	private JButton btnBack;
	private JButton btnStart;
	private JComboBox<Goal> goalCB;
	private JComboBox<Test> testCB;
	private JLabel lblSelectAGoal;
	private JLabel lblSelectATest;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LearningPlanWindow frame = new LearningPlanWindow(null);
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
	
	public static void addPlanToCB(LearningPlan plan) {
		learningPlanCB.addItem(plan);
	}

	/**
	 * Create the frame.
	 */
	public LearningPlanWindow(User user) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 802, 234);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSelectALearning = new JLabel("Select a Learning Plan");
		lblSelectALearning.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectALearning.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectALearning.setBounds(10, 11, 235, 22);
		contentPane.add(lblSelectALearning);
		
		learningPlanCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		learningPlanCB.setBounds(10, 44, 235, 22);
		contentPane.add(learningPlanCB);
		
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
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnStart.setBounds(255, 107, 128, 28);
		contentPane.add(btnStart);
		
		goalCB = new JComboBox<Goal>();
		goalCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		goalCB.setBounds(10, 110, 235, 22);
		contentPane.add(goalCB);
		
		testCB = new JComboBox<Test>();
		testCB.setFont(new Font("Tahoma", Font.PLAIN, 12));
		testCB.setBounds(255, 44, 235, 22);
		contentPane.add(testCB);
		
		lblSelectAGoal = new JLabel("Select a Goal");
		lblSelectAGoal.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectAGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectAGoal.setBounds(10, 77, 235, 22);
		contentPane.add(lblSelectAGoal);
		
		lblSelectATest = new JLabel("Select a Test");
		lblSelectATest.setHorizontalAlignment(SwingConstants.CENTER);
		lblSelectATest.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblSelectATest.setBounds(255, 11, 235, 22);
		contentPane.add(lblSelectATest);
	}

}
