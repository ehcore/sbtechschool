package threadsapi;

import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 *
 */

public class FixedThreadPool implements ThreadPool{
    private int amountThreadsFinal;
    private int amountThreadsCurrent;
    private final List<Runnable> tasks;

    public FixedThreadPool(int amountThreads){
        this.amountThreadsFinal = amountThreads;
        this.tasks = new LinkedList<>();
    }

    @Override
    public void start() {
        for (int i = 0; i < tasks.size(); i++) {
            Thread thread = new Thread(tasks.get(i));
            thread.start();
            System.out.println(Thread.currentThread().getName() + " -------------**----** Удалили задачу, запустили поток," +
                    " количество задач осталось:" + tasks.size() +
                    " количество потоков текущее:" + amountThreadsCurrent);
            amountThreadsCurrent--;
        }
        tasks.clear();
    }

    @Override
    public void execute(Runnable runnable) {
        if(amountThreadsCurrent >= amountThreadsFinal){
            try {
                start();
                System.out.println(Thread.currentThread().getName() + " **** Нет свободного места, спим");
                TimeUnit.SECONDS.sleep(5);
                System.out.println(Thread.currentThread().getName() + " **----** Проснулись");
                execute(runnable);
                System.out.println(Thread.currentThread().getName() + " **--++-** Прошли дальше");

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }else{
            System.out.println(Thread.currentThread().getName() + " **-###################-** Добавили задачу");
            tasks.add(runnable);
            amountThreadsCurrent++;
       }
    }
}
