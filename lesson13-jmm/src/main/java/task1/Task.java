package task1;

import java.util.concurrent.*;

public class Task<T> {
    private Callable<? extends T> callable;
    private T result = null;
    public Task(Callable<? extends T> callable){
        this.callable = callable;
    }

    public T get() /*throws Exception*/{

        if(result==null){
            synchronized (this){
                if(result==null) {
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        throw new CallRTException();
                    }
                }
            }
        }
        return result;
    }
}
