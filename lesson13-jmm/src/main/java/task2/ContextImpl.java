package task2;


public class ContextImpl implements Context{
    private FixedThreadPool threadPool;
    public ContextImpl(FixedThreadPool threadPool){
        this.threadPool = threadPool;
    }
    @Override
    public int getCompletedTaskCount() {
        return threadPool.getCompletedTaslCount();
    }

    @Override
    public int getFailedTaskCount() {
        return threadPool.getFailedTaskCount();
    }

    @Override
    public int getInterruptedTaskCount() {
        return threadPool.getInterruptedTaskCount();
    }

    @Override
    public void interrupt() {
        threadPool.interrupt();
    }

    @Override
    public boolean isFinished() {
        return threadPool.isFinished();
    }
}
