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
	private JFrame thisFrame = this;
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
		setBounds(100, 100, 430, 196);
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
		
		JButton btnDifficultyOne = new JButton("One");
		btnDifficultyOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				@SuppressWarnings("unchecked")
				DiscreteFuzzySet<Integer> set = (DiscreteFuzzySet<Integer>)difficultyCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> points = set.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Difficulty Fuzzy Set", "Difficulty", difficultyCB.getSelectedItem().toString(), points);
				window.enable();
			}
		});
		btnDifficultyOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDifficultyOne.setBounds(10, 83, 61, 25);
		contentPane.add(btnDifficultyOne);
		
		JButton btnDifficultyAll = new JButton("All");
      btnDifficultyAll.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            ArrayList<ArrayList<Pair<Integer,Double>>> points = new ArrayList<ArrayList<Pair<Integer,Double>>>();
            for (int i = 0; i < difficultyCB.getItemCount(); i++)
            {
               points.add(((DiscreteFuzzySet<Integer>)difficultyCB.getItemAt(i)).getPoints());
            }
            ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < difficultyCB.getItemCount(); i++)
            {
               names.add((String)difficultyCB.getItemAt(i).toString());
            }
            FuzzySetGraphWindow window = new FuzzySetGraphWindow("Difficulty Fuzzy Set", "Difficulty", names, points);
            window.enable();
         }
      });
      btnDifficultyAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnDifficultyAll.setBounds(76, 83, 61, 25);
      contentPane.add(btnDifficultyAll);
      
      JButton btnLearningOne = new JButton("One");
		btnLearningOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				DiscreteFuzzySet<Integer> set = (DiscreteFuzzySet<Integer>)learningCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> points = set.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Learning Fuzzy Set", "Learning", learningCB.getSelectedItem().toString(), points);
				window.enable();
			}
		});
		btnLearningOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnLearningOne.setBounds(147, 83, 61, 25);
      contentPane.add(btnLearningOne);
      
      JButton btnLearningAll = new JButton("All");
      btnLearningAll.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            ArrayList<ArrayList<Pair<Integer,Double>>> points = new ArrayList<ArrayList<Pair<Integer,Double>>>();
            for (int i = 0; i < learningCB.getItemCount(); i++)
            {
               points.add(((DiscreteFuzzySet<Integer>)learningCB.getItemAt(i)).getPoints());
            }
            ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < learningCB.getItemCount(); i++)
            {
               names.add((String)learningCB.getItemAt(i).toString());
            }
            FuzzySetGraphWindow window = new FuzzySetGraphWindow("Learning Fuzzy Set", "Learning", names, points);
            window.enable();
         }
      });
      btnLearningAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnLearningAll.setBounds(213, 83, 61, 25);
      contentPane.add(btnLearningAll);
      
      JButton btnSuccessOne = new JButton("One");
		btnSuccessOne.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unchecked")
				DiscreteFuzzySet<Integer> set = (DiscreteFuzzySet<Integer>)successCB.getSelectedItem();
				ArrayList<Pair<Integer,Double>> points = set.getPoints();
				FuzzySetGraphWindow window = new FuzzySetGraphWindow("Success Fuzzy Set", "Success", successCB.getSelectedItem().toString(), points);
				window.enable();
			}
		});
		btnSuccessOne.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnSuccessOne.setBounds(284, 83, 61, 25);
      contentPane.add(btnSuccessOne);
      
      JButton btnSuccessAll = new JButton("All");
      btnSuccessAll.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            ArrayList<ArrayList<Pair<Integer,Double>>> points = new ArrayList<ArrayList<Pair<Integer,Double>>>();
            for (int i = 0; i < successCB.getItemCount(); i++)
            {
               points.add(((DiscreteFuzzySet<Integer>)successCB.getItemAt(i)).getPoints());
            }
            ArrayList<String> names = new ArrayList<String>();
            for (int i = 0; i < successCB.getItemCount(); i++)
            {
               names.add((String)successCB.getItemAt(i).toString());
            }
            FuzzySetGraphWindow window = new FuzzySetGraphWindow("Success Fuzzy Set", "Success", names, points);
            window.enable();
         }
      });
      btnSuccessAll.setFont(new Font("Tahoma", Font.PLAIN, 15));
      btnSuccessAll.setBounds(350, 83, 61, 25);
      contentPane.add(btnSuccessAll);
      
      JButton btnViewAll = new JButton("back");
		btnViewAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LoginChoiceWindow window = new LoginChoiceWindow(user);
				thisFrame.dispose();
				window.enable();
			}
		});
		btnViewAll.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnViewAll.setBounds(147, 119, 127, 37);
		contentPane.add(btnViewAll);
	}
}
