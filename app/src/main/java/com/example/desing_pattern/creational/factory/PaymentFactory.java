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

public class PaymentFactory {
    private PaymentFactory() {
    }
    public static PaymentMethod create(int paymentType) throws NoSuchPaymentException {
        if (paymentType == 0)
            return new CashPayment();
        else if (paymentType == 1)
            return new OnlinePayment();
        else throw new NoSuchPaymentException();
    }
}



