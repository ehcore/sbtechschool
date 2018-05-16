package com.ehcore.javaschool.lesson3.part1;

import java.util.Scanner;
import java.util.TreeMap;
//full solution
public class Solution2057 {

    private TreeMap<Integer,Integer> set = new TreeMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Solution2057 s = new Solution2057();
        for (int i = 0; i < count; i++) {
            int currInt = scanner.nextInt();
            switch (currInt) {
                case 1:
                    int numb = 0;
                    numb = scanner.nextInt();
                    s.add(numb);
                    break;
                case 2:
                    s.remove();
                    break;
            }
        }
    }

    void add(int x) {
        if(!set.containsKey(x)) {
            set.put(x,1);
        } else {
            set.put(x, set.get(x) + 1);
        }

    }

    void remove() {
        if(!set.isEmpty()){
            int keyFirst = set.firstKey();
            if(set.get(keyFirst) > 1){
                set.put(keyFirst, set.get(keyFirst) - 1);

            } else {
                int value = set.remove(keyFirst);
            }
            System.out.println(keyFirst);
        }
    }
}
