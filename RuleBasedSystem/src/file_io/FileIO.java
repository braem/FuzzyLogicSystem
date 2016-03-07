package file_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashSet;

import structures.*;

/**
 * Writes objects to files, and read objects from files.
 * @author Rhys
 * @version 1.0
 */
public class FileIO
{
	private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
	
	/**
	 * Loads learning plans from files in the working directory.
	 * @return    A list of the learning plans.
	 */
	public static HashSet<LearningPlan> loadLearningPlans() {
		HashSet<LearningPlan> learningPlans = new HashSet<LearningPlan>();
		ArrayList<String> fileNamesInFolder = getFileNamesInDir();
		for(String learningPlanStr : fileNamesInFolder) {
			try {
				FileInputStream fis = new FileInputStream(learningPlanStr);
				ObjectInputStream ois = new ObjectInputStream(fis);
				Object obj = ois.readObject();
				if (obj instanceof LearningPlan)
				{
				   LearningPlan result = (LearningPlan) obj;
	            learningPlans.add(result);
				}
				ois.close();
			} catch (IOException e) {} catch (ClassNotFoundException e) {}
		}
		return learningPlans;
	}
	
	/**
	 * Loads the specified User from a file.
	 * @param firstName       First name of the user.
	 * @param lastName        Last name of the user.
	 * @return                The User loaded.
	 */
	public static User loadUser(String firstName, String lastName) {
		ArrayList<String> fileNamesInFolder = getFileNamesInDir();
		User user = new User(firstName, lastName);
		for(String usernameStr : fileNamesInFolder) {
			if(usernameStr.equals(user.getUserName()+".ser")) {
				try {
					FileInputStream fis = new FileInputStream(usernameStr);
					ObjectInputStream ois = new ObjectInputStream(fis);
					user = (User) ois.readObject();
					ois.close();
				} catch (IOException e) {} catch (ClassNotFoundException e) {}
			}
		}
		return user;
	}
	
	/**
	 * Gets the names of all the files in the working directory.
	 * @return       List of filenames for the working directory.
	 */
	private static ArrayList<String> getFileNamesInDir() {
		File folder = new File(CURRENT_DIRECTORY);
		File[] listOfFiles = folder.listFiles();
		ArrayList<String> fileNamesInFolder = new ArrayList<String>();
		for(int i=0; i<listOfFiles.length; i++) {
			if(listOfFiles[i].isFile()) {
				fileNamesInFolder.add(listOfFiles[i].getName());
			}
		}
		return fileNamesInFolder;
	}
	
	/**
	 * Writes a User to a file.
	 * @param user      The User to be written.
	 */
	public static void writeUser(User user) {
		try {
			FileOutputStream fos = new FileOutputStream(user.getUserName()+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(user);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes a learning plan to a file.
	 * @param learningPlan    The learning plan to be written.
	 */
	public static void writeLearningPlan(LearningPlan learningPlan) {
		try {
			FileOutputStream fos = new FileOutputStream(learningPlan.getName()+".ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(learningPlan);
			oos.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * Writes a list of learning plans to files.
	 * Each entry in the list will be saved to a separate file.
	 * @param learningPlans      The list of learning plans.
	 */
	public static void writeAllLearningPlans(ArrayList<LearningPlan> learningPlans) {
		for(LearningPlan plan : learningPlans) {
			writeLearningPlan(plan);
		}
	}
}
