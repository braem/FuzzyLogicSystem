package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ChoiceWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -606638665140433493L;
	private JPanel contentPane;
	private JFrame thisFrame = this;

	/**
	 * Launch the application.
	 * @param args input argument array from calling function.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ChoiceWindow frame = new ChoiceWindow();
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
	public ChoiceWindow() {
	   setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 313, 135);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginWindow window = new LoginWindow();
				window.enable();
				thisFrame.dispose();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLogin.setBounds(82, 11, 137, 39);
		contentPane.add(btnLogin);
		
		JButton btnCreateALearning = new JButton("Create a Learning Plan");
		btnCreateALearning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LearningPlanCreationWindow window = new LearningPlanCreationWindow();
				window.enable();
				thisFrame.dispose();
			}
		});
		btnCreateALearning.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCreateALearning.setBounds(10, 57, 288, 39);
		contentPane.add(btnCreateALearning);
	}
}
