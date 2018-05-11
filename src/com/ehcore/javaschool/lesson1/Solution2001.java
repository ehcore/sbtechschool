package com.ehcore.javaschool.lesson1;

import java.io.*;

public class Solution2001 {
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        String line = in.readLine();
        String[] numbersStr = line.split(" ");
        int result = 0;
        for (String numberStr : numbersStr) {
            result += Integer.parseInt(numberStr);
        }
        System.out.println(result);
    }
}
