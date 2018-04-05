package ie.gmit.sw.ai;

import java.util.Scanner;

public class CipherBreaker {


	/**
	 * Main method creates a user interface that gives the user options.
	 * 1. Allows user to enter a source file.
	 * 2. Allows user to enter a output file name.
	 * 3. Deciphers the source file and outputs it to the output file.
	 * 4. Exits the application.
	 * @param args
	 */

	public static void main(String[] args) {
	    CipherBreaker breaker = new CipherBreaker();
	
	    String SourceFile = "", OutputFile = "";
	    Scanner reader = new Scanner(System.in);  // Reading from System.in
	
	    while (true) {
	        System.out.println("PlayfairCipher Breaker\n\n1.Enter Source File\n2.Enter Output File\n3.Decipher\n\n4.Exit");
	
	        System.out.println("\n\nChoose:");
	        int n = reader.nextInt();
	        switch (n) {
	            case 1:
	                System.out.println("\n\nEnter Source File Name:");
	                SourceFile = reader.next();
	                break;
	            case 2:
	                System.out.println("\n\nEnter Output File Name:");
	                OutputFile = reader.next();
	                break;
	            case 3:
	                breaker.BreakCipher(SourceFile, OutputFile);
	                break;
	            case 4:
	                reader.close();
	                return;
	        }
	
	    }
	}
	
	public void BreakCipher(String FileName, String OutputFile) {
	}
}