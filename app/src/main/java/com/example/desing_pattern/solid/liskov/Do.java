package com.example.desing_pattern.solid.liskov;


/*
-------------Liskov Substitution-------------
    All super class should be replaceable by sub-class.
------------Liskov Substitution--------------
*/

public class Do {
    public static void main(String[] args) {

        NormalPrinter normalPrinter = new NormalPrinter();
        WirelessPrinter2 wirelessPrinter = new WirelessPrinter2();

        InvoicePrinter printer = new InvoicePrinter(normalPrinter);
        printer.connect();
        printer.print();

        InvoicePrinter printer2 = new InvoicePrinter(wirelessPrinter);
        printer2.connect();
        printer2.print();
    }
}

class WirelessPrinter2 implements Printer{
    @Override
    public void connect() {
        System.out.println("Connection success using wired");
    }

    public void wirelessConnect() {
        System.out.println("Connection success using wireless");
    }

    @Override
    public void print() {

    }
}