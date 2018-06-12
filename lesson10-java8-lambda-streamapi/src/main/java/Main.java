
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Arrays.asList("aa","bb","cc").stream()
                .filter(s -> "cc".equals(s))
                .forEach(System.out::println);

    }
}
