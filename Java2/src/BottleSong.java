import java.util.Scanner;

public class BottleSong {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("How many bottles you want to go with?");
        int bottles = input.nextInt();

        /*
        for (int i = bottles; i > 0; i--) {
            // First line of each song section
            String currentBottle = i == 1 ? "1 bottle" : i + " bottles";
            System.out.printf("%s of beer on the wall, %s of beer.\n", currentBottle, currentBottle);

            // Second line of each song section
            String remainBottle = i <= 1 ? "no more bottles" : (i - 1) + " bottles";
            remainBottle = i - 1 == 1 ? "1 bottle" : remainBottle;
            System.out.printf("Take one down and pass it around, %s of beer on the wall.\n\n", remainBottle);
        }*/

        for (int i = bottles; i > 2; i--) {
            // First line of each song section
            System.out.printf("%d bottles of beer on the wall, %s bottles of beer.\n", i, i);
            // Second line of each song section
            System.out.printf("Take one down and pass it around, %d bottles of beer on the wall.\n\n", i - 1);
        }

        System.out.println("2 bottles of beer on the wall, 2 bottles of beer.\n" +
                "Take one down and pass it around, 1 bottle of beer on the wall.\n");
        System.out.println("1 bottle of beer on the wall, 1 bottle of beer.\n" +
                "Take one down and pass it around, no more bottles of beer on the wall.\n");

        // Last lines of song
        System.out.println("no more bottles of beer on the wall, no more bottles of beer");
        System.out.println("Go to the store and buy some more, " + bottles + " bottles of beer on the wall.");
    }
}
