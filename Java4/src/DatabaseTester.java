import java.util.Scanner;

public class DatabaseTester {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Database db = new Database(10);

        // Taking data input
        System.out.println("Enter records to insert into database.");
        for (int index = 0; index < 10; index++) {
            String data = input.nextLine();
            db.add(index + 1, data);
        }

        // Print records
        System.out.println("Records in database:");
        db.print();

        // Sorting records in table
        db.sort();

        // Printing sorted records
        System.out.println("Sorted records in database:");
        db.print();

        // Find your name in database
        System.out.println("Enter string to search in database");
        String data = input.nextLine();
        db.find(data);
    }
}
