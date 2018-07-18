package ru.sbt.patterns1.creational;


public class BuilderApp {
    public static void main(String[] args) {
        Car car = new CarBuilder().build();
        System.out.println(car);
        System.out.println("*********");
        Car car1 = new CarBuilder().buildMake("Kia optima").buildTransmission(Transmission.AUTO).build();
        System.out.println(car1);
    }
}

enum Transmission{
    MANUAL,AUTO
}
class Car{
    private String make;
    private Transmission transmission;
    private int maxSpeed;

    public void setMake(String make) {
        this.make = make;
    }

    public void setTransmission(Transmission transmission) {
        this.transmission = transmission;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", transmission=" + transmission +
                ", maxSpeed=" + maxSpeed +
                '}';
    }
}

class CarBuilder{
    private String make = "KIA ceed";
    private Transmission transmission = Transmission.MANUAL;
    private int maxSpeed = 180;

    CarBuilder buildMake(String make){
        this.make = make;
        return this;
    }

    CarBuilder buildTransmission(Transmission transmission){
        this.transmission = transmission;
        return this;
    }

    CarBuilder buildMaxSpeed(int maxSpeed){
        this.maxSpeed = maxSpeed;
        return this;
    }

    Car build(){
        Car car = new Car();
        car.setMake(make);
        car.setTransmission(transmission);
        car.setMaxSpeed(maxSpeed);
        return car;
    }

}