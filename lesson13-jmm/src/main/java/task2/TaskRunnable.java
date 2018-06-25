package task2;

public class TaskRunnable implements Runnable{
    @Override
    public void run() {
        double x = 0;
        for (int i = 1; i <= 100; i++) {
            x += Math.sqrt(i);
            //x = Math.sqrt(i);
            //System.out.println(Thread.currentThread().getName() + " -- " + i);

            if(System.currentTimeMillis() % 5 == 0){
                throw new RuntimeException("Исключение из задачи");
            }

        }
    }
}
