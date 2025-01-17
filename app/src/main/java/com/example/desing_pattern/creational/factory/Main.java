package com.example.desing_pattern.creational.factory;


    /*
    -------------Factory Pattern-------------
        The Factory Pattern defines a method or class
        responsible for creating instances of a specific type.
        It encapsulates the creation logic, ensuring that the client
        code does not directly instantiate objects but instead relies on the factory.
    ------------Factory Pattern--------------
    */

public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        PaymentMethod paymentMethod = PaymentFactory.create(1);
        paymentMethod.pay(100);

        LazyPaymentFactory cashPayment = new CashPaymentFactory();
        cashPayment.create().pay(200);
    }
}
