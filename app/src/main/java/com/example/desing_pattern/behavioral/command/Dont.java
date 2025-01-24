package com.example.desing_pattern.behavioral.command;


/*
------------Command-------------------
The Strategy Design Pattern is a behavioral design pattern
that turns a request into a stand-alone object called a command
------------Command-------------------
 */

class Player{
    private Speaker speaker;
    public Player(Speaker speaker){
        this.speaker = speaker;
    }

    public void play(){
        speaker.play();
    }

    public void pause(){
        speaker.pause();
    }

    /*
    Now after some times latter i want to add more button then i need to extends these class or
    modify the class. if these happened multiple times then the code get messy. and also player
    handle earphone state also.

    public void previous(){
        earphone.previous();
    }

    public void next(){
        earphone.next();
    }
    */
}


interface Speaker {
    void play();
    void pause();
}

class SpeakerV1 implements Speaker {
    @Override
    public void play() {
        System.out.println("Playing Song");
    }

    @Override
    public void pause() {
        System.out.println("Pause Song");
    }
}

class SpeakerV2 extends SpeakerV1 {
    public void previous() {
        System.out.println("previous");
    }

    public void next() {
        System.out.println("next");
    }
}

class SpeakerV3 extends SpeakerV2 {
    public void volumeUp() {
        System.out.println("volumeUp");
    }

    public void volumeDown() {
        System.out.println("volumeDown");
    }
}
