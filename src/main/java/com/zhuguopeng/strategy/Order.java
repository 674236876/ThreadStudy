package com.zhuguopeng.strategy;

public class Order {

//单价
    private final double price;
    private final double count;

    private final OrderStrategy orderStrategy;

    public Order(double price, double count, OrderStrategy orderStrategy) {

        this.price = price;
        this.count = count;
        this.orderStrategy = orderStrategy;

    }

    protected double getTotal() {
        return orderStrategy.getTotal(price, count);
    }

    public double calculateTotal() {
        return this.getTotal();
    }

    public double getPrice() {
        return price;
    }

    public double getCount() {
        return count;
    }


}
