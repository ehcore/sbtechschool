package streamsapi;

import java.util.*;
import java.util.function.*;

/**
 * Пока сырой код, все плохо и ничего не работает
 * @param <T>
 */

public class   MyStream<T,R> {
    private List<T> collection;
    private List<T> tempCollection = new ArrayList<>();
    private List<T> resultCollection = new ArrayList<>();
    private List<Process> queueTasks = new ArrayList<>();

    MyStream(List<T> collection){
        this.collection = collection;
    }

    static <T> MyStream of(List<T> collection){
        return new MyStream(collection);
    }

    MyStream filter(Predicate<T> predicate){
        Filter filter = new Filter(predicate);
        queueTasks.add(filter);
        return this;
    }

    MyStream transform(Function<T,R> function){
        Transform transform = new Transform(function);
        queueTasks.add(transform);
        return this;
    }


    List<T> collect(){
        for(T t:collection){
            for(Process task: queueTasks){
                task.doWork(t);
            }
        }
        return resultCollection;
    }

    private class Filter implements Process<T>{
        Predicate<T> predicate;
        Filter(Predicate<T> predicate){
            this.predicate = predicate;
        }
        @Override
        public void doWork(T t) {
            if(predicate.test(t)){
                resultCollection.add(t);
            }
        }
    }

    private class Transform implements Process<T>{
        Function<T,R> function;
        Transform(Function<T,R> function){
            this.function = function;
        }

        @Override
        public void doWork(T t) {
            if(resultCollection.contains(t)){
                int index = resultCollection.indexOf(t);
                T elem = resultCollection.get(index);
                T result = (T)function.apply(elem);
                resultCollection.set(index, result);
            }
        }
    }

    /*
    Map toMap();
    */
}
