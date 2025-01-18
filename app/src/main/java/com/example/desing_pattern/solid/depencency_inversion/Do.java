package com.example.desing_pattern.solid.depencency_inversion;


/*
-------------Dependency Inversion-------------
    High level module or class should not depend
    on low level module. rather then they should
    depend on abstraction.
------------Dependency Inversion--------------
*/


public class Do {
    public static void main(String[] args) {

        PrinterX printer = new NormalPrinter();
        InvoiceX invoice = new InvoiceX(printer);
        invoice.print();
    }
}


//--------High level class-------
class InvoiceX{
    private PrinterX printer;
    /*
    ------------------------------------------
        Now high level class are depend on abstraction.
        so any time we can change it.
    -------------------------------------------
    */
    public InvoiceX(PrinterX printer){
        this.printer= printer;
    }

    public void print(){
        printer.print();
    }
}


interface PrinterX{
    void print();
}

//--------Low level class-------
class NormalPrinter implements  PrinterX{
    @Override
    public void print(){
        System.out.println("Printing");
    }
}