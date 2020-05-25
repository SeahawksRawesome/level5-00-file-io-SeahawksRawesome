package _02_File_Encrypt_Decrypt;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JOptionPane;

public class FileDecryptor {
	/*
	 * Decryption is the process of taking encoded or encrypted text or other data
	 * and converting it back into text that you or the computer can read and
	 * understand.
	 *
	 * The shift cipher is decrypted by using using the key and shifting back up, at
	 * the end of our encryption example we had our alphabet as:
	 *
	 * e f g h i j k l m n o p q r s t u v w x y z a b c d
	 *
	 * If we shift it back up by 4 based on the key we used the alphabet is
	 * decrypted:
	 *
	 * a b c d e f g h i j k l m n o p q r s t u v w x y z
	 *
	 * "Lipps Asvph" returns to "Hello World"
	 * 
	 * Create a program that opens the file created by FileEncryptor and decrypts
	 * the message, then display it to the user in a JOptionPane.
	 */
	FileEncryptor decode = new FileEncryptor();

	public static void main(String[] args) {

		decrypt();
	}

	public static void decrypt() {
		String shifted = "";
		String line = "";
		String file = "";
		String number = JOptionPane.showInputDialog("Type a number please:");
		int key = Integer.parseInt(number);
		try {
			BufferedReader br = new BufferedReader(new FileReader("src/_02_File_Encrypt_Decrypt/Untitled 1"));

			line = br.readLine();
			
			while (line != null) {
				System.out.println(line);
				file+=line;
				line = br.readLine();
				
			}

			br.close();
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(file);
		for(int i = 0; i < file.length(); i++) {
			char c = file.charAt(i);
			c = (char)(c-key);
			shifted += c;
		}
		JOptionPane.showMessageDialog(null, shifted);
	}
}//Copyright  © 2020 Brandon Powell