package part2;

import java.util.*;
import java.io.*;

/**
 * Выведите на экран все строки файла в обратном порядке.
 *
 */

public class Task4 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("[^а-яА-Яa-zA-Z0-9-]");
        List<String> list = new ArrayList<>();

        while(scanner.hasNext()){
            String line = scanner.next();
            if(!line.equals("")){
                list.add(line);
            }
        }

        for(int i = list.size()-1; i >= 0; i--){
            System.out.println(list.get(i));
        }
    }
}
