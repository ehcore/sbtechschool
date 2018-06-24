package task1;

import java.util.concurrent.*;

public class Task<T> {
    Callable<? extends T> callable;
    public Task(Callable<? extends T> callable){
        this.callable = callable;
    }

    public T get() throws Exception{

        return callable.call();
    }
}
