
public class TaskRunnable implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 1000_000; i++) {
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
    }
}
