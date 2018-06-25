package task1;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args) /*throws ExecutionException, InterruptedException*/ {
        ExecutorService service = Executors.newFixedThreadPool(5);
        //Future<Double> f;
        //Task<Double> task;
        final Task<Double> task = new Task<>(new CallableImpl());
        for (int i = 0; i < 10; i++) {
            //f = service.submit(new CallableImpl());

            service.execute(new Runnable() {
                @Override
                public void run() {
//                    Task<Double> task = new Task<>(new CallableImpl());
                    System.out.println(task.get());

                }
            });


        }

        service.shutdown();

    }
}
