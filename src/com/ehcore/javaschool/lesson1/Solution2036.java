package com.ehcore.javaschool.lesson1;

import java.util.*;

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
