package streamsapi;

import java.util.*;
import java.util.function.*;

/**
 * Пока сырой код, все плохо, но работает
 * необходимо поработать над параметризацией
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

    public  MyStream filter(Predicate<T> predicate){
        Filter filter = new Filter(predicate);
        queueTasks.add(filter);
        return this;
    }

    public MyStream transform(Function function){
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

    public Map toMap(Function functionKey, Function functionVal){
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
        Predicate predicate;
        Filter(Predicate predicate){
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
        Function function;
        Transform(Function function){
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