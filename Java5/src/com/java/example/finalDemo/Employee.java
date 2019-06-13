package com.java.example.finalDemo;

public class Employee {
    protected String _name;
    protected int _hours;
    protected int _hourlySalary;

    Employee(String name, int hours, int hourlySalary) {
        this.set_name(name);
        this.set_hours(hours);
        this.set_hourlySalary(hourlySalary);
    }

    public String get_name() {
        return this._name;
    }

    public void set_name(String name) {
        this._name = name;
    }

    public int get_hours() {
        return this._hours;
    }

    public void set_hours(int hours) {
        this._hours = hours;
    }

    public int get_hourlySalary() {
        return this._hourlySalary;
    }

    public void set_hourlySalary(int hourlySalary) {
        this._hourlySalary = hourlySalary;
    }

    public final double calculatePay() {
        return _hourlySalary * _hours;
    }
}
