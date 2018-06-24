package task1;


import java.util.concurrent.Callable;

public class CallableImpl implements Callable<Double>{
    @Override
    public Double call() throws Exception {
        double x = 0;
        for (int i = 1; i <= 100; i++) {
            x += Math.sqrt(i);
        }
        return x;
    }
}
