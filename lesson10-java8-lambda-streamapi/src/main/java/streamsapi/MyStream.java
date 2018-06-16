package streamsapi;

import java.util.*;
import java.util.function.*;

/**
 * Пока сырой код, все плохо, но работает
 * необходимо поработать над параметризацией
 * upd 16.06.18: теперь и не компилируется
 * @param <T>
 */

public class MyStream <T>{
    private List<T> tempCollection = new ArrayList<>();
    private List<T> resultCollection = new ArrayList<>();
    private Map resultMap = new HashMap<>();
    private List<Process> queueTasks = new ArrayList<>();

     private MyStream(List<T> collection){
        resultCollection.addAll(collection);
    }

    public static <T> MyStream<T> of(List<T> collection){
        return new MyStream<>(collection);
    }

    public  MyStream<T> filter(Predicate<? super T> predicate){
        Filter filter = new Filter(predicate);
        queueTasks.add(filter);
        return this;
    }

    public MyStream<T> transform(Function<? super T,? extends T> function){
        Transform transform = new Transform(function);
        queueTasks.add(transform);
        return this;
    }


    public List<T> collect(){
        for(Process task: queueTasks){
            task.doWork();
        }
        return resultCollection;
    }

    public <K,V> Map<K,V> toMap(Function<? super K, ? extends V> functionKey, Function<? super K, ? extends V> functionVal){
        for(Process task:queueTasks){
            task.doWork();
        }
        for(T t:resultCollection){
            resultMap.put(functionKey.apply(t),functionVal.apply(t));
        }
        return resultMap;
    }

    private void swapList(){
        tempCollection.clear();
        tempCollection.addAll(resultCollection);
        resultCollection.clear();
    }

    private class Filter implements Process{
        Predicate<? super T> predicate;
        Filter(Predicate<? super T> predicate){
            this.predicate = predicate;
        }
        @Override
        public void doWork() {
            swapList();
            for(T t:tempCollection){
                if(predicate.test(t)){
                    resultCollection.add(t);
                }
            }
        }
    }

    private class Transform implements Process{
        Function<? super T,? extends T> function;
        Transform(Function<? super T,? extends T> function){
            this.function = function;
        }
        @Override
        public void doWork() {
            swapList();
            for(T t:tempCollection){
                resultCollection.add((T) function.apply(t));
            }
        }
    }
}