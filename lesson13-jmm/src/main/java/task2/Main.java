package task2;

public class Main {
    public static void main(String[] args) {
//        FixedThreadPool threadPool = new FixedThreadPool(5);
//        Context context = new ContextImpl(threadPool);
        ExecutionManager executionManager = new ExecutionManagerImpl();

        TaskRunnable[] tasks = new TaskRunnable[10];
        for (int i = 0; i < tasks.length; i++) {
            tasks[i] = new TaskRunnable();
        }

        Context context = executionManager.execute(new Runnable() {
            @Override
            public void run() {
                double x = 0;
                for (int i = 1; i <= 100; i++) {
                    x += Math.sqrt(i);
                }
                System.out.println("x=" + x);
            }
        },tasks);

        context.interrupt();

        System.out.println("Выполнено успешно " + context.getCompletedTaskCount());
        System.out.println("Первано " + context.getInterruptedTaskCount());
        System.out.println("Провалено запусков " + context.getFailedTaskCount());

    }
}
