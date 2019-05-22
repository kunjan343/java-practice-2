package com.java.example.constructor;

public class Manager extends Employee {
    protected int _bonus;

    Manager(String name, int hours, int hourlySalary, int bonus) {
        super(name, hours, hourlySalary);
        this.set_bonus(bonus);
    }

    public int get_bonus() {
        return this._bonus;
    }

    public void set_bonus(int bonus) {
        this._bonus = bonus;
    }

    public double calculatePay() {
        return super.calculatePay() + this._bonus;
    }
}
