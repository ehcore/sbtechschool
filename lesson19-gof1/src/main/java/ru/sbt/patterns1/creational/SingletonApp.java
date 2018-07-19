package ru.sbt.patterns1.creational;


public class SingletonApp {
    public static void main(String[] args) {

        Thread t[] = new Thread[1000];

        for (int i = 0; i < t.length; i++) {
            t[i] = new Thread(Singleton::getInstance);
            t[i].start();
        }

        for (int i = 0; i < t.length; i++) {
            try {
                t[i].join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println(Singleton.count);
    }
}

class Singleton {
    private static volatile Singleton instance;
    public static int count;

    private Singleton() {
        count++;
    }

    public static Singleton getInstance() {
        if (instance == null) {
            synchronized (Singleton.class) {
                if (instance == null)
                    instance = new Singleton();
            }
        }
        return instance;
    }

}