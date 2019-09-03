// Reading data from file c:\\temp\\... TXT
// Program would work properly if you prepare 
// appropriate file at the location with the actual content

import java.util.*;
import java.io.*;

public class ReadingFromFileToStringArray {
	public static void main(String[] args) {
		final int MAX = 10;
		String st[];
		st = new String[MAX];
		try {
			File f = new File("c:\\temp\\mynewfile.txt");
			Scanner in = new Scanner(f);
			int index = 0;

			while(in.hasNextLine()) {
				st[index++] = in.nextLine();
			}	
			in.close();
		}
		catch(Exception e) {
			System.out.println(e.toString());
		}
		for(int i =0; i<st.length; i++ )
			System.out.println(st[i]);
	}
}