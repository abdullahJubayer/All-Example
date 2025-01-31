package com.example.desing_pattern.structural.bridge;

public class SonyTv2 implements AdvanceDevice{
    @Override
    public void setVolume() {
        System.out.println("setVolume");
    }

    @Override
    public void setColor() {
        System.out.println("setColor");
    }

    @Override
    public void turnOn() {
        System.out.println("turnOn");
    }

    @Override
    public void turnOff() {
        System.out.println("turnOff");
    }

    @Override
    public void setChannel(int number) {
        System.out.println("setChannel");
    }
}
