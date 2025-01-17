package com.example.desing_pattern.creational.abstract_factory;


interface Button {
    void draw();
}

class AndroidButton implements Button {
    @Override
    public void draw() {
        System.out.println("Button");
    }
}

class IosButton implements Button {
    @Override
    public void draw() {
        System.out.println("Button");
    }
}

public interface UiFactory {
    Button createBtn();
}

class AndroidUiFactory implements UiFactory {
    @Override
    public Button createBtn() {
        return new AndroidButton();
    }
}

class IosUiFactory implements UiFactory {
    @Override
    public Button createBtn() {
        return new IosButton();
    }
}

