package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import file_io.FileIO;
import structures.User;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Window to authenticate the user and load all their info
 * 
 * @author Braemen
 * @version 1.0
 */
public class LoginWindow extends JFrame 
{
	private static final long serialVersionUID = -5552083409696846055L;
	private JFrame thisFrame = this;
	private JPanel contentPane;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JLabel lblInvalidName;
	private JButton btnBack;

	/**
	 * Tests the window
	 * 
	 * @param args      List of arguments. Not used.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginWindow frame = new LoginWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Enables this window.
	 */
	public void enable() {
		this.setVisible(true);
	}
	
	/**
	 * Controls login attempts.
	 */
	private void login() {
		String firstName = null;
		String lastName = null;
		//restrict firstname
		if(firstNameTF.getText().matches("[A-Z][a-z]+")) {
			lblInvalidName.setVisible(false);
			firstName = firstNameTF.getText();
		}
		else {
			lblInvalidName.setVisible(true);
			return;
		}
		//restrict lastname
		if(lastNameTF.getText().matches("[A-Z][a-z]+")) {	
			lblInvalidName.setVisible(false);
			lastName = lastNameTF.getText();
		}
		else {
			lblInvalidName.setVisible(true);
			return;
		}
		User user = FileIO.loadUser(firstName, lastName);
		LoginChoiceWindow window = new LoginChoiceWindow(user);
		thisFrame.dispose();
		window.enable();
	}
	
	/**
	 * Create the frame.
	 */
	public LoginWindow() {
	   setResizable(false);
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//responds on enter key & attempts login
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		
		//labels
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 11, 81, 17);
		contentPane.add(lblFirstName);
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(10, 39, 81, 17);
		contentPane.add(lblLastName);
		
		//first name text field
		firstNameTF = new JTextField();
		firstNameTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameTF.setBounds(101, 11, 122, 20);
		contentPane.add(firstNameTF);
		firstNameTF.setColumns(10);
		firstNameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) { //respond on enter key
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		
		//last name text field
		lastNameTF = new JTextField();
		lastNameTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastNameTF.setBounds(101, 39, 122, 20);
		contentPane.add(lastNameTF);
		lastNameTF.setColumns(10);
		lastNameTF.addKeyListener(new KeyAdapter() { //respond on enter key
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		
		//login button
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.addKeyListener(new KeyAdapter() { //respond on enter key
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(10, 67, 89, 32);
		contentPane.add(btnLogin);
		
		//error label
		lblInvalidName = new JLabel("invalid name");
		lblInvalidName.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidName.setForeground(Color.RED);
		lblInvalidName.setBounds(10, 95, 89, 14);
		contentPane.add(lblInvalidName);
		
		btnBack = new JButton("back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ChoiceWindow window = new ChoiceWindow();
				window.enable();
				thisFrame.dispose();
			}
		});
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnBack.setBounds(134, 67, 89, 32);
		contentPane.add(btnBack);
		lblInvalidName.setVisible(false);
	}
}
