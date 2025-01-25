package com.example.desing_pattern.behavioral.memento;


import java.util.ArrayList;

/*
------------Memento-------------------
The Memento design pattern is used to capture and restore an object's internal state
without violating encapsulation. It allows you to save and restore the state of an object
to a previous state, providing the ability to undo or roll back changes made to the object.
------------Memento-------------------
 */
public class Main {
    public static void main(String[] args) {
        Document document = new Document();
        History history = new History();

        document.write("Hello");
        history.save(document.createMemento());
        document.write(" World");
        history.save(document.createMemento());

        System.out.println(document.getContent());

        document.restoreFromMemento(history.restore());
        System.out.println(document.getContent());
    }
}

class DocumentMemento{
    private String content;

    public DocumentMemento(String content){
        this.content= content;
    }

    public String getContent() {
        return content;
    }
}

class Document{
    private String content;

    public String getContent() {
        return content;
    }

    public void write(String content){
        this.content += content;
    }

    public DocumentMemento createMemento(){
        return new DocumentMemento(content);
    }

    public void restoreFromMemento(DocumentMemento memento){
        this.content = memento.getContent();
    }
}

class History{
    private final ArrayList<DocumentMemento> history=new ArrayList<>();
    public void save(DocumentMemento memento){
        history.add(memento);
    }

    public DocumentMemento restore(){
        return history.remove(history.size()-1);
    }
}