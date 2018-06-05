import java.util.*;

public class CountMapTester {
    public static void main(String[] args) {
        CountMap<Integer> map = new CountMapImpl<>();
        map.add(10);
        map.add(5);
        map.add(15);
        map.add(6);
        map.add(5);
        map.add(10);
        System.out.println("Содержание отображения:" + map.toMap());

        int count = 5;
        System.out.println("Количество элементов " + count + ":" + map.getCount(count));

        count = 6;
        System.out.println("Количество элементов " + count + ":" + map.getCount(count));

        count = 10;
        System.out.println("Количество элементов " + count + ":" + map.getCount(count));

        count = 11;
        System.out.println("Количество элементов " + count + ":" + map.getCount(count));

        System.out.println("Количество разных элементов:" + map.size());

        System.out.println("Удаление элемента " + count + ", удалено:" +map.remove(count));

        count = 10;
        System.out.println("Удаление элемента " + count + ", удалено:" +map.remove(count));

        CountMap<Integer> newMap = new CountMapImpl<>();
        newMap.add(5);
        newMap.add(6);
        newMap.add(5);
        newMap.add(10);
        newMap.add(11);
        newMap.add(11);

        System.out.println("Содержание нового отображения:" + newMap.toMap());

        map.addAll(newMap);

        System.out.println("Добавление нового отображения в первое отображение:" + map.toMap());

        Map<Integer,Integer> newNewMap = new TreeMap<>();
        map.toMap(newNewMap);

        System.out.println("Содержание нового отображения (не CountMapImpl) и копирование в него первого отображения:" + newNewMap);
    }
}
