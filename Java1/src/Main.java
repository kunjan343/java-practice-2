import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter word:");
        char[] userWord = input.nextLine().toCharArray();

        for (int i = userWord.length - 1; i >= 0; i--) {
            System.out.printf("%s", userWord[i]);
        }
    }
}
