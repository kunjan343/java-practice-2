package com.java.example.finalDemo;

public final class CEO extends Manager {
    private int _stockPrice;
    private int _numberSharesSold;

    CEO(String name, int hours, int hourlySalary, int bonus, int stockPrice, int numberSharesSold) {
        super(name, hours, hourlySalary, bonus);
        this.set_numberSharesSold(numberSharesSold);
        this.set_stockPrice(stockPrice);

    }

    public int get_stockPrice() {
        return _stockPrice;
    }

    public void set_stockPrice(int stockPrice) {
        this._stockPrice = stockPrice;
    }

    public int get_numberSharesSold() {
        return _numberSharesSold;
    }

    public void set_numberSharesSold(int numberSharesSold) {
        this._numberSharesSold = numberSharesSold;
    }

    public double calculatePay() {
        return super.calculatePay() + this._stockPrice * this._numberSharesSold;
    }
}
