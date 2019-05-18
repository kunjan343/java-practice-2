public class RollDice {
    // Rolling self return random number
    // random range = Min + Math.random() * (Max-Min) + 1
    private int roll() {
        return (int) (1 + Math.random() * 6);
    }

    // Rolling 2 dices
    private int roll2Dices() {
        return roll() + roll();
    }

    public static void main(String[] args) {
        RollDice self = new RollDice();
        // Rolling dice average
        int diceSum = 0;
        int currentRole = 0;
        for (int i = 0; i < 20; i++) {
            currentRole = self.roll();
            System.out.println("Current rolling number : " + currentRole);
            diceSum += currentRole;
        }
        System.out.println("Dice roll:" + (diceSum / 20));

        // Rolling 2 dices
        System.out.println("Rolling 2 self");
        for (int i = 0; i < 20; i++) {
            System.out.println("2 dices roll:" + self.roll2Dices());
        }
    }
}
