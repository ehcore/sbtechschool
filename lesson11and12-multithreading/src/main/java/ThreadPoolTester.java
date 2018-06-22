
import threadsapi.*;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolTester {
    public static void main(String[] args) {
        ThreadPool pool = new FixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            pool.execute(new TaskRunnable());
            //pool.execute(new TaskRunnable());
        }
        pool.start();


/*        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            executorService.execute(new TaskRunnable());
        }
        executorService.shutdown();*/
    }
}
