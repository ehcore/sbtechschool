package threadsapi;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 */

public class FixedThreadPool implements ThreadPool{

    //private int amountThreadsCurrent;
    private final LinkedList<Runnable> tasks;
    private int amountThreads/*Final*/;

    private volatile boolean isKillThemAll;

    private final Thread[] threads;


    public FixedThreadPool(int amountThreads){
        this.amountThreads/*Final*/ = amountThreads;
        this.tasks = new LinkedList<>();
        this.isKillThemAll = false;


        threads = new Thread[amountThreads];
        for (int i = 0; i < amountThreads; i++) {
            threads[i] = new ThreadWorker();
            threads[i].start();//******************
        }
    }

    @Override
    public void start() {
    }

    @Override
    public void execute(Runnable runnable) {
        synchronized (tasks){
            tasks.add(runnable);
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
}
