package task2;

import java.util.*;

public class FixedThreadPool {
    private final LinkedList<Runnable> tasks;
    private volatile int taskCount;
    private int amountThreads;
    private volatile int interruptedTaskCount;
    private volatile boolean isKillThemAll;
    private volatile int failedTaskCount;
    private final Thread[] threads;


    public FixedThreadPool(int amountThreads){
        this.amountThreads = amountThreads;
        this.tasks = new LinkedList<>();
        this.isKillThemAll = false;


        threads = new Thread[amountThreads];
        for (int i = 0; i < amountThreads; i++) {
            threads[i] = new ThreadWorker();
            threads[i].setUncaughtExceptionHandler((t, e) -> {
                System.out.println("мы поймали исключение " + e.getMessage());
                synchronized (this){
                    failedTaskCount = failedTaskCount + 1;
                }

            });
            threads[i].start();//******************

        }
    }

     public void execute(Runnable runnable) {
        synchronized (tasks){
            tasks.add(runnable);
            taskCount = taskCount + 1;
            tasks.notify();
        }
    }


    public void shutdown(){
        isKillThemAll=true;
    }

    private class ThreadWorker extends Thread{
        @Override
        public void run() {
            //работа потоков бесконечна
            while(true) {

                synchronized (tasks){

                    while (tasks.isEmpty()){
                        if(isKillThemAll){
                            return;
                        }
                        try {
                            tasks.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }

                Runnable r = tasks.removeFirst();
                r.run();
            }
        }
    }


    public void interrupt(){
        interruptedTaskCount = tasks.size();
        synchronized (tasks){
            tasks.clear();
        }
        shutdown();
    }

    public int getInterruptedTaskCount(){
        return interruptedTaskCount;
    }

    public int getFailedTaskCount(){
        return failedTaskCount;
    }

    public synchronized int getCompletedTaslCount(){
        int complTask = taskCount - failedTaskCount - interruptedTaskCount;
        return complTask;
    }

    public boolean isFinished(){
        return tasks.size()==0;
    }
}
