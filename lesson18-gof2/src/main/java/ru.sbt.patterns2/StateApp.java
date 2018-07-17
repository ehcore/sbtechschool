package ru.sbt.patterns2;


public class StateApp {
    public static void main(String[] args) {
        Radio radio = new Radio();
        radio.setStation(new RadioDFM());
        radio.nextStation();
        radio.play();
        System.out.println("*******");
        for (int i = 0; i < 10; i++) {
            radio.nextStation();
            radio.play();
        }
    }
}

//State
interface Station{
    void play();
}

class Radio7 implements Station{
    @Override
    public void play() {
        System.out.println("Playing Radio 7 ...");
    }
}

class RadioDFM implements Station{
    @Override
    public void play() {
        System.out.println("Playing Radio DFM ...");
    }
}

class Radio103 implements Station{
    @Override
    public void play() {
        System.out.println("Playing Radio 103 ...");
    }
}

//context
class Radio{
    private Station station;
    void setStation(Station station){
        this.station = station;
    }
    void nextStation(){
        if(station instanceof Radio7){
            setStation(new RadioDFM());
        }else if (station instanceof RadioDFM){
            setStation(new Radio103());
        }else {
            setStation(new Radio7());
        }
    }
    void play(){
        station.play();
    }
}