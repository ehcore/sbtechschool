package threadsapi;

import java.util.*;

/**
 * 
 */

public class FixedThreadPool implements ThreadPool{
    private final Set<Runnable> setWorkers;
    private int amountThreadsFinal;
    private int amountThreadsCurrent;
    private final Deque<Runnable> tasks;


    public FixedThreadPool(int amountThreads){
        this.amountThreadsFinal = amountThreads;
        this.setWorkers = new HashSet<>(amountThreads);
        this.tasks = new LinkedList<>();
    }

    @Override
    public void start() {
/*
        for(Runnable runnable: setWorkers){
            Thread thread = new Thread(runnable);
            thread.start();
            amountThreadsCurrent--;
        }
*/
        while (!tasks.isEmpty()){
            for (int i = 0; i < amountThreadsFinal; i++) {
                Thread thread = new Thread(tasks.removeFirst());
                thread.start();
            }
        }

 /*       Thread thread = new Thread(tasks.removeFirst());
        thread.start();
        amountThreadsCurrent--;*/
    }

    @Override
    public void execute(Runnable runnable) {
/*
        if(amountThreadsCurrent > amountThreadsFinal){
            //System.out.println("Нет свободного места");
        }else{
*/
            //setWorkers.add(runnable);
        tasks.add(runnable);
        amountThreadsCurrent++;
     //   }
    }
}
