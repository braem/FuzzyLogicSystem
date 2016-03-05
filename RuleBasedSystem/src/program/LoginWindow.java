package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

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

public class LoginWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -5552083409696846055L;
	private JFrame thisFrame = this;
	private JPanel contentPane;
	private JTextField firstNameTF;
	private JTextField lastNameTF;
	private JLabel lblInvalidName;

	/**
	 * Launch the application.
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

	public void enable() {
		this.setVisible(true);
	}
	
	private void login() {
		String firstName = null;
		String lastName = null;
		if(firstNameTF.getText().matches("[A-Z][a-z]+")) {
			lblInvalidName.setVisible(false);
			firstName = firstNameTF.getText();
		}
		else {
			lblInvalidName.setVisible(true);
			return;
		}
		if(lastNameTF.getText().matches("[A-Z][a-z]+")) {	
			lblInvalidName.setVisible(false);
			lastName = lastNameTF.getText();
		}
		else {
			lblInvalidName.setVisible(true);
			return;
		}
		User user = new User(firstName, lastName);
		SelectWindow window = new SelectWindow(user);
		thisFrame.dispose();
		window.enable();
	}
	
	/**
	 * Create the frame.
	 */
	public LoginWindow() {
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 271, 172);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		this.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblFirstName.setBounds(10, 11, 81, 17);
		contentPane.add(lblFirstName);
		
		JLabel lblLastName = new JLabel("Last Name:");
		lblLastName.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblLastName.setBounds(10, 39, 81, 17);
		contentPane.add(lblLastName);
		
		firstNameTF = new JTextField();
		firstNameTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		firstNameTF.setBounds(101, 11, 122, 20);
		contentPane.add(firstNameTF);
		firstNameTF.setColumns(10);
		firstNameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		
		lastNameTF = new JTextField();
		lastNameTF.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lastNameTF.setBounds(101, 39, 122, 20);
		contentPane.add(lastNameTF);
		lastNameTF.setColumns(10);
		lastNameTF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				login();
			}
		});
		btnLogin.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_ENTER)
					login();
			}
		});
		btnLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnLogin.setBounds(76, 67, 89, 32);
		contentPane.add(btnLogin);
		
		lblInvalidName = new JLabel("invalid name");
		lblInvalidName.setHorizontalAlignment(SwingConstants.CENTER);
		lblInvalidName.setForeground(Color.RED);
		lblInvalidName.setBounds(76, 97, 89, 14);
		contentPane.add(lblInvalidName);
		lblInvalidName.setVisible(false);
	}
}
