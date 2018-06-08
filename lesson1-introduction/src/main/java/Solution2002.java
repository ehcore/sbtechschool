import java.util.Scanner;

/**
 * 2002. Сумма чисел
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2002
 *
 * Задано n целых чисел. Выведите их сумму.
 *
 * Входные данные
 * В первой строке задано целое число n (1 ≤ n ≤ 10_000).
 * Вторая строка содержит n целых чисел, каждое от 1 до 10_000, включительно.
 *
 * Выходные данные
 * Выведите искомую сумму.
 *
 */

public class Solution2002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int result = 0;
        for(int i = 0; i < count; i++){
            result += scanner.nextInt();
        }
        System.out.println(result);
    }
}
