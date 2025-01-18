package com.example.desing_pattern.solid.open_close;


/*
-------------Open-Close-------------
    A class should open for extension but close for modification.
------------Open-Close--------------
*/


public class Dont {
    public static void main(String[] args) {
        InvoicePrinter painter = new InvoicePrinter();
        painter.print();
        painter.print3D();
    }
}

    /*
        -------ODL--------
        class InvoicePrinter{
            public void print(){
                System.out.println("Print Invoice");
            }
        }
    */


// -------NEW--------
class InvoicePrinter{
    public void print(){
        System.out.println("Print Invoice");
    }

    /*
    ------------------------------------------
        Don't do this. if previous class in production
        and working fine, don't change it.
    -------------------------------------------
    */
    public void print3D(){
        System.out.println("Print Invoice");
    }
}