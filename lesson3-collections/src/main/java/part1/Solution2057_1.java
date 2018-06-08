package part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

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

//slow solution
public class Solution2057_1 {

    private ArrayList<Integer> set = new ArrayList<>();
    private int min;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Solution2057_1 s = new Solution2057_1();
        int currInt = 0;
        for (int i = 0; i < count; i++) {
            currInt = scanner.nextInt();
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
        if (set.isEmpty()) {
            min = x;
        }
        min = Math.min(min, x);
        set.add(x);
    }

    void remove() {
        System.out.println(min);
        boolean rem = set.remove((Integer) min);
        if (!set.isEmpty()) min = Collections.min(set);
    }
}
