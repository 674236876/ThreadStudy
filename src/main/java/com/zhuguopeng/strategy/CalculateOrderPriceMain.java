package com.zhuguopeng.strategy;

public class CalculateOrderPriceMain {
    public static void main(String[] args) {
        Order o = new Order(10, 3,(p, c) -> p * c * 0.7);

//        int type = 1;
//        OrderStrategy orderStrategy = new SuperVIPStrategy();

//        if (type == 1) {
//            orderStrategy = new SuperVIPStrategy();
//        }else{
//            orderStrategy = new VIPStrategy();

//        }
        System.out.println(o.calculateTotal());

    }
}
