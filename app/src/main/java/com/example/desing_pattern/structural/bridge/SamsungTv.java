package com.example.desing_pattern.structural.bridge;

public class SamsungTv implements Device{
    @Override
    public void turnOn() {
        System.out.println("Turn On SamsungTv");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn Off SamsungTv");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("Changing SamsungTv Channel");
    }
}
