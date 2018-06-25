package task2;


public class ExecutionManagerImpl implements ExecutionManager {
//    private Context context;

    public ExecutionManagerImpl(){
//        this.context = new ContextImpl();
    }

    @Override
    public Context execute(Runnable callback, Runnable... tasks) {

        FixedThreadPool threadPool = new FixedThreadPool(5);
        for (int i = 0; i < tasks.length; i++) {
            threadPool.execute(tasks[i]);
        }

        Thread thread = new Thread(callback);
        thread.start();

        threadPool.shutdown();

        return new ContextImpl(threadPool);
    }
}
