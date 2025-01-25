package com.example.desing_pattern.behavioral.state;

/*
------------State-------------------
The State design pattern is a behavioral design pattern that allows an object to
alter its behavior when its internal state changes.
------------State-------------------
 */
public class Main {
    public static void main(String[] args) {
        PowerButton powerButton = new PowerButton();
        powerButton.click();


        PowerButton2 powerButton2 = new PowerButton2();
        powerButton2.click();
    }
}
