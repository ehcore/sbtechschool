package task1;

import java.util.concurrent.*;

public class Task<T> {
    private Callable<? extends T> callable;
    private T result = null;
    public Task(Callable<? extends T> callable){
        this.callable = callable;
    }

    public T get() /*throws Exception*/{
        //System.out.println(Thread.currentThread().getName());
        if(result==null){
            synchronized (this){
                if(result==null) {
                    System.out.println("Вычисление результата");
                    try {
                        result = callable.call();
                    } catch (Exception e) {
                        throw new CallRTException(e);
                    }
                }
            }
        }
        return result;
    }
}
