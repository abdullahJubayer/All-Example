package com.example.desing_pattern.solid.open_close;


/*
-------------Open-Close-------------
    A class should open for extension but close for modification.
------------Open-Close--------------
*/


public class Do {
    public static void main(String[] args) {
        InvoicePrinter3D painter = new InvoicePrinter3D();
        painter.print();
        painter.print3D();
    }
}

//-------ODL--------
class IInvoicePrinter {
    public void print() {
        System.out.println("Print Invoice");
    }
}


// -------NEW--------
class InvoicePrinter3D extends IInvoicePrinter {
    public void print3D() {
        System.out.println("Print Invoice");
    }
}