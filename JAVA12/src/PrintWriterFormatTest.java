
// How to write data to file using printf()
// check result of this program in the file c:\\mynewfile.txt

import java.io.*;

public class PrintWriterFormatTest {

	public static void main(String[] args) {

		try {
		
			// create file at location 
			PrintWriter out = new PrintWriter("C:\\temp\\mynewfile.txt");
			
			out.printf("%d,%s,%s", 1000, "Mary", "mary@hotmail.com");
			out.println();
			out.printf("%d,%s,%s", 1001, "John", "john@hotmail.com");
			out.println();
			out.printf("%d,%s,%s", 1002, "Alex", "alex@hotmail.com");
			out.println();
			out.printf("%d,%s,%s", 1003, "KP", "kp@hotmail.com");
			out.println();
			
			out.close();
		
		}catch(Exception e) {
			System.out.println(e.toString());
		}
		finally{
			System.out.println("Writing completed. Check the file!");
		}
		
	}

}
