package streamsapi;

import java.util.*;
import java.util.function.*;

/**
 * Пока сырой код, все плохо и ничего не работает
 * @param <T> - даже и не известно, что здесь будет
 */

public class   MyStream<T> {
    private List<T> collection;
    private Queue<Process> queueTasks = new LinkedList<>();

    MyStream(List<T> collection){
        this.collection = collection;
    }

    static <T> MyStream of(List<T> collection){
        List<T> newCollection = new ArrayList();
        newCollection.addAll(collection);
        return new MyStream(newCollection);
    }

    MyStream filter(Predicate predicate){
        Filter filter = new Filter();
        queueTasks.add(filter);
        return this;
    }

    List<T> collect(){
        for(Process task: queueTasks){
            task.doWork();
        }
        return collection;
    }

    private class Filter implements Process{
        @Override
        public void doWork() {

        }
    }

    /*
    static MyStream of(Collection collection){
        return null;
    }
    MyStream<T> filter(Predicate<T> predicate);
    <R> MyStream<R> transform(Function<T,R> function);
    Map toMap();
    */
}
