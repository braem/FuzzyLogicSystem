package program;

import java.awt.EventQueue;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;

import structures.Goal;
import structures.PreReq;

import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CreatePrereqPopupWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5442319584348255514L;
	private JPanel contentPane;
	private JFrame thisFrame = this;
	private JList<Goal> list;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreatePrereqPopupWindow frame = new CreatePrereqPopupWindow(null,null,null);
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
	public CreatePrereqPopupWindow(DefaultListModel<PreReq> prereqModel, DefaultListModel<Goal> goalModel, Goal selectedGoal) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 193, 336);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		DefaultListModel<Goal> m = new DefaultListModel<Goal>();
		list = new JList<Goal>(m);
		list.setFont(new Font("Tahoma", Font.PLAIN, 14));
		list.setBounds(10, 66, 137, 160);
		contentPane.add(list);
		for(int i=0; i<goalModel.getSize(); i++)
			m.addElement((Goal)goalModel.getElementAt(i));
		m.removeElement(selectedGoal);
		
		JLabel lblChooseAGoal = new JLabel("Choose a Goal");
		lblChooseAGoal.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblChooseAGoal.setBounds(10, 11, 272, 22);
		contentPane.add(lblChooseAGoal);
		
		JLabel lblForThisPrereq = new JLabel("for this Prereq");
		lblForThisPrereq.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblForThisPrereq.setBounds(10, 33, 272, 22);
		contentPane.add(lblForThisPrereq);
		
		JButton btnNewButton = new JButton("Set");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Goal[] goals = (Goal[]) list.getSelectedValues();
				for(Goal goal : goals)
					prereqModel.addElement(new PreReq(selectedGoal, goal, selectedGoal+" | "+goal));
				thisFrame.dispose();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(10, 237, 137, 38);
		contentPane.add(btnNewButton);
	}

}
