package program;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.User;
import system.DiscreteFuzzySet;
import system.DiscreteLinguisticVariable;
import system.Pair;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

/**
 * 
 * @author braem
 * @version 1.0
 */
public class FuzzySetWindow extends JFrame
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3599584867107349804L;
	private JPanel contentPane;
	private JComboBox<DiscreteFuzzySet<Integer>> difficultyCB;
	private JComboBox<DiscreteFuzzySet<Integer>> learningCB;
	private JComboBox<DiscreteFuzzySet<Integer>> successCB;
	
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 467, 209);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		difficultyCB = new JComboBox<DiscreteFuzzySet<Integer>>();
		difficultyCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		difficultyCB.setBounds(10, 47, 127, 25);
		contentPane.add(difficultyCB);
		
		learningCB = new JComboBox<DiscreteFuzzySet<Integer>>();
		learningCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		learningCB.setBounds(147, 47, 127, 25);
		contentPane.add(learningCB);
		
		successCB = new JComboBox<DiscreteFuzzySet<Integer>>();
		successCB.setFont(new Font("Tahoma", Font.PLAIN, 15));
		successCB.setBounds(284, 47, 127, 25);
		contentPane.add(successCB);
		
		/* Adding fuzzy sets from the user to the comboboxes */
		//discrete variables
		DiscreteLinguisticVariable<Integer> difficulty = user.getDifficulty();
		DiscreteLinguisticVariable<Integer> learning = user.getLearning();
		DiscreteLinguisticVariable<Integer> success = user.getSuccess();
		
		//fuzzy sets
		//eg. easy, medium, hard
		ArrayList<DiscreteFuzzySet<Integer>> difficultySets = difficulty.getFuzzySets();
		ArrayList<DiscreteFuzzySet<Integer>> learningSets = learning.getFuzzySets();
		ArrayList<DiscreteFuzzySet<Integer>> successSets = success.getFuzzySets();
		
		//adding fuzzy sets to comboxes
		for(DiscreteFuzzySet<Integer> d : difficultySets)
			difficultyCB.addItem(d);
		for(DiscreteFuzzySet<Integer> l : learningSets)
			learningCB.addItem(l);
		for(DiscreteFuzzySet<Integer> s : successSets)
			successCB.addItem(s);
		
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
		
		JButton btnDifficulty = new JButton("View");
		btnDifficulty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unchecked")
				DiscreteFuzzySet<Integer> set = (DiscreteFuzzySet<Integer>)difficultyCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> points = set.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Difficulty Fuzzy Set", "Difficulty", points);
				window.enable();
			}
		});
		btnDifficulty.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDifficulty.setBounds(10, 83, 127, 25);
		contentPane.add(btnDifficulty);
		
		JButton btnLearning = new JButton("View");
		btnLearning.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				DiscreteFuzzySet<Integer> set = (DiscreteFuzzySet<Integer>)learningCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> points = set.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Learning Fuzzy Set", "Learning", points);
				window.enable();
			}
		});
		btnLearning.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnLearning.setBounds(147, 83, 127, 25);
		contentPane.add(btnLearning);
		
		JButton btnSuccess = new JButton("View");
		btnSuccess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				DiscreteFuzzySet<Integer> set = (DiscreteFuzzySet<Integer>)successCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> points = set.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Success Fuzzy Set", "Success", points);
				window.enable();
			}
		});
		btnSuccess.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSuccess.setBounds(284, 83, 127, 25);
		contentPane.add(btnSuccess);
		
		JButton btnViewAll = new JButton("View All");
		btnViewAll.addActionListener(new ActionListener() {
			@SuppressWarnings("unchecked")
			public void actionPerformed(ActionEvent arg0) {
				DiscreteFuzzySet<Integer> sset = (DiscreteFuzzySet<Integer>)successCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> spoints = sset.getPoints();
				DiscreteFuzzySet<Integer> lset = (DiscreteFuzzySet<Integer>)learningCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> lpoints = lset.getPoints();
				DiscreteFuzzySet<Integer> dset = (DiscreteFuzzySet<Integer>)difficultyCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> dpoints = dset.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Working Fuzzy Sets", "Fuzzy Sets", dpoints, lpoints, spoints);
				window.enable();
			}
		});
		btnViewAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewAll.setBounds(147, 119, 127, 37);
		contentPane.add(btnViewAll);
	}
}
