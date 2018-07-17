package ru.sbt.patterns2.behavioral;

import java.util.*;

public class ObserverApp {
    public static void main(String[] args) {
        MeteoStation station = new MeteoStation();
        station.addObserver(new ConsoleObserver());
        station.setMeasurements(25,740);
        station.setMeasurements(27,750);

    }
}

interface Observable{
    void addObserver(Observer o);
    void removeObserver(Observer o);
    void notifyObserver();
}

class MeteoStation implements Observable{
    private List<Observer> observers = new ArrayList<>();
    private int temperature;
    private int pressure;

    public void setMeasurements(int temperature, int pressure){
        this.temperature = temperature;
        this.pressure = pressure;
        notifyObserver();
    }

    @Override
    public void addObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public void notifyObserver() {
        for(Observer o: observers){
            o.handleEvent(temperature,pressure);
        }
    }
}

interface Observer{
    void handleEvent(int temperature, int pressure);
}

class ConsoleObserver implements Observer{
    @Override
    public void handleEvent(int temperature, int pressure) {
        System.out.println("Показания станции: температура = " + temperature +
                ", давление = " + pressure);
    }
}