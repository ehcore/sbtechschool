
public class TaskRunnable implements Runnable{
    @Override
    public void run() {
        double x = 0;
        for (int i = 1; i <= 100; i++) {
            //x = Math.sqrt(i);
            System.out.println(Thread.currentThread().getName() + " -- " + i);
        }
    }
}
