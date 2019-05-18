import java.util.Scanner;

public class StudentList {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Student[] students = new Student[5];

        System.out.println("Please enter 5 students name:");

        for (int i = 0; i < students.length; i++) {
            students[i] = new Student(input.nextLine());
        }

        System.out.println("You have entered:");

        for (int j = 0; j < students.length; j++) {
            System.out.println(students[j].getName());
        }
    }
}
