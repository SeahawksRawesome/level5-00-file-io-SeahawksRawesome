package _03_To_Do_List;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class ToDoList implements ActionListener {
	JFrame f1;
	JPanel p1;
	JButton add;
	JButton view;
	JButton remove;
	JButton save;
	JButton load;
	ArrayList<String> arr = new ArrayList<String>();
	/*
	 * Create a program with five buttons, add task, view tasks, remove task, save list, and load list. 
	 *
	 * When add task is clicked:
	 * 		Create a JOptionPane to ask the user for a task and add it to an ArrayList
	 * 
	 * When the view tasks button is clicked:
	 *		show all the tasks in the list
	 * 
	 * When the remove task button is clicked:
	 * 		Create a JOptionPane to prompt the user for which task to remove and take it off of the list.
	 * 
	 * When the save list button is clicked:
	 * 		Save the list to a file
	 * 
	 * When the load list button is clicked:
	 * 		Create a JOptionPane to Prompt the user for the location of the file and load the list from that file
	 * 
	 * When the program starts, it should automatically load the last saved file into the list. 
	 */
	public ToDoList() {
		 f1= new JFrame();
		 p1 = new JPanel();
		 add = new JButton();
		 view = new JButton();
		 remove = new JButton();
		 save = new JButton();
		 load = new JButton();
		f1.add(p1);
		p1.add(add);
		p1.add(view);
		p1.add(remove);
		p1.add(save);
		p1.add(load);
		f1.setSize(1000, 500);
		f1.setVisible(true);
		p1.setVisible(true);
		add.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		save.addActionListener(this);
		load.addActionListener(this);
		//add.setSize(100, 50);
		//add.setVisible(true);
	}
	public static void main(String [] args) {
		ToDoList m = new ToDoList();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == add) {
			String answer = JOptionPane.showInputDialog("Give me a task");
			arr.add(answer);
		}
		if(e.getSource() == view) {
			String display = "";
			for(int i = 0; i < arr.size(); i++) {
				display= display + " " + arr.get(i);
			}
			JOptionPane.showMessageDialog(null, display);
		}
		if(e.getSource() == remove) {
			String exact = JOptionPane.showInputDialog("what task would you like to remove?");
			int removed = Integer.parseInt(exact);
			arr.remove(removed);
		}
		if(e.getSource() == save) {
			try {
				FileWriter fw = new FileWriter("src/_03_To_Do_List/WriteTo", true);
				
				/*
				NOTE: To append to a file that already exists, add true as a second parameter when calling the
				      FileWriter constructor.
				      (e.g. FileWriter fw = new FileWriter("src/_00_Intro_To_File_Input_and_Output/test2.txt", true);)
				*/
				for(int i = 0; i < arr.size(); i++) {
					fw.write(arr.get(i)+ "\n");
				};
					
				fw.close();
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
		if(e.getSource() == load) {
			String answer = JOptionPane.showInputDialog("where is the file located");
			try {
				BufferedReader br = new BufferedReader(new FileReader(answer));
				
				String line = br.readLine();
				while(line != null){
					System.out.println(line);
					line = br.readLine();
				}
				
				br.close();
			} catch (FileNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e3) {
				// TODO Auto-generated catch block
				e3.printStackTrace();
			}
		}
	}
}
