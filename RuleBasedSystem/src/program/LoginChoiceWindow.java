package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.User;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class LoginChoiceWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5431857948026169133L;
	private JPanel contentPane;
	private JFrame thisFrame = this;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginChoiceWindow frame = new LoginChoiceWindow(null);
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
	public LoginChoiceWindow(User user) {
	   setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 247, 138);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnTakeTests = new JButton("Take Tests");
		btnTakeTests.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				SelectWindow window = new SelectWindow(user);
				thisFrame.dispose();
				window.enable();
			}
		});
		btnTakeTests.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnTakeTests.setBounds(10, 11, 221, 38);
		contentPane.add(btnTakeTests);
		
		JButton btnChangeFuzzySets = new JButton("Change Fuzzy Sets");
		btnChangeFuzzySets.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				FuzzySetWindow window = new FuzzySetWindow(user);
				window.enable();
				thisFrame.dispose();
			}
		});
		btnChangeFuzzySets.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnChangeFuzzySets.setBounds(10, 60, 221, 38);
		contentPane.add(btnChangeFuzzySets);
	}

}
