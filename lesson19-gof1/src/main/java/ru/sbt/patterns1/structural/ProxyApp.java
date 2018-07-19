package ru.sbt.patterns1.structural;


public class ProxyApp {
    public static void main(String[] args) {
        //Image image = new RealImage("d:/12.jpg");
        //image.display();
        Image imageProxy = new ProxyImage("d:/123.jpg");
        imageProxy.display();

    }
}

interface Image{
    void display();
}

class RealImage implements Image{
    String file;

    public RealImage(String file) {
        this.file = file;
        load();
    }

    void load(){
        System.out.println("load " + file);
    }

    @Override
    public void display() {
        System.out.println("show " + file);
    }
}

class ProxyImage implements Image{
    String file;
    RealImage image;


    public ProxyImage(String file) {
        this.file = file;
    }

    @Override
    public void display() {
        if(image == null){
            image = new RealImage(file);
        }
        image.display();
    }
}