package com.example.desing_pattern.structural.facade;


/*
-------------Facade-------------
Facade pattern hides the complexities of the system and provides
a simplified (but limited) interface to a complex system
------------Facade--------------
*/
public class Main {
    public static void main(String[] args) {
        NotificationService service = new NotificationService();
        service.send("Message");
    }
}
