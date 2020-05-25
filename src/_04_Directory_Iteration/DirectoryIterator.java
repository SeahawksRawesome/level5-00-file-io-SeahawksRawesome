package _04_Directory_Iteration;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;

public class DirectoryIterator {
	public static void main(String[] args) {
		/*
		 * The following is an example of how to list all of the files in a directory.
		 * Once the program is running, the directory is chosen using the JFileChooser.
		 */
		/*
		 * JFileChooser jfc = new JFileChooser();
		 * jfc.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES); int returnVal =
		 * jfc.showOpenDialog(null); if (returnVal == JFileChooser.APPROVE_OPTION) {
		 * File directory = jfc.getSelectedFile(); File[] files = directory.listFiles();
		 * if(files != null) { for(File f : files) {
		 * System.out.println(f.getAbsolutePath()); } } }
		 */

		/*
		 * Your task is to write a program that iterates through the src folder of this
		 * current Java Project. For every .java file it finds, the program will add a
		 * (non-legally binding) copyright statement at the bottom. Be aware of possible
		 * directories inside of directories. (e.g //Copyright © 2019 FirstName
		 * LastName)
		 */
			File directory = new File("src/_02_File_Encrypt_Decrypt");
	
			File[] files = directory.listFiles();
			if (files != null) {
				for (File f : files) {
					String path = f.getAbsolutePath();
					System.out.println(path);
					if(path.substring(path.length()-5, path.length()).equals(".java")) {
						try {
							FileWriter fw = new FileWriter(path, true);
							
							/*
							NOTE: To append to a file that already exists, add true as a second parameter when calling the
							      FileWriter constructor.
							      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
							*/
							
							fw.write("//Copyright  © 2020 Brandon Powell");
								
							fw.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			}
		}
	}
}
