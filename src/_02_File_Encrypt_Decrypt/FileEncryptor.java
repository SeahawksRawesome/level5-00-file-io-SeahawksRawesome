package _02_File_Encrypt_Decrypt;

import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileEncryptor {
	static String response;
	static String number;
	static int key;
	/*
	 * Encryption is the process of encoding a message or information
	 * in such a way that only authorized parties can access it and
	 * those who are not authorized cannot.
	 *
	 * A simple shift cipher works by shifting the letters of a message
	 * down based on a key. If our key is 4 then:
	 * 
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 * 
	 * becomes:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 * 
	 * "Hello World" changes to "Lipps Asvph"
	 *
	 * Create a program that takes a message and a key from the user.
	 * Use the key to shift each letter in the users input and save the final result to a file.
	 */
	public static void main(String [] args) {
		 response = JOptionPane.showInputDialog("Type out a message:");
		 number = JOptionPane.showInputDialog("Type a number please:");
		 key = Integer.parseInt(number);
		encrypt(response, key);
	}
	public static void encrypt(String answer, int key) {
		String shift = "";
		for(int i = 0; i < answer.length(); i++) {
			char c = answer.charAt(i);
			c = (char)(c+key);
			shift += c;
		}
		System.out.println(shift);
		try {
			FileWriter fw = new FileWriter("src/_02_File_Encrypt_Decrypt/Untitled 1", true);
			
			fw.write(shift);
				
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
//Copyright  © 2020 Brandon Powell