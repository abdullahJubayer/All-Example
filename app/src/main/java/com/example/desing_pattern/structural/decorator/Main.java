package com.example.desing_pattern.structural.decorator;


/*
-------------Decorator-------------
Decorator design pattern lets us attach new behaviors
to a objects by placing these objects inside special wrapper
objects that contain the behaviors.
------------Decorator--------------
*/
public class Main {
    public static void main(String[] args) {
        Coffee coffee = new BlackCoffee();
        makeCoffee(new Capuccino(coffee)); // hare the decoration apply
    }

    private static void makeCoffee(Coffee coffee){
        coffee.make();
    }
}

interface Coffee{
    void make();
}

class BlackCoffee implements Coffee{
    @Override
    public void make() {
        System.out.println("Only Coffee");
    }
}

class Capuccino implements Coffee{
    private final Coffee coffee;

    Capuccino(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void make() {
        addMilk();
        coffee.make();
    }

    private void addMilk(){
        System.out.println("adding milk");
    }
}

class Latte implements Coffee{
    private final Coffee coffee;

    Latte(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public void make() {
        add2xMilk();
        coffee.make();
    }

    private void add2xMilk(){
        System.out.println("adding 2x milk");
    }
}