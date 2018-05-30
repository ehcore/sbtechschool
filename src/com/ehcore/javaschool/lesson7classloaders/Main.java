package com.ehcore.javaschool.lesson7classloaders;

import com.ehcore.javaschool.lesson7classloaders.app.App;
import com.ehcore.javaschool.lesson7classloaders.impl.CalculatorImpl;

public class Main {
    public static void main(String[] args) throws Exception{
        System.out.println(new CalculatorImpl());
       // System.out.println(new App());
        ApiClassloader loader = new ApiClassloader("out\\production\\SbTechJavaSchool\\");
        Class<?> clazz = Class.forName("com.ehcore.javaschool.lesson7classloaders.app.App", true, loader);
        System.out.println(clazz.getClassLoader());




      //  Class<?> clazz2 = loader.loadClass("com.ehcore.javaschool.lesson7classloaders.app.App");
       // System.out.println("my loader - " + clazz2.newInstance());
    }
}
