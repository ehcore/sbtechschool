package ru.sbt.patterns2;


public class ChainApp {
    public static void main(String[] args) {
        Logger logger1 = new SmsLogger(1);
        Logger logger2 = new EmailLogger(2);
        Logger logger3 = new FileLogger(3);

        logger1.setNext(logger2);
        logger2.setNext(logger3);

        logger1.writeMessage("Все нормально",Level.INFO);
        System.out.println("************");
        logger1.writeMessage("Тестируем",Level.DEBUG);
        System.out.println("************");
        logger1.writeMessage("Что-то не так",Level.ERROR);

    }
}

class Level{
    public static final int ERROR = 1;
    public static final int DEBUG = 2;
    public static final int INFO = 3;
}

abstract class Logger{
    private int priority;
    private Logger next;

    Logger(int priority){
        this.priority = priority;
    }
    public void setNext(Logger next) {
        this.next = next;
    }
    void writeMessage(String message, int level){
        if(level<=priority){
            write(message);
        }
        if(next!=null){
            next.writeMessage(message,level);
        }
    }
    abstract void write(String message);
}


class SmsLogger extends Logger{

    public SmsLogger(int priority) {
        super(priority);
    }

    @Override
    public void write(String message){
        System.out.println("SMS:" + message);
    }
}

class EmailLogger extends Logger{

    public EmailLogger(int priority) {
            super(priority);
    }
    @Override
    public void write(String message){
        System.out.println("Email:" + message);
    }
}

class FileLogger extends Logger{

    public FileLogger(int priority) {
        super(priority);
    }
    @Override
    public void write(String message){
        System.out.println("File:" + message);
    }
}