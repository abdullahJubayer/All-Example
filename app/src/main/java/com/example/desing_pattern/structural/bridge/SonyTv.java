package com.example.desing_pattern.structural.bridge;

public class SonyTv implements Device{
    @Override
    public void turnOn() {
        System.out.println("Turn On SonyTv");
    }

    @Override
    public void turnOff() {
        System.out.println("Turn Off SonyTv");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("Changing SonyTv Channel");
    }
}
