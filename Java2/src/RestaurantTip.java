import java.util.Scanner;

public class RestaurantTip {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter the billing amount:");
        float bill = input.nextInt();
        float tipPercentage = 0;

        do {
            System.out.println("Please enter the tip (0-100%):");
            tipPercentage = input.nextInt();
        } while (tipPercentage < 0 || tipPercentage > 100);

        float billingTip = (bill * tipPercentage) / 100;
        float billingAmount = billingTip + bill;
        System.out.printf("Your tip amount is $%.2f and the total is $%.2f", billingTip, billingAmount);
    }
}
