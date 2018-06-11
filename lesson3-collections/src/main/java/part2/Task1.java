package part2;


import java.io.*;
import java.util.*;

/**
 * Подсчитайте количество различных слов в файле.
 *
 */

public class Task1 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("[^а-яА-Яa-zA-Z0-9-]");
        List<String> list = new ArrayList<>();

        while (scanner.hasNext()){
            String line = scanner.next();
            if(!line.equals("")){
                list.add(line);
            }
        }

        Set<String> set = new HashSet<>();
        set.addAll(list);

        Map<String,Integer> map = new HashMap<>();

        for(String strSet : set){
            int currInt = 0;
            for(String strList : list){
                if(strSet.equals(strList)){
                    currInt ++;
                }
            }
            map.put(strSet,currInt);
        }

        for(Map.Entry<String,Integer> e : map.entrySet()){
            System.out.println(e.getKey() + ":" + e.getValue());
        }
    }
}