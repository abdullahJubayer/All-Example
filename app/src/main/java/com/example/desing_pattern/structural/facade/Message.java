package com.example.desing_pattern.structural.facade;

/*
-------------Facade-------------
Facade pattern hides the complexities of the system and provides
a simplified (but limited) interface to a complex system
------------Facade--------------
*/
public class Message {
    private String content;

    public Message(String content) {
        this.content = content;
    }
}
