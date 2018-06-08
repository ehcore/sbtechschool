package part1;


import java.io.*;
import java.util.*;

/**
 * 2056. Структуры данных. Самое популярное слово
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2056
 *
 * Дан текст, ваша задача — найти слово, которое встречается в тексте наибольшее количество раз.
 * Текст состоит только из латинских букв, пробелов, переводов строк.
 * Слово — это последовательность подряд идущих латинских букв, регистр не имеет значения.
 * Если искомых слов несколько, ваша задача — найти все такие слова.
 *
 * Входные данные
 * Входные данные состоят только из латинских букв, пробелов и символов перевода строки.
 * Гарантируется, что хотя бы одно слово в текст присутствует.
 *
 * Выходные данные
 * Выведите все слова, которые встречаются наибольшее количество раз, при их следут приводить к нижнему регистру,
 * каждое слово выводите на отдельной строке. Слова выводите в лексикографическом порядке.
 * Размер входного файла не превосходит 100 Кб.
 *
 */

public class Solution2056 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("input.txt")/*System.in*/);

        String line = null;

        ArrayList<String> inStr = new ArrayList<>();

        while (scanner.hasNext()){
            line = scanner.next().toLowerCase();
            inStr.add(line);
        }

        HashSet<String> set = new HashSet<>();
        set.addAll(inStr);

        HashMap<String,Integer> map = new HashMap<>();

        for(String strFromSet : set){
            int counter = 0;
            for(String strFromList : inStr){
                if(strFromList.equals(strFromSet)){
                    counter ++;
                }
            }
            map.put(strFromSet,counter);
        }

        map.values().removeIf(list -> list.equals(1));

        TreeMap<String,Integer> mapSort = new TreeMap<>();
        mapSort.putAll(map);

        for (Map.Entry<String,Integer> e : mapSort.entrySet()){
            System.out.println(e.getKey());
        }
    }
}
