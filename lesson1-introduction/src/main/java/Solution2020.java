import java.util.*;

/**
 * 2020. Наиболее частое значение
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2020
 *
 * Задана последовательность a1, a2,..., an, которая отсортирована по неубыванию.
 * Выведите наиболее часто встречающееся в ней значение и количество его появлений в последовательности.
 *
 * Входные данные
 * В первой строке задано целое число n (1 ≤ n ≤ 10_000).
 * Вторая строка содержит n целых чисел, каждое от 1 до 10_000 включительно.
 * Заданная последовательность отсортирована по неубыванию.
 *
 * Выходные данные
 * Выведите два целых числа f, c (числа разделяйте пробелом),
 * где f — значение наиболее часто встречающегося элемента последовательности
 * и c — количество его появлений.
 * Если существует несколько возможных значений для f, то выведите наименьшее из них.
 *
 */

public class Solution2020 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];

        HashSet<Integer> hashSet = new HashSet<>();

        int currInt = 0;

        for (int i = 0; i < count; i++) {
            currInt = scanner.nextInt();
            numbers[i] = currInt;
            hashSet.add(currInt);
        }

        HashMap<Integer,Integer> map = new HashMap<>();

        for(Integer integer : hashSet){
            int counter = 0;
            for(int i = 0; i < numbers.length; i++){
                if(numbers[i] == integer){
                    counter ++;
                }
            }
            map.put(integer,counter);
        }

        int max = 0;

        for (HashMap.Entry<Integer,Integer> e : map.entrySet()){
            int curIntMap = e.getValue();
            max = Math.max(max,curIntMap);
        }

        for (HashMap.Entry<Integer,Integer> e : map.entrySet()){
            int curIntMap = e.getValue();
            if(curIntMap == max){
                System.out.println(e.getKey() + " " + max);
                break;
            }
        }

    }
}
