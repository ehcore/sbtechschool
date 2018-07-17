package ru.sbt.patterns2;


import java.util.*;

public class StrategyApp {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random r = new Random();
        for (int i = 0; i < arr.length; i++) {
            arr[i] = r.nextInt(100);
        }

        StrategyClient c = new StrategyClient();
        c.setStrategy(new SelectedSort());
        c.executeStrategy(arr);

        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr);

    }
}

//context
class StrategyClient{
    Sorting strategy;
    void setStrategy(Sorting strategy){
        this.strategy = strategy;
    }
    void executeStrategy(int[] arr){
        strategy.sort(arr);
    }
}

//strategy
interface Sorting{
    void sort(int[] arr);
}

class BubbleSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("Bubble sort");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}

class SelectedSort implements Sorting{
    @Override
    public void sort(int[] arr) {
        System.out.println("Select sort");
        System.out.println("before:\t" + Arrays.toString(arr));
        for (int i = 0; i < arr.length - 1 ; i++) {
            //int min = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[i]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
        System.out.println("after:\t" + Arrays.toString(arr));
    }
}