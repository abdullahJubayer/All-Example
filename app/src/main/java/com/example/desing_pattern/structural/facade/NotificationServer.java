package com.example.desing_pattern.structural.facade;


/*
-------------Facade-------------
Facade pattern hides the complexities of the system and provides
a simplified (but limited) interface to a complex system
------------Facade--------------
*/
public class NotificationServer {

    public Authentication authentication(String id){
        return new Authentication();
    }

    public Connection connection(String token,String id){
        return new Connection();
    }

    public void send(Authentication authentication,Message message){
        System.out.println("Sending message");
    }
}
