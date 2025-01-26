package com.example.desing_pattern.structural.adapter;


/*
-------------Adapter-------------
    Adapter pattern works as a bridge between two incompatible interfaces.
------------Adapter--------------
*/
public class Main {
    public static void main(String[] args) {
        Image image = new Image();
        image.applyFilter(new BlackAndWhite());

        image.applyFilter(new Blur(new BlurFilter()));
    }
}
