package streamsapi;

import java.util.*;
import java.util.function.Function;
import java.util.function.Predicate;

public interface MyStreams<T> {
    static MyStreams of(Collection collection){
        return null;
    }
    MyStreams<T> filter(Predicate<T> predicate);
    <R> MyStreams<R> transform(Function<T,R> function);
    Map toMap();
}
