package ru.sbt.patterns1.creational;


public class FactoryMethodApp {
    public static void main(String[] args) {
        WatchMaker maker = getMaker("Digital");
        Watch watch = maker.createWatch();
        watch.showTime();
    }
    static WatchMaker getMaker(String maker){
        if("Digital".equals(maker)){
            return DigitalWatch::new;
        }else if("Romain".equals(maker)){
            return RomainWatch::new;
        }else{
            throw new UnsupportedOperationException("not know watch: " + maker);
        }
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

interface WatchMaker{
    Watch createWatch();
}

class DigitalWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new DigitalWatch();
    }
}

class RomainWatchMaker implements WatchMaker{
    @Override
    public Watch createWatch() {
        return new RomainWatch();
    }
}