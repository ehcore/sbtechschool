package com.ehcore.javaschool.lesson6reflection;

import com.ehcore.javaschool.lesson6reflection.examples.*;

public class Main {
    public static void main(String[] args) {
        GetterCounter counter = new GetterCounterImpl();
        System.out.println(counter.calcGetterCount(Person.class));

    }
}
