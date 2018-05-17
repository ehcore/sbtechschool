package com.ehcore.javaschool.lesson3.part2;

import java.io.*;
import java.util.*;

public class Task6 {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("input.txt")).useDelimiter("\n");
        List<String> list = new ArrayList<>();
        int count = 0;

        while(scanner.hasNext()){
            String line = scanner.next();
            list.add(line);
            count++;
        }

        System.out.println("Введите номер строки для печати от 0 до " + (count-1) + " (включительно) :");
        scanner = new Scanner(System.in);
        int numLine = scanner.nextInt();

        if(numLine >= 0  & numLine < count ) {
            System.out.println(list.get(numLine));
        } else {
            System.out.println("Введен недопустимый номер строки");
        }
    }
}
