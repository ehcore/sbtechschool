package ru.sbt.patterns1.creational;


public class FactoryMethodApp {
    public static void main(String[] args) {

    }
}


interface Watch{
    void showTime();
}

class DigitalWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("digital watch");
    }
}

class RomainWatch implements Watch{
    @Override
    public void showTime() {
        System.out.println("romain watch");
    }
}