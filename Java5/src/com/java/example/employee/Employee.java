package com.java.example.employee;

public class Employee {
    protected String _name;
    protected int _hours;
    protected int _hourlySalary;

    public double calculatePay() {
        return _hourlySalary * _hours;
    }

    public String get_name() {
        return this._name;
    }

    public void set_name(String _name) {
        this._name = _name;
    }

    public int get_hours() {
        return this._hours;
    }

    public void set_hours(int _hours) {
        this._hours = _hours;
    }

    public int get_hourlySalary() {
        return this._hourlySalary;
    }

    public void set_hourlySalary(int _hourlySalary) {
        this._hourlySalary = _hourlySalary;
    }
}
