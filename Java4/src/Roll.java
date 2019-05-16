import java.util.Arrays;

public class Roll {
    private int[] rolls = new int[10000];
    private int[] occurrence = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    private int[] getOccurrence() {
        return this.occurrence;
    }

    // Roll one dice
    private int roll() {
        return (int) (1 + Math.random() * 6);
    }

    // Rolling 2 dices
    private int roll2Dices() {
        return roll() + roll();
    }

    // Fill array with rolled dice
    private void rollDices() {
        for (int index = 0; index < rolls.length; index++) {
            rolls[index] = roll2Dices();
        }
    }

    public void countOccurrence() {
        for (int index = 0; index < rolls.length; index++) {
            occurrence[rolls[index] - 2] += 1;
        }
    }

    public static void main(String[] args) {
        Roll self = new Roll();
        self.rollDices();
        self.countOccurrence();
        int[] ans = self.getOccurrence();
        System.out.println("Number of occurrences:");
        for (int index = 0; index < self.occurrence.length; index++) {
            System.out.println("Number of " + (index + 2) + "'s is : " + ans[index]);
        }
    }
}
