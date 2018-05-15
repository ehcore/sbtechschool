package com.ehcore.javaschool.lesson3.part1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    private ArrayList<Integer> set = new ArrayList<>();
    private int max;


//    public Solution(int maxSize){
////        set = new int[maxSize];
//    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
   //     int[] numbers = new int[count];

     //   HashSet<Integer> hashSet = new HashSet<>();


        Solution s = new Solution();

        int currInt = 0;

        for (int i = 0; i < count; i++) {

            currInt = scanner.nextInt();

            int numb = 0;

            numb = scanner.nextInt();


            switch (currInt){
                case 1: s.add(numb);
                        break;
                case 2: s.remove();
                        break;
            }
            System.out.println(currInt);
        }




        //    set.remove(2);

    }

    void add(int x){
        max = Math.max(max,x);
        set.add(x);
    }

    int remove(){

        return 0;
    }

}
