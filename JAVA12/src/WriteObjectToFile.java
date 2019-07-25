// How to write data to file from object
// check result of this program in the file
import java.io.*;

public class WriteObjectToFile {

public static void main(String[] args) {

		Person p1 = new Person(2000, "Sarah", "sarah@edu.com");
		Person p2 = new Person(2001, "John", "john@yahoo.com");
		try {

			// create file at location
			PrintWriter out = new PrintWriter("C:\\temp\\person.txt");

			out.println(p1.getId()+","+p1.getName()+","+p1.getEmail());
			out.println(p2.getId()+","+p2.getName()+","+p2.getEmail());
			out.close();

		}catch(Exception e) {
			System.out.println(e.toString());
		}
		finally{
			System.out.println("Writing completed. Check the file!");
		}
}
}


