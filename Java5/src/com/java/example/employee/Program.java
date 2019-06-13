package com.java.example.employee;

public class Program {
    public static void main(String[] args) {
        Employee _employee = new Employee();
        _employee.set_name("Alex");
        _employee.set_hours(40);
        _employee.set_hourlySalary(12);

        System.out.println("\nInformation for Employee(" + _employee.get_name() + ")");
        System.out.println("Hourly Salary: " + _employee.get_hourlySalary());
        System.out.println("Total Hours: " + _employee.get_hours());
        System.out.println("Pay: " + _employee.calculatePay());

        Manager _manager = new Manager();
        _manager.set_name("Kunjan");
        _manager.set_hourlySalary(14);
        _manager.set_hours(20);
        _manager.set_bonus(17);

        System.out.println("Information for Manager(" + _manager.get_name() + ")");
        System.out.println("Hourly Salary: " + _manager.get_hourlySalary());
        System.out.println("Total Hours: " + _manager.get_hours());
        System.out.println("Bonus: " + _manager.get_bonus());
        System.out.println("Pay: " + _manager.calculatePay());

        CEO _ceo = new CEO();
        _ceo.set_name("Josh");
        _ceo.set_bonus(130);
        _ceo.set_numberSharesSold(42);
        _ceo.set_stockPrice(19);

        System.out.println("\nInformation for CEO(" + _ceo.get_name() + ")");
        System.out.println("Stock: " + _ceo.get_numberSharesSold());
        System.out.println("Stock Price: " + _ceo.get_stockPrice());
        System.out.println("Pay: " + _ceo.calculatePay());
    }
}
