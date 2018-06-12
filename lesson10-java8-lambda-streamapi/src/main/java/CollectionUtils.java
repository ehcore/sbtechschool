import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Задание из ДЗ к уроку по дженерикам
 * upd: переписать часть функционала на stream api
 */

public class CollectionUtils {

    public static <T> void addAll(List<? extends T> source, List<? super T> destination){
        destination.addAll(source);
    }

    public static <T> List<T> newArrayList(){
        return new ArrayList<T>();
    }

    public static <T> int indexOf(List<? extends T> source, T t){
        return source.indexOf(t);
    }

    public static <T> List<T> limit(List<T> source, int size){
        return source.subList(0,size);
    }

    public static <T> void add(List<T> source, T t){
        source.add(t);
    }

    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2){
        removeFrom.removeAll(c2);
    }

    public static <T> boolean containsAll(List<? extends T> c1, List<? extends T> c2){
        return c1.containsAll(c2);
    }

    public static <T> boolean containsAny(List<? extends T> c1, List<? extends T> c2){
        for(T t : c2){
            if(c1.contains(t)){
                return true;
            }
        }
        return false;
    }

    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<T> comparator){
      List<T> newList = list.stream()
              .filter(t->(comparator.compare(t,min) >= 0) & (comparator.compare(t,max))<=0)
              .sorted(comparator)
              .collect(Collectors.toList());
        return newList;
    }

    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max){
        List<T> newList = list.stream()
                .filter(t->(t.compareTo(min) >= 0) & (t.compareTo(max))<=0)
                .sorted()
                .collect(Collectors.toList());
        return newList;
    }
}
