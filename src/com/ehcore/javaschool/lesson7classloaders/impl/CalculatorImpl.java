package com.ehcore.javaschool.lesson7classloaders.impl;

import com.ehcore.javaschool.lesson7classloaders.api.Calculator;

public class CalculatorImpl implements Calculator{
    @Override
    public int summ(int a, int b) {
        return a+b;
    }

    @Override
    public int diff(int a, int b) {
        return a-b;
    }

    @Override
    public String toString() {
        return "CalculatorImpl{}:" + this.getClass().getClassLoader() ;
    }
}
