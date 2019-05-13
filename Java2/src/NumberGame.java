import java.util.Scanner;

public class NumberGame {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int inputNumber = 1;
        System.out.println("Lets play number game. Start entering number");

        while (inputNumber != 0) {
            try {
                inputNumber = input.nextInt();
                switch (inputNumber) {
                    case 2:
                        System.out.println("move down");
                        break;
                    case 4:
                        System.out.println("move left");
                        break;
                    case 6:
                        System.out.println("move right");
                        break;
                    case 8:
                        System.out.println("move up");
                        break;
                    case 1:
                    case 3:
                    case 7:
                    case 9:
                        System.out.println("diagonal moves not allowed");
                        break;
                }
            } catch (Exception ex) {
                System.out.println("bad input.");
                input.nextLine();
            }
        }

        System.out.println("Good Bye");
    }
}
