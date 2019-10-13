package com.zhuguopeng.strategy;

public class VIPStrategy implements OrderStrategy{


    public double getTotal(double price, double count) {
        return price * count * 0.9;
    }
}
