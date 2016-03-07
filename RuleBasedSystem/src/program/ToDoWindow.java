package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.Goal;

import java.awt.List;

public class ToDoWindow extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2757328134366382669L;
	private static JPanel contentPane = new JPanel();
	private static List list = new List();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ToDoWindow frame = new ToDoWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void addGoal(Goal goal) {
		list.add(""+goal);
	}
	
	public static void removeGoal(Goal goal) {
		list.remove(""+goal);
	}
	
	public static void removeAllGoals() {
		list.removeAll();
	}
	
	public static boolean hasGoal(Goal g)
	{
		String[] items = list.getItems();
		boolean hasGoal = false;
		
		for(String item : items)
		{
			hasGoal |= item.equals(g.toString());
		}
		
		return hasGoal;
	}
	
	public void enable() {
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ToDoWindow() {
		setTitle("Todo List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 497, 333);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list.setBounds(10, 10, 421, 244);
		contentPane.add(list);
	}
}
