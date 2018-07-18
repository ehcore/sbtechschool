package ru.sbt.patterns1.structural;


import java.util.*;

public class CompositeApp {
    public static void main(String[] args) {
        Shape square = new Square();
        Shape square1 = new Square();
        Shape triangle = new Triangle();
        Shape circle = new Circle();

        Composite composite = new Composite();
        composite.addComponent(square);
        composite.addComponent(square1);
        composite.addComponent(triangle);
        composite.addComponent(circle);

        Shape circle1 = new Circle();
        Shape circle2 = new Circle();
        Shape triangle1 = new Triangle();

        Composite composite1 = new Composite();
        composite1.addComponent(circle1);
        composite1.addComponent(circle2);
        composite1.addComponent(triangle1);

        composite.addComponent(composite1);

        composite.draw();

    }
}

interface Shape{
    void draw();
}

class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Square");
    }
}

class Triangle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Triangle");
    }
}

class Circle implements Shape{
    @Override
    public void draw() {
        System.out.println("draw Circle");
    }
}

class Composite implements Shape{
    private List<Shape> components = new ArrayList<>();

    void addComponent(Shape shape){
        components.add(shape);
    }

    void removeComponent(Shape shape){
        components.remove(shape);
    }

    @Override
    public void draw() {
        for(Shape component: components){
            component.draw();
        }
    }
}