package com.example.desing_pattern.solid.interface_segregation;


/*
-------------Interface Segregation-------------
    Interface should be design like, client don't need to
    implement unnecessary function they do not need.
------------Interface Segregation--------------
*/


public class Do {
    public static void main(String[] args) {

        NormalPrinterX normalPrinter = new NormalPrinterX();
        SmartestPrinter smartPrinter = new SmartestPrinter();

        InvoicePrinterX printer = new InvoicePrinterX(normalPrinter);
        printer.connect();
        printer.print();

        InvoicePrinterX printer2 = new InvoicePrinterX(smartPrinter);
        printer2.autoConnect();
        printer2.wirelessConnect();
        printer2.print();
    }
}

class InvoicePrinterX{
    private PrinterX printer;
    private SmartestPrinter smartestPrinter;
    public InvoicePrinterX(PrinterX printer) {
        this.printer = printer;
    }
    public InvoicePrinterX(SmartestPrinter printer) {
        this.smartestPrinter = printer;
    }

    public void connect(){
        printer.connect();
    }
    public void wirelessConnect() {
        smartestPrinter.wirelessConnect();
    }
    public void autoConnect() {
        smartestPrinter.autoConnect();
    }

    public void print(){
        System.out.println("Printing");
    }

}



interface PrinterX{
    void connect();
    void print();
}

interface SmartPrinterX extends PrinterX{
    void autoConnect();
    void wirelessConnect();
}

class NormalPrinterX implements  PrinterX{
    @Override
    public void connect() {
        System.out.println("Connection success");
    }

    @Override
    public void print() {
        System.out.println("Print doc");
    }
}

class SmartestPrinter implements SmartPrinterX{

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