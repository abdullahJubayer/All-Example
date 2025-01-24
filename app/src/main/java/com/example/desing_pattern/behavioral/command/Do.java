package com.example.desing_pattern.behavioral.command;


/*
------------Command-------------------
The Strategy Design Pattern is a behavioral design pattern
that turns a request into a stand-alone object called a command
------------Command-------------------
 */

class NewPlayer {
    private SpeakerCommand command;

    public void setCommand(SpeakerCommand command){
        this.command=command;
    }

    public void execute() {
        command.execute();
    }
}


interface SpeakerCommand {
    void execute();
}

class Play implements SpeakerCommand {
    private final Speaker speaker;

    public Play(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.play();
    }
}

class Pause implements SpeakerCommand {
    private final Speaker speaker;

    public Pause(Speaker speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.pause();
    }
}

class Next implements SpeakerCommand {
    private final SpeakerV2 speaker;

    public Next(SpeakerV2 speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.next();
    }
}

class Previous implements SpeakerCommand {
    private final SpeakerV2 speaker;

    public Previous(SpeakerV2 speaker) {
        this.speaker = speaker;
    }

    @Override
    public void execute() {
        speaker.previous();
    }
}
