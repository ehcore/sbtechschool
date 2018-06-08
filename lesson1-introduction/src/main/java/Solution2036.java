import java.util.*;

/**
 * 2036. Строки. Странные слова
 * http://acm.sgu.ru/lang/problem.php?contest=2&problem=2036
 *
 * Дан набор из n слов, состоящих из маленьких латинских букв.
 * Будем называть слово странным, если в нем встречаются 3 или более гласные буквы подряд.
 * Ваша задача — удалить из данного набора все странные слова.
 * Гласными буквами в латинском алфавите считаются e,y,u,i,o,a.
 *
 * Входные данные
 * В первой строке содержится число n — количество слов в наборе, n не превосходит 100.
 * Далее в n строках по одному на строке содержатся слова из набора.
 * Слова состоят только из маленьких латинских букв.
 * Длина каждого слова не менее 1 и не более 20 символов.
 *
 * Выходные данные
 * Выведите все слова из набора, не являющиеся странными.
 * Каждое слово выводите на отдельной строке в том порядке,
 * в котором они заданы во входных данных.
 *
 */

public class Solution2036 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        String current = null;
        String vowels = new String("eyuioa");
        List<String> finalList = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            current = scanner.next();
            int amountV = 0;
            boolean print = true;

            for (int j = 0; j < current.length(); j++) {
                boolean isVow = false;

                for (int z = 0; z < vowels.length(); z++) {

                    if (current.charAt(j) == vowels.charAt(z)) {
                        isVow = true;
                        break;
                    }
                }
                if (isVow) {
                    amountV++;
                    if (amountV >= 3) {
                        print = false;
                        break;
                    }
                } else {
                    amountV = 0;
                }
            }
            if (print) {
                finalList.add(current);
            }
        }

        for (String str : finalList) {
            System.out.println(str);
        }
    }
}
