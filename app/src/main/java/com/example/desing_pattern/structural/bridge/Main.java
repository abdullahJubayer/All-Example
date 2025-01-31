package com.example.desing_pattern.structural.bridge;


/*
------------Bridge-------------------
Bridge design pattern lets us split a large class or a set of closely related classes
into two separate hierarchies—abstraction and implementation—which can be developed
independently of each other. Any time we need two inheritance hierarchies in our code,
we can simplify that code by utilizing this design pattern.
------------Bridge-------------------
*/
public class Main {

/*
------------Bridge-------------------
Hare we develop 2 inheritance hierarchies separately. they don't know each other but make
a bridge between them
------------Bridge-------------------
*/

    public static void main(String[] args) {
        Device sonyTv = new SonyTv();
        Device samsung = new SamsungTv();
        RemoteControl device = new RemoteControl(sonyTv);


        device.turnOn();


        AdvanceDevice sonyTv2 = new SonyTv2();
        AdvanceRemoteControl advanceControl = new AdvanceRemoteControl(sonyTv2);
        RemoteControl normalControl = new RemoteControl(sonyTv2);
        advanceControl.setVolume();
    }
}
