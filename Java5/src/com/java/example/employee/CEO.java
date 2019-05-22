package com.java.example.employee;

public class CEO extends Employee {
    private int _bonus;
    private int _stockPrice;
    private int _numberSharesSold;

    public int get_bonus() {
        return _bonus;
    }

    public void set_bonus(int _bonus) {
        this._bonus = _bonus;
    }

    public int get_stockPrice() {
        return _stockPrice;
    }

    public void set_stockPrice(int _stockPrice) {
        this._stockPrice = _stockPrice;
    }

    public int get_numberSharesSold() {
        return _numberSharesSold;
    }

    public void set_numberSharesSold(int _numberSharesSold) {
        this._numberSharesSold = _numberSharesSold;
    }

    public double calculatePay() {
        return this._bonus + this._stockPrice * this._numberSharesSold;
    }
}
