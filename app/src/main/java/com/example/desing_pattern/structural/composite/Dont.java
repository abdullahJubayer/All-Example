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
public class Dont {
    public static void main(String[] args) {
        Shape shape = new Shape();
        Circle circle = new Circle();

        ShapeComponents components = new ShapeComponents();
        components.add(shape);
        components.add(circle);
        components.render();
    }
}


class Shape {
    public void render(){
        System.out.println("Rendering");
    }
}

class Circle{
    public void render(){
        System.out.println("Rendering");
    }
}

class ShapeComponents{
    private List<Object> objects = new ArrayList<>();

    public void add(Object object){
        objects.add(object);
    }

    public void render(){
        for (Object o:objects){
            if (o instanceof  Shape)
                ((Shape) o).render();
            if (o instanceof  Circle)
                ((Circle)o).render();
        }
    }
}