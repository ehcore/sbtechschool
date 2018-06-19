
import threadsapi.*;

public class ThreadPoolTester {
    public static void main(String[] args) {
        ThreadPool pool = new FixedThreadPool(7);
        for (int i = 0; i < 6; i++) {
            pool.execute(new TaskRunnable());
            pool.execute(new TaskRunnable());
        }
        pool.start();
    }
}
