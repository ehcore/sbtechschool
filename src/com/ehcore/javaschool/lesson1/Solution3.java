package com.ehcore.javaschool.lesson1;

import java.util.Scanner;

public class Solution3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] numbersStr = line.split(" ");
        int result = 0;
        for(String numberStr :numbersStr){
            result += Integer.parseInt(numberStr);
        }
        System.out.println(result);
    }
}
