package part1;


import java.io.*;
import java.util.*;


public class Solution2056 {

    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(new File("input.txt")/*System.in*/);

        String line = null;

        ArrayList<String> inStr = new ArrayList<>();

        while (scanner.hasNext()){
            line = scanner.next().toLowerCase();
            inStr.add(line);
        }

        HashSet<String> set = new HashSet<>();
        set.addAll(inStr);

        HashMap<String,Integer> map = new HashMap<>();

        for(String strFromSet : set){
            int counter = 0;
            for(String strFromList : inStr){
                if(strFromList.equals(strFromSet)){
                    counter ++;
                }
            }
            map.put(strFromSet,counter);
        }

        map.values().removeIf(list -> list.equals(1));

        TreeMap<String,Integer> mapSort = new TreeMap<>();
        mapSort.putAll(map);

        for (Map.Entry<String,Integer> e : mapSort.entrySet()){
            System.out.println(e.getKey());
        }
    }
}
