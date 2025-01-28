package com.example.desing_pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/*
-------------Composite-------------
The Composite Design Pattern lets us compose objects into
tree-like structures and then work with these structures
as if they were individual objects.
------------Composite--------------
*/
public class Do {
    public static void main(String[] args) {
        Components r = new Rectangle();
        Components p = new Polygon();

        ComponentShape components = new ComponentShape();
        components.add(r);
        components.add(p);
    }
}

interface Components{
    void render();
}

class Rectangle implements Components{
    @Override
    public void render() {
        System.out.println("Rectangle");
    }
}

class Polygon implements Components{
    @Override
    public void render() {
        System.out.println("Polygon");
    }
}

// Composite
class ComponentShape implements Components{
    private List<Components> components = new ArrayList<>();
    public void add(Components component){
        components.add(component);
    }
    @Override
    public void render() {
        for (Components c: components)
            c.render();
    }
}