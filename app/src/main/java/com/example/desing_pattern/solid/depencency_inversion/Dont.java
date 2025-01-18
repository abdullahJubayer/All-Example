package com.example.desing_pattern.solid.depencency_inversion;


/*
-------------Dependency Inversion-------------
    High level module or class should not depend
    on low level module. rather then they should
    depend on abstraction.
------------Dependency Inversion--------------
*/


public class Dont {
    public static void main(String[] args) {

        Printer printer = new Printer();
        Invoice invoice = new Invoice(printer);
        invoice.print();
    }
}


//--------High level class-------
class Invoice{
    private Printer printer;
    /*
    ------------------------------------------
        Don't do this. because if sometime latter
        printer class change this will break
        invoice class. and we can't replace new printer.
    -------------------------------------------
    */
    public Invoice(Printer printer){
        this.printer= printer;
    }

    public void print(){
        printer.print();
    }
}


//--------Low level class-------
class Printer{
    public void print(){
        System.out.println("Printing");
    }
}