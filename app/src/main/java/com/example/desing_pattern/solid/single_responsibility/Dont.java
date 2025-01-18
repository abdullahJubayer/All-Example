package com.example.desing_pattern.solid.single_responsibility;


/*
-------------Single Responsibility-------------
    A class have only one responsibility and only one reasons to change.
------------Single Responsibility--------------
*/


public class Dont {

    /*
    ------------------------------------------
        So hare the principal is broken.
        Because when the calculation logic change,
        then we need to update the class. also when
        the printing logic change we need to update the class.
    -------------------------------------------
    */
    public static void main(String[] args) {
        Pencil pencil = new Pencil("A",10.0);
        Invoice invoice = new Invoice(pencil,5);

        invoice.calculatePrice();
        invoice.printInvoice();
    }
}

class Invoice{
    private Pencil pencil;
    private int quantity;

    public Invoice(Pencil pencil, int quantity) {
        this.pencil = pencil;
        this.quantity = quantity;
    }

    /*
    ------------------------------------------
        One responsibility to calculate price.
    -------------------------------------------
    */
    public double calculatePrice(){
        return pencil.getPrice() * quantity;
    }

    /*
    ------------------------------------------
        One responsibility to print invoice.
    -------------------------------------------
    */
    public void printInvoice(){
        System.out.println("Print Invoice");
    }
}


class Pencil{
    private String name;
    private double price;

    public Pencil(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }
}