import java.io.*;

/**
 * 2001. A+B
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2001
 *
 * Заданы a и b. Выведите a+b.
 *
 * Входные данные
 * В единственной строке входных данных заданы целочисленные a и b (1 ≤ a,b ≤ 1000).
 *
 * Выходные данные
 * Выведите a+b.
 *
 */

public class Solution2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        String[] numbersStr = line.split(" ");
        int result = 0;
        for (String numberStr : numbersStr) {
            result += Integer.parseInt(numberStr);
        }
        System.out.println(result);
    }
}
