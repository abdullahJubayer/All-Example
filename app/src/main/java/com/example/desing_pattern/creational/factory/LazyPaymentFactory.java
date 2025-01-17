package com.example.desing_pattern.creational.factory;

public interface LazyPaymentFactory{
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
