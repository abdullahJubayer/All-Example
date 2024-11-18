package com.example.desing_pattern.creational.factory;


    /*
    ------------Approach 1-------------------
     */

interface PaymentMethod {
    void pay(int amount);
}

class CashPayment implements PaymentMethod {
    @Override
    public void pay(int amount) {
        System.out.println("Cash payment : " + amount);
    }
}

class OnlinePayment implements PaymentMethod {
    @Override
    public void pay(int amount) {
        System.out.println("Online payment : " + amount);
    }
}

class PaymentFactory {
    private PaymentFactory() {
    }

    public static PaymentMethod create(int paymentType) throws NoSuchMethodException {
        if (paymentType == 0)
            return new CashPayment();
        else if (paymentType == 1)
            return new OnlinePayment();
        else throw new NoSuchMethodException();
    }
}


    /*
    ------------Approach 2-------------------
     */

interface LazyPaymentFactory{
    PaymentMethod create();
}

class CashPaymentFactory implements  LazyPaymentFactory{
    @Override
    public PaymentMethod create() {
        return new CashPayment();
    }
}

class OnlinePaymentFactory implements  LazyPaymentFactory{
    @Override
    public PaymentMethod create() {
        return new OnlinePayment();
    }
}


public class Main {
    public static void main(String[] args) throws NoSuchMethodException {
        PaymentMethod paymentMethod = PaymentFactory.create(1);
        paymentMethod.pay(100);

        PaymentMethod method2 = new CashPaymentFactory().create();
        method2.pay(200);
    }
}



