package com.example.desing_pattern.behavioral.command;


/*
------------Command-------------------
The Strategy Design Pattern is a behavioral design pattern
that turns a request into a stand-alone object called a command
------------Command-------------------
 */
public class Main {
    public static void main(String[] args) {
        SpeakerV3 speaker = new SpeakerV3();

        Player player = new Player(speaker);
        player.play();
        // player.next();  can't call next

        SpeakerCommand play = new Play(speaker);
        SpeakerCommand next = new Next(speaker);
        SpeakerCommand previous = new Previous(speaker);
        NewPlayer newPlayer = new NewPlayer();

        newPlayer.setCommand(play);
        newPlayer.execute();

        newPlayer.setCommand(next);
        newPlayer.execute();

        newPlayer.setCommand(previous);
        newPlayer.execute();
    }
}
