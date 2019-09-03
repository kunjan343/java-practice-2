/*
 * DistinctNumbers.java
 * Eliminates duplication in the list of numbers-8-
 */
import java.util.ArrayList;
import java.util.Scanner;

public class DistinctNumbers {
  public static void main(String[] args) {
    ArrayList<String> list = new ArrayList<>();
    
    Scanner input = new Scanner(System.in);   
    System.out.print("Enter integers (input ends with 0): ");
    String value;
    
    do {
      value = input.nextLine(); // Read a value from the input
      if (!list.contains(value) && !value.equals(""))
        list.add(value); // Add the value if it is not in the list
    } while (!value.equals(""));

    // Display the distinct numbers
    // for (int i = 0; i < list.size(); i++)
    //   System.out.print(list.get(i) + " ");
    System.out.println(list);
  }
}
