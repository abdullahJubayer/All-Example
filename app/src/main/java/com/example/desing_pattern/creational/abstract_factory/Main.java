package com.example.desing_pattern.creational.abstract_factory;


/*
-------------Abstract Factory Pattern-------------
    The Abstract Factory Pattern provides an interface for creating
    families of related or dependent objects without specifying their
    concrete classes. It is used when there are multiple related products,
    and you need to ensure that they are created together in a consistent way.
------------Pattern--------------
*/
public class Main {
    public static void main(String[] args) {
        UiFactory androidUiFactory = new AndroidUiFactory();
        androidUiFactory.createBtn();

        UiFactory iosUiFactory = new IosUiFactory();
        iosUiFactory.createBtn();
    }
}
