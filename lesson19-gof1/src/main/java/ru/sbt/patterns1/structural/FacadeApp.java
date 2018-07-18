package ru.sbt.patterns1.structural;


public class FacadeApp {
    public static void main(String[] args) {
        Computer computer = new Computer();
        computer.copyData();
    }
}

class Power{
    void on(){
        System.out.println("ON");
    }
    void off(){
        System.out.println("OFF");
    }
}

class DvdRom{
    private boolean data;
    boolean hasData(){
        return data;
    }
    void load(){
        System.out.println("load dvd...");
        data = true;
    }
    void unload(){
        System.out.println("unload dvd");
        data = false;
    }
}

class Hdd{
    void copyFromDvd(DvdRom dvdRom){
        if(dvdRom.hasData()){
            System.out.println("copy from dvd...");
        } else {
            System.out.println("wait dvd...");
        }
    }
}

class Computer{
    Power power = new Power();
    DvdRom dvdRom = new DvdRom();
    Hdd hdd = new Hdd();

    void copyData(){
        power.on();
        dvdRom.load();
        hdd.copyFromDvd(dvdRom);
        dvdRom.unload();
        power.off();
    }
}