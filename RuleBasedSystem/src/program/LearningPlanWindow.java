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
	private JButton btnSelect;

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
		setBounds(100, 100, 289, 206);
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
		btnBack.setBounds(82, 116, 89, 23);
		contentPane.add(btnBack);
		
		btnSelect = new JButton("Select Plan");
		btnSelect.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnSelect.setBounds(53, 77, 149, 28);
		contentPane.add(btnSelect);
	}

}
