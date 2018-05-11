package com.ehcore.javaschool.lesson1;

import java.util.*;

public class Solution2037 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inStr = scanner.next();
        int amount = scanner.nextInt();

        ArrayList<String> lists = splitString(inStr);

        ArrayList<String> finalList = new ArrayList<>();

        for(String str : lists){
            if(str.length() >= amount) finalList.add(str);
        }

        for(int i = 0; i < finalList.size() - 1 ; i++){
            System.out.print(finalList.get(i) + ",");
        }
        if(!finalList.isEmpty()){
            System.out.print(finalList.get(finalList.size() - 1));
        }
    }

    private static  ArrayList<String> splitString(String str){

        ArrayList<Character> characterList = new ArrayList<>();
        ArrayList<String> lists = new ArrayList<>();
        char ch = ' ';

        for(int i = 0 ; i < str.length(); i++){
            ch = str.charAt(i);
            if(ch == ','){
                if(i == str.length()-1){
                    StringBuilder sb = new StringBuilder();
                    for(char c : characterList){
                        sb.append(c);
                    }
                    lists.add(sb.toString());
                    characterList.clear();

                    lists.add("");
                }else if(i == 0){
                    lists.add("");
                }else{
                    StringBuilder sb = new StringBuilder();
                    for(char c : characterList){
                        sb.append(c);
                    }
                    lists.add(sb.toString());
                    characterList.clear();
                }
            } else {
                characterList.add(str.charAt(i));
                if(i == str.length()-1) {
                    StringBuilder sb = new StringBuilder();
                    for(char c : characterList){
                        sb.append(c);
                    }
                    lists.add(sb.toString());
                    characterList.clear();
                }
            }
        }
        return lists;
    }
}
