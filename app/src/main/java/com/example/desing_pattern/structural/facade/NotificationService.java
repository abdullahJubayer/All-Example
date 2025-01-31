package com.example.desing_pattern.structural.facade;


/*
-------------Facade-------------
Facade pattern hides the complexities of the system and provides
a simplified (but limited) interface to a complex system
------------Facade--------------
*/
public class NotificationService {
    public void send(String message){
        NotificationServer server = new NotificationServer();
        Connection connection = server.connection("Token","IP");
        Authentication authentication = server.authentication("Id");
        connection.connect();
        authentication.authenticate();
        server.send(authentication,new Message(message));
        connection.disconnect();
    }
}
