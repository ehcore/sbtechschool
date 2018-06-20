
import threadsapi.*;

public class ThreadPoolTester {
    public static void main(String[] args) {
        ThreadPool pool = new FixedThreadPool(10);
        for (int i = 1; i <= 10; i++) {
            pool.execute(new TaskRunnable());
            pool.start();
            //pool.execute(new TaskRunnable());
        }

    }
}
