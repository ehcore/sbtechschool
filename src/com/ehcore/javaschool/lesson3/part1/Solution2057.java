package com.ehcore.javaschool.lesson3.part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Solution2057 {

    private ArrayList<Integer> set = new ArrayList<>();
    private int min;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        Solution2057 s = new Solution2057();
        int currInt = 0;
        for (int i = 0; i < count; i++) {
            currInt = scanner.nextInt();
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
        if (set.isEmpty()) {
            min = x;
        }
        min = Math.min(min, x);
        set.add(x);
    }

    void remove() {
        System.out.println(min);
        boolean rem = set.remove((Integer) min);
        if (!set.isEmpty()) min = Collections.min(set);
    }
}
