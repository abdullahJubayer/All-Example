package com.example.desing_pattern.structural.bridge;


/*
------------Bridge-------------------
Bridge design pattern lets us split a large class or a set of closely related classes
into two separate hierarchies—abstraction and implementation—which can be developed
independently of each other. Any time we need two inheritance hierarchies in our code,
we can simplify that code by utilizing this design pattern.
------------Bridge-------------------
*/
public interface Device {
    void turnOn();
    void turnOff();
    void setChannel(int number);
}
