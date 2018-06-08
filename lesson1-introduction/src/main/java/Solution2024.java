import java.util.Scanner;

/**
 * 2024. Сделать палиндром!
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2024
 *
 * Последовательность чисел называется палиндромом, если она читается справа налево и слева направо одинаково.
 * Например, (1, 2, 1) и (12, 14, 14, 12) — палиндромы,
 * а (1, 2, 3) и (4, 5, 5, 6) — нет.
 * Дана последовательность из n элементов (a1, a2,..., an).
 * Ваша задача — узнать, какое минимальное количество элементов нужно заменить,
 * чтобы последовательность стала палиндромом.
 *
 * Входные данные
 * В первой строке входного файла дано число n (1 ≤ n ≤ 100) — количество чисел в массиве.
 * Во второй строке через пробел записаны числа a1, a2,..., an (1 ≤ ai ≤ 100).
 *
 * Выходные данные
 * Выведите единственное число — минимальное количество элементов,
 * которые нужно заменить, чтобы последовательность стала палиндромом.
 *
 */

public class Solution2024 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int[] numbers = new int[count];
        for (int i = 0; i < count; i++) {
            numbers[i] = scanner.nextInt();
        }
        int min = 0;
        for(int i = 0 ,  j = count - 1; i < count; i++, j--){
            if(i > j){
                break;
            }
            if(numbers[i] != numbers[j]){
                min++;
            }
        }
        System.out.println(min);
    }
}
