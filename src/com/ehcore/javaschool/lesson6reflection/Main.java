package com.ehcore.javaschool.lesson6reflection;

import com.ehcore.javaschool.lesson6reflection.examples.*;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        GetterCounter counter = new GetterCounterImpl();
        //System.out.println(counter.calcGetterCount(Person.class));

        GetterCounter counter2 = (GetterCounter) Proxy.newProxyInstance(Main.class.getClassLoader(),
                new Class[]{GetterCounter.class},
                new MyGetterCounterInvocationHandler(counter));

        counter2.calcGetterCount(Person.class);

    }
}
