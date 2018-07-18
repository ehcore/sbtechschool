package ru.sbt.patterns1.creational;


public class PrototypeApp {
    public static void main(String[] args) {
        Human original = new Human("Jack",40);
        System.out.println(original);
        Human copy = (Human) original.copy();
        System.out.println(copy);

        HumanFactory factory = new HumanFactory(copy);
        Human copy2 = factory.makeCopy();
        System.out.println(copy2);
    }
}

interface Copyable{
    Object copy();
}

class Human implements Copyable{
    String name;
    int age;

    public Human(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public Object copy() {
        Human humanCopy = new Human(name,age);
        return humanCopy;
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class HumanFactory{
    Human human;

    public HumanFactory(Human human) {
        setPrototype(human);
    }

    void setPrototype(Human human){
        this.human = human;
    }
    Human makeCopy(){
        return (Human) human.copy();
    }
}