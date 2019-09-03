/* FileTest.java*/

import java.io.*;

public class FileTest {

	public static void main(String[] args) {
		
		// create File object with name with specified path
		File f = new File("c:\\temp\\myfile.txt");
      try {
      	// return a boolean value : true if the file is created successful; 
       	// or false if the file is already exists or the operation failed.
		if (f.createNewFile()){
	        System.out.println("File is created!");
	       }
		else
	        System.out.println("File already exists.");
			} 
      catch (IOException e) {
				e.printStackTrace();
			}

		if(f.canRead())
			System.out.println("can read");
		else
			System.out.println("cannot read");
		
		if(f.canWrite())
			System.out.println("can write");
		else
			System.out.println("cannot write");

		if(f.canExecute())
			System.out.println("can execute");
		else
			System.out.println("cannot execute");

		System.out.println("the length of the file: " + f.length());
		
		if(f.exists()){
			System.out.print("file exists at:");
			System.out.println(f.getAbsolutePath());
		}
		else
			System.out.println("file does not exist");
	}

}
