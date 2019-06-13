package patkunja;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    // Scanner class
    private Scanner _input = new Scanner(System.in);
    // Inventory class instance
    private Inventory _iv;


    /**
     * Read fraction number from user until gets correct value
     *
     * @param message
     * @param method
     * @return {double}
     */
    private double getDoubleInput(String message, String method) {
        double data;
        do {
            try {
                System.out.println(message + ": ");
                data = _input.nextDouble();
                Method md = this._iv.getClass().getDeclaredMethod(method, double.class);
                md.invoke(this._iv, data);
            } catch (Exception ex) {
                if (ex instanceof InvocationTargetException) {
                    System.out.println(ex.getCause().getMessage());
                } else {
                    System.out.println("ERROR: Please enter number");
                }
                data = -1;
                _input.nextLine();
            }
        } while (data < 0);
        return data;
    }


    /**
     * Read whole number from user until gets correct value
     *
     * @param message
     * @param method
     * @return {number}
     */
    private int getIntInput(String message, String method) {
        int data;
        do {
            try {
                System.out.println(message + ": ");
                data = _input.nextInt();
                Method md = this._iv.getClass().getDeclaredMethod(method, int.class);
                md.invoke(this._iv, data);
            } catch (Exception ex) {
                if (ex instanceof InvocationTargetException) {
                    System.out.println(ex.getCause().getMessage());
                } else {
                    System.out.println("ERROR: Please enter number");
                }
                data = -1;
                _input.nextLine();
            }
        } while (data < 0);
        return data;
    }

    /**
     * Read line of sentence from user until gets correct value
     *
     * @param message
     * @param method
     * @return {String}
     */
    private String getStringInput(String message, String method) {
        String data;
        do {
            try {
                System.out.println(message + ": ");
                data = _input.nextLine();
                Method md = this._iv.getClass().getDeclaredMethod(method, String.class);
                md.invoke(this._iv, data);
            } catch (Exception ex) {
                if (ex instanceof InvocationTargetException) {
                    System.out.println(ex.getCause().getMessage());
                } else {
                    System.out.println("ERROR: Please enter valid string value");
                }
                data = null;
            }
        } while (data == null);
        return data;
    }

    public static void main(String[] args) {
        // Default inventory
        Inventory iv = new Inventory();
        // Main method object
        Main _self = new Main();
        _self._iv = iv;

        // Ask for inventory input values
        _self.getStringInput("Enter Inventory Item Id", "setId");
        _self.getStringInput("Enter Item Name", "setName");
        _self.getIntInput("Enter Quantity On Hand", "setQoh");
        _self.getIntInput("Enter Re-Order Point", "setRop");
        _self.getDoubleInput("Enter Selling Price", "setSellPrice");

        // Print current inventory information
        System.out.println(_self._iv);

        // Notify user about low inventory
        if (_self._iv.getQoh() < _self._iv.getRop()) {
            System.out.println("INFO: You need to order more " + _self._iv.getName());
        }

        // Ask for number of units to buy
        int units = -1;
        do {
            try {
                System.out.println("Enter # of units to buy: ");
                units = _self._input.nextInt();
                if (units < 0) {
                    System.out.println("ERROR: Units must be 0 or more.");
                    units = -1;
                }
            } catch (Exception ex) {
                System.out.println("ERROR: Please enter correct # of units.");
                units = -1;
                _self._input.nextLine();
            }
        } while (units < 0);

        // Total cost of purchase
        double totalCost = _self._iv.getSellPrice() * units;
        totalCost += (totalCost * 0.13);
        System.out.printf("Total cost: $%.2f\n", totalCost);
    }
}
