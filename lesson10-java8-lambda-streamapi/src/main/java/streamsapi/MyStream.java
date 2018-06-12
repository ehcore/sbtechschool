package streamsapi;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public interface MyStream<T> {
    static MyStream of(Collection collection){
        return null;
    }
    MyStream<T> filter(Predicate<T> predicate);
    <R> MyStream<R> transform(Function<T,R> function);
    Map toMap();
}
