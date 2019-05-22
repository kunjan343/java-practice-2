package com.java.example.employee;

public class Manager extends Employee {
    private int _bonus;

    public double calculatePay() {
        return this._hourlySalary * this._hours + this._bonus;
    }

    public int get_bonus() {
        return this._bonus;
    }

    public void set_bonus(int _bonus) {
        this._bonus = _bonus;
    }
}
