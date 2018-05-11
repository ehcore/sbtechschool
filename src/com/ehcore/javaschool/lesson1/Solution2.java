package com.ehcore.javaschool.lesson1;

import java.util.Scanner;
//for solution 2002 - not right, but work
public class Solution2 {
    public static void main(String[] args) {
        System.out.println("Вычисление суммы 2 чисел:");
        Scanner scanner = new Scanner(System.in);
        int result = 0;
        System.out.print("Введите первое число:");
        int a = scanner.nextInt();
        System.out.print("Введите второе число:");
        int b = scanner.nextInt();
        result = a + b;
        System.out.println("Сумма двух чисел равна:" + result);
    }
}
