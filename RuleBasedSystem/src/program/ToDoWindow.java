package program;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import structures.Goal;

import java.awt.List;

/**
 * Static Window for the todo list
 * Shows the user the list of goals left they need to meet
 * Manipulated by the inference engine
 * 
 * @author Braemen
 * @version 1.0
 */
public class ToDoWindow extends JFrame
{
	private static final long serialVersionUID = -2757328134366382669L;
	private static JPanel contentPane = new JPanel();
	private static List list = new List();

	/**
	 *  Test the window
	 *  
	 *  @param args     A list of arguments. Not used.
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
	
	/**
	 * Adds goal to the todo list
	 * 
	 * @param goal      Goal to be added.
	 */
	public static void addGoal(Goal goal) {
		list.add(""+goal);
	}
	
	/**
	 * Removes goal from the todo list
	 * 
	 * @param goal      Goal to be removed.
	 */
	public static void removeGoal(Goal goal) {
		list.remove(""+goal);
	}
	
	/**
	 * Removes all goals from the todo list.
	 */
	public static void removeAllGoals() {
		list.removeAll();
	}
	
	/**
	 * check if a goal is in the list
	 * 
	 * @param g      Goal to that may be in the list.
	 * @return       <code>true</code> if the goal is in the list.
	 *               <code>false</code> otherwise.
	 */
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
	
	/**
	 * Enable this window
	 */
	public void enable() {
		this.setVisible(true);
	}

	/**
	 * Create the frame.
	 */
	public ToDoWindow() {
	   setResizable(false);
		setTitle("Todo List");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 447, 293);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		list.setBounds(10, 10, 421, 244);
		contentPane.add(list);
	}
}
