package com.example.desing_pattern.structural.facade;

/*
-------------Facade-------------
Facade pattern hides the complexities of the system and provides
a simplified (but limited) interface to a complex system
------------Facade--------------
*/
public class Connection {
    public void connect(){
        System.out.println("Connect to server");
    }

    public void disconnect(){
        System.out.println("Connect to server");
    }
}
