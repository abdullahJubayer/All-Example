package com.example.desing_pattern.solid.liskov;


/*
-------------Liskov Substitution-------------
    All super class should be replaceable by sub-class.
------------Liskov Substitution--------------
*/


import android.content.res.Resources;

public class Dont {
    public static void main(String[] args) {

        NormalPrinter normalPrinter = new NormalPrinter();
        WirelessPrinter wirelessPrinter = new WirelessPrinter();

        InvoicePrinter printer = new InvoicePrinter(normalPrinter);
        printer.connect();
        printer.print();

        InvoicePrinter printer2 = new InvoicePrinter(wirelessPrinter);
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
    void print();
}

class NormalPrinter implements  Printer{
    @Override
    public void connect() {
        System.out.println("Connection success");
    }

    @Override
    public void print() {
        System.out.println("Print doc");
    }
}

class WirelessPrinter implements Printer{

    /*
    ------------------------------------------
        Don't do this. because other dev can call it
        expecting all are fine and the system got crush.
    -------------------------------------------
    */
    @Override
    public void connect() {
        throw new Resources.NotFoundException("connection doesn't support");
    }

    public void wirelessConnect() {
        System.out.println("Connection success");
    }

    @Override
    public void print() {

    }
}