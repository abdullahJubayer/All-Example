package com.example.desing_pattern.behavioral.strategy;


/*
------------Strategy-------------------
The Strategy Design Pattern is a behavioral design pattern
that allows you to define a family of algorithms or behaviors,
put each of them in a separate class, and make them interchangeable at runtime.
The Strategy pattern promotes the open/closed principle.
------------Strategy-------------------
 */
public class Main {
    public static void main(String[] args) {
        PaymentStrategy paymentStrategy = new CreditCardPaymentStrategy();
        Payment payment= new Payment(paymentStrategy);
        payment.processPayment(10);

    }
}

/*

-------------------------------
Don't do this. The problem with this code is that it violates the Open-Closed Principle.
In this code, if you want to add a new payment type, you would have to modify the
processPayment method, which violates the Principle.
-------------------------------

class Payment {
    private PaymentType paymentType;

    public void processPayment(double amount) {
        if (paymentType == PaymentType.CREDIT_CARD) {
            System.out.println("Processing credit card payment of amount " + amount);
        } else if (paymentType == PaymentType.DEBIT_CARD) {
            System.out.println("Processing debit card payment of amount " + amount);
        }
    }
    public void setPaymentType(PaymentType paymentType) {
        this.paymentType = paymentType;
    }
}

*/

class Payment {
    private PaymentStrategy paymentStrategy;

    public Payment(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void processPayment(double amount) {
        paymentStrategy.processPayment(amount);
    }
}

interface PaymentStrategy {
    void processPayment(double amount);
}

class CreditCardPaymentStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing credit card payment of amount " + amount);
    }
}

class DebitCardPaymentStrategy implements PaymentStrategy {
    public void processPayment(double amount) {
        System.out.println("Processing debit card payment of amount " + amount);
    }
}

