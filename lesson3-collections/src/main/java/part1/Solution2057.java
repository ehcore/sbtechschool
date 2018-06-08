package part1;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * 2057. Структуры данных. Множество
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2057
 *
 * Ваша задача — реализовать структуру данных, которая умеет хранить мультимножество натуральных чисел,
 * т.е. в этой структуре могут одновременно храниться несколько равных элементов.
 * Эта структура должна поддерживать две операции:
 * - добавить элемент x в множество
 * - удалить минимальный элемент в множестве и вернуть его значение
 * (если минимальных элементов несколько, то удаляется только один из них)
 *
 * Входные данные
 * Первая строка входных данных содержит число n (1 ≤ n ≤ 1000_000) — количество операций.
 * Далее в n строках даны описания операций над множеством.
 * Описание представляет собой число — тип запроса (1 или 2) и
 * число x (1 ≤ x ≤ 1000_000_000) если это запрос первого типа.
 *
 * Выходные данные
 * Для каждого запроса второго типа выведите результат на отдельной строке.
 *
 */

//full solution
public class Solution2057 {

    private TreeMap<Integer,Integer> set = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Solution2057 s = new Solution2057();
        for (int i = 0; i < count; i++) {
            int currInt = scanner.nextInt();
            switch (currInt) {
                case 1:
                    int numb = 0;
                    numb = scanner.nextInt();
                    s.add(numb);
                    break;
                case 2:
                    s.remove();
                    break;
            }
        }
    }

    void add(int x) {
        if(!set.containsKey(x)) {
            set.put(x,1);
        } else {
            set.put(x, set.get(x) + 1);
        }

    }

    void remove() {
        if(!set.isEmpty()){
            int keyFirst = set.firstKey();
            if(set.get(keyFirst) > 1){
                set.put(keyFirst, set.get(keyFirst) - 1);

            } else {
                int value = set.remove(keyFirst);
            }
            System.out.println(keyFirst);
        }
    }
}
