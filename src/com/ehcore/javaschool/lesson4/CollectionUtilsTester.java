package com.ehcore.javaschool.lesson4;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionUtilsTester {
    public static void main(String[] args) {

        List<Integer> integerList = new ArrayList<>();
        integerList.add(10);
        integerList.add(5);
        integerList.add(15);
        integerList.add(6);
        integerList.add(5);
        integerList.add(10);

        System.out.println("Заполненный список целых чисел:" + integerList);

        CollectionUtils.add(integerList,15);
        CollectionUtils.add(integerList,6);

        System.out.println("Добавлено два целых числа:" + integerList);

        Comparator<Integer> comparator = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        List<Integer> newIntegerList = new ArrayList<>();

        int intMin = 6;
        int intMax = 15;

        CollectionUtils.addAll(CollectionUtils.range(integerList,intMin,intMax,comparator),newIntegerList);

        System.out.println("Новый, отсортированный список после обрезки старого в диапазоне от " + intMin +  " до " + intMax + " :" + newIntegerList);

        CollectionUtils.add(newIntegerList,3);
        CollectionUtils.add(newIntegerList,4);
        CollectionUtils.add(newIntegerList,7);
        CollectionUtils.add(newIntegerList,2);

        System.out.println("Добавлено несколько целых числел в новый спиок:" + newIntegerList);

        intMin = 0;
        intMax = 10;

        newIntegerList = CollectionUtils.range(newIntegerList,intMin,intMax);

        System.out.println("Новый, отсортированный список после обрезки старого в диапазоне от " + intMin +  " до " + intMax + " :" + newIntegerList);

        intMax = 6;

        newIntegerList = CollectionUtils.limit(newIntegerList,intMax);

        System.out.println("Ограничение списка до " + intMax + " элементов :" + newIntegerList);

        System.out.println("Содержание всех элементов списка в новом списке :" + CollectionUtils.containsAll(newIntegerList,integerList));
        System.out.println("Содержание любого из элементов списка в новом списке :" + CollectionUtils.containsAny(newIntegerList,integerList));

        int idx = 6;

        System.out.println("Индекс элемента " + idx + " в списке :" + CollectionUtils.indexOf(newIntegerList,idx));

        CollectionUtils.removeAll(newIntegerList,integerList);

        System.out.println("Удаление всех совпадающих элементов списка из нового списка :" + newIntegerList);
    }
}
