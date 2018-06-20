
import threadsapi.*;

public class ThreadPoolTester {
    public static void main(String[] args) {
        ThreadPool pool = new FixedThreadPool(5);
        for (int i = 1; i <= 20; i++) {
            pool.execute(new TaskRunnable());

            //pool.execute(new TaskRunnable());
        }

        pool.start();

    }
}
