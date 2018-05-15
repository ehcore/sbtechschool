package com.ehcore.javaschool.lesson3.part1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {

    ArrayList<Integer> set = new ArrayList<>();



//    public Solution(int maxSize){
////        set = new int[maxSize];
//    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int count = scanner.nextInt();
   //     int[] numbers = new int[count];

     //   HashSet<Integer> hashSet = new HashSet<>();


        Solution s = new Solution();

        String currInt = null;

        for (int i = 0; i < count; i++) {
                    currInt = scanner.nextLine();
     //       numbers[i] = currInt;
           // hashSet.add(currInt);
            //s.add();
            System.out.println(currInt);
        }




        //    set.remove(2);

    }

    void add(int x){
        //set.add(x);
    }

    int remove(){

        return 0;
    }

}
