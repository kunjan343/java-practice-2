// Reading data from file 
// Program would work properly if you prepare
// appropriate file at the location with the actual content
// similar to Person object attributes
// Check a class Person below and prepare file
// OR use WriteObjectToFile.java to run and populate file

import java.util.*;
import java.io.*;

public class ReadingFromFileToObject {
    public static void main(String[] args) {
        final int MAX = 3;
        Person[] p = new Person[MAX];
        try {

            File f = new File("d:\\person.txt");
            Scanner in = new Scanner(f);
            int cnt = 0;
            while (in.hasNextLine() && cnt < 10) {
                p[cnt++] = new Person(in.nextLine());
            }
            in.close();
        } catch (Exception e) {
            System.out.println(e.toString());
        }
        for (Person singleP : p) {
            if (singleP != null)
                System.out.println(singleP.getName() + " " + singleP.getEmail());
        }
    }
}

