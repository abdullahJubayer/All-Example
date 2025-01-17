package com.example.desing_pattern.creational.prototype;

    /*
    -------------Factory Pattern-------------
       The Prototype Design Pattern is a creational pattern that enables the creation
       of new objects by copying an existing object. it is required when object creation
       is a time-consuming, and costly operation, so we create objects with the existing
        object itself to by copying the existing ones.
    ------------Factory Pattern--------------
    */

public class Main {
    public static void main(String[] args) {
        BookShop branchA1= new BookShop("Framgate-01");
        branchA1.loadData();
        BookShop branchA2= branchA1.shadowClone();

        branchA1.sellBook();
        branchA2.setName("Framgate-02");



        BookShop branchB1= new BookShop("Karwanbaazar-01");
        branchB1.loadData();
        BookShop branchB2= branchB1.deepClone();

        branchB1.sellBook();
        branchB2.setName("Karwanbaazar-02");

        System.out.println("Books : Framgate-01 -> "+ branchA1.getBooks().toString());
        System.out.println("Books : Framgate-02 -> "+ branchA2.getBooks().toString());

        System.out.println("Books : Karwanbaazar-01 -> "+ branchB1.getBooks().toString());
        System.out.println("Books : Karwanbaazar-02 -> "+ branchB2.getBooks().toString());
    }
}
