package com.example.desing_pattern.solid.interface_segregation;


/*
-------------Interface Segregation-------------
    Interface should be design like, client don't need to
    implement unnecessary function they do not need.
------------Interface Segregation--------------
*/


import android.content.res.Resources;

public class Dont {
    public static void main(String[] args) {

        NormalPrinter normalPrinter = new NormalPrinter();
        SmartPrinter smartPrinter = new SmartPrinter();

        InvoicePrinter printer = new InvoicePrinter(normalPrinter);
        printer.connect();
        printer.print();

        InvoicePrinter printer2 = new InvoicePrinter(smartPrinter);
        printer2.connect();
        printer2.print();
    }
}


class InvoicePrinter{
    private Printer printer;
    public InvoicePrinter(Printer printer) {
        this.printer = printer;
    }

    public void connect(){
        printer.connect();
    }

    public void print(){
        System.out.println("Printing");
    }
}

interface Printer{
    void connect();
    void autoConnect();
    void wirelessConnect();
    void print();
}

class NormalPrinter implements  Printer{
    @Override
    public void connect() {
        System.out.println("Connection success");
    }

    /*
    ------------------------------------------
        Don't do this. because these method do
        nothing. and force to implement
    -------------------------------------------
    */
    @Override
    public void autoConnect() {

    }

    @Override
    public void wirelessConnect() {

    }

    @Override
    public void print() {
        System.out.println("Print doc");
    }
}

class SmartPrinter implements Printer{

    @Override
    public void connect() {
        System.out.println("Connection success");
    }

    @Override
    public void wirelessConnect() {
        System.out.println("Connection success");
    }

    @Override
    public void autoConnect() {
        System.out.println("Connection success");
    }

    @Override
    public void print() {
        System.out.println("Print doc");
    }
}