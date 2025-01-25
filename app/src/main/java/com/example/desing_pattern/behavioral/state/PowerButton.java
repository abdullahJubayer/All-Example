package com.example.desing_pattern.behavioral.state;


/*
------------State-------------------
The State design pattern is a behavioral design pattern that allows an object to
alter its behavior when its internal state changes.
------------State-------------------
 */
public class PowerButton {
    private DeviceState state;

    public PowerButton(){
        state = new OffState(this);
    }

    private void setState(DeviceState state){
        this.state = state;
    }

    public void click(){
        state.click();
    }

    abstract class DeviceState {
        public abstract void click();
    }

    class OffState extends DeviceState{
        private final PowerButton powerButton;
        public OffState(PowerButton powerButton){
            this.powerButton = powerButton;
        }

        @Override
        public void click() {
            powerButton.setState(new OnState(powerButton));
            System.out.println("On Device");
        }
    }

    class OnState extends DeviceState{
        private final PowerButton powerButton;
        public OnState(PowerButton powerButton){
            this.powerButton = powerButton;
        }

        @Override
        public void click() {
            powerButton.setState(new UnLockState(powerButton));
            System.out.println("UnLock Device");
        }
    }

    class UnLockState extends DeviceState{
        private final PowerButton powerButton;
        public UnLockState(PowerButton powerButton){
            this.powerButton = powerButton;
        }

        @Override
        public void click() {
            powerButton.setState(new LockState(powerButton));
            System.out.println("Lock Device");
        }
    }

    class LockState extends DeviceState{
        private final PowerButton powerButton;
        public LockState(PowerButton powerButton){
            this.powerButton = powerButton;
        }

        @Override
        public void click() {
            powerButton.setState(new UnLockState(powerButton));
            System.out.println("UnLock Device");
        }
    }
}