package com.example.desing_pattern.behavioral.state;


/*
------------State-------------------
The State design pattern is a behavioral design pattern that allows an object to
alter its behavior when its internal state changes.
------------State-------------------
 */
public class PowerButton2 {
    private int deviceState = 0;

    public void setDeviceState(int deviceState){
        this.deviceState=deviceState;
    }

    public void click(){
        if (deviceState == 0){
            System.out.println("Device Off");
        }else if (deviceState == 1){
            System.out.println("Device On");
        }else if (deviceState == 2){
            System.out.println("Lock Device");
        }else if (deviceState == 3){
            System.out.println("UnLock Device");
        }
    }
}
