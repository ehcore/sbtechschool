package threadsapi;

import java.util.*;

public class FixedThreadPool implements ThreadPool{
    private final Set<Runnable> setWorkers;
    private int amountThreadsFinal;
    private int amountThreadsCurrent;
    private final Deque<Runnable> listWorkers;


    public FixedThreadPool(int amountThreads){
        this.amountThreadsFinal = amountThreads;
        this.setWorkers = new HashSet<>(amountThreads);
        this.listWorkers = new LinkedList<>();
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
        Thread thread = new Thread(listWorkers.removeFirst());
        thread.start();
        amountThreadsCurrent--;
    }

    @Override
    public void execute(Runnable runnable) {
        if(amountThreadsCurrent > amountThreadsFinal){
            //System.out.println("Нет свободного места");
        }else{
            //setWorkers.add(runnable);
            listWorkers.add(runnable);
            amountThreadsCurrent++;
        }
    }
}
