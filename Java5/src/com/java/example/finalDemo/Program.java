package com.java.example.finalDemo;

public class Program {
    public static void main(String[] args) {
        Employee _employee = new Employee("Alex", 40, 12);

        System.out.println("\nInformation for Employee(" + _employee.get_name() + ")");
        System.out.println("Hourly Salary: " + _employee.get_hourlySalary());
        System.out.println("Total Hours: " + _employee.get_hours());
        System.out.println("Pay: " + _employee.calculatePay());

        Manager _manager = new Manager("Kunjan", 20, 14, 17);

        System.out.println("Information for Manager(" + _manager.get_name() + ")");
        System.out.println("Hourly Salary: " + _manager.get_hourlySalary());
        System.out.println("Total Hours: " + _manager.get_hours());
        System.out.println("Bonus: " + _manager.get_bonus());
        System.out.println("Pay: " + _manager.calculatePay());

        CEO _ceo = new CEO("Josh", 40, 25, 130, 19, 42);

        System.out.println("\nInformation for CEO(" + _ceo.get_name() + ")");
        System.out.println("Stock: " + _ceo.get_numberSharesSold());
        System.out.println("Stock Price: " + _ceo.get_stockPrice());
        System.out.println("Pay: " + _ceo.calculatePay());
    }
}
