package program;

import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ChangeEvent ;
import javax.swing.event.ChangeListener ;
import javax.swing.event.ListSelectionEvent ;
import javax.swing.event.ListSelectionListener ;

import file_io.FileIO ;
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
import javax.swing.JList;
import javax.swing.ListSelectionModel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSlider;

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
	@SuppressWarnings({ "unchecked", "rawtypes" })
   public FuzzySetWindow(User user) {
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 338);
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
		btnViewAll.setBounds(147, 265, 127, 37);
		contentPane.add(btnViewAll);
		
		JLabel lblEdit = new JLabel("------------------------------------------------Edit-----------------------------------------------");
		lblEdit.setBounds(10, 119, 401, 14);
		contentPane.add(lblEdit);
      
		ArrayList<ArrayList<ArrayList<Pair<Integer,Double>>>> points = new ArrayList<ArrayList<ArrayList<Pair<Integer,Double>>>>();
		points.add(new ArrayList<ArrayList<Pair<Integer,Double>>>());
		points.add(new ArrayList<ArrayList<Pair<Integer,Double>>>());
		points.add(new ArrayList<ArrayList<Pair<Integer,Double>>>());
      for(DiscreteFuzzySet<Integer> d : difficultySets)
         points.get(0).add(d.getPoints());
      for(DiscreteFuzzySet<Integer> l : learningSets)
         points.get(1).add(l.getPoints());
      for(DiscreteFuzzySet<Integer> s : successSets)
         points.get(2).add(s.getPoints());
      for (int i = 0; i < points.size(); i++){
         for (int j = 0; j < points.get(i).size(); j++){
            for (int k = 0; k < points.get(i).get(j).size(); k++){
               points.get(i).get(j).set(k, points.get(i).get(j).get(k).clone());
            }
         }
      }
      
      JLabel lblXResult = new JLabel("1");
      lblXResult.setBounds(284, 148, 46, 14);
      contentPane.add(lblXResult);
      
      JLabel lblYResult = new JLabel("2");
      lblYResult.setBounds(284, 182, 46, 14);
      contentPane.add(lblYResult);
      
      JSlider sliderY = new JSlider();
      JList listSet = new JList(new String[]{"Difficulty", "Learning", "Success"});
      JList listVars1 = new JList(new String[]{"Easy", "Medium", "Hard"});
      JList listVars2 = new JList(new String[]{"Bad", "Good", "Excellent"});
      JList listVars3 = new JList(new String[]{"Bad", "Good", "Excellent"});
      
      JSlider sliderX = new JSlider();
      sliderX.addChangeListener(new ChangeListener(){
         public void stateChanged(ChangeEvent arg0){
            lblXResult.setText("" + sliderX.getValue());
            if(listSet != null)
            {
               if(listSet.getSelectedIndex() == 0)
               {
                  sliderY.setValue((int)(points.get(0).get(listVars1.getSelectedIndex()).get(sliderX.getValue()-1).getSecond()*10));
               }
               else if(listSet.getSelectedIndex() == 1)
               {
                  sliderY.setValue((int)(points.get(1).get(listVars2.getSelectedIndex()).get(sliderX.getValue()-1).getSecond()*10));
               }
               else if(listSet.getSelectedIndex() == 2)
               {
                  sliderY.setValue((int)(points.get(2).get(listVars3.getSelectedIndex()).get(sliderX.getValue()-1).getSecond()*10));
               }
            }
         }
      });
		sliderX.setValue(5);
		sliderX.setMinimum(1);
		sliderX.setMaximum(10);
      sliderX.setBounds(157, 144, 117, 26);
      contentPane.add(sliderX);
      
      sliderY.addChangeListener(new ChangeListener(){
         public void stateChanged(ChangeEvent arg0){
            lblYResult.setText("" + sliderY.getValue()/10.0);
            if(listSet != null)
            {
               if(listSet.getSelectedIndex() == 0)
               {
                  points.get(0).get(listVars1.getSelectedIndex()).get(sliderX.getValue()-1).setSecond((Double)(sliderY.getValue()/10.0));
               }
               else if(listSet.getSelectedIndex() == 1)
               {
                  points.get(1).get(listVars2.getSelectedIndex()).get(sliderX.getValue()-1).setSecond((Double)(sliderY.getValue()/10.0));
               }
               else if(listSet.getSelectedIndex() == 2)
               {
                  points.get(2).get(listVars3.getSelectedIndex()).get(sliderX.getValue()-1).setSecond((Double)(sliderY.getValue()/10.0));
               }
            }
         }
      });
      sliderY.setValue(5);
      sliderY.setMaximum(10);
      sliderY.setBounds(157, 178, 117, 26);
      contentPane.add(sliderY);
      
      
      listVars1.addListSelectionListener(new ListSelectionListener(){
         public void valueChanged(ListSelectionEvent e){
            int temp = sliderX.getValue();
            if (temp == 1)
            {
               sliderX.setValue(2);
            }
            else
            {
               sliderX.setValue(1);
            }
            sliderX.setValue(temp);
         }
      });
      listVars1.setVisibleRowCount(3);
      listVars1.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      listVars1.setBounds(76, 144, 61, 60);
      listVars1.setSelectedIndex(0);
      listVars1.setVisible(true);
      contentPane.add(listVars1);
      
      listVars2.addListSelectionListener(new ListSelectionListener(){
         public void valueChanged(ListSelectionEvent e){
            int temp = sliderX.getValue();
            if (temp == 1)
            {
               sliderX.setValue(2);
            }
            else
            {
               sliderX.setValue(1);
            }
            sliderX.setValue(temp);
         }
      });
      listVars2.setVisibleRowCount(3);
      listVars2.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      listVars2.setBounds(76, 144, 61, 60);
      listVars2.setSelectedIndex(0);
      listVars2.setVisible(false);
      contentPane.add(listVars2);
      
      listVars3.addListSelectionListener(new ListSelectionListener(){
         public void valueChanged(ListSelectionEvent e){
            int temp = sliderX.getValue();
            if (temp == 1)
            {
               sliderX.setValue(2);
            }
            else
            {
               sliderX.setValue(1);
            }
            sliderX.setValue(temp);
         }
      });
      listVars3.setVisibleRowCount(3);
      listVars3.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      listVars3.setBounds(76, 144, 61, 60);
      listVars3.setSelectedIndex(0);
      listVars3.setVisible(false);
      contentPane.add(listVars3);
      
      listSet.addListSelectionListener(new ListSelectionListener(){
		   public void valueChanged(ListSelectionEvent e){
		      if(listSet.getSelectedIndex()==0)
		      {
		         listVars2.setVisible(false);
		         listVars3.setVisible(false);
               listVars1.setVisible(true);
               sliderX.setValue(1);
               sliderX.setMaximum(points.get(0).get(listVars1.getSelectedIndex()).size());
            }
		      else if(listSet.getSelectedIndex()==1)
            {
		         listVars1.setVisible(false);
               listVars3.setVisible(false);
               listVars2.setVisible(true);
               sliderX.setValue(1);
               sliderX.setMaximum(points.get(1).get(listVars2.getSelectedIndex()).size());
            }
		      else if(listSet.getSelectedIndex()==2)
            {
		         listVars1.setVisible(false);
               listVars2.setVisible(false);
               listVars3.setVisible(true);
               sliderX.setValue(1);
               sliderX.setMaximum(points.get(2).get(listVars3.getSelectedIndex()).size());
            }
		   }
		});
		listSet.setVisibleRowCount(3);
		listSet.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		listSet.setBounds(10, 144, 61, 60);
		listSet.setSelectedIndex(0);
		contentPane.add(listSet);
		sliderX.setValue(1);
		
		ArrayList<String> nameList1 = new ArrayList<String>();
      nameList1.add("Easy");
      nameList1.add("Medium");
      nameList1.add("Hard");
      ArrayList<String> nameList2 = new ArrayList<String>();
      nameList2.add("Bad");
      nameList2.add("Good");
      nameList2.add("Excellent");
      ArrayList<String> nameList3 = new ArrayList<String>();
      nameList3.add("Bad");
      nameList3.add("Good");
      nameList3.add("Excellent");
      
      JButton btnEditOne = new JButton("One");
		btnEditOne.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            ArrayList<String> names = null;
            String graphName = "";
            String graphTitle = "";
            ArrayList<Pair<Integer,Double>> point = null;
            String name = "";
            if (listSet.getSelectedIndex() == 0){
               names = nameList1;
               graphTitle = "Difficulty Fuzzy Set";
               graphName = "Difficulty";
               point = points.get(listSet.getSelectedIndex()).get(listVars1.getSelectedIndex());
               name = names.get(listVars1.getSelectedIndex());
            }
            else if (listSet.getSelectedIndex() == 1){
               names = nameList2;
               graphTitle = "Learning Fuzzy Set";
               graphName = "Learning";
               point = points.get(listSet.getSelectedIndex()).get(listVars2.getSelectedIndex());
               name = names.get(listVars2.getSelectedIndex());
            }
            else if (listSet.getSelectedIndex() == 2){
               names = nameList3;
               graphTitle = "Success Fuzzy Set";
               graphName = "Success";
               point = points.get(listSet.getSelectedIndex()).get(listVars3.getSelectedIndex());
               name = names.get(listVars3.getSelectedIndex());
            }
            
            FuzzySetGraphWindow window = new FuzzySetGraphWindow(graphTitle, graphName, name, point);
            window.enable();
         }
      });
      btnEditOne.setBounds(322, 144, 89, 23);
		contentPane.add(btnEditOne);
		
		JButton btnEditAll = new JButton("All");
		btnEditAll.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            ArrayList<String> names = null;
            String graphName = "";
            String graphTitle = "";
            if (listSet.getSelectedIndex() == 0){
               names = nameList1;
               graphTitle = "Difficulty Fuzzy Set";
               graphName = "Difficulty";
            }
            else if (listSet.getSelectedIndex() == 1){
               names = nameList2;
               graphTitle = "Learning Fuzzy Set";
               graphName = "Learning";
            }
            else if (listSet.getSelectedIndex() == 2){
               names = nameList3;
               graphTitle = "Success Fuzzy Set";
               graphName = "Success";
            }
            
            FuzzySetGraphWindow window = new FuzzySetGraphWindow(graphTitle, graphName, names, points.get(listSet.getSelectedIndex()));
            window.enable();
         }
      });
		btnEditAll.setBounds(322, 178, 89, 23);
		contentPane.add(btnEditAll);
		
		JButton btnEditSave = new JButton("Save Sets");
		btnEditSave.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent arg0) {
            int i = 0;
            for(DiscreteFuzzySet<Integer> d : difficultySets){
               d.setPoints(points.get(0).get(i));
               i++;
            }
            i = 0;
            for(DiscreteFuzzySet<Integer> l : learningSets){
               l.setPoints(points.get(1).get(i));
               i++;
            }
            i = 0;
            for(DiscreteFuzzySet<Integer> s : successSets){
               s.setPoints(points.get(2).get(i));
               i++;
            }
            FileIO.writeUser(user);
         }
      });
      btnEditSave.setBounds(147, 206, 127, 23);
		contentPane.add(btnEditSave);
		
		JLabel lblEnd = new JLabel("----------------------------------------------------------------------------------------------------");
		lblEnd.setBounds(10, 240, 401, 14);
		contentPane.add(lblEnd);
		
		JLabel lblX = new JLabel("X:");
		lblX.setBounds(147, 148, 46, 14);
		contentPane.add(lblX);
		
		JLabel lblY = new JLabel("Y:");
		lblY.setBounds(147, 182, 46, 14);
		contentPane.add(lblY);
	}
}
