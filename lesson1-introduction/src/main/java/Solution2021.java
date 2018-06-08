import java.util.Scanner;

/**
 * 2021. Делим максимум
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2021
 *
 * Задан массив из n чисел (a1, a2,..., an).
 * С ним два раза повторяют следующую процедуру:
 * одновременно все максимумы в массиве делят на два.
 * Нечетные числа при делении на два следует округлять вниз.
 * Ваша задача — вывести массив после этих действий.
 *
 * Входные данные
 * В первой строке входного файла дано число n (1 ≤ n ≤ 100) — количество чисел в массиве.
 * Во второй строке через пробел записаны числа a1, a2,..., an (1 ≤ ai ≤ 100).
 *
 * Выходные данные
 * Выведите массив после всех действий. Числа разделяйте пробелами.
 *
 */

public class Solution2021 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        int max = 0;
        for (int i = 0; i < count; i++) {
            int current = scanner.nextInt();
            max = Math.max(max, current);
            numbers[i] = current;
        }
        int newMax = 0;
        for (int i = 0; i < count; i++) {
            int current = numbers[i];
            if (current == max) {
                numbers[i] = current >> 1;
            }
            newMax = Math.max(newMax, numbers[i]);
        }
        for (int i = 0; i < count; i++) {
            int current = numbers[i];
            if (current == newMax) {
                numbers[i] = current >> 1;
            }
            System.out.print(numbers[i] + " ");
        }
    }
}
