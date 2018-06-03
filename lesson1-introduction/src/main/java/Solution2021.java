import java.util.Scanner;

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
