import java.util.Scanner;

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
