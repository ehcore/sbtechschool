package com.ehcore.javaschool.lesson1;

import java.util.Scanner;

public class Solution2002 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
        int result = 0;
        for(int i = 0; i < count; i++){
            result += scanner.nextInt();
        }
        System.out.println(result);
    }
}
