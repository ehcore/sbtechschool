package com.ehcore.javaschool.lesson7classloaders.app;

public class App {


    @Override
    public String toString() {
        return "App{}:" + this.getClass().getClassLoader();
    }
}
