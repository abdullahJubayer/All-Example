package com.example.desing_pattern.solid.single_responsibility;


/*
-------------Single Responsibility-------------
    A class have only one responsibility and only one reasons to change.
------------Single Responsibility--------------
*/


public class Do {
    public static void main(String[] args) {
        Pencil pencil = new Pencil("A",10.0);
        InvoicePrinter printer = new InvoicePrinter();
        Invoice2 invoice = new Invoice2(pencil,printer,5);

        invoice.calculatePrice();
        invoice.printInvoice();
    }
}

class Invoice2{
    private Pencil pencil;
    private InvoicePrinter printer;
    private int quantity;

    public Invoice2(Pencil pencil,InvoicePrinter printer,int quantity) {
        this.pencil = pencil;
        this.quantity = quantity;
        this.printer = printer;
    }

    /*
    ------------------------------------------
        One responsibility to calculate price.
    -------------------------------------------
    */
    public double calculatePrice(){
        return pencil.getPrice() * quantity;
    }

    public void printInvoice(){
        printer.print();
    }
}


class Book{
    private String name;
    private double price;

    public Book(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}

class InvoicePrinter{
    /*
    ------------------------------------------
        One responsibility to print invoice.
    -------------------------------------------
    */
    public void print(){
        System.out.println("Print Invoice");
    }
}