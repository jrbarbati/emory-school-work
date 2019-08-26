//Joseph Barbati - jdbarba
//Section 004
//specify the import statements needed to use
//a Scanner object and File objects
import java.io.*;
import java.util.Scanner;
public class Words {
	// add a throws exception to the main method
    public static void main(String[] args) throws IOException {
		int wordCount = 0;
		int lineCount = 0;
		//declare and initialize a file built from poe.txt
        File poeFile = new File("poe.txt");
	
		//declare and initialize a Scanner which reads the File object
        Scanner wordInput = new Scanner(poeFile);
		//write a while-loop to count all *words* in the file
        while (wordInput.hasNext()) {
            String poeWords = wordInput.next();
            wordCount++;
        }
		//reset your Scanner
        Scanner lineInput = new Scanner(poeFile);
		//write a while-loop to count all *lines* in the file
        while (lineInput.hasNextLine()) {
            String poeLines = lineInput.nextLine();
            lineCount++;
        }
		System.out.println("Total words = " + wordCount);
		System.out.println("Total lines = " + lineCount);
	}
}
