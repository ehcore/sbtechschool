package app;

import impl.*;

public class MyApp extends App implements Apps{
    private CalculatorImpl calculator = new CalculatorImpl();

    public CalculatorImpl getCalculator() {
        return calculator;
    }

    public void setCalculator(CalculatorImpl calculator) {
        this.calculator = calculator;
    }

    @Override
    public String toString() {
        return "MyApp{}:" + this.getClass().getClassLoader();
    }
}
