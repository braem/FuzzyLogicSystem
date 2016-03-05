package file_io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import structures.*;

/*
 * t
 */
public class FileIO
{
	private static final String CURRENT_DIRECTORY = System.getProperty("user.dir");
	
	public static ArrayList<LearningPlan> loadLearningPlans() {
		ArrayList<LearningPlan> learningPlans = new ArrayList<LearningPlan>();
		ArrayList<String> fileNamesInFolder = getFileNamesInDir();
		for(String learningPlanStr : fileNamesInFolder) {
			try {
				FileInputStream fis = new FileInputStream(learningPlanStr);
				ObjectInputStream ois = new ObjectInputStream(fis);
				LearningPlan result = (LearningPlan) ois.readObject();
				learningPlans.add(result);
				ois.close();
			} catch (IOException e) {} catch (ClassNotFoundException e) {}
		}
		return learningPlans;
	}
	
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
	
	public static void writeAllLearningPlans(ArrayList<LearningPlan> learningPlans) {
		for(LearningPlan plan : learningPlans) {
			writeLearningPlan(plan);
		}
	}
}
